package carRentalSystem;

import java.time.LocalDateTime;

public class Reservation {
	User user;
	Vehicle vehicle;
	int reservationId;
	LocalDateTime  fromDateTime;
	LocalDateTime  toDateTime;
	
	LocalDateTime bookingDate;
	
	Location pickupPoint;
	Location dropPoint;
	ReservationType reservationType;
	ResversationStatus status;
	public int createReservation(Vehicle vehicle,User user,LocalDateTime  fromDateTime,LocalDateTime  toDateTime) {
		reservationId=909;
		this.vehicle=vehicle;
		this.user=user;
		reservationType=ReservationType.DAILY;
		status=ResversationStatus.CREATED;
		this.fromDateTime=fromDateTime;
		this.toDateTime=toDateTime;
		bookingDate= LocalDateTime.now();
		
		return reservationId;
	}
	public User getUser() {
		return user;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public int getReservationId() {
		return reservationId;
	}
	public LocalDateTime getFromDateTime() {
		return fromDateTime;
	}
	public LocalDateTime getToDateTime() {
		return toDateTime;
	}
	public LocalDateTime getBookingDate() {
		return bookingDate;
	}
	public Location getPickupPoint() {
		return pickupPoint;
	}
	public Location getDropPoint() {
		return dropPoint;
	}
	public ReservationType getReservationType() {
		return reservationType;
	}
	public ResversationStatus getStatus() {
		return status;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public void setFromDateTime(LocalDateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}
	public void setToDateTime(LocalDateTime toDateTime) {
		this.toDateTime = toDateTime;
	}
	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}
	public void setPickupPoint(Location pickupPoint) {
		this.pickupPoint = pickupPoint;
	}
	public void setDropPoint(Location dropPoint) {
		this.dropPoint = dropPoint;
	}
	public void setReservationType(ReservationType reservationType) {
		this.reservationType = reservationType;
	}
	public void setStatus(ResversationStatus status) {
		this.status = status;
	}
	
	
	

}
