package snakeAndLadders;

public class Player {
    String name;
    Move move;
    int currentPosition;
    public Player(String name,Move move) {
    	this.name=name;
    	this.move=move;
    	this.currentPosition=1;
    }
    public String getName() {
    	return name;
    }
    public Move move() {
    	return move;
    }
    public int getCurrentPosition() {
    	return currentPosition;
    }
    public void setCurrentPosition(int pos) {
    	currentPosition=pos;
    }
    
}
