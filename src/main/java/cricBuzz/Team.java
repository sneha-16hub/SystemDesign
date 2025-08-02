package cricBuzz;

import java.util.List;
import java.util.Queue;

public class Team {
	Queue<PlayerDetails> playing11;
	List<PlayerDetails> bench;
	BatingController batingController;
	BowlingController bowlingController;
	String name;
    Boolean isWinner;
    public Team(String name,Queue<PlayerDetails> playing11, List<PlayerDetails> bench, List<PlayerDetails> bowlers) {
    	this.playing11=playing11;
    	this.bench=bench;
    	this.name=name;
    	batingController=new BatingController(playing11);
    	bowlingController=new BowlingController(bowlers);
    }
    public String getTeamName() {
    	return name;
    }
    public PlayerDetails getNextBowler(int maxOverPerBowler) {
    	bowlingController.getNextBowler(maxOverPerBowler);
    	return bowlingController.getcurrentBowler();
    }
    public void setNextbatsmen() throws Exception {
    	batingController.setNextPlayers();
    	
    }
    public int getTotalRuns() {
    	Queue<PlayerDetails> players=playing11;
    	int totalScore=0;
    	while(!players.isEmpty()) {
    		totalScore+=players.poll().battingScoreBoard.totalRuns;
    	}
    	return totalScore;
    	
    }
    public void setStriker(PlayerDetails player) {
    	batingController.setStriker(player);
    }
    public void setNonStriker(PlayerDetails player) {
    	batingController.setNonStriker(player);
    }
    public PlayerDetails getStriker() {
    	return batingController.getStriker();
    }
    public PlayerDetails getNonStriker() {
    	return batingController.getNonStriker();
    }

}
