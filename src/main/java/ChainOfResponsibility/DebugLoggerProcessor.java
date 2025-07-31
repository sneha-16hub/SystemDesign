package ChainOfResponsibility;

public class DebugLoggerProcessor extends LogProcessor{
	public DebugLoggerProcessor(LogProcessor lp) {
		super(lp);
		
	}
	public void log(int logLevel,String msg) {
		if(logLevel== DEBUG) {
			System.out.println("Debug"+ msg);
		}else {
			super.log(logLevel,msg);
		}
	}

}
