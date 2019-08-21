package com.demo.filetest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Find {
	ArrayList<String> lines = new ArrayList<String>();
	public void read() throws IOException
	{
			File file = new File("C:\\Users\\SE-MENTOR\\Desktop\\test.txt"); 
			
			try(BufferedReader br = new BufferedReader(new FileReader(file));)
			{ 
				String currentLine = br.readLine();
				while (currentLine != null) 
				{
					lines.add(currentLine);
					currentLine = br.readLine();
				} 
				for(String prnt:lines)
				{
					System.out.println(prnt);
				}
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Find fobj=new Find();
		fobj.read();
	}

}
