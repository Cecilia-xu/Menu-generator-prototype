package edu.pitt.is18.xix64.menumanager;

public class MenuItem {

	private String name;
	private String description;
	private int calories;
	private double price;
	
	public MenuItem(String name,String desc,int cal,double price) {
		this.name = name;
		this.description = desc;
        this.calories = cal;
        this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return this.name;
	}
	


}
