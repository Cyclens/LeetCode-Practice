package Elevator;

import java.util.LinkedList;
import java.util.Queue;

public class Elevator implements ElevatorCreator {

	private Integer currFloor;
	private Queue<Integer> destinations;

	public Elevator(Integer currFloor) {
		this.currFloor = currFloor;
		this.destinations = new LinkedList<Integer>();
	}

	public int currentFloor() {
		return this.currentFloor();
	}

	public int nextDestination() {
		return this.destinations.peek();
	}
	
	public void removeDestination() {
		this.destinations.remove();
	}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		currFloor++;
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		currFloor--;
	}

	@Override
	public void addDestination(Integer destination) {
		// TODO Auto-generated method stub
		destinations.add(destination);
	}

	@Override
	public ElevatorDirection direction() {
		// TODO Auto-generated method stub
		if (destinations.size() > 0) {
			if (destinations.peek() > currFloor)
				return ElevatorDirection.UP;
			else if (destinations.peek() < currFloor)
				return ElevatorDirection.DOWN;
		}
		return ElevatorDirection.HOLD;
	}

	@Override
	public ElevatorStatus status() {
		// TODO Auto-generated method stub
		if (destinations.size() > 0) return ElevatorStatus.OCCUPIED;
		else return ElevatorStatus.EMPTY;
	}

}
