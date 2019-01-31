package edu.pitt.is18.xix64.menumanager;
/**
 * Class Menu
 * author : Xiaoqian Xu
 * created: 10/25/2018
 */
public class Menu {
	private String name;
	private Appetizer appetizer;
	private Entree entree;
	private Side side;
	private Beer beer;

	public Menu(String name) {
		this.name=name;
		this.appetizer=null;
		this.entree=null;
		this.side=null;
		this.beer=null;
	}
	public Menu(String name,Entree entree,Side side) {
		this.name=name;
		this.appetizer=null;
		this.entree=entree;
		this.side=side;
		this.beer=null;
	}	
	public Menu(String name,Entree entree,Side side,Appetizer appetizer,Beer beer) {
		this.name=name;
		this.appetizer=appetizer;
		this.entree=entree;
		this.side=side;
		this.beer=beer;
	}

	/**
	* Method calculate
	* @param a a double number
	* @param b an integer number
	* @return the multiplication
	*/
	public int sumCalories() {
		int sum= 0;

		if(this.appetizer!=null){
			sum+=this.appetizer.getCalories();
		}
		if(this.beer!=null){
			sum+=this.beer.getCalories();
		}
		if(this.entree!=null){
			sum+=this.entree.getCalories();
		}
		if(this.side!=null){
			sum+=this.side.getCalories();
		}

		return sum;
	} 
	
	public double totalPrice() {
		double total= 0;

		if(this.appetizer!=null){
			total+=this.appetizer.getPrice();
		}
		if(this.beer!=null){
			total+=this.beer.getPrice();
		}
		if(this.entree!=null){
			total+=this.entree.getPrice();
		}
		if(this.side!=null){
			total+=this.side.getPrice();
		}

		return total;
	} 
	/**
	* Method dishDetail
	* @return all the information of dishes in the menu
	*/
	public String dishDetail(){
		String dishInfo = "";

		if(this.appetizer!=null){
			dishInfo+="Appetizer: "+this.appetizer.getName()+". "+this.appetizer.getDescription()+"."+this.appetizer.getCalories()+"."+this.appetizer.getPrice()+".\n";
		}
		else{
			dishInfo+="Appetizer: N/A\n";
		}

		if(this.entree!=null){
			dishInfo+="Entree: "+this.entree.getName()+". "+this.entree.getDescription()+"."+this.entree.getCalories()+"."+this.entree.getPrice()+".\n";
		}
		else{
			dishInfo+="Entree: N/A\n";
		}

		if(this.side!=null){
			dishInfo+="Side: "+this.side.getName()+". "+this.side.getDescription()+"."+this.side.getCalories()+"."+this.side.getPrice()+".\n";
		}
		else{
			dishInfo+="Side: N/A\n";
		}

		if(this.beer!=null){
			dishInfo+="Beer: "+this.beer.getName()+". "+this.beer.getDescription()+"."+this.beer.getCalories()+"."+this.beer.getPrice()+".\n";
		}
		else{
			dishInfo+="Beer: N/A\n";
		}

		return dishInfo;
	}
    //getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Appetizer getAppetizer() {
		return appetizer;
	}
	public void setAppetizer(Appetizer appetizer) {
		this.appetizer = appetizer;
	}
	public Entree getEntree() {
		return entree;
	}
	public void setEntree(Entree entree) {
		this.entree = entree;
	}
	public Side getSide() {
		return side;
	}
	public void setSide(Side side) {
		this.side = side;
	}
	public Beer getBeer() {
		return beer;
	}
	public void setBeer(Beer beer) {
		this.beer = beer;
	}
	@Override
	public String toString() {
		return this.name;
	}
	
}
