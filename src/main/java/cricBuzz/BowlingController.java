package cricBuzz;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BowlingController {
   Deque<PlayerDetails> bowlers;
   Map<PlayerDetails,Integer> bowlerVsOverCount;
   PlayerDetails currentBowler;
   public BowlingController(List<PlayerDetails> players) {
	   setBowler(players);
   }
   public void setBowler(List<PlayerDetails> players) {
	   bowlers=new LinkedList<>();
	   bowlerVsOverCount=new HashMap<>();
	   for(PlayerDetails player:players) {
		   bowlers.add(player);
		   bowlerVsOverCount.put(player, 0);
	   }
   }
   public PlayerDetails getcurrentBowler() {
	  
	   return currentBowler;
   }
   public void getNextBowler(int maxOverCountPerBowler) {
	   PlayerDetails player=bowlers.poll();
	   if(bowlerVsOverCount.get(player)+1<maxOverCountPerBowler) {
		   bowlers.addLast(player);
	   }
	   currentBowler=player;
	   bowlerVsOverCount.put(player, bowlerVsOverCount.get(player)+1);
   }
}
