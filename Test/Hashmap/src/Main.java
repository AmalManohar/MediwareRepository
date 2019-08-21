import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.*;

public class Main {
	
	public void Hashmap() throws IOException
	{
			File file = new File("C:\\Users\\SE-MENTOR\\Desktop\\project.txt"); 
			HashMap<String,String> hm=new HashMap<String, String>(); 
		  try(BufferedReader br = new BufferedReader(new FileReader(file));) 
		  { 
			  String currentLine = "";
			  //System.out.println(currentLine);
			  while ((currentLine = br.readLine()) != null)  
			  {
				  System.out.println(currentLine);
		            String parts[] = currentLine.split("\t");
		            hm.put(parts[0], parts[1]); 
		           
				  } 
			  br.close();
			  System.out.println(hm.toString());
			  } 
		  catch (IOException e) { // TODO: handle
			  e.printStackTrace();  
		 }
			List<Map.Entry<String,String>> list=new LinkedList<Map.Entry<String,String>>(hm.entrySet());
			System.out.println(list);
			Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
				@Override
				public int compare(java.util.Map.Entry<String, String> o1, java.util.Map.Entry<String, String> o2) {
					// TODO Auto-generated method stub
					return o2.getKey().compareTo(o1.getKey());
				}
			});
			File file1= new File("C:\\Users\\SE-MENTOR\\Desktop\\test.txt");
			System.out.println("\nASCENDING :\n"); 
			//try(BufferedWriter wr = new BufferedWriter(new FileWriter(file1))) 
		//	{ 
			/*for(<Map.Entry<Integer,String>> item:list) 
			{
			System.out.println(item); 
			wr.write(line); 
			wr.newLine(); } 
			}
			catch
				 (IOException e) { // TODO: handle exception e.printStackTrace(); }
				 
			//System.out.println(hm.get(2));
			//for(Map.Entry<Integer,String> item : list) {
			///	System.out.println(item);
			//}
			}*/
	
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Main m= new Main();
		m.Hashmap();
	}

}
