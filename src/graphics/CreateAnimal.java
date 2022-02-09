package graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.*;

import animals.*;
import mobilty.Point;
import olympics.Medal;


//this JDialog is for create all types of animals

public class CreateAnimal extends JDialog  implements ActionListener {
	private JFrame parent;
	private ZooPanel pan;
	private String category;
	private String typeOfAnimal;

	
	private JLabel l_name;
	private JTextField t_name;
	private JLabel l_weight;
	private JTextField t_weight;
	private JLabel l_speed;
	private JTextField t_speed;
	private JLabel l_gender;
	private JRadioButton r1;
	private JRadioButton r2;
	private JButton b;
	private JLabel l_maxEnergy;
	private JTextField t_maxEnergy;
	private JLabel l_energyPerMeter;
	private JTextField t_energyPerMeter;
	private JLabel l_diveDept;
	private JTextField t_diveDept;
	private JLabel l_waterType;
	private JRadioButton r_see;
	private JRadioButton r_sweet;
	private JLabel l_foodType;
	private JTextField t_foodType;
	private JLabel l_wingspan;
	private JTextField t_wingspan;
	private JLabel l_altitudeOfFlight;
	private JTextField t_altitudeOfFlight;
	private JLabel l_family;
	private JTextField t_family;
	private JLabel l_noLegs;
	private JTextField t_noLegs;
	private JLabel l_Castrated;
	private JRadioButton r_false;
	private JRadioButton r_true;
	private JLabel l_breed;
	private JTextField t_breed;
	private JLabel l_length;
	private JTextField t_length;
	private JLabel l_poisonous;
	private JRadioButton r_Low;
	private JRadioButton r_Medium;
	private JRadioButton r_High;
	private JLabel l_areaOfLiving;
	private JTextField t_areaOfLiving;
	private JLabel l_route;
	private JRadioButton r_r1;
	private JRadioButton r_r2;
	private JRadioButton r_r3;
	private JRadioButton r_r4;
	private JRadioButton r_r5;
	
	
	private ArrayList<IAnimal> arrayList;

	
	
	public CreateAnimal(JFrame f,ZooPanel pan, ArrayList<IAnimal> arrayList) {
		super(f , "Add Animal Dialog", true);  
		this.parent=f;
		this.pan=pan;
		this.arrayList=arrayList;


	}


	public void createGeneral() {
	    //name
		l_name=new JLabel("enter name:");
		l_name.setBounds(30,30,100,30);    
		add(l_name);
		t_name=new JTextField();
		t_name.setBounds(200,30,100,30);    
		add(t_name);
	    
		//gender
		l_gender=new JLabel("enter gender:");
		l_gender.setBounds(30,60,100,30);    
		add(l_gender);
		r1=new JRadioButton("A) Female"); 
		r1.setBounds(200,60,100,30);    
		add(r1);
		r2=new JRadioButton("B) Male");  
		r2.setBounds(300,60,100,30);    
		add(r2);
		ButtonGroup bg=new ButtonGroup();    
		bg.add(r1);
		bg.add(r2); 
		
		
		//weight
		l_weight=new JLabel("enter weight:");
		l_weight.setBounds(30,90,100,30);    
		add(l_weight);
		t_weight=new JTextField();
		t_weight.setBounds(200,90,100,30);    
		add(t_weight);
		
		//speed
		l_speed=new JLabel("enter speed:");
		l_speed.setBounds(30,120,100,30);    
		add(l_speed);
		t_speed=new JTextField();
		t_speed.setBounds(200,120,100,30);    
		add(t_speed);
		
		//maxEnergy
		l_maxEnergy=new JLabel("enter max Energy:");
		l_maxEnergy.setBounds(30,150,150,30);    
		add(l_maxEnergy);
		t_maxEnergy=new JTextField();
		t_maxEnergy.setBounds(200,150,100,30);    
		add(t_maxEnergy);
		
		//energyPerMeter
		l_energyPerMeter=new JLabel("enter energy Per Meter:");
		l_energyPerMeter.setBounds(30,180,150,30);    
		add(l_energyPerMeter);
		t_energyPerMeter=new JTextField();
		t_energyPerMeter.setBounds(200,180,100,30);    
		add(t_energyPerMeter);
		
		
		
		//button
		b=new JButton("DONE");
		b.setBounds(30,600,100,30);
		b.addActionListener(this);

		add(b);
		
		
		
        setBounds(400,300,500,700);
		setLayout(null);    
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //pack();
	}
	public void createWater() {
		category="Water";
		//diveDept
		l_diveDept=new JLabel("enter dive Dept:");
		l_diveDept.setBounds(30,210,100,30);    
		add(l_diveDept);
		t_diveDept=new JTextField();
		t_diveDept.setBounds(200,210,100,30);    
		add(t_diveDept);
		
		
		
		//route
		l_route=new JLabel("chose route:");
		l_route.setForeground(Color.red);
		l_route.setBounds(30,400,100,30);    
		add(l_route);
		r_r1=new JRadioButton("1"); 
		r_r1.setBounds(200,400,30,30);    
		add(r_r1);
		r_r2=new JRadioButton("2");  
		r_r2.setBounds(250,400,30,30);    
		add(r_r2);
		add(l_diveDept);
		r_r3=new JRadioButton("3"); 
		r_r3.setBounds(300,400,30,30);    
		add(r_r3);
		r_r4=new JRadioButton("4");  
		r_r4.setBounds(350,400,30,30);    
		add(r_r4);
		
		
		
		ButtonGroup bg=new ButtonGroup();    
		bg.add(r_r1);
		bg.add(r_r2); 
		bg.add(r_r3); 
		bg.add(r_r4); 

		
	}
	
	
	public void createDolphin() {
		typeOfAnimal="Dolphin";
		createGeneral();
		createWater();
		
	
		l_waterType=new JLabel("enter water type:");
		l_waterType.setBounds(30,240,150,30);    
		add(l_waterType);
		r_see=new JRadioButton("A) see"); 
		r_see.setBounds(200,240,100,30);    
		add(r_see);
		r_sweet=new JRadioButton("B) sweet");  
		r_sweet.setBounds(300,240,100,30);    
		add(r_sweet);
		ButtonGroup bg=new ButtonGroup();    
		bg.add(r_see);
		bg.add(r_sweet); 
		
		
		
        setVisible(true);	

	}
	
	public void createWhale() {
		typeOfAnimal="Whale";
		createGeneral();
		createWater();
	
		
		l_foodType=new JLabel("enter food type:");
		l_foodType.setBounds(30,240,150,30);    
		add(l_foodType);
		t_foodType=new JTextField();
		t_foodType.setBounds(200,240,100,30);    
		add(t_foodType);
		
        setVisible(true);	
		
	}

	public void createAir() {
		category="Air";
		//diveDept
		l_wingspan=new JLabel("enter wingspan:");
		l_wingspan.setBounds(30,210,100,30);    
		add(l_wingspan);
		t_wingspan=new JTextField();
		t_wingspan.setBounds(200,210,100,30);    
		add(t_wingspan);
		
		
		
		
		
		//route
		l_route=new JLabel("chose route:");
		l_route.setForeground(Color.red);
		l_route.setBounds(30,400,100,30);    
		add(l_route);
		r_r1=new JRadioButton("1"); 
		r_r1.setBounds(200,400,30,30);    
		add(r_r1);
		r_r2=new JRadioButton("2");  
		r_r2.setBounds(250,400,30,30);    
		add(r_r2);
		add(r_r2);
		r_r3=new JRadioButton("3"); 
		r_r3.setBounds(300,400,30,30);    
		add(r_r3);
		r_r4=new JRadioButton("4");  
		r_r4.setBounds(350,400,30,30);    
		add(r_r4);
		r_r5=new JRadioButton("5");  
		r_r5.setBounds(400,400,30,30);    
		add(r_r5);
		
		
		ButtonGroup bg=new ButtonGroup();    
		bg.add(r_r1);
		bg.add(r_r2); 
		bg.add(r_r3); 
		bg.add(r_r4); 
		bg.add(r_r5); 

	}
	
	public void createEagle() {
		typeOfAnimal="Eagle";
		createGeneral();
		createAir();
	
		
		l_altitudeOfFlight=new JLabel("enter altitudeOfFlight:");
		l_altitudeOfFlight.setBounds(30,240,150,30);    
		add(l_altitudeOfFlight);
		t_altitudeOfFlight=new JTextField();
		t_altitudeOfFlight.setBounds(200,240,100,30);    
		add(t_altitudeOfFlight);
		
        setVisible(true);	
		
	}
	
	public void createPigeon() {
		typeOfAnimal="Pigeon";
		createGeneral();
		createAir();
	
		
		l_family=new JLabel("enter family:");
		l_family.setBounds(30,240,150,30);    
		add(l_family);
		t_family=new JTextField();
		t_family.setBounds(200,240,100,30);    
		add(t_family);
		
        setVisible(true);	
		
	}
	

	public void createTerrestrial() {
		category="Terrestrial";
		//noLegs
		l_noLegs=new JLabel("enter noLegs:");
		l_noLegs.setBounds(30,210,100,30);    
		add(l_noLegs);
		t_noLegs=new JTextField();
		t_noLegs.setBounds(200,210,100,30);    
		add(t_noLegs);
	}
	
	public void createCat() {
		typeOfAnimal="Cat";
		createGeneral();
		createTerrestrial();
		
		
		l_Castrated=new JLabel("is it Castrated:");
		l_Castrated.setBounds(30,240,150,30);    
		add(l_Castrated);
		r_false=new JRadioButton("A) False"); 
		r_false.setBounds(200,240,100,30);    
		add(r_false);
		r_true=new JRadioButton("B) True");  
		r_true.setBounds(300,240,100,30);    
		add(r_true);
		ButtonGroup bg=new ButtonGroup();    
		bg.add(r_false);
		bg.add(r_true); 

		
        setVisible(true);	
		
	}
	
	public void createDog() {
		typeOfAnimal="Dog";
		createGeneral();
		createTerrestrial();
		
		
		l_breed=new JLabel("enter breed:");
		l_breed.setBounds(30,240,150,30);    
		add(l_breed);

		t_breed=new JTextField();
		t_breed.setBounds(200,240,100,30);    
		add(t_breed);
		
		
        setVisible(true);	
		
	}
	

	public void createAligator(String whichComp) {
		typeOfAnimal="Alligator";
		createGeneral();
		createWater();
		category=whichComp; // ter or water
		//noLegs for ter
		l_noLegs=new JLabel("enter noLegs:");
		l_noLegs.setBounds(30,240,100,30);    
		add(l_noLegs);
		t_noLegs=new JTextField();
		t_noLegs.setBounds(200,240,100,30);    
		add(t_noLegs);
		
		//ali
		l_areaOfLiving=new JLabel("enter area Of Living:");
		l_areaOfLiving.setBounds(30,270,150,30);    
		add(l_areaOfLiving);
		t_areaOfLiving=new JTextField();
		t_areaOfLiving.setBounds(200,270,100,30);    
		add(t_areaOfLiving);
		
        setVisible(true);	

		
	}
	
	public void createSnake() {

		
		
		typeOfAnimal="Snake";
		createGeneral();
		createTerrestrial();
		
		
		l_poisonous=new JLabel("poisonous:");
		l_poisonous.setBounds(30,240,150,30);    
		add(l_poisonous);
		r_Low=new JRadioButton("A) Low"); 
		r_Low.setBounds(200,240,100,30);    
		add(r_Low);
		r_Medium=new JRadioButton("B) Medium");  
		r_Medium.setBounds(300,240,100,30);    
		add(r_Medium);
		r_High=new JRadioButton("C) High");  
		r_High.setBounds(400,240,100,30);    
		add(r_High);
		
		l_length=new JLabel("enter length:");
		l_length.setBounds(30,270,150,30);    
		add(l_length);

		t_length=new JTextField();
		t_length.setBounds(200,270,100,30);    
		add(t_length);

		
		ButtonGroup bg=new ButtonGroup();    
		bg.add(r_Low);
		bg.add(r_Medium); 
		bg.add(r_High); 

		
        setVisible(true);	
		
	}
	@Override
	

	public void actionPerformed(ActionEvent arg0) {
		 String name;
		 Gender gender = null;
		 double weight;
		 double speed;
		 Medal[] arrMedal=null;
		 int maxEnergy;
		 int energyPerMeter;
		

		
		//general
		if(r1.isSelected()){  
			gender=Gender.FEMALE;
		}
		else if(r2.isSelected())
			gender=Gender.MALE;

		name=(t_name.getText().equals(""))?null:t_name.getText();

		try{
			weight=Double.parseDouble(t_weight.getText());
		}
		catch (NumberFormatException e1) {
			weight=0;
		}

		try {
			speed=Double.parseDouble(t_speed.getText());
		}
		catch (NumberFormatException e2) {
			speed=0;
		}
		
		try {
			maxEnergy=Integer.parseInt(t_maxEnergy.getText());
		}
		catch (NumberFormatException e2) {
			maxEnergy=0;
		}
		try {
			energyPerMeter=Integer.parseInt(t_energyPerMeter.getText());
		}
		catch (NumberFormatException e2) {
			energyPerMeter=0;
		}
		
		
		//route
		int route=1;
		
		if(category=="Water" || category=="Air") {
			if(r_r1.isSelected()) {
				route=1;
			}
			else if(r_r2.isSelected()) {
				route=2;
			}
			else if(r_r3.isSelected()) {
				route=3;
			}
			else if(r_r4.isSelected()) {
				route=4;
			}
			if(category=="Air" && r_r5.isSelected()) {
				route=5;
			}

		}
		
		
		
		
		
		double diveDept;
		int noLegs;
		Point point=null;
		
		
		switch(category) {
		
		case "Water":
			switch (route) {
			//pools
			case 1:
				point=new Point(100,110);
				break;
			case 2:
				point=new Point(100,300);
				break;
			case 3:
				point=new Point(100,490);
				break;
			case 4:
				point=new Point(100,670);
				break;
			}
			try {
				diveDept=Double.parseDouble(t_diveDept.getText());
			}
			catch (NumberFormatException e2) {
				diveDept=0;
			}
			
			//dolphin
			if(typeOfAnimal=="Dolphin") {
				Water waterType = null;

				if(r_see.isSelected()){  
					waterType=Water.SEA;
				}
				else if(r_sweet.isSelected())
					waterType=Water.SWEET;

				Dolphin d=new Dolphin(name,gender,weight,speed,arrMedal,point,diveDept,waterType,maxEnergy,energyPerMeter,pan);
				pan.addAnimalToVector(d);
				arrayList.add(d);


			}
			

			//whale
			else if(typeOfAnimal=="Whale") {
				String foodType;
				foodType=(t_foodType.getText().equals(""))?null:t_foodType.getText();

				Whale d=new Whale(name,gender,weight,speed,arrMedal,point,diveDept,foodType,maxEnergy,energyPerMeter,pan);
				pan.addAnimalToVector(d);
				arrayList.add(d);

			}
			break;
		
		
		case "Air":
			switch (route) {
			//pools
			case 1:
				point=new Point(45,20);
				break;
			case 2:
				point=new Point(45,200);
				break;
			case 3:
				point=new Point(45,385);
				break;
			case 4:
				point=new Point(45,570);
				break;
			case 5:
				point=new Point(45,750);
				break;
			}
			
			
			double wingspan;
			//point=new Point(50,200);
			try {
				wingspan=Double.parseDouble(t_wingspan.getText());
			}
			catch (NumberFormatException e2) {
				wingspan=0;
			}
			if(typeOfAnimal=="Eagle") {
				double altitudeOfFlight;

				try {
					altitudeOfFlight=Double.parseDouble(t_altitudeOfFlight.getText());
				}
				catch (NumberFormatException e2) {
					altitudeOfFlight=0;
				}
				Eagle d=new Eagle(name,gender,weight,speed,arrMedal,point,wingspan,altitudeOfFlight,maxEnergy,energyPerMeter,pan);
				pan.addAnimalToVector(d);
				arrayList.add(d);

			}
			
			if(typeOfAnimal=="Pigeon") {
				String family;
				family=(t_family.getText().equals(""))?null:t_family.getText();
				Pigeon d=new Pigeon(name,gender,weight,speed,arrMedal,point,wingspan,family,maxEnergy,energyPerMeter,pan);
				pan.addAnimalToVector(d);
				arrayList.add(d);

			}
			
			break;
		case "Terrestrial":
			point=new Point(0,10);
			try {
				noLegs=Integer.parseInt(t_noLegs.getText());
			}
			catch (NumberFormatException e2) {
				noLegs=0;
			}
			if(typeOfAnimal=="Cat") {
				boolean Castrated = false;

				if(r_false.isSelected()){  
					Castrated=false;
				}
				else if(r_true.isSelected())
					Castrated=true;

				Cat d=new Cat(name,gender,weight,speed,arrMedal,point,noLegs,Castrated,maxEnergy,energyPerMeter,pan);
				pan.addAnimalToVector(d);
				arrayList.add(d);

			}
			if(typeOfAnimal=="Dog") {
				String breed=(t_breed.getText().equals(""))?null:t_breed.getText();
				Dog d=new Dog(name,gender,weight,speed,arrMedal,point,noLegs,breed,maxEnergy,energyPerMeter,pan);
				pan.addAnimalToVector(d);
				arrayList.add(d);

			}
			if(typeOfAnimal=="Snake") {
				double length;
				try {
					length=Double.parseDouble(t_length.getText());
				}
				catch (NumberFormatException e2) {
					length=0;
				}
				
				Poisonous poisonous = null;

				if(r_Low.isSelected()){  
					poisonous=Poisonous.LOW;
				}
				else if(r_Medium.isSelected()){  
					poisonous=Poisonous.MEDIUM;
				}
				else if(r_High.isSelected()){  
					poisonous=Poisonous.HIGH;
				}

				Snake d=new Snake(name,gender,weight,speed,arrMedal,point,noLegs,poisonous,length,maxEnergy,energyPerMeter,pan);
				pan.addAnimalToVector(d);
				arrayList.add(d);

				
			}
			
			break;

		}
		
		
		//alligator
		if(typeOfAnimal=="Alligator") {
	
			
			try {
				noLegs=Integer.parseInt(t_noLegs.getText());
			}
			catch (NumberFormatException e2) {
				noLegs=0;
			}
			try {
				diveDept=Double.parseDouble(t_diveDept.getText());
			}
			catch (NumberFormatException e2) {
				diveDept=0;
			}
			
			String areaOfLiving=(t_areaOfLiving.getText().equals(""))?null:t_areaOfLiving.getText();

			Alligator d=new Alligator(name,gender,weight,speed,arrMedal,point,diveDept,areaOfLiving,noLegs,maxEnergy,energyPerMeter,pan);
			pan.addAnimalToVector(d);
			arrayList.add(d);

		}
		
		

		
		dispose();
		repaint();
    
	}

}
