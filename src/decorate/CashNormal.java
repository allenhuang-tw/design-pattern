package decorate;

public class CashNormal implements ISale{

	@Override
	public double acceptCash(double price, int num) {
		// TODO Auto-generated method stub
		return price * num;
	}

}
