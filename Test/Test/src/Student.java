import java.util.*;
import java.io.*;

public class Student implements Comparable<Student> {
	private String name;
	private int grade;
	private double gpa;

	public Student(String n, int g, double gp) {
		name = n;
		grade = g;
		gpa = gp;
	}

	public String getName() {
		return name;

	}

	public int getgrade() {
		return grade;
	}

	public double getGpa() {
		return gpa;

	}

	public int compareTo(Student other) {

		if (getgrade() > other.getgrade()) {
			return 1;
		} else if (getgrade() < other.getgrade()) {
			return -1;
		} else {
			return 0;
		}

		// return name.compareTo(other.getName());
	}

}