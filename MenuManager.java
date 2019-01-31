package edu.pitt.is18.xix64.menumanager;

import java.util.ArrayList;

public class MenuManager {
	
	private ArrayList<Appetizer> appetizers = new ArrayList<Appetizer>();
	private ArrayList<Entree> entrees = new ArrayList<Entree>();
	private ArrayList<Side> sides = new ArrayList<Side>();
	private ArrayList<Beer> beers = new ArrayList<Beer>();

	public MenuManager(String dishesFile) {
		ArrayList<MenuItem> menus = FileManager.readItems(dishesFile);
        for (int i=0; i < menus.size(); i++) {
        	if (menus.get(i) instanceof Appetizer) {
        		Appetizer a = (Appetizer)menus.get(i);
        		appetizers.add(a);
        	}
        	else if (menus.get(i) instanceof Beer) {
        		Beer b = (Beer)menus.get(i);
        		beers.add(b);
        	}
        	else if (menus.get(i) instanceof Entree ) {
        		Entree e = (Entree)menus.get(i);
        		entrees.add(e);
        	}
        	else {
        		Side s = (Side)menus.get(i);
        		sides.add(s);
        	}
        }
	}
	
	public Menu randomMenu(String name) {
		Appetizer randomA = appetizers.get((int)(Math.random()*appetizers.size())); 
		Entree randomE = entrees.get((int)(Math.random()*entrees.size())); 
		Side randomS = sides.get((int)(Math.random()*sides.size())); 
		Beer randomB = beers.get((int)(Math.random()*beers.size())); 
		Menu randomMenu = new Menu(name,randomE,randomS,randomA,randomB);

		return randomMenu;
	}
	
	public Menu minCaloriesMenu(String name) {
		Appetizer minAppetizer = appetizers.get(0);
		for (int i = 1; i < appetizers.size(); i++) {
			if (minAppetizer.getCalories() > appetizers.get(i).getCalories()) {minAppetizer = appetizers.get(i);}
		}
		
		Beer minBeer = beers.get(0);
		for (int i = 1; i < beers.size(); i++) {
			if (minBeer.getCalories() > beers.get(i).getCalories()) {minBeer = beers.get(i);}
		}
		
		Entree minEntree = entrees.get(0);
		for (int i = 1; i < entrees.size(); i++) {
			if (minEntree.getCalories() > entrees.get(i).getCalories()) {minEntree = entrees.get(i);}
		}
		
		Side minSide = sides.get(0);
		for (int i = 1; i < sides.size(); i++) {
			if (minSide.getCalories() > sides.get(i).getCalories()) {minSide = sides.get(i);}
		}
		Menu minCal = new Menu(name,minEntree,minSide,minAppetizer,minBeer);
		return minCal;
	}
	
	public Menu maxCaloriesMenu(String name) {
		Appetizer maxAppetizer = appetizers.get(0);
		for (int i = 1; i < appetizers.size(); i++) {
			if (maxAppetizer.getCalories() < appetizers.get(i).getCalories()) {maxAppetizer = appetizers.get(i);}
		}
		
		Beer maxBeer = beers.get(0);
		for (int i = 1; i < beers.size(); i++) {
			if (maxBeer.getCalories() < beers.get(i).getCalories()) {maxBeer = beers.get(i);}
		}
		
		Entree maxEntree = entrees.get(0);
		for (int i = 1; i < entrees.size(); i++) {
			if (maxEntree.getCalories() < entrees.get(i).getCalories()) {maxEntree = entrees.get(i);}
		}
		
		Side maxSide = sides.get(0);
		for (int i = 1; i < sides.size(); i++) {
			if (maxSide.getCalories() < sides.get(i).getCalories()) {maxSide = sides.get(i);}
		}
		Menu maxCal = new Menu(name,maxEntree,maxSide,maxAppetizer,maxBeer);
		return maxCal;
	}
	
	public ArrayList<Appetizer> getAppetizers() {
		return appetizers;
	}

	public void setAppetizers(ArrayList<Appetizer> appetizers) {
		this.appetizers = appetizers;
	}

	public ArrayList<Entree> getEntrees() {
		return entrees;
	}

	public void setEntrees(ArrayList<Entree> entrees) {
		this.entrees = entrees;
	}

	public ArrayList<Side> getSides() {
		return sides;
	}

	public void setSides(ArrayList<Side> sides) {
		this.sides = sides;
	}

	public ArrayList<Beer> getBeers() {
		return beers;
	}

	public void setBeers(ArrayList<Beer> beers) {
		this.beers = beers;
	}

}
