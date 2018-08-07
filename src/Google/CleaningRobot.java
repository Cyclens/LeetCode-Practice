package Google;

import java.util.*;

class Coordinate {
	int x;
	int y;
	public Coordinate (int i, int j) {
		this.x = i;
		this.y = j;
	}
}

public class CleaningRobot implements RobotInterface{

	Coordinate pos;
	
	int curDir;
	Set<Coordinate> visited;
	
	public CleaningRobot(int i, int j) {
		pos = new Coordinate(i, j);
		curDir = 0;
		visited = new HashSet<Coordinate>();
		
	}
	
	@Override
	public boolean Move() {
		
	}

	@Override
	public void TurnLeft(int k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void TurnRight(int k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Clean() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main (String[] args) {
		CleaningRobot Robot = new CleaningRobot(0, 0);
		Coordinate curPos = Robot.pos;
		int x = curPos.x;
		int y = curPos.y;
		dfs(Robot, x, y, Robot.visited, Robot.curDir);
	}
	
	static void dfs(CleaningRobot Robot, int x, int y, Set<Coordinate> visited,int curDir) {
		
		if (visited.contains(new Coordinate(x, y))) return;
		Robot.Clean();
		visited.add(new Coordinate(x, y));
		int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		for (int i = 0; i < 4; i++) {
			Robot.TurnRight(1);
			curDir += 1;
			curDir %= 4;
			if (Robot.Move())
				dfs(Robot, x + dirs[curDir][0], y + dirs[curDir][1], Robot.visited, curDir);
			else
				visited.add(new Coordinate(x + dirs[curDir][0], y + dirs[curDir][1]));
			Robot.TurnRight(2);
			Robot.Move();
			Robot.TurnLeft(2);
			
		}
	}

	
}
