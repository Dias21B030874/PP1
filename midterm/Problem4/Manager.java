package Problem4;
import java.util.Date;
import java.util.Vector;

public class Manager extends Employee{
	private int bonus;
	Vector<Employee> employees = new Vector<>();
	public Manager(){
		super();
	}
	public Manager(String name, double salary, Date date, String insuranceNumber,Vector<Employee> employees){
		super(name, salary, date, insuranceNumber);
		this.employees = employees;
		recalculateBonus();
	}
	
	public String toString() {
		return super.toString() + " bonus:" + bonus + " employees:" + employees.toString();
	}
	public void setEmployees(Vector<Employee> empls) {
		this.employees = empls;
		recalculateBonus();
	}
	
	public int getBonus() {
		return bonus;
	}
	public void setHireDate(Date hireDate) {
		super.setHireDate(hireDate);
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	public void recalculateBonus() {
		this.bonus = employees.size() * 25;
	}
	
	public int compareTo(Manager m) {
		if(super.compareTo(m) == 0) {
			if(this.getBonus() > (m).getBonus()) return 1;
			if(this.getBonus() < (m).getBonus()) return 1;
			return 0;
		}
		return super.compareTo(m);
	}
//	public int compareTo(Manager m) {
//		if(super.compareTo(m) == 0) {
//			if(sum() > (m).sum()) return 1;
//			if(sum() < (m).sum()) return 1;
//			return 0;
//		}
//		return super.compareTo(m);
//	}
//	
//	private double sum() {
//		double sum = this.getBonus() + this.getSalary();
//		return 0;
//	}
	public Object clone() throws CloneNotSupportedException {
		Manager s = (Manager)super.clone();
		s.setBonus(this.getBonus());
		s.employees = (Vector<Employee>)employees.clone();
		return s;
	}

}
