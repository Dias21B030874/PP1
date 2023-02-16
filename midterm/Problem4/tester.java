package Problem4;
import java.util.Date;
import java.util.Vector;

import Problem5.Chocolate;
import Problem5.Sort;
import trainingWithClasses.Time;

import java.util.Collections;

public class tester{

	public static void main(String[] args) throws CloneNotSupportedException{
		
		//NameComparator a = new NameComparator();
		//a.compare(null, null);
		//System.out.println(a.compare(null, null));
		
		Employee e1 = new Employee("Bob", 0.9999, new Date(2003,12,2), "G112");
		Employee e2 = new Employee("Alex", 0.9999, new Date(2030,12,2), "G112");
		System.out.println(e1);
		Vector<Employee> v = new Vector<Employee>();
		Vector<Manager> vm = new Vector<Manager>();
		v.add(e1);
		Manager m1 = new Manager("Bob", 0.9999, new Date(2003,12,2), "G112", v);
		System.out.println(m1);
		e1.setSalary(10000);
		v.add(e2);
		System.out.println(m1);
		Manager m2 = (Manager)m1.clone();
		System.out.println(m2);
		v.add(e1);
		v.add((Employee)e1.clone());
		e1.setSalary(9000);
		System.out.println(m1);
		System.out.println(m2);
		Collections.sort(v, new HireDateComparator());
		System.out.println(m1);
		System.out.println(m2);
		
		vm.add(m2); vm.add(m1);
		m1.setHireDate(new Date(201,1,2));
		Collections.sort(vm, new HireDateComparator());
		System.out.print(vm);
		
//		Employee[] arrE = new Employee[4];
//		
//		Employee e007 = new Employee("Bob", 0.9999, new Date(2003,12,2), "G112");
//		Employee e008 = new Employee("Alex", 0.9999, new Date(2030,12,2), "G112");
//		Employee e009 = new Employee("Bob", 1000, new Date(2003,12,2), "G112");
//		Employee e010 = new Employee("Alex", 11999, new Date(2030,12,2), "G112");
// 		arrE[0] = e007; arrE[1] = e008; arrE[2] = e009; arrE[3] = e010;
// 		Sort.quickSort(arrE, 0, 3);
// 		
// 		for(int i = 0 ; i < 4 ; i++) {
//			System.out.println(arrE[i]);
	}

}
//}