package reader;
/**********************************************************
 * @author Victor Alegiani Sagnotti
 * @date_created 29/01/2018
 * @last_update 06/02/2018
 * @version 0.3
 * @description Provides methods to read files with .CDZ extension.
 **********************************************************/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

public class CdzFileReader {
	
	private static final String HEAD = "<CDZ_header>";
	private static final String BODY = "<CDZ_data>";
	private static final String FOOT = "<CDZ_end>";
	
	private static final String VERSION = "0.3";
	
	private String version;
	private String file_length;
	private String location;
	private String date;
	private String measurement;
	
	private double [][] data;
	
	/**********************************************************
	 * Read file with .CDZ extension.
	 * Parse through header and recover variables.
	 * Get data array from file.
	 * Return True if successful, or False if unsuccessful (Corrupt file).
	 * @param path
	 * @return boolean
	 *********************************************************/
	public boolean cdzRead(String path) throws IOException{
		BufferedReader file;
		double [][] data;
		List<String> sl = new ArrayList<String>();
		String line;
		String splitter = ",";

		try {
			file = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			return false;
		}

		if(!file.readLine().equals(HEAD)) {file.close(); return false;}

		if(!(version = file.readLine()).equals(VERSION)) {file.close(); return false;}
		file_length = file.readLine();
		location = file.readLine();
		date = file.readLine();
		measurement = file.readLine();
		
		if(!file.readLine().equals(BODY)) {file.close(); return false;}
		
		while(!(line = file.readLine()).equals(FOOT)) {
			sl.add(line);
		}
		
		data = new double[sl.size()][sl.get(0).split(splitter).length];
		for (int i = 0; i < sl.size(); i+=1) {
			data [i] = toDouble(sl.get(i).split(splitter));
		}
		
		this.data = data;
		
		file.close();
		return true;
	}
	
	/**********************************************************
	 * Fetch the header variables from the CdzFileReader.
	 * Returns null if no file has been read.
	 * @return String array
	 **********************************************************/
	public String[] cdzFetchHeader() {
		return new String[] {version, file_length, location, date, measurement};
	}
	
	/**********************************************************
	 * Fetch the data array from the CdzFileReader.
	 * Returns null if no file has been read.
	 * @return Byte array
	 **********************************************************/
	public double[][] cdzFetchData() {
		return data;
	}
	
	
	/**********************************************************
	 * Turns String array into double array.
	 * @return double array
	 **********************************************************/
	private double[] toDouble(String [] s) {
		return Arrays.stream(s).mapToDouble(Double::parseDouble).toArray();
	}
}
