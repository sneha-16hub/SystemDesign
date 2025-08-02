package cricBuzz;

import java.time.LocalDate;

public class CricBuzz {
    Match match;
    Team teamA;
    Team teamB;
	public void inilialize() throws Exception {
		//call the match.
		match=new Match(teamA,teamB,new TestMatch(),LocalDate.now(),"galino4");
		match.startMatch();
		
	}
	
    
}
