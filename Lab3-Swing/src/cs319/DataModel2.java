package cs319;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DataModel2 extends javax.swing.AbstractListModel{
	
	public DefaultTableModel tableModel = new DefaultTableModel();
	public JTable people= new JTable();
	
	public DataModel2(){

		try {
			File f=new File("people.csv");
			people.setModel(tableModel);
			Scanner s=new Scanner(f);
			int i = 0;
			while(s.hasNextLine()){
				String nextLine=s.nextLine();
				String[] columns = nextLine.split(",");

				//Handle the column names first
				if(i==0){
					i++;
					// Loop through all of them and add them to the 
					for(String column: columns) tableModel.addColumn(column);
					continue;
				}
				// Ok, we know that this is actual data, 
				tableModel.addRow(columns);
			}
			
			s.close();//I have good programming practices
		} 	
		
		//various error checking for a file
		catch (FileNotFoundException e)
		{
			System.out.println("Error, file was not found.");
		}
		catch (IOException e)
		{
			System.out.println("Error, IOException.");
		}
		catch (InputMismatchException e) 
		{
			System.out.println("Input Mismatch");
		}
		catch(NullPointerException e)
		{
			System.out.println("Error, null pointer exception.");
		}
		
		
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	
		
	
	

}
