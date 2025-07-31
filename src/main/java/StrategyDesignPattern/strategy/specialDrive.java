package StrategyDesignPattern.strategy;

public class specialDrive implements DriveStrategy{
	@Override
	public void drive() {
		System.out.println("special Drive");
	}
}
