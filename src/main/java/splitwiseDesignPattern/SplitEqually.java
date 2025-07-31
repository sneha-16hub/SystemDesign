package splitwiseDesignPattern;

import java.util.List;

public class SplitEqually implements ExpenseSplit {

	@Override
	public boolean validateSplit(List<Split> splitDetails, double totalAmount) {
		int totalSplitUsers=splitDetails.size();
		double perUserSplitAmount=totalAmount/totalSplitUsers;
		for(Split s:splitDetails) {
			if(s.amount!=perUserSplitAmount) {
				return false;
			}
		}
		return true;
	}
	

}
