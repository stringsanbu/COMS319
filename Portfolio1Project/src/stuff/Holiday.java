package stuff;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;

public class Holiday {
	public Calendar calendar;
	private String date="";
	private String name="";
	private String country="";
	
	public Holiday(String date,String name,String country, File icsFile) throws IOException, ParserException
	{
		this.date=date;
		this.name=name;
		this.country=country;
		FileInputStream file = new FileInputStream(icsFile);
		CalendarBuilder builder = new CalendarBuilder();
		System.out.println(icsFile.getName());
		calendar = builder.build(file);
	}

	public String getDate(){
		return date;
	}
	public String getName(){
		return name;
	}
	public String getCountry(){
		return country;
	}
}
