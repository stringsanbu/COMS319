package stuff;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.plaf.PanelUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.michaelbaranov.microba.calendar.CalendarPane;
import com.michaelbaranov.microba.calendar.DatePicker;

import net.fortuna.ical4j.data.ParserException;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class dataPickerStuff {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dataPickerStuff window = new dataPickerStuff();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 * @throws ParserException 
	 * @throws IOException 
	 */
	public dataPickerStuff() throws IOException, ParserException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ParserException 
	 * @throws IOException 
	 */
	private void initialize() throws IOException, ParserException {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		
		JDatePickerImpl datePickerImpl = new JDatePickerImpl(datePanel, null);
		datePickerImpl.setTextEditable(true);
				
		JPanel pane = new JPanel();
		JPanel jpanel = new JPanel();
		GridBagLayout gbl_jpanel = new GridBagLayout();
		gbl_jpanel.columnWidths = new int[]{0, 160, 120, 0};
		gbl_jpanel.rowHeights = new int[]{28, 0, 0, 0, 0};
		gbl_jpanel.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_jpanel.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		jpanel.setLayout(gbl_jpanel);
		frame.getContentPane().add(jpanel);
		
		JLabel lblDate = new JLabel("          Date:");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 0;
		gbc_lblDate.gridy = 0;
		jpanel.add(lblDate, gbc_lblDate);
		
		final DatePicker  datepicker = new DatePicker(new Date());
		GridBagConstraints gbc_datepicker = new GridBagConstraints();
		gbc_datepicker.insets = new Insets(0, 0, 5, 5);
		gbc_datepicker.anchor = GridBagConstraints.NORTHWEST;
		gbc_datepicker.gridx = 1;
		gbc_datepicker.gridy = 0;
		jpanel.add(datepicker, gbc_datepicker);
		
		/*
		 * Let's add the countries table in a scroll pane.
		 */
		JScrollPane countryListPane = new JScrollPane();
		
		DataListModel list = new DataListModel();
		
		JButton btnGotempButton = new JButton("Go (temp button)");

		GridBagConstraints gbc_btnGotempButton = new GridBagConstraints();
		gbc_btnGotempButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnGotempButton.gridx = 1;
		gbc_btnGotempButton.gridy = 1;
		jpanel.add(btnGotempButton, gbc_btnGotempButton);
		
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 2;
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 2;
		gbc_list.gridy = 2;
		
		countryListPane.setViewportView(list.countries);
		jpanel.add(countryListPane, gbc_list);
				
		JLabel lblChooseYourCountries = new JLabel("Choose Your Countries:");
		GridBagConstraints gbc_lblChooseYourCountries = new GridBagConstraints();
		gbc_lblChooseYourCountries.insets = new Insets(0, 0, 5, 0);
		gbc_lblChooseYourCountries.gridx = 2;
		gbc_lblChooseYourCountries.gridy = 0;
		jpanel.add(lblChooseYourCountries, gbc_lblChooseYourCountries);
		 
		DefaultTableModel tbmodel = new DefaultTableModel();
		tbmodel.addColumn("Description");
		tbmodel.addColumn("Country");
		table = new JTable(tbmodel);
		
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridheight = 2;	
		gbc_table.gridwidth = 2;
		gbc_table.insets = new Insets(0, 0, 0, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 2;
		jpanel.add(new JScrollPane(table), gbc_table);
		
		btnGotempButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = datepicker.getDate();
				int[] selectedCountries = list.countries.getSelectedIndices();
				ArrayList<String[]> holidays = null;
				try {
					holidays = list.getHolidays(selectedCountries, date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				for(String[] holiday : holidays){
					model.addRow(holiday);
				}
				
				
			}
		});

		
	}

}
