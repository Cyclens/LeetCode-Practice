
public interface ElevatorCreator {
	public void moveUp();
	public void moveDown();
	public void addDestination(Integer destination);
	public ElevatorDirection direction();
	public ElevatorStatus status();
}
