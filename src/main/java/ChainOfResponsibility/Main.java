package ChainOfResponsibility;

public class Main {

	public static void main(String[] args) {
		LogProcessor lp=new InfoLoggerProcessor(new DebugLoggerProcessor(new ErrorLoggerProcessor(null)));
		lp.log(lp.ERROR, "error");
		lp.log(lp.INFO, "info");
		lp.log(lp.DEBUG, "debug");

	}

}
