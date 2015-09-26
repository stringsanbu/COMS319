package calList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class DataListModel extends javax.swing.AbstractListModel{
	
	public DefaultListModel listmodel=new DefaultListModel();
	public JList<String> countries= new JList<String>();
	public ArrayList<String> x=new ArrayList<String>();

		
	public DataListModel(){
	try {
		countries.setModel(listmodel);
		File folder = new File("Countries");
		File fileList[] = folder.listFiles();
		for(int i=0; i<fileList.length;i++)
		{
			if(fileList[i].isFile())
				x.add(fileList[i].getName());
				String name=fileList[i].getName();
				
	String s=name.substring(0,name.lastIndexOf("."));
				listmodel.addElement(s);
		}
		
		
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
	public Object getElementAt(int index) {
		return x.get(index);
	}
	@Override
	public int getSize() {
		return x.size();
	}
	
	



}
