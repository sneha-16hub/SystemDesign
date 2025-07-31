package splitwiseDesignPattern;

public class SplitFactory {
	public static ExpenseSplit getSplitFactoryObject(SplitType type){
		if(type==SplitType.SPLITBYPERCENTAGE) {
			return new splitByPercentage();
		}else if(type==SplitType.SPLITEQUALLY) {
			return new SplitEqually();
		}else if(type==SplitType.SPLITUNEQUALLY) {
			return new SPLITUNEQUALLY();
		}else {
			System.out.println("Opps");
		}
		return null;
	}

}
