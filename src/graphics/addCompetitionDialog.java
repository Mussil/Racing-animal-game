package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class addCompetitionDialog extends JDialog implements ActionListener {
	
	
	private JButton but;
	private JRadioButton r1;
	private JRadioButton r2;
	private ZooPanel pan;
	private JFrame frame;

	public addCompetitionDialog(JFrame f, ZooPanel pan) {
		super(f , "Add competition dialog", true);  
		this.pan=pan;
		this.frame=f;
		JLabel text=new JLabel("chose the type of your competition");
		text.setBounds(75,20,200,30);
		r1=new JRadioButton("A) Courier Tournament");    
		r2=new JRadioButton("B) Regular Tournament");  
		r1.setBounds(75,70,200,30);    
		r2.setBounds(75,100,200,30);    

		ButtonGroup bg=new ButtonGroup();    
		bg.add(r1);
		bg.add(r2);  
		add(text);
		add(r1);
		add(r2);  
		
		but=new JButton("click");    
		but.setBounds(100,200,80,30);    
		but.addActionListener(this);
		add(but);
		
		
		setLayout(null);    
		setBounds(400,300,400,300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//pack();
		setVisible(true);	
    }
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		
		
		if(r1.isSelected()){   
			new AddAnimalDialog(frame,pan,"Courier");
			dispose();
		}    
		else if(r2.isSelected()){   
			new AddAnimalDialog(frame,pan,"Regular");
			dispose();
		} 

 		
		
	}
	
	
}
