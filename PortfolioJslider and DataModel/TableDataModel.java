package calList;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.InputMismatchException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableDataModel extends javax.swing.AbstractListModel{

	public DefaultTableModel tableModel = new DefaultTableModel();
	public JTable holidays= new JTable();
	
	public TableDataModel() throws FileNotFoundException{
		holidays.setModel(tableModel);
		
		FileInputStream fin = new FileInputStream("mycalendar.ics");
		//CalendarBuilder builder = new CalendarBuilder(); //iclal4?
		//Calendar calendar = builder.build(fin);

		//ical4 methods and code?
		//...
		//loop
		//...
		//initialize holidays as Holiday holiday = new Holiday(date,name,country)
		//tableModel.addRow(new Object[] {holiday.getName(), holiday.getCountry(), holiday.getDate()}
		//endloop
		
	}
	
	@Override
	public Object getElementAt(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

}
