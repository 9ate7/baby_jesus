import java.awt.*;
import javax.swing.JFrame;

public class Screen {

    private GraphicsDevice vc; //uses graphics card
    
    public Screen(){
    	GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
    	vc = env.getDefaultScreenDevice();
    }
    
    public void setFullScreen(DisplayMode dm, JFrame window){
    	window.setUndecorated(true);//no borders
    	window.setResizable(false);//can't resie
    	vc.setFullScreenWindow(window);//convert to full screen
    	
    	if(dm !=null && vc.isDisplayChangeSupported()){
    		try{
    			vc.setDisplayMode(dm);
    		}catch(Exception ex){}
    	}
    	
    }
    
    public Window getFullScreenWindow(){
    	return vc.getFullScreenWindow();
    }
    
    public int screenWidth(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		return (int)screenSize.getWidth();
	}
	
	public int screenHeight(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		return (int)screenSize.getHeight();
	}
    
    public void restoreScreen(){
    	Window w = vc.getFullScreenWindow();
    	if (w !=null){
    		w.dispose();
    	}
    	vc.setFullScreenWindow(null);
    }
    
}