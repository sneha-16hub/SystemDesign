package snakeAndLadders;

public class Main {

	public static void main(String[] args) {
		Player player1=new Player("Raju", Move.BLUE);
		Player player2=new Player("Shreya", Move.RED);
		Player player3=new Player("Sneha", Move.GREEN);
		Player player4=new Player("Hemu", Move.YELLOW);
		Game snakeAndLadders=new Game(player1,player2,player3,player4);
		snakeAndLadders.play();

	}

}
