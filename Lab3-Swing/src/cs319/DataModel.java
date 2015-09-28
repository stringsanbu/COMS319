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

public class DataModel extends javax.swing.AbstractListModel{
	
	public DefaultListModel listmodel=new DefaultListModel();
	public JList<String> companies= new JList<String>();
	public ArrayList<String> x=new ArrayList<String>();
	
	public DataModel(){	

		try {
			File f=new File("companies.txt");
			companies.setModel(listmodel);
			Scanner s=new Scanner(f);
			while(s.hasNextLine()){
				String nextLine=s.nextLine();
				listmodel.addElement(nextLine);
				x.add(nextLine);
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
	public Object getElementAt(int index) {
		return x.get(index);
	}

	@Override
	public int getSize() {
		return x.size();
	}


	public void addCompany(String s) {
		x.add(s);
		listmodel.addElement(s);
		//now add to file
		File f=new File("companies.txt");
		try {
			FileWriter outfile=new FileWriter(f,true);
			BufferedWriter out=new BufferedWriter(outfile);
			out.write(s+'\n');
			out.close();
			outfile.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void remove(int index) {
		String removeString=x.get(index);
		x.remove(index);
		listmodel.removeElementAt(index);
		
		try {
            File f = new File("companies.txt");
            String line = null;//the line the reader will use
            //Construct a new file
            File tempFile = new File(f.getAbsolutePath() + ".tmp");
           
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
            BufferedReader br = new BufferedReader(new FileReader(f));
            
            //Read from the original file and write to the new
            //unless content matches data to be removed.
            while ((line = br.readLine()) != null) {
                if (!line.trim().equals(removeString)) {
                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();
 

           f.delete();//delete file
           tempFile.renameTo(f);// rename to temp file
		}
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

	}
		
	
	

}
