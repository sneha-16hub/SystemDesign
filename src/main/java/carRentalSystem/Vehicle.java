package carRentalSystem;


public abstract class Vehicle {
	VehicleType type;
	VehicleStatus status;
	int id;
	int capacity;
	int price;
	public Vehicle(VehicleType type,int capacity) {
		this.type=type;
		this.capacity=capacity;
		status=VehicleStatus.IDLE;
		id=89;
	}
	public VehicleType getType() {
		return type;
	}
	public VehicleStatus getStatus() {
		return status;
	}
	public int getId() {
		return id;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setType(VehicleType type) {
		this.type = type;
	}
	public void setStatus(VehicleStatus status) {
		this.status = status;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public abstract int price();
	

}
