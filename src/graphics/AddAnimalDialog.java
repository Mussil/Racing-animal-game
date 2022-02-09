package graphics;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.*;

import animals.*;
import competitions.CourierTournament;
import competitions.RegularTournament;
import competitions.Tournament;
import olympics.Medal;

public class AddAnimalDialog extends JDialog implements ActionListener {
	private ZooPanel pan;
	private JFrame parent;
	private JRadioButton r_dol;
	private JRadioButton r_ali;
	private JRadioButton r_cat;
	private JRadioButton r_dog;
	private JRadioButton r_snake;
	private JRadioButton r_eagle;
	private JRadioButton r_pigeon;
	private JRadioButton r_whale;
	private JRadioButton r_ali_te;

	
	
	private JButton but;
	private JButton but2;
	private JButton but3;

	
	private String typeOfComp;

	private int numOfGroups=-1;
	private ArrayList<ArrayList<IAnimal>> matrix = new ArrayList<ArrayList<IAnimal>>();  

	
	public AddAnimalDialog(JFrame f,ZooPanel pan,String typeOfComp) {
		super(f , "Add Animal Dialog", true);  
		this.pan=pan;
		this.parent=f;
		this.typeOfComp=typeOfComp;
		


		JLabel text=new JLabel("chose your animal: ");
		text.setBounds(100,20,300,30);
		text.setFont(new Font("Ariel", Font.BOLD, 24));

		//water
		JLabel water =new JLabel("Water");
		water.setBounds(100,70,100,30);
		add(water);

		
		r_dol=new JRadioButton("Dolphin");    
		r_ali=new JRadioButton("Alligator"); 
		r_whale=new JRadioButton("Whale"); 
		r_dol.setBounds(75,130,100,30);    
		r_ali.setBounds(75,180,100,30);    
		r_whale.setBounds(75,230,100,30);  

		ButtonGroup bg=new ButtonGroup();    
		bg.add(r_dol);
		bg.add(r_ali); 
		bg.add(r_whale);  
		add(text);
		add(r_dol);
		add(r_ali);  
		add(r_whale);

		//terrestrial
		JLabel terrestrial =new JLabel("Terrestrial");
		terrestrial.setBounds(250,70,100,30);
		add(terrestrial);
		r_cat=new JRadioButton("Cat"); 
		r_dog=new JRadioButton("Dog"); 
		r_snake=new JRadioButton("Snake"); 
		//r_ali_te=new JRadioButton("Alligator"); 

		r_cat.setBounds(225,130,100,30);    
		r_dog.setBounds(225,180,100,30);  
		r_snake.setBounds(225,230,100,30);  
		//r_ali_te.setBounds(225,280,100,30);  

		bg.add(r_cat);
		bg.add(r_dog);  
		bg.add(r_snake);  
		//bg.add(r_ali_te);  
		add(r_cat);
		add(r_dog);
		add(r_snake);
		//add(r_ali_te);

		
		
		//air
		JLabel air =new JLabel("Air");
		air.setBounds(400,70,100,30);
		add(air);
		
		r_eagle=new JRadioButton("Eagle"); 
		r_pigeon=new JRadioButton("Pigeon"); 
		r_eagle.setBounds(375,130,100,30);    
		r_pigeon.setBounds(375,180,100,30);  
		bg.add(r_eagle);
		bg.add(r_pigeon);  
		add(r_eagle);
		add(r_pigeon);
		


		setEnabledAnimalsButtons();
		
		but=new JButton("new group");    
		but.setBounds(0,0,100,30);    
        but.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                		but2.setEnabled(true);
                		but.setEnabled(false);
                		but3.setEnabled(false);
                		
                		r_dol.setEnabled(true);
                		r_ali.setEnabled(true);
                		r_whale.setEnabled(true);
                		r_cat.setEnabled(true);
                		r_dog.setEnabled(true);
                		r_snake.setEnabled(true);
                		//r_ali_te.setEnabled(true);
                		r_eagle.setEnabled(true);
                		r_pigeon.setEnabled(true);
                    	numOfGroups++;
                    	matrix.add(new ArrayList<IAnimal>());
            			JOptionPane.showMessageDialog(pan,"new group has created"); 


                    }
                });		
        add(but);
		
		
		
		
		but2=new JButton("add animal to the group");    
		but2.setBounds(350,230,200,30);    
		but2.addActionListener(this);
		add(but2);
		but2.setEnabled(false);
		
		but3=new JButton("create competition");    
		but3.setBounds(350,330,200,30);    
		if (numOfGroups<0) {
			but3.setEnabled(false);
		}
		but3.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
  
              
                    	Tournament t=null;
                    	if(typeOfComp=="Regular") {
                    		t=new RegularTournament(matrix);
                    	}
                    	else if(typeOfComp=="Courier") {
                    		t=new CourierTournament(matrix);
                    	}
                    	pan.addTournament(t);
            			JOptionPane.showMessageDialog(pan,"new competition has createad"); 
            			dispose();

                    }
                });	
		add(but3);
		
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
        		if(numOfGroups<0) {
        			dispose();
        		}
        		else {
        			JOptionPane.showMessageDialog(pan,"can not exit in process, please finsh create the competition"); 

        		}
            }
        });

		
        setBounds(400,300,600,450);
		setLayout(null);    
        //pack();
        setVisible(true);	
	}

	
	private void setEnabledAnimalsButtons() {
		r_dol.setEnabled(false);
		r_ali.setEnabled(false);
		r_whale.setEnabled(false);
		r_cat.setEnabled(false);
		r_dog.setEnabled(false);
		r_snake.setEnabled(false);
		//r_ali_te.setEnabled(false);
		r_eagle.setEnabled(false);
		r_pigeon.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (typeOfComp=="Regular") {
			setEnabledAnimalsButtons();
			but2.setEnabled(false);
		}

		if (numOfGroups<0) {
			JOptionPane.showMessageDialog(this,"first create new group"); 
			return;
		}
		else {
			but3.setEnabled(true);
		}
		

		
		
		CreateAnimal create=new CreateAnimal(parent,pan,matrix.get(numOfGroups));
		try {
			//water
			if(r_dol.isSelected()){  
				if (typeOfComp=="Courier" && matrix.get(numOfGroups).size()>0 && !(matrix.get(numOfGroups).get(0) instanceof WaterAnimal) ) {//!=water
					throw(new Exception());
				}
				create.createDolphin();
				
			}
			else if(r_whale.isSelected()) {
				if (typeOfComp=="Courier" && matrix.get(numOfGroups).size()>0 && !(matrix.get(numOfGroups).get(0) instanceof WaterAnimal) ) {//!=water
					throw(new Exception());
				}
				create.createWhale();

			}
	
			else if(r_ali.isSelected()) {
				if (typeOfComp=="Courier" && matrix.get(numOfGroups).size()>0 && !(matrix.get(numOfGroups).get(0) instanceof WaterAnimal) ) {//!=water
					throw(new Exception());
				}
				create.createAligator("Water");
			}
			
			//ter
			else if(r_cat.isSelected()) {
				if (typeOfComp=="Courier" && matrix.get(numOfGroups).size()>0 && !(matrix.get(numOfGroups).get(0) instanceof TerrestrialAnimals) ) {//!=water
					throw(new Exception());
				}
				create.createCat();
			}
			else if(r_dog.isSelected()) {
				if (typeOfComp=="Courier" && matrix.get(numOfGroups).size()>0 && !(matrix.get(numOfGroups).get(0) instanceof TerrestrialAnimals) ) {//!=water
					throw(new Exception());
				}
				create.createDog();
			}
			else if(r_snake.isSelected()) {
				if (typeOfComp=="Courier" && matrix.get(numOfGroups).size()>0 && !(matrix.get(numOfGroups).get(0) instanceof TerrestrialAnimals) ) {//!=water
					throw(new Exception());
				}
				create.createSnake();
			}
			
//			else if(r_ali_te.isSelected()) {
//				if (typeOfComp=="Courier" && matrix.get(numOfGroups).size()>0 && !(matrix.get(numOfGroups).get(0) instanceof TerrestrialAnimals) ) {//!=water
//					throw(new Exception());
//				}
//				create.createAligator("Terrestrial");
//			}
			
			
			
			//air
			else if(r_eagle.isSelected()) {
				if (typeOfComp=="Courier" && matrix.get(numOfGroups).size()>0 && !(matrix.get(numOfGroups).get(0) instanceof AirAnimal) ) {//!=water
					throw(new Exception());
				}
				create.createEagle();
			}
			else if(r_pigeon.isSelected()) {
				if (typeOfComp=="Courier" && matrix.get(numOfGroups).size()>0 && !(matrix.get(numOfGroups).get(0) instanceof AirAnimal) ) {//!=water
					throw(new Exception());
				}
				create.createPigeon();
			}

			else {
				but3.setEnabled(false);
				matrix.remove(matrix.size()-1);
				JOptionPane.showMessageDialog(this,"you forgat to chose animal"); 
				numOfGroups--;
			}
			

			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(this,"the animal doesnt fit to the group"); 

		}	
		
		but.setEnabled(true);


		
	
		} 
}
