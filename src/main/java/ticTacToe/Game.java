package ticTacToe;

import java.util.Scanner;

public class Game {
	Board board;
	Player[] player;
	int currPlayerIdx;
	public Game(Player p1,Player p2) {
		board=new Board(3);
		player=new Player[] {p1,p2};
		currPlayerIdx=0;	
	}
	
	public void play() {
		Scanner sc=new Scanner(System.in);
		while(true) {
			Player nowPlaying=player[currPlayerIdx];
			System.out.println(nowPlaying.getName()+" : Enter your moves");
			int r=sc.nextInt();
			int c=sc.nextInt();
			
			if(!board.makeMove(r, c, nowPlaying)) {
				System.out.println("InvalidMove");
				continue;
			}
			if(board.won(nowPlaying)) {
				System.out.println(nowPlaying.getName()+" you won");
				break;
			}
			if(board.isFull()) {
				System.out.println("Its a draw");
				break;
			}
			currPlayerIdx=(currPlayerIdx+1)%2;
			
		}
		sc.close();
		
		
		
	}

}
