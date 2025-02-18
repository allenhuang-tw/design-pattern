package proxy;

public class Proxy implements IGiveGift{
	
	private Pursuit pt;
	
	public Proxy(SchoolGirl sg) {
		this.pt = new Pursuit(sg);
	}

	@Override
	public void giveDolls() {
		this.pt.giveDolls();
		
	}

	@Override
	public void giveFlowers() {
		this.pt.giveFlowers();
		
	}

	@Override
	public void giveChocolate() {
		this.pt.giveChocolate();
		
	}
	
	
	
}
