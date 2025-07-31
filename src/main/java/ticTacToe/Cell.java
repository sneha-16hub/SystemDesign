package ticTacToe;

public class Cell {
	int x;
	int y;
	Player player;
	Cell(int x,int y){
		this.x=x;
		this.y=y;
		this.player=null;
	}
	void setPlayer(Player player) {
		this.player=player;
	}
	boolean isEmpty() {
		if(this.player==null) {
			return true;
		}
		return false;
	}
	Player getPlayer() {
		return player;
	}

}
