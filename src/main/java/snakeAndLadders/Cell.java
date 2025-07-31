package snakeAndLadders;


public class Cell {
   int number;
   Jump jump;
   Type type;
   public Cell(int number){
	   this.number=number;
	   this.jump=null;
	   type=Type.NORMAL;
   }
   
}
