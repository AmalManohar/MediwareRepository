import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Comparableexample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ArrayList<Student> users=new ArrayList<Student>();
		Student s1=new Student("amal",12,3.5);
		Student s2=new Student("manohar",9,3.7);
		System.out.println("compares to returns" + s1.compareTo(s2));
		int result=s1.compareTo(s2);
		if(result<0)
		{
			System.out.println(s1.getName() +" comes before "+ s2.getName());
		}
		else if(result>0)
		{
			System.out.println(s2.getName() +" comes before "+ s1.getName());
		}
		else
			System.out.println(s1.getName() +" is equals to "+ s2.getName());
		
	}

}