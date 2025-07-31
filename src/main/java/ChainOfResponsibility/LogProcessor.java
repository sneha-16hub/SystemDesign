package ChainOfResponsibility;

public class LogProcessor {
	public static int INFO=1;
	public static int DEBUG=2;
	public static int ERROR=3;
	
	LogProcessor lp;
	LogProcessor(LogProcessor lp){
		this.lp=lp;
	}
	
	public void log(int logLevel,String msg) {
		if(lp!=null) {
			lp.log(logLevel, msg);
		}
	}

}
