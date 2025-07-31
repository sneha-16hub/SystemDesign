package ElevatorSystem.real;

import java.util.List;

public class ExternalPanel {
	List<ElevatorController> elevatorController=ElevatorCreator.elevatorControllerList;
	public ExternalPanel() {
		
	}
	public void callLift(int floorNumber,Direction direction) {
		for(ElevatorController x:elevatorController) {
			int elevatorID=x.getElevator().getid();
			if(elevatorID%2==0 && floorNumber%2==0) {
				x.submitRequest(floorNumber,direction);
			}else {
				x.submitRequest(floorNumber,direction);
			}
		}
	}
	

}
