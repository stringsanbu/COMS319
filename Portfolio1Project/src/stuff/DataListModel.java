package stuff;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
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

import groovyjarjarantlr.collections.List;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.filter.Filter;
import net.fortuna.ical4j.filter.PeriodRule;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.DateTime;
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
	public ArrayList<String[]> getHolidays(int[] indecies, Date date){
		ArrayList<String[]> holidayData = new ArrayList<String[]>();
		for(int index: indecies){
			// Grab holiday from the selected index and go through each iterator to find the dates
			Calendar calendar = holidays.get(index).calendar;
			
			net.fortuna.ical4j.model.Period period = new net.fortuna.ical4j.model.Period(new DateTime(date.getTime()), new DateTime(date.getTime()));
			@SuppressWarnings("deprecation")
			Filter filter = new Filter(new PeriodRule(period));
			
			Collection<Object> events = filter.filter(calendar.getComponents("VEVENT"));
			
			for(Object obj : events){
				VEvent event = (VEvent) obj;
				String eventStringArray[] = {};
				eventStringArray[0] = event.getName();
				eventStringArray[1] = holidays.get(index).getCountry();
				holidayData.add(eventStringArray);
			}
			
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
