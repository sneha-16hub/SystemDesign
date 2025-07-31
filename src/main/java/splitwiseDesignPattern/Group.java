package splitwiseDesignPattern;

import java.util.List;

public class Group {
	int groupId;
	String groupName;
	List<User> members;
	User createdBy;
	List<Expense> items;
	ExpenseController expenseController;
	public Group() {
		
	}
	public int getGroupId() {
		return groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public List<User> getMembers() {
		return members;
	}
	public User getCreatedBy() {
		return createdBy;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public void setMembers(List<User> members) {
		this.members = members;
	}
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	public void addMember(User user) {
		members.add(user);
	}
	public Expense createExpense(int expenseId,String expenseName,String description, double amount,SplitType type,List<Split> splits, User paidBy) {
		Expense expense=expenseController.createExpense(expenseId, expenseName, description, amount, type, splits, paidBy);
		items.add(expense);
		return expense;
	}
	

}
