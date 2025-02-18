package strategy;

public class ClientCash {
	public static void main(String args []) {
		CashContext cashContext = new CashContext(new CashNomel());
		
		System.out.println(cashContext.getResult(5, 10));
	}
}
