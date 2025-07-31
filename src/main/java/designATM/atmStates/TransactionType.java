package designATM.atmStates;

public enum TransactionType {
    WITHDRAWAMOUNT,TRANSFERAMOUNT, INSERTCASH, CHECKACCOUNTSTATEMENT;

	public static void showAllTransactionTypes() {
		for(TransactionType type: TransactionType.values()) {
			System.out.println(type);
		}
		
	}
}
