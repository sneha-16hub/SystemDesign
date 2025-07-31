package snakeAndLadders;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
	Map<Integer,Cell> board=new HashMap<>();
	int size;
	public Board(int size,int ladders,int snakes) {
		this.size=size;
		initialize(size);
		addLadders(ladders);
		addSnake(snakes);
	}
	public void getBoard(){
		Cell[][] boardView = new Cell[size][size];
		int cellNumber =1;
		 for (int row = size - 1; row >= 0; row--) {
	            if ((size - row) % 2 == 1) {
	                for (int col = 0; col < size; col++) {
	                    boardView[row][col] = board.get(cellNumber++);
	                }
	            } else {
	                for (int col = size - 1; col >= 0; col--) {
	                    boardView[row][col] = board.get(cellNumber++);
	                }
	            }
	        }
		 for(int i=0;i<size;i++) {
			 for(int j=0;j<size;j++) {
				 System.out.print(boardView[i][j].type+ " ");
			 }
			 System.out.println();
		 }
		
	}
	void initialize(int size) {
	    int k=size*size;
	    for(int i=1;i<=k;i++) {
	    	board.put(i, new Cell(i));
	    }
	}
	public boolean checkJump(int destination,Player player) {
		if(board.get(destination).jump!=null) {
			player.setCurrentPosition(board.get(destination).jump.getEnd());
			return true;
		}
		return false;
	}
	void addLadders(int ladders) {
		int currladders=0;
		while(currladders!=ladders) {
			int start=ThreadLocalRandom.current().nextInt(1,size*size+1);
			int end=ThreadLocalRandom.current().nextInt(1,size*size+1);
			if(start==1 || end==size*size || board.get(start).jump!=null || board.get(end).jump!=null || start>=end) {
				continue;
			}
			board.get(start).jump=new Jump(start,end);
			board.get(start).type=Type.LADDER;
			currladders++;
		}
		
	}
	
	void addSnake(int snake) {
		int currSnakes=0;
		while(currSnakes!=snake) {
			int start=ThreadLocalRandom.current().nextInt(1,size*size+1);
			int end=ThreadLocalRandom.current().nextInt(1,size*size+1);
			if(start==1 || end==size*size || board.get(start).jump!=null || board.get(end).jump!=null || start<=end) {
				continue;
			}
			board.get(start).jump=new Jump(start,end);
			board.get(start).type=Type.SNAKE;
			currSnakes++;
		}
		
	}
	public Boolean isWon(Player player) {
		if(player.getCurrentPosition()==size*size) {
			return true;
		}
		return false;
		
	}

}
