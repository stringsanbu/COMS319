package stuff;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import org.omg.CORBA.PUBLIC_MEMBER;

import groovy.ui.Console;
import groovyjarjarantlr.collections.List;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.filter.Filter;
import net.fortuna.ical4j.filter.PeriodRule;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.ComponentList;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.Dur;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.component.VEvent;

public class DataListModel extends javax.swing.AbstractListModel {

	public DefaultListModel listmodel = new DefaultListModel();
	public JList<String> countries = new JList<String>();
	public ArrayList<String> x = new ArrayList<String>();
	public ArrayList<Holiday> holidays = new ArrayList<Holiday>();

	@SuppressWarnings("unchecked")
	public DataListModel() throws IOException, ParserException {
		try {
			countries.setModel(listmodel);
			File folder = new File("Countries");
			File fileList[] = folder.listFiles(new FileFilter() {
				@Override
				public boolean accept(File file) {
					return !file.isHidden();
				}
			});

			for (int i = 0; i < fileList.length; i++) {
				if (fileList[i].isFile()) {
					String name = fileList[i].getName();
					
					String s = name.substring(0, name.lastIndexOf("."));
					Holiday holiday = null;
					// We use this when it is time to get the holidays
					try{
						holiday = new Holiday(null, null, s, fileList[i]);
					}
					catch(Exception e){
						continue;
					}
					
					x.add(fileList[i].getName());
					holidays.add(holiday);
					listmodel.addElement(s);
				}
			}

		} catch (InputMismatchException e) {
			System.out.println("Input Mismatch");
		} catch (NullPointerException e) {
			System.out.println("Error, null pointer exception.");
		}

	}
	
	// format of table is as follows: Name, Country
	@SuppressWarnings("deprecation")
	public ArrayList<String[]> getHolidays(int[] indecies, Date date) throws ParseException{
		ArrayList<String[]> holidayData = new ArrayList<String[]>();
		for(int index: indecies){
			// Grab holiday from the selected index and go through each iterator to find the dates
			Calendar calendar = holidays.get(index).calendar;
			java.util.Calendar cal = java.util.Calendar.getInstance();
			String yearString = Integer.toString(date.getYear());
			yearString = yearString.substring(yearString.length()-2, yearString.length());
			yearString = "20"+yearString;
			 
			cal.set(java.util.Calendar.DATE, date.getDate());
			cal.set(java.util.Calendar.YEAR, Integer.parseInt(yearString));
			cal.set(java.util.Calendar.MONTH, date.getMonth());

			cal.set(java.util.Calendar.HOUR_OF_DAY, 0);
			cal.clear(java.util.Calendar.MINUTE);
			cal.clear(java.util.Calendar.SECOND);
			
			DateTime dateTime = new DateTime(cal.getTime());
			String ds = dateTime.toGMTString();
			net.fortuna.ical4j.model.Period period = new net.fortuna.ical4j.model.Period(new DateTime(date.getTime()), new Dur(2, 0, 0, 0));
			@SuppressWarnings("deprecation")
			Filter filter = new Filter(new PeriodRule(period));
			
			Collection<Object> events = filter.filter(calendar.getComponents(Component.VEVENT));
		
			ComponentList list = (ComponentList) filter.filter(calendar.getComponents(Component.VEVENT));
			ArrayList<Component> components = new ArrayList<Component>();
			for (Iterator i = calendar.getComponents().iterator(); i.hasNext();) {
			    Component component = (Component) i.next();
			    System.out.println("Component [" + component.getName() + "]");

			    for (Iterator j = component.getProperties().iterator(); j.hasNext();) {
			        Property property = (Property) j.next();
			        if(property.getName() == "DtStart" || property.getName() == "DTSTART"){
			        	DateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
			            DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			            Date targetDate = originalFormat.parse(property.getValue());
			            DateTime targetDateTime = new DateTime(targetDate.getTime());			        	
			        	System.out.println(targetDateTime.toGMTString());
			        	System.out.println(dateTime.toGMTString());
			        	if(targetDateTime.getDate() == dateTime.getDate() 
			        			&& targetDateTime.getMonth() == dateTime.getMonth() 
			        			&& targetDateTime.getYear() == dateTime.getYear() )
			        		{
			        			@SuppressWarnings("unused")
								String description = ((Property) component.getProperties("Description").get(0)).getValue();
			        			String location = ((Property) component.getProperties("Location").get(0)).getValue();
			        			String[] arr = {description, location};
			        			holidayData.add(arr);
			        		}
			        	
			        }
			        System.out.println("Property [" + property.getName() + ", " + property.getValue() + "]");
			    }
			}
			
			// OK, now that the painful process of finding the holidays is over, we need to be able to make our String arrays from the components.
			
			
		}
		
		
		return holidayData;
	}

	@Override
	public Object getElementAt(int index) {
		return x.get(index);
	}

	@Override
	public int getSize() {
		return x.size();
	}

}
