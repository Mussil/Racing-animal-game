package graphics;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.*;

import animals.Animal;
import animals.Eagle;
import animals.Gender;
import competitions.Tournament;
import competitions.TournamentThread;
import mobilty.Point;
import olympics.Medal;

public class ZooPanel extends JPanel implements ActionListener{

	
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	
	private JButton button_for_scores;

	private JFrame parent;

	
	private BufferedImage background=null;
	private Vector<IAnimal> v; //contain all the animals that are in the panel


	private Vector<Tournament> allTournament;
	
	public ZooPanel(JFrame parent){
		this.parent=parent;

	    v = new Vector<IAnimal>();
	    //HW3
	    allTournament=new Vector<Tournament>();
	    

	    //set background
		try { background = ImageIO.read(new File("competitionBackground.png")); }
		catch (IOException e) { System.out.println("Cannot load image"); }

		
		
		

		///////////////////////buttons
		
		button1=new JButton("Competition");
		button1.setBounds(100,820,150,50);  
		add(button1);
		//button2=new JButton("Add Animal");
		//button2.setBounds(250,820,150,50);  
		//add(button2);
		
		button_for_scores=new JButton("Scores");
		button_for_scores.setBounds(250,820,150,50);  
		add(button_for_scores);
		//
		button3=new JButton("Clear");
		button3.setBounds(400,820,150,50);  
		add(button3);
		button4=new JButton("Eat");
		button4.setBounds(550,820,150,50);  
		add(button4);
		button5=new JButton("Info");
		button5.setBounds(700,820,150,50);  
		add(button5);
		button6=new JButton("Exit");
		button6.setBounds(850,820,150,50);  
		add(button6);


        button1.addActionListener(this);
        //button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button_for_scores.addActionListener(this);

		///////////////////////////////end buttons
		
		setLayout(null);
        setBounds(0, 0, 1190,871);
        
	}
	
	
	
	
	
	//HW3
	public void addTournament(Tournament newT) {
		allTournament.add(newT);
	}

	public Iterator  TournamentItertor() {
		return allTournament.iterator();
	}

	
	
	
	

	
	public Vector<IAnimal> getVector(){
		return v;
	}
	
	public void addAnimalToVector(Animal a) {
	    v.add(a);
	}

	


	
	

	
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
        g.drawImage(background,0,0,getWidth(),getHeight(), this);

        
        //each time go through the vector and paint the update animals
        synchronized(v) {
        	Enumeration<IAnimal> enumeration = v.elements();
            while(enumeration.hasMoreElements()) {
                Animal p = (Animal)(enumeration.nextElement());
                p.drawObject(g);
             }
        }
        


        
    }
	
	


    public void actionPerformed(ActionEvent e) {

        //add competition
    	if (e.getSource()==button1) {
    		new addCompetitionDialog(parent,this);            
        	repaint();

        }
    	//add animal
        if (e.getSource()==button2) {
           // new AddAnimalDialog(this,CompetitionPanel);   
        	repaint();

        }
        //clear button
        if (e.getSource()==button3) {
        	clearAll();

        }
        // eat button
        if (e.getSource()==button4) {
        	eat();
        }
        
        // the info button
        if (e.getSource()==button5) {
        	infoAll();
        }
        //the exit button
        if (e.getSource()==button6) {
            System.exit(0);
        }
        //HW3
        if (e.getSource()==button_for_scores) {
        	Iterator iter=TournamentItertor();
            while (iter.hasNext()) { 
                ((Tournament) iter.next()).getTournamentThread().competitionInfo(); 
            } 
        }
        
    }
    
    /**
     * the user will chose animal and it will send him to EatDialog to feed it
     */
    public void eat() {
    	
    	Vector<IAnimal> v=getVector();
		JDialog d=new JDialog();
		if (v.isEmpty()) {
			JOptionPane.showMessageDialog(this,"there are no animals"); 
			return;
		}
		d.setTitle("eat");

		String [] names=new String [v.size()];
		int i=0;
        Enumeration<IAnimal> enumeration = v.elements();
        while(enumeration.hasMoreElements()) {
           names[i]=((Animal) (enumeration.nextElement())).getAnimalName();
           i++;
        }
		
		JButton b=new JButton("submit");  
	    b.setBounds(250,50,75,20); 
	    JComboBox cb=new JComboBox(names);    
	    cb.setBounds(50, 50,120,20);    
	    d.add(cb);
	    d.add(b);
	    d.setLayout(null);    
	    
		
	    b.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {     
	        		int i=cb.getSelectedIndex();
	        		IAnimal a=v.elementAt(i);
	        		new EatDialog(d,a);
	        }  
	    });  
		
		d.setVisible(true);
		d.setBounds(400,400,400,200);

    }
    
    /*
     * from a list chose a animal to remove 
     */
    public void clearAll() {
     	Vector<IAnimal> v=getVector();
    		JDialog d=new JDialog();
    		if (v.isEmpty()) {
    			JOptionPane.showMessageDialog(this,"there are no animals"); 
    			return;
    		}
    		d.setTitle("clear");

    		String [] names=new String [v.size()];
    		int i=0;
            Enumeration<IAnimal> enumeration = v.elements();
            while(enumeration.hasMoreElements()) {
               names[i]=((Animal) (enumeration.nextElement())).getAnimalName();
               i++;
            }
    		
    		JButton b=new JButton("clear");  
    	    b.setBounds(250,50,75,20); 
    	    JComboBox cb=new JComboBox(names);    
    	    cb.setBounds(50, 50,120,20);    
    	    d.add(cb);
    	    d.add(b);
    	    d.setLayout(null);    
    	    
    		
    	    b.addActionListener(new ActionListener() {  
    	        public void actionPerformed(ActionEvent e) {     
    	        		int i=cb.getSelectedIndex();
    	        		v.remove(i);
    	    			JOptionPane.showMessageDialog(d,"the animel removed"); 
    	            	repaint();

    	        		d.dispose();
    	        }  
    	    });  
    		
    		d.setVisible(true);
    		d.setBounds(400,400,400,200);
    }
    
    public void infoAll() {
    	Vector<IAnimal> v=getVector();
		JDialog d=new JDialog();
		if (v.isEmpty()) {
			JOptionPane.showMessageDialog(this,"there are no animals"); 
			return;
		}
		d.setTitle("information");

		String [] names=new String [v.size()];
		int i=0;
        Enumeration<IAnimal> enumeration = v.elements();
        while(enumeration.hasMoreElements()) {
           names[i]=((Animal) (enumeration.nextElement())).getAnimalName();
           i++;
        }
		
		JButton b=new JButton("Show");  
	    b.setBounds(250,50,75,20); 
	    JComboBox cb=new JComboBox(names);    
	    cb.setBounds(50, 50,120,20);    
	    d.add(cb);
	    d.add(b);
	    d.setLayout(null);    
	    
		
	    b.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {     
	        		int i=cb.getSelectedIndex();
	        		info(v.elementAt(i));
	        }  
	    });  
		
		d.setVisible(true);
		d.setBounds(400,400,400,200);

    }
	
	public void info(IAnimal a) {
		JDialog di=new JDialog();

		String [][] entries=((Animal) a).makeTableInfo();

		String[] columnNames = {"Animal","Category","Type","Speed","Energy amount","Distance","Energy comsumpt"};
		JTable table = new JTable(entries,columnNames);
		JScrollPane scrollpane = new JScrollPane(table);
		
		di.add(scrollpane);
		di.setVisible(true);
		di.setBounds(200,200,800,100);

				
	}
	
	
	
	
	
	
	
	
	
}
























