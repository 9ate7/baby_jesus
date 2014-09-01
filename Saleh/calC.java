/**
A simple Calculator
 */


public class calC {
	
	int result,x,y;
	String op;
    public calC() {
    }
    public void setX(int num1){
    	x = num1;
    }
    public void setY(int num2){
    	y = num2;
    }
    public void setOP(String operator){
    	op = operator;
    }
    public int getResult(){
    	if(op=="+"){
    		return x+y;
    	}else if(op=="-"){
    		return x-y;
    	}else if(op=="*"){
    		return x*y;
    	}else if(op=="/"){
    		return x/y;
    	}else{
    		return -1;
    	}
    }
    public static void main(String []args){
    	calC newcal = new calC();
    	
    	newcal.setX(1);
    	newcal.setY(1);
    	newcal.setOP("+");
    	System.out.println(newcal.getResult());
    }
    
}