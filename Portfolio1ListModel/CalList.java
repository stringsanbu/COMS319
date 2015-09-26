package calList;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import java.awt.Color;

public class CalList extends JFrame {

	@SuppressWarnings("rawtypes")
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalList frame = new CalList();
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
	public CalList() {
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
		
		DataListModel d = new DataListModel();
		JScrollPane scrollPane = new JScrollPane(d.countries);
		d.countries.setSelectionBackground(Color.YELLOW);
		d.countries.setSelectionForeground(Color.BLACK);
		scrollPane.setBounds(0, 0, 425, 197);
		JPanel List = new JPanel();
		tabbedPane.addTab("List", null, List, null);
		List.setLayout(null);

		List.add(scrollPane);
		
		
	}

}
