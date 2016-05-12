package com.mcreasindo.synop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class SaveProgramListener implements ActionListener {
	
	DemoJFileChooser context;
	
	public SaveProgramListener(DemoJFileChooser c) {
		this.context = c;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String programLine = context.programLineTextField.getText();
		context.prefs.put(DemoJFileChooser.PROGRAM_LINE, programLine);
		
		JOptionPane.showMessageDialog(null, "Program Tersimpan: "+ programLine);
	}
}
