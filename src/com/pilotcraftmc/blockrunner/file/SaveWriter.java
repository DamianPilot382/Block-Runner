package com.pilotcraftmc.blockrunner.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveWriter {
	
	private FileWriter fw;
	private BufferedWriter bw;

	public void Write(String fileName, String toWrite){
		try{
			fw = new FileWriter(fileName, true);
			bw = new BufferedWriter(fw);
			bw.write(toWrite);
			bw.newLine();
			bw.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
