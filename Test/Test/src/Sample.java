import java.io.*;
import java.util.*;
public class Sample {
	ArrayList<String> lines = new ArrayList<String>();
	public void sort() throws IOException
	{
			File file = new File("C:\\Users\\SE-MENTOR\\Desktop\\project.txt"); 
			
			try(BufferedReader br = new BufferedReader(new FileReader(file));)
			{ 
				String currentLine = br.readLine();
				while (currentLine != null) 
				{
					lines.add(currentLine);
					currentLine = br.readLine();
				} 
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}}
	public static void main(String[] args) throws Exception{
		Ascending obj=new Ascending();
		Descending obj1=new Descending();
		obj.ascending();
		obj1.descending();
		
	}

}
