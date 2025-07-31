package StrategyDesignPattern;

import StrategyDesignPattern.strategy.specialDrive;

public class offRoadDrive extends Vehicle{
	offRoadDrive(){
		super(new specialDrive());
	}
}
