package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EatDialog extends JDialog implements ActionListener  {
	//private ZooPanel pan;
	private JButton b;
	private JLabel label;
	private JTextField text;
	private IAnimal animal;
	private int energy;
	
	public EatDialog(JDialog d,IAnimal a){
		super(d , "eat dialog", true);  
		//this.pan=pan;
		this.animal=a;
		label=new JLabel("enter energy for the animal");
		label.setBounds(100,30,200,30);
		add(label);
		text=new JTextField();
		text.setBounds(100,60,150,30);    
		add(text);
		
		//button
		b=new JButton("DONE");
		b.setBounds(100,120,100,30);
		b.addActionListener(this);

		add(b);
		
		
		
		
		setLayout(null);    
		setBounds(400,300,400,300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//pack();
		setVisible(true);	
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			energy=Integer.parseInt(text.getText());
			animal.eat(energy);
			dispose();
		}
		catch (NumberFormatException e2) {
			JOptionPane.showMessageDialog(this,"enter integer"); 
		      text.setText("");

			energy=0;
		}		
		
	}

}
