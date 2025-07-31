package ChainOfResponsibility;

public class ErrorLoggerProcessor extends LogProcessor{
	public ErrorLoggerProcessor(LogProcessor lp) {
		super(lp);
		
	}
	public void log(int logLevel,String msg) {
		if(logLevel== ERROR) {
			System.out.println("Error"+ msg);
		}else {
			super.log(logLevel,msg);
		}
	}

}
