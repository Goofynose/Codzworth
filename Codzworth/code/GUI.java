package code;
/**********************************************************
 * @author Victor Alegiani Sagnotti
 * @last_update 17/03/2018
 * @description Main GUI frame
 **********************************************************/

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class GUI{

	private JFrame frmMain;
	private static JLabel lblDate;
	private static JLabel lblSize;
	private static JLabel lblMeasure;
	private static JLabel lblLoc;
	private static HeatMap panel;

	/**********************************************************
	 * Create frame
	 **********************************************************/
	public GUI() {
		initialize();
	}

	/**********************************************************
	 * Initialise frame contents
	 **********************************************************/
	private void initialize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frmMain = new JFrame();
		frmMain.setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/img/guiicon.jpg")));
		frmMain.setTitle("Codzworth, V" + Ressources.getVersion());
		frmMain.setBounds(0, 0, screenSize.width/2, screenSize.height/2);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmMain.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Open 'Open file' dialog
		        Logic.displayFileDialogOpen();
			}
		});
		mnFile.add(mntmOpen);
		
		JMenuItem mntmExport = new JMenuItem("Export");
		mntmExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Open 'Export file' dialog
				Logic.displayFileDialogExport();
			}
		});
		mnFile.add(mntmExport);
		
		JMenuItem mntmStartCodzconnect = new JMenuItem("Start CdzConnect");
		mntmStartCodzconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Start cdzconnect.exe
				Logic.startCdzConnect();
			}
		});
		mnFile.add(mntmStartCodzconnect);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHowToUse = new JMenuItem("How to use");
		mntmHowToUse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Display 'How to' frame
				Logic.displayHowToFrame();
			}
		});
		mnHelp.add(mntmHowToUse);
		
		JMenuItem mntmCredits = new JMenuItem("Credits");
		mntmCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				//Display 'Credits' frame
				Logic.displayCreditsFrame();
			}
		});
		mnHelp.add(mntmCredits);
		
		JMenuItem mntmLicense = new JMenuItem("License");
		mntmLicense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Display 'License' frame
				Logic.displayLicenseFrame();
			}
		});
		mnHelp.add(mntmLicense);
		SpringLayout springLayout = new SpringLayout();
		frmMain.getContentPane().setLayout(springLayout);
		
		//Default empty data
		double[][] data = new double[100][100];
		
		//create heat map
		panel = new HeatMap(data, true, Gradient.GRADIENT_BLACK_TO_WHITE);
		
		springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, frmMain.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 170, SpringLayout.WEST, frmMain.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -10, SpringLayout.SOUTH, frmMain.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -210, SpringLayout.EAST, frmMain.getContentPane());
		panel.setBackground(Color.LIGHT_GRAY);
		frmMain.getContentPane().add(panel);
		
		JLabel lblHeatMap = new JLabel("Heat Map:");
		springLayout.putConstraint(SpringLayout.NORTH, lblHeatMap, 0, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, lblHeatMap, 10, SpringLayout.WEST, frmMain.getContentPane());
		frmMain.getContentPane().add(lblHeatMap);
		
		JLabel lblColourGradient = new JLabel("Colour Gradient:");
		springLayout.putConstraint(SpringLayout.WEST, lblColourGradient, 0, SpringLayout.WEST, lblHeatMap);
		frmMain.getContentPane().add(lblColourGradient);
		
		JButton btnUpdate = new JButton("Update Map");

		springLayout.putConstraint(SpringLayout.NORTH, btnUpdate, 6, SpringLayout.SOUTH, lblHeatMap);
		springLayout.putConstraint(SpringLayout.WEST, btnUpdate, 0, SpringLayout.WEST, lblHeatMap);
		frmMain.getContentPane().add(btnUpdate);
		
		JRadioButton rdbtnGradientRG = new JRadioButton("Red to Green");
		springLayout.putConstraint(SpringLayout.WEST, rdbtnGradientRG, 0, SpringLayout.WEST, lblHeatMap);
		frmMain.getContentPane().add(rdbtnGradientRG);
		
		JLabel lblData = new JLabel("Data");
		springLayout.putConstraint(SpringLayout.NORTH, lblData, 0, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, lblData, 91, SpringLayout.EAST, panel);
		frmMain.getContentPane().add(lblData);
		
		JLabel lblFileDate = new JLabel("File date:");
		springLayout.putConstraint(SpringLayout.NORTH, lblFileDate, 0, SpringLayout.NORTH, btnUpdate);
		springLayout.putConstraint(SpringLayout.WEST, lblFileDate, 6, SpringLayout.EAST, panel);
		frmMain.getContentPane().add(lblFileDate);
		
		JLabel lblFileSize = new JLabel("File size:");
		springLayout.putConstraint(SpringLayout.NORTH, lblFileSize, 15, SpringLayout.SOUTH, lblFileDate);
		springLayout.putConstraint(SpringLayout.WEST, lblFileSize, 6, SpringLayout.EAST, panel);
		frmMain.getContentPane().add(lblFileSize);
		
		JLabel lblMeasurementType = new JLabel("Measurement type:");
		springLayout.putConstraint(SpringLayout.NORTH, lblColourGradient, 0, SpringLayout.NORTH, lblMeasurementType);
		springLayout.putConstraint(SpringLayout.NORTH, lblMeasurementType, 15, SpringLayout.SOUTH, lblFileSize);
		springLayout.putConstraint(SpringLayout.WEST, lblMeasurementType, 6, SpringLayout.EAST, panel);
		panel.setLayout(null);
		frmMain.getContentPane().add(lblMeasurementType);
		
		JLabel lblLocation = new JLabel("Location:");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnGradientRG, -4, SpringLayout.NORTH, lblLocation);
		springLayout.putConstraint(SpringLayout.NORTH, lblLocation, 14, SpringLayout.SOUTH, lblMeasurementType);
		springLayout.putConstraint(SpringLayout.EAST, lblLocation, 0, SpringLayout.EAST, lblFileDate);
		frmMain.getContentPane().add(lblLocation);
		
		JRadioButton rdbtnGradientBW = new JRadioButton("Black to White");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnGradientBW, 6, SpringLayout.SOUTH, rdbtnGradientRG);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnGradientBW, 0, SpringLayout.WEST, lblHeatMap);
		frmMain.getContentPane().add(rdbtnGradientBW);
		
		JRadioButton rdbtnGradientBR = new JRadioButton("Blue to Red");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnGradientBR, 6, SpringLayout.SOUTH, rdbtnGradientBW);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnGradientBR, 0, SpringLayout.WEST, lblHeatMap);
		frmMain.getContentPane().add(rdbtnGradientBR);
		
		JRadioButton rdbtnGradientR = new JRadioButton("Rainbow");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnGradientR, 6, SpringLayout.SOUTH, rdbtnGradientBR);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnGradientR, 0, SpringLayout.WEST, lblHeatMap);
		frmMain.getContentPane().add(rdbtnGradientR);
		
		ButtonGroup group = new ButtonGroup();
	    group.add(rdbtnGradientRG);
	    group.add(rdbtnGradientBW);
	    group.add(rdbtnGradientBR);
	    group.add(rdbtnGradientR);
	    rdbtnGradientBW.setSelected(true);

		
		JLabel lblGraphOptions = new JLabel("Graph Options:");
		springLayout.putConstraint(SpringLayout.NORTH, lblGraphOptions, 37, SpringLayout.SOUTH, rdbtnGradientR);
		springLayout.putConstraint(SpringLayout.WEST, lblGraphOptions, 0, SpringLayout.WEST, lblHeatMap);
		frmMain.getContentPane().add(lblGraphOptions);
		
		JCheckBox chckbxDrawTitle = new JCheckBox("Draw Title");
		springLayout.putConstraint(SpringLayout.NORTH, chckbxDrawTitle, 6, SpringLayout.SOUTH, lblGraphOptions);
		springLayout.putConstraint(SpringLayout.WEST, chckbxDrawTitle, 0, SpringLayout.WEST, lblHeatMap);
		frmMain.getContentPane().add(chckbxDrawTitle);
		
		JCheckBox chckbxDrawLegend = new JCheckBox("Draw Legend");
		springLayout.putConstraint(SpringLayout.NORTH, chckbxDrawLegend, 6, SpringLayout.SOUTH, chckbxDrawTitle);
		springLayout.putConstraint(SpringLayout.WEST, chckbxDrawLegend, 0, SpringLayout.WEST, lblHeatMap);
		frmMain.getContentPane().add(chckbxDrawLegend);
		
		JCheckBox chckbxDrawXaxisTitle = new JCheckBox("Draw X-Axis Title");
		springLayout.putConstraint(SpringLayout.NORTH, chckbxDrawXaxisTitle, 6, SpringLayout.SOUTH, chckbxDrawLegend);
		springLayout.putConstraint(SpringLayout.WEST, chckbxDrawXaxisTitle, 0, SpringLayout.WEST, lblHeatMap);
		frmMain.getContentPane().add(chckbxDrawXaxisTitle);
		
		JCheckBox chckbxDrawYaxisTitle = new JCheckBox("Draw Y-Axis Title");
		springLayout.putConstraint(SpringLayout.NORTH, chckbxDrawYaxisTitle, 6, SpringLayout.SOUTH, chckbxDrawXaxisTitle);
		springLayout.putConstraint(SpringLayout.WEST, chckbxDrawYaxisTitle, 0, SpringLayout.WEST, lblHeatMap);
		frmMain.getContentPane().add(chckbxDrawYaxisTitle);
		
		JCheckBox chckbxDrawScales = new JCheckBox("Draw Scales");
		springLayout.putConstraint(SpringLayout.NORTH, chckbxDrawScales, 6, SpringLayout.SOUTH, chckbxDrawYaxisTitle);
		springLayout.putConstraint(SpringLayout.WEST, chckbxDrawScales, 0, SpringLayout.WEST, lblHeatMap);
		frmMain.getContentPane().add(chckbxDrawScales);
		
		lblDate = new JLabel("N/A");
		springLayout.putConstraint(SpringLayout.NORTH, lblDate, 0, SpringLayout.NORTH, btnUpdate);
		springLayout.putConstraint(SpringLayout.WEST, lblDate, 6, SpringLayout.EAST, lblFileDate);
		frmMain.getContentPane().add(lblDate);
		
		lblSize = new JLabel("N/A");
		springLayout.putConstraint(SpringLayout.NORTH, lblSize, 0, SpringLayout.NORTH, lblFileSize);
		springLayout.putConstraint(SpringLayout.WEST, lblSize, 0, SpringLayout.WEST, lblDate);
		frmMain.getContentPane().add(lblSize);
		
		lblMeasure = new JLabel("N/A");
		springLayout.putConstraint(SpringLayout.WEST, lblMeasure, 6, SpringLayout.EAST, lblMeasurementType);
		springLayout.putConstraint(SpringLayout.SOUTH, lblMeasure, 0, SpringLayout.SOUTH, lblColourGradient);
		frmMain.getContentPane().add(lblMeasure);
		
		lblLoc = new JLabel("N/A");
		springLayout.putConstraint(SpringLayout.NORTH, lblLoc, 0, SpringLayout.NORTH, lblLocation);
		springLayout.putConstraint(SpringLayout.WEST, lblLoc, 6, SpringLayout.EAST, lblLocation);
		frmMain.getContentPane().add(lblLoc);
		
		JLabel lblUpdate = new JLabel("Last update: ");
		springLayout.putConstraint(SpringLayout.WEST, lblUpdate, 44, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, lblUpdate, 0, SpringLayout.SOUTH, frmMain.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblUpdate, -10, SpringLayout.EAST, frmMain.getContentPane());
		lblUpdate.setText("Last update: " + Ressources.getLastUpdate());
		frmMain.getContentPane().add(lblUpdate);
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent f) {
				//Update heat map display
				if(rdbtnGradientRG.isSelected()) {panel.updateGradient(Gradient.GRADIENT_RED_TO_GREEN);}
				else if(rdbtnGradientBW.isSelected()) {panel.updateGradient(Gradient.GRADIENT_BLACK_TO_WHITE);}
				else if(rdbtnGradientBR.isSelected()) {panel.updateGradient(Gradient.GRADIENT_BLUE_TO_RED);}
				else {panel.updateGradient(Gradient.GRADIENT_RAINBOW);}
				
				if (chckbxDrawTitle.isSelected()) {panel.setTitle(lblMeasure.getText()); panel.setDrawTitle(true);}
				if (chckbxDrawLegend.isSelected()) {panel.setDrawLegend(true);}
				if (chckbxDrawXaxisTitle.isSelected()) {panel.setXAxisTitle("X axis"); panel.setDrawXAxisTitle(true);}
				if (chckbxDrawYaxisTitle.isSelected()) {panel.setYAxisTitle("Y axis"); panel.setDrawYAxisTitle(true);}
				if(chckbxDrawScales.isSelected()) {panel.setDrawXTicks(true); panel.setDrawYTicks(true);}
			}
		});
		frmMain.setVisible(true);
	}
	
	/**********************************************************
	 * Return frame object
	 **********************************************************/
	public JFrame getFrame() {
		return frmMain;
	}
	
	/**********************************************************
	 * Return panel object
	 **********************************************************/
	public JPanel getPanel() {
		return panel;
	}
	
	/**********************************************************
	 * Update the labels in the Data section
	 **********************************************************/
	public static void setLabels(String [] s) {
		lblDate.setText(s[3]);
		lblSize.setText(s[1]);
		lblMeasure.setText(s[4]);
		lblLoc.setText(s[2]);
	}
	
	/**********************************************************
	 * Update the heat map
	 **********************************************************/
	public static void setMap(double[][] d) {
		panel.updateData(d, true);
	}
}
