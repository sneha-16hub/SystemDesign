package designATM;

public class Database {
	int totalAmount;
	int twoThousandCash;
	int fiveHundredCash;
	int hundredCash;
	int tenCash;
	public void insertCash(int totalAmount,int twoThousandCash,int fiveHundredCash,int hundredCash,int tenCash) {
		this.tenCash=tenCash;
		this.hundredCash=hundredCash;
		this.fiveHundredCash=fiveHundredCash;
		this.fiveHundredCash=twoThousandCash;
		this.fiveHundredCash=totalAmount;
		
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public int getTwoThousandCash() {
		return twoThousandCash;
	}
	public int getFiveHundredCash() {
		return fiveHundredCash;
	}
	public int getHundredCash() {
		return hundredCash;
	}
	public int getTenCash() {
		return tenCash;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public void setTwoThousandCash(int twoThousandCash) {
		this.twoThousandCash = twoThousandCash;
	}
	public void setFiveHundredCash(int fiveHundredCash) {
		this.fiveHundredCash = fiveHundredCash;
	}
	public void setHundredCash(int hundredCash) {
		this.hundredCash = hundredCash;
	}
	public void setTenCash(int tenCash) {
		this.tenCash = tenCash;
	}
	

}
