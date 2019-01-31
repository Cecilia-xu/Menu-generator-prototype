package edu.pitt.is18.xix64.menumanager;
import java.io.BufferedWriter;
/**
 * Class FileManager
 * author : Xiaoqian Xu
 * created: 11/13/2018
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {
	/**
	* Method readAppetizers
	* @param filename the file name about appetizer
	* @return an arraylist which concludes all menu items from the file
	*/
	public static ArrayList<MenuItem> readItems(String fileName) {
		ArrayList<MenuItem> menuList = new ArrayList<MenuItem>();
		try{	
			Scanner input = new Scanner(new File(fileName));

			while(input.hasNextLine()) {
				String info = input.nextLine();
				String a[] = info.split("@@");
				String name = a[0];
				String type = a[1];
				String desc = a[2];
				int cal = Integer.parseInt(a[3]);
				double pri = Double.parseDouble(a[4]);
				if (type.equals("appetizer")) {
					Appetizer appetizerItem = new Appetizer(name,desc,cal,pri);
					menuList.add(appetizerItem);
				}
				else if (type.equals("beer")) {
					Beer beerItem = new Beer(name,desc,cal,pri);
					menuList.add(beerItem);
				}
				else if (type.equals("entree")) {
					Entree entreeItem = new Entree(name,desc,cal,pri);
					menuList.add(entreeItem);
				}
				else {
					Side sideItem = new Side(name,desc,cal,pri);
					menuList.add(sideItem);
				}
			}
			input.close();
		}
		catch(FileNotFoundException fnfe){fnfe.printStackTrace();}
		return menuList;
	}
	
	public static void writeMenus(String fileName,ArrayList<Menu> menus) throws IOException  {
		File writename = new File(fileName); 
		writename.createNewFile(); 
		BufferedWriter out = new BufferedWriter(new FileWriter(writename));
		
		String output = "";
		for (int i=0; i < menus.size(); i++) {
			String menuName = menus.get(i).getName();
			output += "Menu Name:"+menuName+"/n";
			String dishes = menus.get(i).dishDetail();
			output += "Details of dishes:"+dishes+"/n";
			int sumCal = menus.get(i).sumCalories();
			output +="Sum of calories:"+sumCal+"/n";
			double totalPri = menus.get(i).totalPrice();
			output +="Total price:"+totalPri+"/n";
		}
		out.write(output); 
		out.flush(); 
		out.close(); 

	}


}


