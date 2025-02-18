package decorate;

public class CashContext {
	private ISale sale;
	
	public CashContext(int cashType) {
		switch(cashType) {
		case 1:
			this.sale = new CashNormal();
			break;
		case 2:
			CashNormal cn10 = new CashNormal();
			CashRebate cn78 = new CashRebate(0.8);
			cn78.decorate(cn10);
			this.sale = cn78;
			break;
		case 3:
			CashNormal cn11 = new CashNormal();
			CashReturn cn7 = new CashReturn(100, 50);
			cn7.decorate(cn11);
			this.sale = cn7;;
			break;
		case 4:
			
			//先打八折 再滿300反50
			CashNormal cn = new CashNormal();
			CashRebate cn1 = new CashRebate(0.8);
			CashReturn cn2 = new CashReturn(100, 50);
			cn2.decorate(cn);
			cn1.decorate(cn2);
			
			this.sale = cn1;
			break;
		case 5:
			
			//滿200反100 再打七折 
			CashNormal cn3 = new CashNormal();
			CashRebate cn4 = new CashRebate(0.7);
			CashReturn cn5 = new CashReturn(100, 500);
			cn4.decorate(cn3);
			cn5.decorate(cn4);
			this.sale = cn5;
			break;
		}
	}
	
	public double getResult(double price, int num) {
		return this.sale.acceptCash(price, num);
	}
}
