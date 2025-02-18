package strategy;

public class CashContext {
	
	CashSuper cashsuper;
	
	public CashContext(CashSuper cashsuper) {
		this.cashsuper = cashsuper;
	}
	
	public double getResult(double price, int num) {
		return cashsuper.acceptCash(price, num);
	}
}
