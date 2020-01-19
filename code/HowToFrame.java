package code;
/**********************************************************
 * @author Victor Alegiani Sagnotti
 * @last_update 11/04/2018
 * @description Display 'How to' frame
 **********************************************************/

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HowToFrame extends JFrame {

	private JPanel contentPane;

	/**********************************************************
	 * Create frame
	 **********************************************************/
	public HowToFrame(){
		setTitle("How To Guide");
		setIconImage(Toolkit.getDefaultToolkit().getImage(HowToFrame.class.getResource("/img/guiicon.jpg")));
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JTextArea textArea = new JTextArea("");
		
		try {
			BufferedReader txtReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/files/LicenseBrief.txt")));
			textArea.setWrapStyleWord(true);
			textArea.setLineWrap(true);
			textArea.read(txtReader, "src/files/Guide.txt");
			textArea.setEditable(false);
			txtReader.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, Ressources.ERROR_HT_FILE_NOTFOUND, Ressources.ERROR, JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, Ressources.ERROR_HT_IO_ERROR + "\n" + e.getMessage(), Ressources.ERROR, JOptionPane.ERROR_MESSAGE);
		}
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(0,0,894,465);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane);
	}

}
