package StrategyDesignPattern;

import StrategyDesignPattern.strategy.normalDrive;
import StrategyDesignPattern.strategy.specialDrive;

public class SportsVehicle extends Vehicle{
	SportsVehicle(){
		super(new normalDrive());
	}
}
