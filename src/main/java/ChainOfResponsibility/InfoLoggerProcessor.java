package ChainOfResponsibility;

public class InfoLoggerProcessor extends LogProcessor{
	public InfoLoggerProcessor(LogProcessor lp) {
		super(lp);
		
	}
	public void log(int logLevel,String msg) {
		if(logLevel== INFO) {
			System.out.println("Info "+ msg);
		}else {
			super.log(logLevel,msg);
		}
	}

}
