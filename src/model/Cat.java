package model;

import BaseModel.Animal;

public class Cat extends Animal {
	public Cat() {
		super();
	}
	
	public Cat(String name) {
		super(name);
	}
	
	public String shout() {
		String result="";
		
		for(int i = 0; i<this.shutNum; i ++) {
			result += "喵";
		}
		
		return "貓貓" + result;
	}
}
