package code;
/**********************************************************
 * @author Victor Alegiani Sagnotti
 * @last_update 01/03/2018
 * @description Checks if user has accepted license agreement
 **********************************************************/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CheckLicense {
	/**********************************************************
	 * Check which values is stored in the LicenseAccepted.txt
	 * file.
	 * @return True if value is 1, False if value is 0
	 **********************************************************/
	public static boolean checkAccepted() {
		try {
			int value;
			FileReader reader = new FileReader("src/files/LicenseAccepted.txt");
			value = reader.read();
			reader.close();
			if(value == 49) {
				return true;
			}
			else {return false;}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
