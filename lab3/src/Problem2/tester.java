package Problem2;

public class tester {

	public static void main(String[] args) {
		RobotVacuumCleaner r = new RobotVacuumCleaner();
		OldRobot oR = new OldRobot();
		r.moveHoriz(-3);
		r.moveVert(10);
		oR.moveHoriz(-3);
		oR.moveVert(10);
		System.out.println(r);
		System.out.println(oR);
		r.moveDiag(3,-10);
		System.out.println(r);
	}

}

