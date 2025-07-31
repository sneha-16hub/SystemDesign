package ElevatorSystem.real;

import java.util.PriorityQueue;

public class ElevatorController {
	PriorityQueue<Integer> upDirRequests;
	PriorityQueue<Integer> downDirRequests;
	Elevator elevator;
	public ElevatorController(Elevator elevator) {
		this.elevator=elevator;
		upDirRequests=new PriorityQueue<>();
		downDirRequests=new PriorityQueue<>((a,b)->b-a);
	}
	public void submitRequest(int floorNumber,Direction direction) {
		if(direction==Direction.UP) {
			upDirRequests.offer(floorNumber);
		}else {
			downDirRequests.offer(floorNumber);
		}
	}
	public Elevator getElevator() {
		return elevator;
	}
	public void handleInternalRequests(int floorNumber) {
		if(elevator.getCurrentFloor()<floorNumber) {
			upDirRequests.offer(floorNumber);
		}else {
			downDirRequests.offer(floorNumber);
		}
	}
	public void controlElevator() {
		while(true) {
			if(elevator.getState()==ElevatorState.MOVING) {
				if(elevator.getDirection()==Direction.UP) {
					while(!upDirRequests.isEmpty()) {
						int idx=upDirRequests.poll();
						moveElevatorTo(idx);
					}
					if(!downDirRequests.isEmpty()) {
						elevator.setDirection(Direction.DOWN);
						int idx=downDirRequests.poll();
						moveElevatorTo(idx);
					}else {
						elevator.setState(ElevatorState.IDLE);
					}
				}
				if(elevator.getDirection()==Direction.DOWN) {
					while(!downDirRequests.isEmpty()) {
						int idx=downDirRequests.poll();
						moveElevatorTo(idx);
					}
					if(!upDirRequests.isEmpty()) {
						elevator.setDirection(Direction.UP);
						int idx=upDirRequests.poll();
						moveElevatorTo(idx);
					}else {
						elevator.setState(ElevatorState.IDLE);
					}
				}
				
			}else {
				if(!upDirRequests.isEmpty()) {
					elevator.setDirection(Direction.UP);
				}else if(!downDirRequests.isEmpty()){
					elevator.setDirection(Direction.DOWN);
				}
			}
			
		}
	}
	private void moveElevatorTo(int idx) { // template design pattern
		elevator.setCurrentFloor(idx);
		elevator.setDisplay(idx);
        elevator.openDoor();
        elevator.closeDoor();
		
	}

}
