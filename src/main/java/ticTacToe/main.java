package ticTacToe;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player player1=new Player("raju",Move.O);
		Player player2=new Player("Ranu",Move.X);
		Game game=new Game(player1,player2);
		game.play();

	}

}
