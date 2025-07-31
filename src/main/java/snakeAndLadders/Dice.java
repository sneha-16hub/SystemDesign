package snakeAndLadders;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
	int noOfDice;
	int min=1;
	int max=6;
	public Dice(int dices) {
		noOfDice=dices;
	}
	public int throwDice() {
		int sum=0;
		int currDice=0;
		while(currDice<noOfDice) {
			sum+=ThreadLocalRandom.current().nextInt(min,max+1);
			currDice++;
		}
		return sum;
	}

}
