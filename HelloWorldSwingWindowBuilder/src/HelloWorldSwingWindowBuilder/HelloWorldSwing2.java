package HelloWorldSwingWindowBuilder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class HelloWorldSwing2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtHelloWorld;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelloWorldSwing2 frame = new HelloWorldSwing2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HelloWorldSwing2() {
		setTitle("HelloWorldSwing!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(new Dimension(370, 220));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hello World!");
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
		txtHelloWorld.setBounds(41, 6, 130, 26);
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
		comboBox.setBounds(196, 7, 107, 27);
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
				dispose();
			}
		});
		btnExit.setBounds(212, 161, 117, 29);
		contentPane.add(btnExit);
		

	}
}
