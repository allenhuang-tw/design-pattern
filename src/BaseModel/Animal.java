package BaseModel;

public class Animal {
	
	protected String name;
	protected int shutNum = 3;
	
	public  Animal() {
		
	}
	
	public  Animal(String name) {
		this.name = name;
	}

	public int getShutNum() {
		return shutNum;
	}

	public void setShutNum(int shutNum) {
		this.shutNum = shutNum;
	}
	
	public String chout() {
		return "";
	}


}
