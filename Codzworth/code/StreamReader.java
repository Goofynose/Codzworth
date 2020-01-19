package code;
/**********************************************************
 * @author Victor Alegiani Sagnotti
 * @last_update 18/04/2018
 * @description Thread that acts as message stream for the
 * 				cdzconnect.exe file outputs
 **********************************************************/

import java.io.*;

class StreamReader extends Thread
{
    InputStream is;
    String type;
    
    /**********************************************************
	 * Constructor, assign variables
	 **********************************************************/
    StreamReader(InputStream is, String type)
    {
        this.is = is;
        this.type = type;
    }
    
    /**********************************************************
	 * Called when thread is started, print messages to connection
	 * dialog frame
	 **********************************************************/
    public void run()
    {
        try
        {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line=null;
            while ( (line = br.readLine()) != null)
                ConnectFrame.print(type + ">" + line);    
            } catch (IOException e)
              {
                e.printStackTrace();  
              }
    }
}