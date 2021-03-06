import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;



public class HelloWorldSwing3 {
	
public static JFrame helloFrame;	
public static JTextField clearbox;
public static JCheckBox checkbox;
public static JTextField textField;
public static JPanel contentPane;
public static JTextField txtHelloWorld;
public final static ButtonGroup buttonGroup = new ButtonGroup();
public static Boolean clearFlag;
public static int numSeconds;
public static JCheckBox chckbxClearAfter;
public static JLabel lblNewLabel;

public static void main(String[] args) {
		
		// TODO: At least on mac, the grid moves and resizes when typing. This needs to NOT happen to be a good program.
	
		helloFrame = new JFrame("HelloWorldSwing!");
	    helloFrame.setSize(new Dimension(370, 220));
	    helloFrame.setVisible(true);
	    helloFrame.setContentPane(createContainers());//creates container
	    helloFrame.setVisible(true);
	    // Some dimension work added to try to keep UI from moving (at least on Mac)

//		while(helloFrame.isActive())
//	    {
//	    	// Some dimension work added to try to keep UI from moving (at least on Mac)
//	    	j.setText(textbox.getText());
//		    j.setMaximumSize(textbox.getSize());
//	    	j.setPreferredSize(textbox.getSize());
//	    	
//	    }
	    
	    
}
static JPanel createContainers() {
	

	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(null);
	
	lblNewLabel = new JLabel("Hello World!");
	lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
	lblNewLabel.setBounds(97, 60, 232, 89);
	contentPane.add(lblNewLabel);
	
	JLabel lblText = new JLabel("Text: ");
	lblText.setBounds(6, 11, 61, 16);
	contentPane.add(lblText);
	
	txtHelloWorld = new JTextField();
	txtHelloWorld.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			
			lblNewLabel.setText(txtHelloWorld.getText());
		}
	});
	txtHelloWorld.setText("Hello World!");
	txtHelloWorld.setBounds(41, 6, 95, 26);
	contentPane.add(txtHelloWorld);
	txtHelloWorld.setColumns(10);
	

	
	
	JComboBox<String> comboBox = new JComboBox<String>();
	comboBox.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			@SuppressWarnings("unchecked")
			JComboBox<String> combo = (JComboBox<String>)e.getSource();
			String s = (String) combo.getSelectedItem();
			if(s=="tiny")
				lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(8.0f));
			if(s=="small")
				lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(12.0f));
			if(s=="medium")
				lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(20.0f));
			if(s=="large")
				lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(28.0f));
		}
	});
	comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"tiny", "small", "medium", "large"}));
	comboBox.setSelectedIndex(2);
	comboBox.setBounds(137, 7, 101, 27);
	contentPane.add(comboBox);
	
	JRadioButton rdbtnNewRadioButton = new JRadioButton("Plain");
	rdbtnNewRadioButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Font f = lblNewLabel.getFont();
			lblNewLabel.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD & ~Font.ITALIC));
		}
	});
	rdbtnNewRadioButton.setSelected(true);
	buttonGroup.add(rdbtnNewRadioButton);
	rdbtnNewRadioButton.setBounds(6, 31, 141, 23);
	contentPane.add(rdbtnNewRadioButton);
	
	JRadioButton rdbtnBold = new JRadioButton("Bold");
	rdbtnBold.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Font f = lblNewLabel.getFont();
			lblNewLabel.setFont(f.deriveFont(f.getStyle() & ~Font.ITALIC | Font.BOLD));
		}
	});
	buttonGroup.add(rdbtnBold);
	rdbtnBold.setBounds(6, 66, 141, 23);
	contentPane.add(rdbtnBold);
	
	JRadioButton rdbtnItalic = new JRadioButton("Italic");
	rdbtnItalic.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Font f = lblNewLabel.getFont();
			lblNewLabel.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD | Font.ITALIC));
		}
	});
	buttonGroup.add(rdbtnItalic);
	rdbtnItalic.setBounds(6, 101, 141, 23);
	contentPane.add(rdbtnItalic);
	
	JRadioButton rdbtnBoldItalic = new JRadioButton("Bold Italic");
	rdbtnBoldItalic.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Font f = lblNewLabel.getFont();
			lblNewLabel.setFont(f.deriveFont(f.getStyle() | Font.BOLD | Font.ITALIC));
		}
	});
	buttonGroup.add(rdbtnBoldItalic);
	rdbtnBoldItalic.setBounds(6, 136, 141, 23);
	contentPane.add(rdbtnBoldItalic);
	
	JButton btnShow = new JButton("Show");
	btnShow.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			if(lblNewLabel.getForeground()==Color.black)
				lblNewLabel.setForeground(Color.red);
			else
				lblNewLabel.setForeground(Color.black);
		}
	});
	btnShow.setBounds(6, 167, 117, 29);
	contentPane.add(btnShow);
	
	JButton btnExit = new JButton("Exit");
	btnExit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			helloFrame.dispose();
		}
	});
	btnExit.setBounds(212, 167, 117, 29);
	contentPane.add(btnExit);
	
	chckbxClearAfter = new JCheckBox("Clear After:");
	chckbxClearAfter.setFont(new Font("Arial", Font.PLAIN, 10));
	chckbxClearAfter.setBounds(236, 7, 84, 23);
	contentPane.add(chckbxClearAfter);
	

	
	
	textField = new JTextField();
	textField.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
	textField.setText("10");
	textField.setBounds(317, 8, 35, 26);
	contentPane.add(textField);
	textField.setColumns(10);
	
	chckbxClearAfter.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			clearFlag = chckbxClearAfter.isSelected();
			timerHelperfunction(this);

		}
	});

	
	textField.addActionListener(new ActionListener() {
		// TODO: Finish the verifier to make sure no letters are inputed
		// Might need to be keytyped/keyinput instead of action
		public void actionPerformed(ActionEvent e) {
			JTextField field = (JTextField) e.getSource();
			String str = field.toString();
			if(str == "" || str == null){
				numSeconds = 0;
				return;
			}
			
			try{
				numSeconds = Integer.parseInt(str);//partially verifies so that there is no error
			}
			catch(Exception exc){
				JOptionPane.showMessageDialog(helloFrame, exc.toString());
				chckbxClearAfter.setEnabled(false);
			}
			
			// If the number is not between 1 and 10, clear the checkbox & field, set numSeconds to null, and show an error
			if(numSeconds < 1 || numSeconds > 10){
				JOptionPane.showMessageDialog(helloFrame, "Time for clear must be between 1 and 10 seconds");
				numSeconds = 0;
				chckbxClearAfter.setEnabled(false);
				textField.setText("");
				return;
			}
			
			// Ok, so the input seems valid, we should call into a helper function here to set/unset the timer
			timerHelperfunction(this);
			
		}


	});
	

	return contentPane;
	
}

private static void timerHelperfunction(ActionListener actionListener) {
	// TODO Use numSeconds and the clearFlag to determine what to do
	// If clearFlag is open, set the timer to clear
	// If it is off, stop the current timer and set it to null.
	// The timer should also fire a function that clears the timer box and the checkbox
	Timer timer=new Timer(numSeconds*1000, actionListener);
	timer.start();

	if(clearFlag)
	{
		lblNewLabel.setText("");
		textField.setText("");
		timer.stop();
	}
	else{
		lblNewLabel.setText(txtHelloWorld.getText());
		timer.stop();
	}
	

}
}
