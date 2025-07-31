package ticTacToe;

public class Player {
   String name;
   Move move;
   public Player(String name,Move move) {
	   this.name=name;
	   this.move=move;
   }
   public String getName() {
	   return name;
   }
   public Move getMove() {
	   return move;
   }
   
}
