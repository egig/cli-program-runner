package org.egig.java;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;

public class FileChooserListener implements ActionListener {
	
	public String selectedPath;
	JFileChooser inputChooser;
	DemoJFileChooser context;
	
	public FileChooserListener(DemoJFileChooser c) {
		this.context = c;
	}
	
	public void actionPerformed(ActionEvent e) {        
	    inputChooser = new JFileChooser();
	    inputChooser.setCurrentDirectory(new java.io.File("."));
	    inputChooser.setDialogTitle("Pilih input folder");
	    inputChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    
	    // disable the "All files" option.
	    inputChooser.setAcceptAllFileFilterUsed(false);
	    
	    if (inputChooser.showOpenDialog(this.context) == JFileChooser.APPROVE_OPTION) {
	    	selectedPath = inputChooser.getSelectedFile().toString();
	    	
	        if(e.getActionCommand() == "Pilih Folder Input") {
	        	context.inputPath = inputChooser.getSelectedFile().toString();
	        	context.inputLabel.setText("Input: "+ selectedPath);
	        } else if(e.getActionCommand() == "Pilih Folder Output") {
	        	this.context.outputPath = inputChooser.getSelectedFile().toString();
	        	context.outputLabel.setText("Input: "+ selectedPath);
	        }
	    }
	 }
}
