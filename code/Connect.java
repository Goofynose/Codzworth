package code;
/**********************************************************
 * @author Victor Alegiani Sagnotti
 * @last_update 18/04/2018
 * @description Runs the cdzconnect.exe file
 **********************************************************/

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Connect extends Thread {
	
	Runtime runtime = Runtime.getRuntime(); //Get runtime
	Process process = null;
	String[] cmd = new String[3];
	
	/**********************************************************
	 * Initialise command
	 **********************************************************/
	public Connect() {
		String path = null;
		try {
			path = new File(".").getCanonicalPath(); //Get the location of this program
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, Ressources.ERROR_CO_PATH_ERROR, Ressources.ERROR, JOptionPane.ERROR_MESSAGE);
		}
		
		//Create the command to execute cdzconnect.exe
        cmd[0] = "cmd.exe" ;
        cmd[1] = "/C" ;
        cmd[2] = path + "\\src\\files\\cdzconnect.exe";
        ConnectFrame.print("Running " + cmd[0] + " " + cmd[1] + " " + cmd[2]);
	}
	
	/**********************************************************
	 * Start thread
	 * @return nothing
	 **********************************************************/
	public void run(){
		try {            
            Process process = runtime.exec(cmd);
            
            // Error messages output stream
            StreamReader errorReader = new StreamReader(process.getErrorStream(), "ERROR");            
            // Standard output stream
            StreamReader outputReader = new StreamReader(process.getInputStream(), "OUTPUT");
                
            // Start threads
            errorReader.start();
            outputReader.start();
                                    
            // Return exit value
            int exitVal = process.waitFor();
            System.out.println("ExitValue: " + exitVal);        
        } catch (Throwable e) {
        	JOptionPane.showMessageDialog(null, Ressources.ERROR_CO_STREAM_ERROR, Ressources.ERROR, JOptionPane.ERROR_MESSAGE);
        }
	}

}
