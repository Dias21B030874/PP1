package Problem2;

public class OldRobot implements Moveable{
	private int speed;
	private int xPos;
	private int yPos;
	
	public OldRobot() {
		speed = 1;
		xPos = 0;
		yPos = 0;
	}
	
	public void moveHoriz(int x) {
		xPos += x*speed;
	}
	public void moveVert(int y) {
		yPos += y*speed;
	}
	public String toString() {
		return String.format("Robot: (%s,%s) with speed %s km/h", xPos, yPos, speed);
	}
}
