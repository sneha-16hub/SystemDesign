package cricBuzz;

import java.util.List;

public class OverDetails {
	List<BallDetails> balls;
	PlayerDetails bowledBy;
	int overNumber;
	int noOfExtraBalls;
	public OverDetails(PlayerDetails bowledBy, int overNumber) {
		this.bowledBy=bowledBy;
		this.overNumber=overNumber;
	}
	public Boolean startOver(Team battingTeam,Team ballingTeam,int runsToWin) throws Exception {
		int ball=1;
		while(ball<=6) {
			BallDetails newBall=new BallDetails(ball);
			newBall.startPlaying(battingTeam,ballingTeam,this);
			if(newBall.balltype==BallType.NORMAL) {
				balls.add(newBall);
				ball++;
				if(newBall.wicket!=null) {
					battingTeam.setNextbatsmen();
					battingTeam.getStriker();
				}
				if(runsToWin!=-1 && runsToWin<=battingTeam.getTotalRuns()) {
					battingTeam.isWinner=true;
					return true;
				}
				
			}else {
				noOfExtraBalls++;
			}
		}
		return false;
	}
	

}
