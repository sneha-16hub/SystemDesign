package snakeAndLadders;

public class Game {
	Board board;
	Dice dice;
	Player[] players;
	int currPlayer;
	Player winner;
    public Game(Player p1,Player p2,Player p3,Player p4) {
    	board=new Board(10,5,4);
		dice=new Dice(2);
		players=new Player[] {p1,p2,p3,p4};
		currPlayer=0;
    }
    
	public void play() {
		while(winner==null) {
			board.getBoard();
			int pos=players[currPlayer].getCurrentPosition();
			
			System.out.println("Current turn :"+players[currPlayer].getName()+ " Current position :"+pos);
			int k=dice.throwDice();
			System.out.println("Dice thrown :"+ k);
			players[currPlayer].setCurrentPosition(pos+k);
			if(board.checkJump(pos+k,players[currPlayer])) {
				int destination = players[currPlayer].getCurrentPosition();
				System.out.println(board.board.get(pos+k).type +" found; new Player position is: "+players[currPlayer].getCurrentPosition());
			}
			if(board.isWon(players[currPlayer])) {
				System.out.println("you won !!!!!!!!!!! Hurray");
				winner=players[currPlayer];
			}
			currPlayer=(currPlayer+1)%4;
		}
		
		
	}
	

}
