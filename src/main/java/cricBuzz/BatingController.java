package cricBuzz;

import java.util.LinkedList;
import java.util.Queue;

public class BatingController {
	Queue<PlayerDetails> yetToPlay;
	PlayerDetails striker;
	PlayerDetails nonStriker;
	
	
	public BatingController(Queue<PlayerDetails> players) {
		yetToPlay=new LinkedList<>();
		yetToPlay.addAll(players);
	}
	public void setNextPlayers() throws Exception{
		if(yetToPlay.isEmpty()) {
			throw new Exception();
		}
		if(striker==null) {
			striker=yetToPlay.poll();
		}
		if(nonStriker==null) {
			nonStriker=yetToPlay.poll();
		}
	}
	public void setStriker(PlayerDetails player) {
		striker=player;
	}
	public void setNonStriker(PlayerDetails player) {
		nonStriker=player;
	}
	public Queue<PlayerDetails> getYetToPlay() {
		return yetToPlay;
	}
	public PlayerDetails getStriker() {
		return striker;
	}
	public PlayerDetails getNonStriker() {
		return nonStriker;
	}
	
	

}
