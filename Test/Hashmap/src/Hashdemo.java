import java.io.*;
import java.util.*;

public class Hashdemo {
	
	private static final Exception NullPointerException = null;


	public void hashmapdemo() throws IOException
	{
				HashMap<Integer,String> hm=new HashMap<Integer, String>();
				Scanner input=new  Scanner(System.in);
		        try(BufferedReader in = new BufferedReader( new FileReader("C:\\Users\\SE-MENTOR\\Desktop\\project.txt")))
		        {
		        
		        
		           String currentline=in.readLine();
		          int key=0;
		            while(currentline != null)
		            {
		                String[] values = currentline.split(" ", 2);
		                //System.out.println(values);
		                for(String a:values)
		                {
		                	if(a.matches("[0-9]"))
		                	{
		                		key=Integer.parseInt(a);
		                	}
		                	hm.put(key, a);
		                }
		                currentline=in.readLine();
		            }
		        }
		        catch (FileNotFoundException e)
		        {
		        		e.printStackTrace();
		        }
		        List<Map.Entry<Integer,String>> list=new ArrayList<Map.Entry<Integer,String>>(hm.entrySet());
				//System.out.println(list);
		/*
		 * Collections.sort(list,new Comparator<Map.Entry<Integer,String>>() {
		 * 
		 * @Override public int compare(java.util.Map.Entry<Integer, String> o1,
		 * java.util.Map.Entry<Integer, String> o2) { // TODO Auto-generated method stub
		 * return o2.getKey().compareTo(o1.getKey()); } });
		 */
				for(Map.Entry<Integer,String> item : list) {
					System.out.println(item);
				}
		        System.out.println("enter the value to be searched");
		        int key=input.nextInt();
		        try{
		        	if(hm.get(key) != null) {
		        		System.out.println();
		        	}
		        	else
		        	{
		        		throw NullPointerException;
		        	}
		        }
		        	catch (Exception e) {
						// TODO: handle exception
		        		e.printStackTrace();
					}
		        }


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Hashdemo demo=new Hashdemo();
		demo.hashmapdemo();
		
	}

}
