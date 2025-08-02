package cricBuzz;

public class bowlingScoreObserver implements ScoreUpdaterObserver {

	@Override
	public void update(BallDetails balldetails) {
		PlayerDetails bowler=balldetails.bowledBy;
		if(balldetails.balltype==BallType.NOBALL) {
			bowler.bowlingScoreBoard.noBall++;
		}
		if(balldetails.balltype==BallType.WIDEBALL) {
			bowler.bowlingScoreBoard.wideBall++;
		}
		if(balldetails.runtype==RunType.FOUR) {
			bowler.bowlingScoreBoard.runsGiven+=4;
		}
		if(balldetails.runtype==RunType.ONE) {
			bowler.bowlingScoreBoard.runsGiven+=1;
		}if(balldetails.runtype==RunType.SIX) {
			bowler.bowlingScoreBoard.runsGiven+=6;
		}
		if(balldetails.runtype==RunType.TWO) {
			bowler.bowlingScoreBoard.runsGiven+=2;
		}
		if(balldetails.runtype==RunType.THREE) {
			bowler.bowlingScoreBoard.runsGiven+=3;
		}
		if (balldetails.ballNumber == 6 && balldetails.balltype == BallType.NORMAL) {
            balldetails.bowledBy.bowlingScoreBoard.totalOversCount++;
        }
		if(balldetails.wicket!=null) {
			 balldetails.bowledBy.bowlingScoreBoard.wicketTaken++;
		}
		
		

	}

}
