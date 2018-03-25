package global;
import java.awt.Robot;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.event.InputEvent;
 

public class Utility {

	final static int DELAY = 100;

	//function to log message
	public static void log(String message){
		System.out.println(message);
	}
	
	//function to perform mouse right click
	public static void rightClick() {
		try {

			Robot robot = new Robot();
			  
	        // RIGHT CLICK
	        robot.mousePress(InputEvent.BUTTON3_MASK);
	        robot.mouseRelease(InputEvent.BUTTON3_MASK);
	        
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	//function to perform mouse click
	public static void click() {
		try {

			Robot robot = new Robot();

            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
           
			double X = MouseInfo.getPointerInfo().getLocation().getX();
			double Y = MouseInfo.getPointerInfo().getLocation().getX();
			
			System.out.println("X is =>"+X + " & Y is =>"+Y);
			
		}catch (Exception e) {
			// TODO: handle exception
		}			
	}
	
	//function to perform scrolling by middle mouse button
	public static void scroll() {
		try {
		     Robot robot = new Robot();
		     
	            // MIDDLE WHEEL CLICK
	         robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
	         robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
	 
	            // SCROLL THE MOUSE WHEEL
	         robot.mouseWheel(-100);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//function to move left from mouse pointer
	public static void moveLeft(int steps) {
		try {

			int X = MouseInfo.getPointerInfo().getLocation().x;
			int Y = MouseInfo.getPointerInfo().getLocation().y;
			
		     Robot robot = new Robot();
	         // Creates the delay of 50 sec 
	         // Robot start moving mouse 
	         robot.delay(DELAY);
	         robot.mouseMove(X, Y);
			 System.out.println("X is =>"+X + " & Y is =>"+Y);	
	         robot.delay(DELAY);
	         int newY = Y;

	         for(int i=0;i<steps;i++) {
		         int newX = X - i;
		         robot.mouseMove(newX, newY);
				 System.out.println("newX is =>"+newX + " & newY is =>"+newY);	          	 
		         robot.delay(DELAY);
	         }
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	
	//function to move left from mouse pointer
	public static void moveRight(int steps) {
		try {

			int X = MouseInfo.getPointerInfo().getLocation().x;
			int Y = MouseInfo.getPointerInfo().getLocation().y;
			
		     Robot robot = new Robot();
	         // Creates the delay of 50 sec 
	         // Robot start moving mouse 
	         robot.delay(DELAY);
	         robot.mouseMove(X, Y);
			 System.out.println("X is =>"+X + " & Y is =>"+Y);	
	         robot.delay(DELAY);
	         int newY = Y;

	         for(int i=0;i<steps;i++) {
		         int newX = X + i;
		         robot.mouseMove(newX, newY);
				 System.out.println("newX is =>"+newX + " & newY is =>"+newY);	          	 
		         robot.delay(DELAY);
	         }
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//function to move up from mouse pointer
	public static void moveUp(int steps) {
		try {

			int X = MouseInfo.getPointerInfo().getLocation().x;
			int Y = MouseInfo.getPointerInfo().getLocation().y;
			
		     Robot robot = new Robot();
	         // Creates the delay of 50 sec 
	         // Robot start moving mouse 
	         robot.delay(DELAY);
	         robot.mouseMove(X, Y);
			 System.out.println("X is =>"+X + " & Y is =>"+Y);	
	         robot.delay(DELAY);
	         int newX = X;

	         for(int i=0;i<steps;i++) {
		         int newY = Y - i;
		         robot.mouseMove(newX, newY);
				 System.out.println("newX is =>"+newX + " & newY is =>"+newY);	          	 
		         robot.delay(DELAY);
	         }
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	//function to move mouse pointer downward
	public static void moveDown(int steps) {
		try {

			int X = MouseInfo.getPointerInfo().getLocation().x;
			int Y = MouseInfo.getPointerInfo().getLocation().y;
			
		     Robot robot = new Robot();
	         // Creates the delay of 50 sec 
	         // Robot start moving mouse 
	         robot.delay(DELAY);
	         robot.mouseMove(X, Y);
			 System.out.println("X is =>"+X + " & Y is =>"+Y);	
	         robot.delay(DELAY);
	         int newX = X;

	         for(int i=0;i<steps;i++) {
		         int newY = Y + i;
		         robot.mouseMove(newX, newY);
				 System.out.println("newX is =>"+newX + " & newY is =>"+newY);	          	 
		         robot.delay(DELAY);
	         }
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//function to move mouse scrolling
	public static void scroll(int steps) {
		try {

			 //time to switch to a specific window where the robot ought to be tested
	        try{ Thread.sleep(2000); }catch(InterruptedException e){}

	        Robot r = new Robot();
	        for(int i = 0; i < steps; i++){
	            //scroll and wait a bit to give the impression of smooth scrolling
	            r.mouseWheel(1);
	            try{ Thread.sleep(50); }catch(InterruptedException e){}
	        }
	
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	

}
