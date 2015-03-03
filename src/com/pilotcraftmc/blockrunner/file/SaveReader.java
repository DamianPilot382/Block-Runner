package com.pilotcraftmc.blockrunner.file;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SaveReader {
	
	@SuppressWarnings("unused")
	private Scanner in;
	
	public void Read(String fileName){
		try{
			in = new Scanner(new File(fileName)).useDelimiter(",\\s*");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
