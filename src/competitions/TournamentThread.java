
package competitions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Enumeration;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import animals.Animal;
import graphics.IAnimal;

public class TournamentThread implements Runnable {

	private Scores scores;
	private BooleanClass startSignal;
	private int groups;
	
	private JComboBox cb;
	
	
	
	private JDialog d;
	
	public TournamentThread(Scores scores,BooleanClass startSignal, int groups ) {
		this.scores=scores;
		this.startSignal=startSignal;
		this.groups=groups;
	}
	
	@Override
	public void run() {


		synchronized(startSignal){
			startSignal.setValue(true);
			startSignal.notifyAll();
		}

		while(true) {
			
	        try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	        
	        Set<String > names=	scores.getAll().keySet();
		    cb=new JComboBox(names.toArray()); 
	       
		}
	}
	
	//public void infoUpdate() {
	//}
	
	public void competitionInfo() {
		d=new JDialog();
		d.setTitle("competition info");


		

		

		JButton b=new JButton("Show");  
	    b.setBounds(250,50,75,20); 
	    
        Set<String > names=	scores.getAll().keySet();
	    cb=new JComboBox(names.toArray());    
	    cb.setBounds(50, 50,120,20);    
	    d.add(cb);
	    JLabel l=new JLabel();
	    l.setBounds(50, 100,160,20);
	    d.add(l);
	    
	    b.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	Date text=scores.getAll().get(cb.getSelectedItem());
                    	if(text!=null)
                    		l.setText(text.toString());
                    }
                });	
	    d.add(b);
	    
	    
	    d.setLayout(null);    
		d.setBounds(400,400,400,200);
		d.setVisible(true);

	}

}