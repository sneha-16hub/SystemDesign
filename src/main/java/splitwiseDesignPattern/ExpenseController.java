package splitwiseDesignPattern;

import java.util.List;

public class ExpenseController {
	BalanceSheetController balanceSheetController;
    public Expense createExpense(int expenseId,String expenseName,String description, double amount,SplitType type,List<Split> splits, User paidBy) {
    	ExpenseSplit obj=SplitFactory.getSplitFactoryObject(type);
    	if(obj.validateSplit(splits, amount)) {
    		Expense expense=new Expense(expenseId,expenseName,description,  amount, type, splits, paidBy);
    		balanceSheetController.updateBalanceSheet(paidBy,splits,amount);
    		return expense;
    	}
    	return null;
    }
}
