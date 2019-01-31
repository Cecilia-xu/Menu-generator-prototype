package edu.pitt.is18.xix64.menumanager;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class MenuManagerGUI extends JFrame {
	
	/**
	 * Global variables representing SWING controls for the parent frame
	 */
	private JFrame parentFrame;
	private JLabel buildInfo;
	private JLabel generateInfo;
	private JLabel createInfo;
	private JLabel labelE;
	private JLabel labelS;
	private JLabel labelA;
	private JLabel labelB;
	private JComboBox<String> cboE;
	private JComboBox<String> cboS;
	private JComboBox<String> cboA;
	private JComboBox<String> cboB;
	private JList<String> menuList;
	private JButton btnCreate;
	private JButton btnRandom;
	private JButton btnMin;
	private JButton btnMax;
	private JButton btnDetails;
	private JButton btnDeleteAll;
	private JButton btnSaveToFile;
	
	/**
	 * Global variables representing SWING controls for the child frame
	 */
	private JFrame childFrame;
	private JLabel lblE;
	private JLabel lblS;
	private JLabel lblA;
	private JLabel lblB;
	private JLabel lblTotalCalories;
	private JLabel lblTotalPrice;		
	private JTextField textFieldE;
	private JTextField textFieldS;
	private JTextField textFieldA;
	private JTextField textFieldB;
	private JTextField textFieldCalories;
	private JTextField textFieldTotalPrice;
	
	private MenuManager mm;
	private ArrayList<Menu> myMenuLists;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MenuManagerGUI window = new MenuManagerGUI();
		window.parentFrame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public MenuManagerGUI(){
		initParentFrame();
		this.mm = new MenuManager("data/dishes.txt");
		this.myMenuLists = new ArrayList<Menu>();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initParentFrame(){
		parentFrame = new JFrame("Menu Manager");
		parentFrame.setBounds(100, 100, 1055, 698);
		parentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		parentFrame.getContentPane().setLayout(null);
		
		buildInfo = new JLabel("Build your own menu");
		buildInfo.setFont(new Font("Calibri", Font.PLAIN, 20));
		buildInfo.setBounds(77, 16, 202, 30);
		parentFrame.getContentPane().add(buildInfo);
		
		labelE = new JLabel("Entree");
		labelE.setBounds(77, 61, 105, 30);
		parentFrame.getContentPane().add(labelE);
		
		labelS = new JLabel("Side");
		labelS.setBounds(77, 116, 105, 30);
		parentFrame.getContentPane().add(labelS);
		
		
		labelA = new JLabel("Salad");
		labelA.setBounds(77, 171, 105, 30);
		parentFrame.getContentPane().add(labelA);
		
		labelB = new JLabel("Dessert");
		labelB.setBounds(77, 226, 105, 30);
		parentFrame.getContentPane().add(labelB);
		
		ArrayList<Entree> entreeAll = mm.getEntrees();
		for (int i = 0; i < entreeAll.size(); i++) {
			cboB.addItem(entreeAll.get(i).getName());
		}
		cboE.setBounds(183, 61, 255, 30);
		cboE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		parentFrame.getContentPane().add(cboE);

		cboS = new JComboBox<String>();
		cboS.setBounds(183, 116, 255, 30);
		ArrayList<String> sideNames = new ArrayList<String>();
		for (int i = 0; i < mm.getSides().size(); i++) {
		      sideNames.add(mm.getSides().get(i).getName());
		}
		for(String sideName : sideNames){
			cboS.addItem(sideName);
		}
		cboS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		parentFrame.getContentPane().add(cboS);
		
		cboA = new JComboBox<String>();
		cboA.setBounds(183, 171, 255, 30);
		ArrayList<String> appetizerNames = new ArrayList<String>();
		for (int i = 0; i < mm.getAppetizers().size(); i++) {
			appetizerNames.add(mm.getAppetizers().get(i).getName());
		}
		for(String appetizerName : appetizerNames){
			cboA.addItem(appetizerName);
		}
		cboA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		parentFrame.getContentPane().add(cboA);
		
		cboB = new JComboBox<String>();
		cboB.setBounds(183, 226, 255, 30);
		ArrayList<String> beerNames = new ArrayList<String>();
		for (int i = 0; i < mm.getBeers().size(); i++) {
		      beerNames.add(mm.getBeers().get(i).getName());
		}
		for(String beerName : beerNames){
			cboE.addItem(beerName);
		}
		cboB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		parentFrame.getContentPane().add(cboB);
			
		btnCreate = new JButton("Create menu with these dishes");
		btnCreate.setBounds(77, 283, 360, 40);
		btnCreate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				createMenu();
			}
		});
		parentFrame.getContentPane().add(btnCreate);
		
		generateInfo = new JLabel("Generate a menu");
		generateInfo.setFont(new Font("Calibri", Font.PLAIN, 20));
		generateInfo.setBounds(77, 370, 202, 30);
		parentFrame.getContentPane().add(generateInfo);
		
		btnRandom = new JButton("Generate a random menu");
		btnRandom.setBounds(74, 415, 360, 40);
		btnRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				randomMenu();
			}
		});
		parentFrame.getContentPane().add(btnRandom);
		
		btnMin = new JButton("Generate a minimum calories menu");
		btnMin.setBounds(74, 480, 360, 40);
		btnMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minMenu();
			}
		});
		parentFrame.getContentPane().add(btnMin);
		
		btnMax = new JButton("Generate a maximum calories menu");
		btnMax.setBounds(74, 547, 360, 40);
		btnMax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maxMenu();
			}
		});
		parentFrame.getContentPane().add(btnMax);
		
		createInfo = new JLabel("Created menus");
		createInfo.setFont(new Font("Calibri", Font.PLAIN, 20));
		createInfo.setBounds(509, 16, 202, 30);
		parentFrame.getContentPane().add(createInfo);
		
		menuList = new JList<String>();
		menuList.setBounds(509, 53, 438, 465);
		parentFrame.getContentPane().add(menuList);
		
		btnDetails = new JButton("Details");
		btnDetails.setBounds(509, 547, 140, 40);
		btnDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				detail();
			}
		});
		parentFrame.getContentPane().add(btnDetails);
		
		btnDeleteAll = new JButton("Delete all");
		btnDeleteAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnDeleteAll.setBounds(658, 547, 140, 40);
		parentFrame.getContentPane().add(btnDeleteAll);
	
		btnSaveToFile = new JButton("Save to file");
		btnSaveToFile.setBounds(807, 547, 140, 40);
		btnSaveToFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					save();
				} catch (Exception e1) {
					
				}
			}
		});
		parentFrame.getContentPane().add(btnSaveToFile);
	
	}
	
	private void initChildFrame(Menu myMenu, String name){
		childFrame = new JFrame(name);
		childFrame.setBounds(100, 100, 875, 605);
		childFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		childFrame.getContentPane().setLayout(null);
		childFrame.setVisible(false);
			
		textFieldE = new JTextField();
		textFieldE.setBounds(199, 46, 627, 74);
		textFieldE.setEditable(false);
		Entree infoE = myMenu.getEntree();
		textFieldE.setText(infoE.getName()+"/n"+infoE.getDescription()+"/n"+infoE.getPrice()+"/n"+infoE.getCalories()+"/n");
		childFrame.getContentPane().add(textFieldE);
		
		
		textFieldS = new JTextField();
		textFieldS.setBounds(199, 135, 627, 74);
		textFieldS.setEditable(false);
		Side infoS = myMenu.getSide();
		textFieldS.setText(infoS.getName()+"/n"+infoS.getDescription()+"/n"+infoS.getPrice()+"/n"+infoS.getCalories()+"/n");
		childFrame.getContentPane().add(textFieldS);
		
		textFieldA = new JTextField();
		textFieldA.setBounds(199, 224, 627, 74);
		textFieldA.setEditable(false);
		Appetizer infoA = myMenu.getAppetizer();
		textFieldA.setText(infoA.getName()+"/n"+infoA.getDescription()+"/n"+infoA.getPrice()+"/n"+infoA.getCalories()+"/n");
		childFrame.getContentPane().add(textFieldA);
		
		textFieldB = new JTextField();
		textFieldB.setBounds(199, 312, 627, 74);
		textFieldB.setEditable(false);
		Beer infoB = myMenu.getBeer();
		textFieldE.setText(infoB.getName()+"/n"+infoB.getDescription()+"/n"+infoB.getPrice()+"/n"+infoB.getCalories()+"/n");
		childFrame.getContentPane().add(textFieldB);
		
		textFieldCalories = new JTextField();
		textFieldCalories.setEditable(false);
		int sum = myMenu.sumCalories();
		textFieldCalories.setText(sum+"");
		textFieldCalories.setBounds(199, 404, 165, 45);
		childFrame.getContentPane().add(textFieldCalories);
		
		textFieldTotalPrice = new JTextField();
		textFieldTotalPrice.setEditable(false);
		double total = myMenu.totalPrice();
		textFieldCalories.setText(total+"");
		textFieldTotalPrice.setBounds(199, 464, 165, 45);
		childFrame.getContentPane().add(textFieldTotalPrice);
		
		lblE = new JLabel("Entree");
		lblE.setBounds(41, 72, 81, 21);
		childFrame.getContentPane().add(lblE);
		
		lblS = new JLabel("Side");
		lblS.setBounds(41, 161, 81, 21);
		childFrame.getContentPane().add(lblS);
		
		lblA = new JLabel("Salad");
		lblA.setBounds(41, 249, 81, 21);
		childFrame.getContentPane().add(lblA);
		
		lblB = new JLabel("Dessert");
		lblB.setBounds(41, 338, 81, 21);
		childFrame.getContentPane().add(lblB);
		
		lblTotalCalories = new JLabel("Total Calories:");
		lblTotalCalories.setBounds(41, 416, 143, 21);
		childFrame.getContentPane().add(lblTotalCalories);
		
		lblTotalPrice = new JLabel("Total Price: $");
		lblTotalPrice.setBounds(41, 476, 143, 21);
		childFrame.getContentPane().add(lblTotalPrice);		
	}
	
	/**
	 * Add events
	 */
	
	//Input the name of the menu
	public String getMenuName(){
		return JOptionPane.showInputDialog("Please input the name of the menu:");
	}
	
	//Update list of all the menus
	public void updateList() {
		ArrayList<String> myMenu = new ArrayList<String>();
		for(int i = 0; i < myMenuLists.size(); i++) {
			myMenu.add(myMenuLists.get(i).toString()) ;
		}
		menuList.setListData((String[]) myMenu.toArray());
	}
	
	//Create your own menu
	public void createMenu() {
		String name = getMenuName();
		if(name != null){
			Appetizer appetizer = null;
			Entree entree = null;
			Side side = null;
			Beer beer = null;
			
			if(cboE.getSelectedIndex() > 0){
				entree = mm.getEntrees().get(cboE.getSelectedIndex()-1);
			}
			if(cboS.getSelectedIndex() > 0){
				side = mm.getSides().get(cboS.getSelectedIndex()-1);
			}
			if(cboA.getSelectedIndex() > 0){
				appetizer = mm.getAppetizers().get(cboA.getSelectedIndex()-1);
			}
			if(cboB.getSelectedIndex() > 0){
				beer = mm.getBeers().get(cboB.getSelectedIndex()-1);
			}
			
			Menu newMenu = new Menu(name,entree,side,appetizer,beer);
			myMenuLists.add(newMenu);
			updateList();
		}
	}
	
	//Generate a random menu
	public void randomMenu() {
		String name = getMenuName();
		if(name != null){
			Menu newMenu = mm.randomMenu(name);
			myMenuLists.add(newMenu);
			updateList();
		}
	}
	
	//Generate a menu which has minimum calories 
	public void minMenu() {
		String name = getMenuName();
		if(name != null){
			Menu newMenu = mm.minCaloriesMenu(name);
			myMenuLists.add(newMenu);
			updateList();
		}
	}
	
	//Generate a menu which has maximum calories 
	public void maxMenu() {
		String name = getMenuName();
		if(name != null){
			Menu newMenu = mm.maxCaloriesMenu(name);
			myMenuLists.add(newMenu);
			updateList();
		}
	}
	
	//Detail of each menu
	public void detail() {
		if(myMenuLists.size() !=0 ) {
			if (menuList.getSelectedIndex() != 0) {
				Menu menuSelected = myMenuLists.get(menuList.getSelectedIndex());
			    initChildFrame(menuSelected,"myMenu");
				} else {
					JOptionPane.showMessageDialog(null, "Please select a menu");
				}
			} else {
				JOptionPane.showMessageDialog(null, "No menu");
			}
	}
	
	//delete all the menu
	public void delete() {
		myMenuLists.clear();
		updateList();
	}
	
	//Save the menu to the file
	public void save() throws Exception {
		FileManager.writeMenus("data/menuList.txt", myMenuLists);
	}
}
