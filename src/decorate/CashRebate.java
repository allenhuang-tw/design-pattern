package decorate;

public class CashRebate extends CashSuper{
	
	private double moneyRebate = 1d;
	
	public CashRebate(double moneyRebate) {
		this.moneyRebate = moneyRebate;
	}
	
	
	public CashRebate() {
	}
	
	@Override
	public double acceptCash(double price, int num) {
		double result = price * num * this.moneyRebate;
		return super.acceptCash(result, 1);
	}
}
