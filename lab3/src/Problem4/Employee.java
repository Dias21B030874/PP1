package Problem4;
import java.util.Date;

public class Employee extends Person implements Comparable<Employee>, Cloneable{
	private double salary;
	private Date hireDate;
	private String insuranceNumber;
	public Employee(){
		super();
		this.salary = 0;
		this.hireDate = new Date(0,0,0);
		this.insuranceNumber = "---";
	}
	public Employee(String name, double salary, Date date, String insuranceNumber){
		super(name);
		this.salary = salary;
		this.hireDate = date;
		this.insuranceNumber = insuranceNumber;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	
	public String getInsuranceNumber() {
		return insuranceNumber;
	}
	
	public int compareTo(Employee e) {
		if(this.getSalary() > (e).getSalary()) return 1;
		if(this.getSalary() < (e).getSalary()) return -1;
		return 0;
	}
	
	public String toString() {
		return super.toString() + " salary:" + salary +" hire date:" + hireDate + " IN:" + insuranceNumber;
	}
	
	public boolean equals(Object o) {
		if(!super.equals(o)) return true;
		return salary == ((Employee)o).getSalary() && hireDate.equals(((Employee)o).getHireDate()) && insuranceNumber.equals(((Employee)o).getInsuranceNumber());
	}
	
	public Object clone() throws CloneNotSupportedException {
		Employee s = (Employee)super.clone();
		s.setHireDate((Date)this.hireDate.clone());
		return s;
	}

}
