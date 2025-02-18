package strategy;

public class CashNomel extends CashSuper{

	@Override
	public double acceptCash(double price, int num) {
		return price * num;
	}

}
