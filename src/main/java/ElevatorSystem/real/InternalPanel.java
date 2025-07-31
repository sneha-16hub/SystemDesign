package ElevatorSystem.real;

public class InternalPanel {
	int availableButtons[]= {0,1,2,3,4,5,6,7};
	int buttonSelected;
   
	public void pressButton(int destination, Elevator elevator) {
		
		ElevatorCreator.getElevatorController(elevator.getid()).handleInternalRequests(destination);
		
	}
}
