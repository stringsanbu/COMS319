import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;


import javax.swing.*;


@SuppressWarnings("unused")
public class HelloWorldSwing {
	
public static JFrame helloFrame;	
public static JLabel j;
public static JTextField textbox;

public static void main(String[] args) {
		
		// TODO: At least on mac, the grid moves and resizes when typing. This needs to NOT happen to be a good program.
	
		helloFrame = new JFrame("HelloWorldSwing!");
	    helloFrame.setSize(new Dimension(370, 220));
	    helloFrame.setVisible(true);
	    helloFrame.setContentPane(createContainers());//creates container
	    helloFrame.setVisible(true);
	    // Some dimension work added to try to keep UI from moving (at least on Mac)

		while(helloFrame.isActive())
	    {
	    	// Some dimension work added to try to keep UI from moving (at least on Mac)
	    	j.setText(textbox.getText());
		    j.setMaximumSize(textbox.getSize());
	    	j.setPreferredSize(textbox.getSize());
	    	
	    }
	    
	    
}
static JPanel createContainers() {
	
	JPanel main = new JPanel(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	
	//textfield		
    textbox = new JTextField("Hello World!", 10); //makes the text panel (blank)
    
    JLabel text2 = new JLabel("Text: ");
    c.anchor=GridBagConstraints.WEST;
    c.weightx = 1.0;
    
	main.add(text2, c);
	main.add(textbox,c);
	
	
	//dropdown
	String [] s = {"tiny", "small", "medium", "large"};
	JComboBox dropDown = new JComboBox(s);
    c.anchor=GridBagConstraints.LINE_START;
	c.gridwidth = GridBagConstraints.REMAINDER;
    main.add(dropDown,c);
    
    dropDown.addActionListener(
    		new ActionListener() {
    				public void actionPerformed(ActionEvent e) {
					JComboBox combo = (JComboBox)e.getSource();
					String s = (String) combo.getSelectedItem();
					if(s=="tiny")
						j.setFont(j.getFont().deriveFont(8.0f));
					if(s=="small")
						j.setFont(j.getFont().deriveFont(12.0f));
					if(s=="medium")
						j.setFont(j.getFont().deriveFont(20.0f));
					if(s=="large")
						j.setFont(j.getFont().deriveFont(28.0f));
				}
    		}
    	);
    
    //radio buttons
    final JRadioButton plain = new JRadioButton("Plain", true);
    final JRadioButton bold = new JRadioButton("Bold");
    final JRadioButton italic = new JRadioButton("Italic");
    final JRadioButton boldItalic = new JRadioButton("Bold Italic");
    
    c.anchor=GridBagConstraints.WEST;
    main.add(plain,c);
    c.gridwidth = GridBagConstraints.WEST;
    main.add(bold,c);
    c.gridwidth=GridBagConstraints.REMAINDER;
    j = new JLabel(textbox.getText());
    j.setForeground(Color.black);
    main.add(j,c);
	c.gridwidth = GridBagConstraints.REMAINDER;
    c.anchor=GridBagConstraints.WEST;
    main.add(italic,c);
    main.add(boldItalic,c);
    

    ButtonGroup textStyle = new ButtonGroup();
    textStyle.add(plain);
    textStyle.add(bold);
    textStyle.add(italic);
    textStyle.add(boldItalic);

    // TODO: There might be an easier way to add listeners.
    // You cannot add a listener to the group
    plain.addActionListener(
    		new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					Font f = j.getFont();
					j.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD & ~Font.ITALIC));
				}
    		}
    		
    	);
    
    bold.addActionListener(
    		new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					Font f = j.getFont();
					j.setFont(f.deriveFont(f.getStyle() & ~Font.ITALIC | Font.BOLD));
				}
    		}
    		
    	);
    
    italic.addActionListener(
    		new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					Font f = j.getFont();
					j.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD | Font.ITALIC));
				}
    		}
    		
    	);
    
    boldItalic.addActionListener(
    		new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					Font f = j.getFont();
					j.setFont(f.deriveFont(f.getStyle() | Font.BOLD | Font.ITALIC));
				}
    		}
    		
    	);
    
    
	// Create a JButton and add it to the panel.
    JButton buttonShow = new JButton("Show!");
    JButton buttonExit = new JButton("Exit");
    c.anchor=GridBagConstraints.CENTER;
    c.gridwidth = GridBagConstraints.RELATIVE;
    main.add(buttonShow, c);
    main.add(buttonExit, c);
    
    buttonShow.addActionListener(
    		new ActionListener() {
    				public void actionPerformed(ActionEvent e) {
					if(j.getForeground()==Color.black)
						j.setForeground(Color.red);
					else
						j.setForeground(Color.black);
				}
    		}
    	);
    buttonExit.addActionListener(
    		new ActionListener() {
    				public void actionPerformed(ActionEvent e) {
					helloFrame.dispose();
				}
    		}
    	);
    


	return main;
	
}

	
	
}
