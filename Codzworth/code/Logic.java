package code;
/**********************************************************
 * @author Victor Alegiani Sagnotti
 * @last_update 18/04/2018
 * @description Starting point for the application.
 * 				Main logic centre for the application.
 * 				Most method calls are handled here.
 **********************************************************/

import java.awt.EventQueue;
import java.io.File;
import java.io.InputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public abstract class Logic {
	
	private static GUI gui;
	private final static JFileChooser fileChooser_open = new JFileChooser();
	private final static JFileChooser fileChooser_export = new JFileChooser();

	/**********************************************************
	 * Start application
	 **********************************************************/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				initialiseLogic();
				startGraphicalUserInterface();
			}
		});
	}
	
	/**********************************************************
	 * Initialise variables
	 **********************************************************/
	private static void initialiseLogic() {
		fileChooser_open.setAcceptAllFileFilterUsed(false);
		fileChooser_open.setFileFilter(new FileNameExtensionFilter("CDZ Files (.cdz)", "cdz"));
		
		fileChooser_export.setAcceptAllFileFilterUsed(false);
		fileChooser_export.setFileFilter(new FileNameExtensionFilter("JPG Files (.jpg)", "jpg"));
	}
	
	/**********************************************************
	 * Create GUI
	 **********************************************************/
	private static void startGraphicalUserInterface() {
		TermsAndConditionsFrame terms = new TermsAndConditionsFrame();
		gui = new GUI();
		
		if(!CheckLicense.checkAccepted()) {
			terms.setAlwaysOnTop(true);
			terms.setVisible(true);
		}
	}
	
	/**********************************************************
	 * Display 'Open file' dialog
	 **********************************************************/
	public static void displayFileDialogOpen() {
		int returnVal = fileChooser_open.showOpenDialog(gui.getFrame());

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser_open.getSelectedFile();
			OpenFile.open(file);
        }
	}
	
	/**********************************************************
	 * Display 'Export file' dialog
	 **********************************************************/
	public static void displayFileDialogExport() {
		int returnVal = fileChooser_export.showSaveDialog(gui.getFrame());

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser_export.getSelectedFile();
            String file_name = file.toString();
            Export.exportToImage(gui.getPanel(), file_name);
        }
	}
	
	/**********************************************************
	 * Run cdzconnect.exe and display connection dialog frame
	 **********************************************************/
	public static void startCdzConnect() {
		ConnectFrame connectFrame = new ConnectFrame();
		connectFrame.setVisible(true);
		Connect s = new Connect();
		s.start();
	}
	
	/**********************************************************
	 * Display 'How to' frame
	 **********************************************************/
	public static void displayHowToFrame() {
			HowToFrame guide = new HowToFrame();
			guide.setVisible(true);
	}
	
	/**********************************************************
	 * Display 'Credits' frame
	 **********************************************************/
	public static void displayCreditsFrame() {
		CreditsFrame creditsFrame = new CreditsFrame();
		creditsFrame.setVisible(true);
	}
	
	/**********************************************************
	 * Display 'License' frame
	 **********************************************************/
	public static void displayLicenseFrame() {
		LicenseFrame license = new LicenseFrame();
		license.setVisible(true);
	}
	
}
