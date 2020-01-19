package code;
/**********************************************************
 * @author Victor Alegiani Sagnotti
 * @last_update 11/04/2018
 * @description Display 'License' frame
 **********************************************************/

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.ScrollPaneConstants;
import java.awt.Toolkit;

public class LicenseFrame extends JFrame {

	private JPanel contentPane;

	/**********************************************************
	 * Create frame
	 **********************************************************/
	public LicenseFrame(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(LicenseFrame.class.getResource("/img/guiicon.jpg")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("License");
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTextArea textArea = new JTextArea("");
		try {
			BufferedReader txtReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/files/License.txt")));
			textArea.setWrapStyleWord(true);
			textArea.setLineWrap(true);
			textArea.read(txtReader, null);
			textArea.setEditable(false);
			txtReader.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, Ressources.ERROR_LF_FILE_NOTFOUND, Ressources.ERROR, JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, Ressources.ERROR_LF_IO_ERROR + "\n" + e.getMessage(), Ressources.ERROR, JOptionPane.ERROR_MESSAGE);
		}
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(0,0,894,465);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane);
	}
}
