package model;

import BaseModel.Animal;

public class Dog extends Animal {
	
	public Dog() {
		super();
	}
	
	public Dog(String name) {
		super(name);
	}
	
	public String shout() {
		String result="";
		
		for(int i = 0; i<this.shutNum; i ++) {
			result += "汪";
		}
		
		return "狗狗" + result;
	}
	
	public void bit() {
		System.out.println("咬咬攻擊");
	}
}
