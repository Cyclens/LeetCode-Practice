
public interface ElevatorControlSystemCreator {
	public void pickUp(Integer floor);
	public void destination(Integer eID, Integer destination);
	public void step();
}
