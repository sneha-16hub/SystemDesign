package ElevatorSystem.real;

public class Elevator {
	private Integer id;
	private DisplayBoard displayboard;
	private Door door;
	private InternalPanel internalPanel;
	private int currentFloor;
	private ElevatorState elevatorState;
	private Direction elevatorDirection;
	public Elevator(){
		displayboard=new DisplayBoard();
		door=new Door();
		internalPanel=new InternalPanel();
		elevatorState=ElevatorState.IDLE;
		elevatorDirection=Direction.UP;
		currentFloor=0;
	}
	public void pressButton(int destination) {
		internalPanel.pressButton(destination,this);
	}
	public void setDisplay(int destination) {
		displayboard.setDisplay(currentFloor,elevatorDirection);
	}
	
	public int getCurrentFloor() {
		return currentFloor;
	}
	public void setCurrentFloor(int idx) {
		 this.currentFloor=idx;
	}
	public void setState(ElevatorState state) {
		this.elevatorState=state;
	}
	public ElevatorState getState() {
		return elevatorState;
	}
	public void setDirection(Direction direction) {
		this.elevatorDirection=direction;
	}
	public Direction getDirection() {
		return elevatorDirection;
	}
	public void openDoor() {
		door.openDoor();
	}
	public void closeDoor() {
		door.closeDoor();
	}
	public int getid() {
		// TODO Auto-generated method stub
		return id;
	}
	public void setId(int idx) {
		id=idx;
	}
	

}
