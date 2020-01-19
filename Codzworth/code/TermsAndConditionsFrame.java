package code;
/**********************************************************
 * @author Victor Alegiani Sagnotti
 * @last_update 11/04/2018
 * @description Display the terms and conditions frame
 **********************************************************/

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TermsAndConditionsFrame extends JFrame {

	private JPanel contentPane;

	/**********************************************************
	 * Create frame
	 **********************************************************/
	public TermsAndConditionsFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TermsAndConditionsFrame.class.getResource("/img/guiicon.jpg")));
		setTitle("Terms and Conditions");
		setResizable(false);
		setVisible(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 550, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		FileReader reader;
		
		JTextArea textArea = new JTextArea("");
		contentPane.add(textArea);
		textArea.setBounds(0, 0, 544, 320);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		JButton btn = new JButton("Continue");
		
		try {
			BufferedReader txtReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/files/LicenseBrief.txt")));
			textArea.read(txtReader, null);
			txtReader.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, Ressources.ERROR_TC_FILE_NOTFOUND, Ressources.ERROR, JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, Ressources.ERROR_TC_IO_ERROR + "\n" + e.getMessage(), Ressources.ERROR, JOptionPane.ERROR_MESSAGE);
		}
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter writer = new FileWriter("src/files/LicenseAccepted");
					writer.write("1");
					writer.close();
					dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, Ressources.ERROR_TC_WRITE_ERROR, Ressources.ERROR, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
			
		JCheckBox chckbx = new JCheckBox("I have read and accept the above Terms and Conditions.");
		chckbx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbx.isSelected()) {
					btn.setEnabled(true);
				}
				else {
					btn.setEnabled(false);
				}
			}
		});
		chckbx.setBounds(8, 338, 353, 25);
		contentPane.add(chckbx);
		btn.setEnabled(false);
		btn.setBounds(435, 338, 97, 25);
		contentPane.add(btn);
	}
}
