package com.mcreasindo.synop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ProcessListener implements ActionListener {
	
	DemoJFileChooser context;
	
	public ProcessListener(DemoJFileChooser c) {
		this.context = c;
	}
	
	public void actionPerformed(ActionEvent e) {
			
		String programLine = context.programLineTextField.getText();
		String programLineArgs = programLine+" \""+context.inputPath+"\" \""+context.outputPath+"\"";
		// System.out.println("Runnig: "+ programLineArgs);
		context.logTextArea.append("\nRunning: "+ programLineArgs);
		
		 try {
             Runtime rt = Runtime.getRuntime();
             Process pr = rt.exec(programLineArgs);

             BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));

             String line=null;

             while((line=input.readLine()) != null) {
                 //System.out.println(line);
            	 context.logTextArea.append("\n"+line);
             }

             int exitVal = pr.waitFor();
             // System.out.println("Exited with error code "+exitVal);
             context.logTextArea.append("\nExited with error code "+exitVal);

         } catch(Exception ex) {
             System.out.println(ex.toString());
             ex.printStackTrace();
         }
	}
}
