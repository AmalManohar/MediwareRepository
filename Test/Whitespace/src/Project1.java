import java.io.*;
import java.util.*;

public class Project1 {
	public void sample() throws IOException{
		try {
			Scanner s=new Scanner(System.in);
		       System.out.println("Enter your string\n");
		       String a;
		       a = s.nextLine();
		       System.out.println("Input String is  :\n"+a);
		       a= a.replaceAll("\\s+","");
		       System.out.println("\nOutput String is  :\n"+a);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub	
		Project1 p=new Project1();
		p.sample();
	}
}