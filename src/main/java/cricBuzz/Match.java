package cricBuzz;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Match {
    Team teamA;
    Team teamB;
    MatchType matchtype;
    List<InningsDetails> innings;
    LocalDate matchDate;
    String Venue;
    Team tossWinner;
    public Match(Team teamA,Team teamB,MatchType matchType,LocalDate localDate,String Venue) {
    	this.teamA=teamA;
    	this.teamB=teamB;
    	this.matchtype=matchType;
    	this.matchDate=localDate;
    	this.Venue=Venue;
    }
    public Team tossWinner() {
    	if(Math.random()<0.5) {
    		return teamA;
    	}else {
    		return teamB;
    	}
    }
    void startMatch() throws Exception {
    	int noofInnings=2;
    	InningsDetails inningDetails;
    	Team battingTeam = null,bowlingTeam=null;
    	for(int inning=1;inning<=2;inning++) {
    		if(inning==1) {
    			battingTeam=tossWinner();
        		bowlingTeam=battingTeam==teamA? teamB:teamA;
        		inningDetails=new InningsDetails(battingTeam,bowlingTeam,matchtype);
        		inningDetails.startInning(-1);
    		}else {
    			Team teamhelper=battingTeam;
    			battingTeam=bowlingTeam;
    			bowlingTeam=teamhelper;
    		    inningDetails=new InningsDetails(battingTeam,bowlingTeam,matchtype);
        		inningDetails.startInning(bowlingTeam.getTotalRuns());
        		if(bowlingTeam.getTotalRuns()>battingTeam.getTotalRuns()) {
            		bowlingTeam.isWinner=true;
            	}
    			
    		}
    		innings.add(inningDetails);
    		
    	}
    	if(teamA.isWinner){
            System.out.println("---WINNER---" + teamA.name);

        }else {
            System.out.println("---WINNER---" + teamB.name);

        }
    	
    }
}
