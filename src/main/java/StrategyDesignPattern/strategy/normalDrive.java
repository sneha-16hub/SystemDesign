package StrategyDesignPattern.strategy;

public class normalDrive implements DriveStrategy{
	@Override
	public void drive() {
		System.out.println("normal Drive");
	}
}
