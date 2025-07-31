package ticTacToe;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private Cell[][] board;
	int size=0;
	public Board(int size) {
		this.size=size;
		board=new Cell[size][size];
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				board[i][j]=new Cell(i,j);
			}
		}
	}
	public boolean isFull() {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(board[i][j].isEmpty()) {
					return false;
				}
			}
		}
		return true;
	}
	public List<Cell> freeCells(){
		List<Cell> freeSpace=new ArrayList<>();
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(board[i][j].isEmpty()) {
					freeSpace.add(board[i][j]);
				}
			}
		}
		return freeSpace;
	}
	public boolean makeMove(int i,int j,Player player) {
		if(i<0 || j<0 || i>=size || j>=size) {
			return false;
		}
		if(!board[i][j].isEmpty()) {
			return false;
		}
		board[i][j].setPlayer(player);
		return true;
	}
	
	public boolean won(Player player) {
		Move move=player.getMove();
		//row
		for(int i=0;i<size;i++) {
			boolean won=true;
			for(int j=0;j<size;j++) {
				if(board[i][j].isEmpty() || board[i][j].getPlayer().getMove()!=move) {
					won=false;
				}
			}
			if(won) {
				return true;
			}
		}
		for(int i=0;i<size;i++) {
			boolean won=true;
			for(int j=0;j<size;j++) {
				
				if(board[j][i].isEmpty() || board[j][i].getPlayer().getMove()!=move) {
					won= false;
				}
			}
			if(won) {
				return true;
			}
		}
		Boolean won=true;
		for(int i=0;i<size;i++) {
			if(board[i][i].isEmpty() || board[i][i].getPlayer().getMove()!=move) {
				won=false;
			}
		}
		if(won) {
			return true;
		}
		won = true;
        for (int i = 0; i < size; i++) {
            if (board[i][size - 1 - i].getPlayer() == null || board[i][size - 1 - i].getPlayer().getMove() != move) {
                won = false; break;
            }
        }
        return won;
		
	}

}
