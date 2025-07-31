package DesignPatternExamples.ParkingLotNew;

import java.util.ArrayList;
import java.util.Scanner;

import DesignPatternExamples.ParkingLotNew.Gate.EntranceGate;
import DesignPatternExamples.ParkingLotNew.Gate.ExitGate;
import DesignPatternExamples.ParkingLotNew.ParkingLot.ParkingFloor;
import DesignPatternExamples.ParkingLotNew.ParkingLot.ParkingLot;
import DesignPatternExamples.ParkingLotNew.payments.PaymentService;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		ParkingFloor floor=new ParkingFloor(1,2,3);
		ArrayList<ParkingFloor> floors=new ArrayList<>();
		floors.add(floor);
		ParkingLot parkingLot=new ParkingLot(floors);
		
		PaymentService paymentService=new PaymentService(scanner);
		EntranceGate entranceGate=new EntranceGate(parkingLot);
		ExitGate exitGate=new ExitGate(parkingLot,paymentService);
		
		boolean exit=false;
		while(!exit) {
			showMenu();
			int choice=getUserChoice(scanner);
			switch(choice) {
			case 1:
				parkVehicle(entranceGate);
				break;
			case 2:
				vacateSpot(exitGate,scanner);
				break;
			case 3:
				exit=true;
				System.out.println("Thank you for using parking lot");
				break;
			}
		}
		scanner.close();
		

	}

	private static void vacateSpot(ExitGate exitGate, Scanner scanner) {
		System.out.println("Enter spot number");
		int spotNumber=scanner.nextInt();
		System.out.println("enter no of hours");
		int hoursstayed=scanner.nextInt();
		exitGate.processExit(spotNumber, hoursstayed);
		
	}

	private static int getUserChoice(Scanner scanner) {
		return scanner.nextInt();
	}
	private static void parkVehicle(EntranceGate entranceGate) {
		entranceGate.processEntrance();
	}

	private static void showMenu() {
		System.out.println("1. Park the vehicle");
		System.out.println("2. Vacate the vehicle spot");
		System.out.println("3. Exit the system");
	}
}
