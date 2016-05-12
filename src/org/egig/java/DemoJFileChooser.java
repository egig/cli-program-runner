package org.egig.java;
import javax.swing.*;

import java.awt.event.*;
import java.util.prefs.Preferences;
import java.awt.*;


public class DemoJFileChooser extends JPanel {
	
	public final static String PROGRAM_LINE = "program_line";

	JButton inputFolderBtn;
	JButton outputFolderBtn;
	JButton processBtn;
	JButton saveProgramBtn;
	
	public String inputPath;
	public String outputPath;
	
	JLabel programLabel;
	JLabel inputLabel;
	JLabel outputLabel;
	
	JTextField programLineTextField;
	
	JTextArea logTextArea;
	
	Preferences prefs = Preferences.userRoot().node(this.getClass().getName());
	
	public DemoJFileChooser() {
	    
		//We will use absolute layout
	    setLayout(null);
		
		programLineTextField = new JTextField();
		programLineTextField.setPreferredSize(new Dimension(200, 28));
		programLineTextField.setBounds(10, 10, 200, 28);
		
		String pL = prefs.get(PROGRAM_LINE, "{Ketik program disini}");
		programLineTextField.setText(pL);
		add(programLineTextField);
		
		saveProgramBtn  = new JButton("Simpan Program");
		saveProgramBtn.setBounds(210, 10, 140, 28);
		
		inputLabel = new JLabel("Input: Tidak ada input terpilih");
		inputLabel.setBounds(10, 40, 500, 40);
		
		inputFolderBtn  = new JButton("Pilih Folder Input");
		inputFolderBtn.setBounds(10, 80, 140, 28);
		
		outputLabel = new JLabel("Output: Tidak ada output terpilih");
		outputLabel.setBounds(10, 110, 500, 40);
		
		outputFolderBtn  = new JButton("Pilih Folder Output");
		outputFolderBtn.setBounds(10, 150, 140, 28);
		
		processBtn  = new JButton("Proses");
		processBtn.setBounds(10, 190, 140, 28);
		
		FileChooserListener listener = new FileChooserListener(this);
		
		inputFolderBtn.addActionListener(listener);
		outputFolderBtn.addActionListener(listener);
		processBtn.addActionListener(new ProcessListener(this));
		saveProgramBtn.addActionListener(new SaveProgramListener(this));
		
		add(saveProgramBtn);
		add(inputFolderBtn);
		add(outputFolderBtn);
		add(processBtn);

		add(inputLabel);
		add(outputLabel);
		
		logTextArea = new JTextArea();
		logTextArea.setPreferredSize(new Dimension(800, 600));
		logTextArea.setText("[log]");
		logTextArea.setEditable(false);
		
		JScrollPane scroll = new JScrollPane (logTextArea, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		scroll.setBounds(10, 230, 500, 100);
		
		add(scroll);
   }

	public Dimension getPreferredSize(){
		return new Dimension(600, 400);
    }

	public static void main(String s[]) {
	    JFrame frame = new JFrame("Jalankan Program CLI");
	    DemoJFileChooser panel = new DemoJFileChooser();
	    frame.addWindowListener(
	      new WindowAdapter() {
	        public void windowClosing(WindowEvent e) {
	          System.exit(0);
	          }
	        }
	      );
	    frame.getContentPane().add(panel);
	    frame.setSize(panel.getPreferredSize());
	    frame.setVisible(true);
    }
}