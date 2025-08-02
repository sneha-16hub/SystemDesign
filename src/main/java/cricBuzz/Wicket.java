package cricBuzz;

public class Wicket {
     PlayerDetails takenBy;
     OverDetails overDetails;
     BallDetails balldetails;
     WicketType wicketType;
     public Wicket(PlayerDetails takenBy,OverDetails overDetails,BallDetails balldetails,WicketType wicketType) {
    	 this.takenBy=takenBy;
    	 this.overDetails=overDetails;
    	 this.balldetails=balldetails;
    	 this.wicketType=wicketType;
     }
}
