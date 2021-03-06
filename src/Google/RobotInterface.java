package Google;



public interface RobotInterface {
	// returns true if next cell is open and robot moves into the cell.
	// returns false if next cell is obstacle and robot stays on the current cell.
	boolean Move();

	// Robot will stay on the same cell after calling Turn*. k indicates how
	// many turns to perform.
	void TurnLeft(int k);

	void TurnRight(int k);

	// Clean the current cell.
	void Clean();

}