package code;
/**********************************************************
 * @author Victor Alegiani Sagnotti
 * @last_update 18/04/2018
 * @description Class that holds all constant variables to be
 * 				accessed throughout the application code
 **********************************************************/

final class Ressources {
	
	//Program information
	private static final String VERSION = "0.3.1";
	private static final String AUTHOR = "Victor Alegiani Sagnotti";
	private static final String CONTACT = "victor.alegiani-sagnotti@hotmail.it";
	private static final String LAST_UPDATE = "11/04/18";
	
	public static final String ERROR = "Error";
	
	//OpenFile.java errors
	public static final String ERROR_OF_INVALID_FILE = "Error OF01: Invalid file.";
	public static final String ERROR_OF_FILEREADER_IO = "Error OF02-S: IOException in CdzFileReader.";
	
	//Logic.java errors
	public static final String ERROR_LG_CDZCONNECT_NOTFOUND = "Error LG01-S: CdzConnect.exe not found.";
	
	//GUI.java errors
	public static final String ERROR_GI_DISPLAY_FAIL_S = "Error GI02-S: Failed to display GUI.";
	public static final String ERROR_GI_DISPLAY_FAIL = "Error GI03: Failed to display License.";
	
	//TermsAndConditions.java errors
	public static final String ERROR_TC_FILE_NOTFOUND = "Error TC01: Failed to read Terms and Conditions file.";
	public static final String ERROR_TC_IO_ERROR = "Error TC02-S: IOException in FileReader.";
	public static final String ERROR_TC_WRITE_ERROR = "Error TC03: Failed to write to LicenseAccepted.txt.";
	
	//ProcessFrame.java errors
	public static final String ERROR_PF_VALUE_ERROR = "Error PF01-S: Unexpected value.";
	
	//HowToFrame.java errors
	public static final String ERROR_HT_FILE_NOTFOUND = "Error HT01: Guide File not found.";
	public static final String ERROR_HT_IO_ERROR = "Error HT02-S: IOException in FileReader.";
	
	//LicenseFrame.java errors
	public static final String ERROR_LF_FILE_NOTFOUND = "Error LF01: License File not found.";
	public static final String ERROR_LF_IO_ERROR = "Error LF02-S: IOException in FileReader.";
	
	//CreditsFrame.java errors
	public static final String ERROR_CF_FILE_NOTFOUND = "Error CF01: Credits File not found.";
	public static final String ERROR_CF_IO_ERROR = "Error CF02-S: IOException in FileReader.";
	
	//Connect.java errors
	public static final String ERROR_CO_PATH_ERROR = "Error CO01: Error getting application path.";
	public static final String ERROR_CO_STREAM_ERROR = "Error CO02: Error initialising streams or executable.";
	
	//StreamReader.java errors
	public static final String ERROR_SR_STREAM_ERROR = "Error SR01: Error initialising stream.";
	
	public static String getVersion() {
		return VERSION;
	}
	
	public static String getAuthor() {
		return AUTHOR;
	}
	
	public static String getContact() {
		return CONTACT;
	}
	
	public static String getLastUpdate() {
		return LAST_UPDATE;
	}
}
