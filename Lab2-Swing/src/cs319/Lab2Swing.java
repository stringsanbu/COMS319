package cs319;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLayeredPane;
import javax.swing.JButton;

import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

public class Lab2Swing extends JFrame {

	@SuppressWarnings("rawtypes")
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lab2Swing frame = new Lab2Swing();
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
	public Lab2Swing() {
		setTitle("JTree Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		tabbedPane.setBounds(3, 3, 431, 258);
		contentPane.add(tabbedPane);
		
		DataModel d = new DataModel();
		JScrollPane scrollPane = new JScrollPane(d.companies);
		d.companies.setSelectionBackground(Color.YELLOW);
		scrollPane.setBounds(0, 0, 425, 197);
		JPanel List = new JPanel();
		tabbedPane.addTab("Table", null, List, null);
		List.setLayout(null);

		List.add(scrollPane);
		
		JButton add = new JButton("Add");
		add.setBounds(91, 201, 89, 23);
		List.add(add);
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = JOptionPane.showInputDialog( add, "What is new company?", "Enter new company name", JOptionPane.QUESTION_MESSAGE);
				
					d.addCompany(s);
				
			}
		});
		
		JButton remove = new JButton("Remove");
		remove.setBounds(223, 201, 89, 23);
		List.add(remove);
		
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=d.companies.getSelectedIndex();
				//if statement garuntees a list item was selected
				if (index != -1) 
				   d.remove(index);
			}
		});
		
		JPanel Table = new JPanel();
		tabbedPane.addTab("Table", null, Table, null);

		
		JPanel Tree = new JPanel();
		tabbedPane.addTab("Tree", null, Tree, null);
	}
}
