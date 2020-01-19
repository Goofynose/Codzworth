package code;
/**********************************************************
 * @author Victor Alegiani Sagnotti
 * @last_update 18/04/2018
 * @description Read .cdz file by using reader.CdzFileReader
 **********************************************************/

import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import reader.CdzFileReader;

public class OpenFile {
	
	private static CdzFileReader fileReader;
	private static String [] header;
	
	/**********************************************************
	 * Open file and call on GUI to display data
	 **********************************************************/
	public static void open(File file) {
		String path = file.getPath();
		fileReader = new CdzFileReader();
		
		try {
			if(!fileReader.cdzRead(path)) {JOptionPane.showMessageDialog(null, Ressources.ERROR_OF_INVALID_FILE, Ressources.ERROR, JOptionPane.ERROR_MESSAGE); return;}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, Ressources.ERROR_OF_FILEREADER_IO + "\n" + e.getMessage(), Ressources.ERROR, JOptionPane.ERROR_MESSAGE);
			return;
		} catch (NullPointerException f) {
			JOptionPane.showMessageDialog(null, Ressources.ERROR_OF_INVALID_FILE, Ressources.ERROR, JOptionPane.ERROR_MESSAGE);
			return;
		}

		if(!populateDataInfo()) {JOptionPane.showMessageDialog(null, Ressources.ERROR_OF_INVALID_FILE, Ressources.ERROR, JOptionPane.ERROR_MESSAGE); return;}
		populateMap();
	}
	
	/**********************************************************
	 * Fetch file header
	 * Call on GUI to display file information
	 **********************************************************/
	private static boolean populateDataInfo() {
		header = fileReader.cdzFetchHeader();
		if (header == null) {return false;}
		GUI.setLabels(header);
		return true;
	}
	
	/**********************************************************
	 * Fetch file data
	 * Call on GUI to display heat map
	 **********************************************************/
	private static void populateMap() {
		double [][] data = fileReader.cdzFetchData();
		GUI.setMap(data);
	}
}
