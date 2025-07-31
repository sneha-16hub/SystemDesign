package ElevatorSystem.real;

import java.util.List;

public class Building {
	List<Floor> floors;
	public Building(List<Floor> floors) {
		this.floors=floors;
	}
	
	public void addFloor(Floor floor) {
		floors.add(floor);
	}
	
	public void removeFloor(Floor floor) {
		floors.remove(floor);
	}
	
}
