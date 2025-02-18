package decorate;

public class ClientCash {
	public static void main(String args []) {
		CashContext cc = new CashContext(1);
		CashContext cc1 = new CashContext(2);
		CashContext cc2 = new CashContext(3);
		CashContext cc3 = new CashContext(4);
		CashContext cc4 = new CashContext(5);
		
		System.out.println(cc.getResult(100, 2));
		System.out.println(cc1.getResult(100, 2));
		System.out.println(cc2.getResult(100, 2));
		System.out.println(cc3.getResult(100, 2));
		System.out.println(cc4.getResult(100, 2));
		
	}
}
