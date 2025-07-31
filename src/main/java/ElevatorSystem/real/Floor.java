package ElevatorSystem.real;

public class Floor {
	private int floorNumber;
	private ExternalPanel externalPanel;
	Floor(int floorNumber){
		this.floorNumber=floorNumber;
		this.externalPanel=new ExternalPanel();
	}
	public void pressLiftButton(Direction direction) {
		externalPanel.callLift(floorNumber,direction);
	}
	public int getFloorNumber() {
		return floorNumber;
	}
	
	

}
