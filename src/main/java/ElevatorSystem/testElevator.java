/*Requirement Analysis - 
1. Will there be multiple lift instances?
2. Will people also mention which floor he/she wants to move while putting a request for a lift or it would be taken cared off after the person gets into the lift?
3. Will a request for a lift be only for a specific lift or any other lift which is idle at that time also be used for the purpose?
4. Some of the possible corner cases - 
     a. Lift moving upward, someone enters, but wants to go to down and pressed the button accordingly and vice-versa.
     b. List is at last floor and two persons at two different floors want to go to the last floor.
     c. List is at first floor and two persons at two different floors  want to go the basement.
5. What if the lift is overweight?

Simple thought - 
Env with multiple lifts
whenever a request comes in for a PARTICULAR direction, one lift would be chosen among all the lifts moving in the same direction and currently in nearest lower floors (for UP) or nearest upper floors (for DOWN) in comparison to the source floor. we an have little more intelligence. In case, nearest one is overweight, then the 2nd nearest one would be chosen. Now, this above scenario is valid for multi-lift instances env. Here since there are multiple lifts, we can further do something like whichever requests can be served early considering the close proximity of any lift with the source floor will be taken cared off, but there must be some threshold of how many times a request can be delayed to avoid any kind of starvation.

Env with single lift/each lift has a separate switch.
Lift will always process the requests in order. 

Resource - delegates call to the Service/Manager class, request(src_floor, dest_floor), addLift(Lift), removeLift(Lift)
Service - 1. has instance of scheduler and call will be delegated to scheduler-request would be added in the queue, request(src_floor, dest_floor). 
                 2. has instance of a LiftInventory which is the inventory of all lifts - addLift(Lift), removeLift(Lift).
Scheduler - 1. queue of requests (each request has id, src_floor, dest_floor), 
                     2. Map with key - direction, value - list of elevators ids moving in the direction (lift ids sorted in ascending order) . 
                     3. allocate(src_floor, dest_floor) - find list of elevators moving in same direction, then search in the list using binary search to find the most suited lift (based on close proximity discussed above considering multiple lifts env). If none of the lifts are moving in that direction, go check if there is any lift which is still idle, this info can be found from the inventory. If none of the lifts are idle, then assign a lift which will complete processing its requests soon. 
                    4. unallocate(Lift) : When a lift completes processing all its requests, it should be removed from map and also updated in LiftInventory class.
LiftInventory - Map<Lift, Boolean> map, getAllLifts(), getIdleLifts(), allocateLift(Lift), unallocateLift(Lift).
Lift - id, state, direction - This can be considered as a state machine - If any lift is moving, its door can't be open/ if the door is open, lift can't move - all these cases would be handled.
LiftState - opendoor(), closedoor(), move() - Four subclasses - OpendoorState, CloseDoorState, StandingState, MovingState, UnusedState.
Direction - ENUM - UP/DOWN.*/
package ElevatorSystem;

import java.util.TreeSet;

enum Direction{
	UP,
	DOWN
}

enum State{
	MOVING,
	IDLE,
	NOT_WORKING
}

class ExternalRequest{
	private Direction direction;
	private int sourceFloorNumber;
	
	
	public ExternalRequest(Direction direction, int floorNumber) {
		super();
		this.direction = direction;
		this.sourceFloorNumber = floorNumber;
	}
	public Direction getDirection() {
		return direction;
	}
	public int getSourceFloorNumber() {
		return sourceFloorNumber;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	public void setSourceFloorNumber(int floorNumber) {
		this.sourceFloorNumber = floorNumber;
	}
	
	
}

class InternalRequest{
	private int destFloorNumber;
	
	public InternalRequest(int destFloorNumber) {
		super();
		this.destFloorNumber = destFloorNumber;
	}

	public int getDestFloorNumber() {
		return destFloorNumber;
	}

	public void setDestFloorNumber(int destFloorNumber) {
		this.destFloorNumber = destFloorNumber;
	}
	
}

class Request implements Comparable<Request>{
	private InternalRequest internalRequest;
	private ExternalRequest externalRequest;
	
	public Request(InternalRequest internalRequest, ExternalRequest externalRequest) {
		super();
		this.internalRequest = internalRequest;
		this.externalRequest = externalRequest;
	}
	public InternalRequest getInternalRequest() {
		return internalRequest;
	}
	public ExternalRequest getExternalRequest() {
		return externalRequest;
	}
	public void setInternalRequest(InternalRequest internalRequest) {
		this.internalRequest = internalRequest;
	}
	public void setExternalRequest(ExternalRequest externalRequest) {
		this.externalRequest = externalRequest;
	}
	@Override
	public int compareTo(Request req) {
		if(this.getInternalRequest().getDestFloorNumber()==req.getInternalRequest().getDestFloorNumber() ) {
			return 0;
		}else if(this.getInternalRequest().getDestFloorNumber()>req.getInternalRequest().getDestFloorNumber()){
			return 1;
		}else {
			return -1;
		}
	}
	
	
}
public class Elevator {
	private int currentFloorNumber;
	private Direction currentDirection=Direction.UP;
	private State currentState=State.IDLE;
	
	private TreeSet<Request> currentJobs=new TreeSet<>();
	private TreeSet<Request> upPendingJobs=new TreeSet<>();
	private TreeSet<Request> downPendingJobs=new TreeSet<>();
	
	public void startElevator() {
		while(true) {
			if(checkIfJob()) {
				if(currentDirection==Direction.UP) {
					Request request=currentJobs.pollFirst();
					processUpRequest(request);
					if(currentJobs.isEmpty()) {
						addPendingDownJobsToCurrentJobs();
					}
				}
				if(currentDirection==Direction.DOWN) {
					Request request=currentJobs.pollFirst();
					processDownRequest(request);
					if(currentJobs.isEmpty()) {
						addPendingUpJobsToCurrentJobs();
					}
				}
			}
		}
		
	}
	
	private void addPendingUpJobsToCurrentJobs() {
		if(!upPendingJobs.isEmpty()) {
			currentJobs=upPendingJobs;
			currentDirection=Direction.UP;
		}else {
			currentState=State.IDLE;
		}
	}

	private void addPendingDownJobsToCurrentJobs() {
		if(!downPendingJobs.isEmpty()) {
			currentJobs=downPendingJobs;
			currentDirection=Direction.DOWN;
		}else {
			currentState=State.IDLE;
		}
	}

	public boolean checkIfJob() {
		if(currentJobs.isEmpty()) {
			return false;
		}
		return true;
	}
	
	private void processUpRequest(Request request) {
		int startFloor=currentFloorNumber;
		if(startFloor<request.getExternalRequest().getSourceFloorNumber()) {
			for(int i=startFloor;i<=request.getExternalRequest().getSourceFloorNumber();i++) {
				try {
					Thread.sleep(1000);
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("We have reached floor"+i);
				currentFloorNumber=i;
			}
		}
		System.out.println("Reached the source floor");
		startFloor=currentFloorNumber;
		for(int i=startFloor;i<=request.getInternalRequest().getDestFloorNumber();i++) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("We have reached floor"+i);
			currentFloorNumber=i;
			if(checkNewJobsCanBeProcessed(request)) {
				break;
			}
		}
	}
	private void processDownRequest(Request request) {
		int startFloor=currentFloorNumber;
		if(startFloor<request.getExternalRequest().getSourceFloorNumber()) {
			for(int i=startFloor;i<=request.getExternalRequest().getSourceFloorNumber();i++) {
				try {
					Thread.sleep(1000);
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("We have reached floor"+i);
				currentFloorNumber=i;
			}
		}
		System.out.println("Reached the source floor");
		startFloor=currentFloorNumber;
		for(int i=startFloor;i>=request.getInternalRequest().getDestFloorNumber();i--) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("We have reached floor"+i);
			currentFloorNumber=i;
			if(checkNewJobsCanBeProcessed(request)) {
				break;
			}
		}
	}
	
	public boolean checkNewJobsCanBeProcessed(Request currentRequest) {
		if(checkIfJob()) {
			if(currentDirection==Direction.UP) {
				Request request=currentJobs.pollLast();
				if(request.getInternalRequest().getDestFloorNumber()<currentRequest.getInternalRequest().getDestFloorNumber()) {
					currentJobs.add(request);
					currentJobs.add(currentRequest);
					return true;
					
				}
				currentJobs.add(request);
			}
			if(currentDirection==Direction.DOWN) {
				Request request=currentJobs.pollLast();
				if(request.getInternalRequest().getDestFloorNumber()<currentRequest.getInternalRequest().getDestFloorNumber()) {
					currentJobs.add(request);
					currentJobs.add(currentRequest);
					return true;
					
				}
				currentJobs.add(request);
			}
		}
		return false;
	}
	public void addJobs(Request request) {
		if(currentState==State.IDLE);{
			currentState=State.MOVING;
			currentDirection=request.getExternalRequest().getDirection();
			currentJobs.add(request);
		}else if(currentState==State.MOVING) {
			if(request.getExternalRequest().getDirection()!=currentDirection) {
				addToPendingJobs(request);
			}else if(request.getExternalRequest().getDirection()==currentDirection) {
				if(currentDirection==Direction.UP 
						&& request.getInternalRequest().getDestFloorNumber()<currentFloorNumber) {
					addToPendingJobs(request);
				}else if(currentDirection==Direction.DOWN 
						&& request.getInternalRequest().getDestFloorNumber()<currentFloorNumber){
					addToPendingJobs(request);
				}else {
					currentJobs.add(request);
				}
			}
		}
		
	}
	public void addToPendingJobs(Request request) {
		if(request.getExternalRequest().getDirection()==Direction.UP) {
			upPendingJobs.add(request);
		}else {
			downPendingJobs.add(request);
		}
	}
		

}

class ProcessJobWorker implements Runnable{
	private Elevator elevator;

	public ProcessJobWorker(Elevator elevator) {
		super();
		this.elevator = elevator;
	}
	@Override
	public void run() {
		elevator.startElevator();
	}
}
 class AddJobWorker implements Runnable{
	private Elevator elevator;
	private Request request;
	public AddJobWorker(Elevator elevator, Request request) {
		super();
		this.elevator = elevator;
		this.request = request;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(300);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		elevator.addJobs(request);
	}
	
}

public class testElevator{
	public static void main(String args[]) {
		Elevator elevator=new Elevator();
		ProcessJobWorker processJobWorker=new ProcessJobWorker(elevator);
		Thread t2=new Thread(processJobWorker);
		t2.start();
		try {
			Thread.sleep(300);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		ExternalRequest er=new ExternalRequest(Direction.DOWN,5);
		InternalRequest ir=new InternalRequest(0);
		Request request=new Request(ir,er);
		
		new Thread(new AddJobWorker(elevator,request)).start();
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
