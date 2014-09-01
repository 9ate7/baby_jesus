import java.awt.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class runGame extends JFrame{
	public static void main(String[] args){
		DisplayMode dm = new DisplayMode(800,600,16,DisplayMode.REFRESH_RATE_UNKNOWN);
		runGame r = new runGame();
		r.run(dm);
	}
	
	private Screen s;
	private Image bg;
	private boolean loaded;
	
	public void run(DisplayMode dm){
		setBackground(Color.PINK);
		setForeground(Color.WHITE);
		setFont(new Font("Arial", Font.PLAIN,24));
		loaded = false;
		
		s = new Screen();
		try{
			s.setFullScreen(dm, this);
			loadpics();
			try{
				Thread.sleep(5000);
			}catch(Exception ex){}
		}finally{
			s.restoreScreen();
		}
	}
	//loads pictures
	public void loadpics(){
		bg = new ImageIcon("img/background.png").getImage();
		loaded = true;
		repaint();
	}
	
	public void paint(Graphics g){
		if(g instanceof Graphics2D){
			Graphics2D g2 = (Graphics2D)g; //to add smooth text
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON); //add antialiasing to text
		}
		
		if(loaded){
			g.drawImage(bg,0,0,s.screenWidth(),s.screenHeight(),this); //draws BG
		}
		g.drawString("This is a test",200,200); //adds text
	}
}