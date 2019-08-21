import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

public class Descending extends Sample {
	public void descending() throws IOException
	{
		sort();
		File file1= new File("C:\\Users\\SE-MENTOR\\Desktop\\test1.txt");
		
		Collections.sort(lines,Collections.reverseOrder());
		System.out.println("\nDESCENDING :\n");
		try(BufferedWriter wr = new BufferedWriter(new FileWriter(file1));) {
			for(String line : lines) {
				System.out.println(line);
				wr.write(line); 
				wr.newLine();
				}
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	}
}
