package splitwiseDesignPattern;

public class User {
	int userId;
	String userName;
	UserBalanceSheet userBalanceSheet;
	User(int userId,String userName){
		this.userId=userId;
		this.userName=userName;
		this.userBalanceSheet=new UserBalanceSheet();
	}
	public int getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public UserBalanceSheet getBalanceSheet() {
		return userBalanceSheet;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setBalanceSheet(UserBalanceSheet balanceSheet) {
		this.userBalanceSheet = balanceSheet;
	}
	

}
