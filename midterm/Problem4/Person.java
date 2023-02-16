package Problem4;

public class Person implements Cloneable{
	private String name;
	public Person(){
		this.name = "Bobby";
	}
	
	public Person(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null) return false;
		if(this.getClass() != o.getClass()) return false;
		return this.name.equals(((Person)o).getName());
	}
	
	public Object clone() throws CloneNotSupportedException {
		Person s = (Person)super.clone();
		s.setName((String)this.name);
		return s;
	}

}
