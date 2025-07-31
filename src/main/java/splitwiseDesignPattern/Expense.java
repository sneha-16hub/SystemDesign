package splitwiseDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Expense {
	int expenseId;
	String expenseName;
	String description;
	double amount;
	SplitType type;
	User paidBy;
	List<Split> splitDetails=new ArrayList<>();
	public Expense(int expenseId,String expenseName,String description,double amount,SplitType type,List<Split> splitDetails,User paidBy) {
		 this.description=description;
		 this.expenseId=expenseId;
		 this.expenseName=expenseName;
		 this.amount=amount;
		 this.type=type;
		 this.splitDetails.addAll(splitDetails);
		 this.paidBy=paidBy;
	}
	
	
}
