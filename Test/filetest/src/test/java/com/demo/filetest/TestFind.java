package com.demo.filetest;

import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import org.junit.Test;
public class TestFind
{
	File file = new File("C:\\Users\\SE-MENTOR\\Desktop\\test2.txt");
	ArrayList<String> lines = new ArrayList<String>();
	
	@Test()
	public void find_file() 
	{
		assertTrue(file.exists());
	}
	
	@Test
	public void find_file_empty() 
	{
		long chk=file.length();
		assertTrue(chk!=0);
	}
	
	@Test
	public void valid_string() throws IOException 
	{
		int i=0;
		BufferedReader br = new BufferedReader(new FileReader(file));
		String[] input= {"1 Apple","2 Infosys","3 Palnar","4 Se-mentor","5 Ust global"};
		String currentLine = br.readLine();
		while (currentLine != null) 
		{
			lines.add(currentLine);
			currentLine = br.readLine();
		} 
		assertTrue(lines.contains(input[i]));
	}
	
	@Test
	public void exist_string() throws IOException 
	{
		BufferedReader br = new BufferedReader(new FileReader(file));
		String input="5 Ust global";
		String currentLine = br.readLine();
		while (currentLine != null) 
		{
			lines.add(currentLine);
			currentLine = br.readLine();
		} 
		assertTrue(lines.contains(input));
	}
	
	@Test
	public void is_sorted_asc() throws IOException 
	{
		BufferedReader br = new BufferedReader(new FileReader(file));
		String currentLine = br.readLine();
		int i;
		while (currentLine != null) 
		{
			lines.add(currentLine);
			currentLine = br.readLine();
		}
		boolean isSorted = true;
		for(i = 0; i < lines.size() - 1; i++) 
		{
		   if(lines.get(i).compareTo(lines.get(i + 1)) > 0 || lines.get(i).compareTo(lines.get(i + 1)) == 0) 
		   { 
		       isSorted = false;
		   }
		   else
		   {
			   isSorted=true;
		   }
		}
		assertEquals(true, isSorted);

	}
 
}
