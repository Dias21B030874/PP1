package Problem5;
import java.util.Date;
import java.util.Vector;
import java.util.Date;

import Problem4.Employee;

import trainingWithClasses.Time;

public class tester {

	public static void main(String[] args) {
		Chocolate[] arrC = new Chocolate[3];
		Employee[] arrE = new Employee[4];
		Time[] arrT = new Time[4];

		Employee e1 = new Employee("Bob", 0.9999, new Date(2003,12,2), "G112");
		Employee e2 = new Employee("Alex", 0.9999, new Date(2030,12,2), "G112");
		Employee e3 = new Employee("Bob", 1000, new Date(2003,12,2), "G112");
		Employee e4 = new Employee("Alex", 11999, new Date(2030,12,2), "G112");
		arrE[0] = e1; arrE[1] = e2; arrE[2] = e3; arrE[3] = e4;
		
		Chocolate c1 = new Chocolate("TWIX", 1.70);
		Chocolate c2 = new Chocolate("SNIKERS", 1.80);
		Chocolate c3 = new Chocolate("ALENKA", 1.60);
		arrC[0] = c1; arrC[1] = c2; arrC[2] = c3;
		
		Time t1 = new Time(11,11);
		Time t2 = new Time(12,11);
		Time t3 = new Time(12,40);
		Time t4 = new Time(9,11);
		arrT[0] = t1;arrT[1] = t2;arrT[2] = t3;arrT[3] = t4;
		
		Sort.STLSort(arrC);
		Sort.quickSort(arrE, 0, 3);
		Sort.quickSort(arrT, 0, 3);
		for(int i = 0 ; i < 3 ; i++) {
			System.out.println(arrC[i]);
		}
		for(int i = 0 ; i < 4 ; i++) {
			System.out.println(arrE[i]);
		}
		for(int i = 0 ; i < 4 ; i++) {
			System.out.println(arrT[i]);
		}
		

	}

}
