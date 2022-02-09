
package graphics;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

import javax.imageio.*;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import mobilty.*;
import mobilty.Point;
import animals.*;
import competitions.CourierTournament;
import competitions.RegularTournament;
import competitions.Tournament;

public class CompetitionFrame extends JFrame {

	
	private JMenuBar menu;    
	private JMenu file,help,time;    
	private JMenuItem help2,exit,sleep ; 
	
	//private ZooPanel pan;


	
	private ZooPanel CompetitionPanel;
	
	
	public CompetitionFrame(){
		super("Competition");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		CompetitionPanel=new ZooPanel(this);
		

		/////end background


		

		
		/////////////////////menu bar
		menu=new JMenuBar();    
		file=new JMenu("File");    
		exit=new JMenuItem("exit");   
	

		exit.addActionListener((event) -> System.exit(0));    
		file.add(exit);
		
		help=new JMenu("Help");     
		help2=new JMenuItem("help");    
		help2.addActionListener((event) -> JOptionPane.showMessageDialog(this,"Home Work 2\nGUI"));    
		help.add(help2);
		
		
		time=new JMenu("time");    
		sleep=new JMenuItem("sleep");   
		time.add(sleep);

		sleep.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                		JDialog di=new JDialog();
                		
                		JLabel label=new JLabel("enter the time that the animal sleep in milisecond");
                		label.setBounds(20,0,300,100);
                		JTextField tex=new JTextField();
                		tex.setBounds(20,70,100,30);
                		JButton but=new JButton("done");
                		but.setBounds(20,130,100,30);

                		but.addActionListener(
                                new ActionListener() {
                                    public void actionPerformed(ActionEvent e2) {
                            			int time=0;
                                    	try {
                            				time=Integer.parseInt(tex.getText());
                            			}
                            			catch (NumberFormatException e3) {
                            				time=0;
                            			}
                                    	Animal.setSleep(time);
                                    	di.dispose();
                                    }
                                });	
                		
                		di.add(label);
                		di.add(tex);
                		di.add(but);
                		
                		di.setLayout(null);
                		di.setVisible(true);
                		di.setBounds(200,200,350,250);                    	

                    }
                });	

		
		
		
		
		menu.add(file);
		menu.add(help);    
		menu.add(time);

		
		
		add(menu); 
		setJMenuBar(menu);  
		/////////////////////// end menu bar

     
		
		
		
		
        
        
        

        add(CompetitionPanel);

		setLayout(null);
		setSize(1200,950);
		setResizable(false);
		//pack();
		setVisible(true);
	}
	



	
	
	
	
	public static void main(String[] args) {

		new CompetitionFrame();
		
	}



}












































