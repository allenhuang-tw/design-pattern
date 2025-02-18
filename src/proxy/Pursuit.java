package proxy;

public class Pursuit implements IGiveGift {

	private SchoolGirl sg;
	
	public Pursuit(SchoolGirl sg) {
		this.sg = sg;
	}
	
	@Override
	public void giveDolls() {
		System.out.println("give money" + sg.getName());
		
	}

	@Override
	public void giveFlowers() {
		System.out.println("give flower" + sg.getName());
		
	}

	@Override
	public void giveChocolate() {
		System.out.println("give chocolate" + sg.getName());
		
	}
	
}
