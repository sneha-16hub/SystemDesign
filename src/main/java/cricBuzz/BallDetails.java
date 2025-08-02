package cricBuzz;

import java.util.List;

public class BallDetails {
    public BallType balltype;
    public RunType runtype;
    public PlayerDetails bowledBy;
    public PlayerDetails playedBy;
    public int ballNumber;
    public Wicket wicket;
    List<ScoreUpdaterObserver> observers;
    
    public BallDetails(int ballNumber) {
    	this.ballNumber=ballNumber;
    	observers.add(new batingScoreOberver());
    	observers.add(new bowlingScoreObserver());
    }
    void notifyObservers() {
    	for(ScoreUpdaterObserver observer:observers) {
    		observer.update(this);
    	}
    }
	public void startPlaying(Team battingTeam, Team ballingTeam, OverDetails overDetails) throws Exception {
		bowledBy=overDetails.bowledBy;
		playedBy=battingTeam.getStriker();
		balltype=BallType.NORMAL;
		if(isWicket()) {
			runtype=RunType.ZERO;
			wicket=new Wicket(bowledBy,overDetails,this,WicketType.BOLD);
		}else {
			findRun();
			if(runtype==RunType.ONE ||runtype==RunType.THREE) {
				PlayerDetails player=battingTeam.getStriker();
				battingTeam.setStriker(battingTeam.getNonStriker());
				battingTeam.setStriker(player);
			}
		}
		notifyObservers();
		
	}
	public void findRun() {
		if(Math.random()<0.2) {
			runtype=RunType.FOUR;
		}else if(Math.random()>0.2 && Math.random()<0.4) {
			runtype=RunType.SIX;
		}else if(Math.random()>0.4 && Math.random()<0.6) {
			runtype=RunType.ONE;
		}else if(Math.random()>0.6 && Math.random()<0.9) {
			runtype=RunType.TWO;
		}else {
			runtype=RunType.THREE;
		}
	}
	public Boolean isWicket() {
		if(Math.random()<0.3) {
			return true;
		}
		return false;
	}
    

}
