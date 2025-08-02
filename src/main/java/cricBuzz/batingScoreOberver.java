package cricBuzz;

public class batingScoreOberver implements ScoreUpdaterObserver {

	@Override
	public void update(BallDetails balldetails) {
		BattingScoreBoard batingScoreBoard=balldetails.playedBy.battingScoreBoard;
		if(balldetails.runtype==RunType.FOUR) {
			batingScoreBoard.fours++;
			batingScoreBoard.totalRuns+=4;
		}
		if(balldetails.runtype==RunType.SIX) {
			batingScoreBoard.sixes++;
			batingScoreBoard.totalRuns+=6;
		}
		if(balldetails.runtype==RunType.ONE) {
			
			batingScoreBoard.totalRuns+=1;
		}
		if(balldetails.runtype==RunType.TWO) {
			batingScoreBoard.totalRuns+=2;
		}
		if(balldetails.runtype==RunType.THREE) {
			batingScoreBoard.totalRuns+=3;
		}
		batingScoreBoard.totalBallsPlayed++;
		if(balldetails.wicket!=null) {
			batingScoreBoard.wicket=balldetails.wicket;
		}
		
		
		

	}

}
