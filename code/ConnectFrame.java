package code;
/**********************************************************
 * @author Victor Alegiani Sagnotti
 * @last_update 18/04/2018
 * @description Display the connection dialog frame
 **********************************************************/

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class ConnectFrame extends JFrame {

	private JPanel contentPane;
	private static JTextArea textArea;

	/**********************************************************
	 * Create frame
	 **********************************************************/
	public ConnectFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LicenseFrame.class.getResource("/img/guiicon.jpg")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Connect");
		setBounds(100, 100, 530, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		FileReader reader;
		textArea = new JTextArea("");		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(0,0,524,465);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane);
	}
	
	/**********************************************************
	 * Print message on frame
	 **********************************************************/
	public static void print(String s) {
		textArea.append("\n" + s);
	}

}
