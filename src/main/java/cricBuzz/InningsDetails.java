package cricBuzz;

import java.util.List;

public class InningsDetails {
    Team battingTeam;
    Team bowlingTeam;
    List<OverDetails> overs;
    MatchType matchType;
    public InningsDetails(Team battingTeam,Team bowlingTeam,MatchType matchType) {
    	this.battingTeam=battingTeam;
    	this.bowlingTeam=bowlingTeam;
    	this.matchType=matchType;
    }
    public void startInning(int runstoWin)throws Exception {
    	int totalNoofOvers=matchType.getNoOfOvers();
    	battingTeam.setNextbatsmen();
    	for(int over=1;over<=totalNoofOvers;over++) {
    		PlayerDetails bowler=battingTeam.getNextBowler(totalNoofOvers);
    		OverDetails overDetails=new OverDetails(bowler,over);
    		overs.add(overDetails);
    		if(overDetails.startOver(battingTeam, bowlingTeam, runstoWin)) {
    			break;
    		}
    		PlayerDetails player=battingTeam.getNonStriker();
    		battingTeam.setNonStriker(battingTeam.getStriker());
    		battingTeam.setStriker(player);
    	}
    	
    	
    }
}
