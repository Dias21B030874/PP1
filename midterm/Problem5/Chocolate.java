package Problem5;

public class Chocolate implements Comparable<Chocolate>{
	private double weight;
	private String name;
	Chocolate(){
		weight = 0.0;
		name = "Alenka";
	}
	Chocolate(String name, double weight){
		this.name = name;
		this.weight = weight;
	}
	public double getWeight() {
		return this.weight;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String toString() {
		return String.format("%s (%s)", name, weight);
	}
	
	public int compareTo(Chocolate c) {
		if(c == null) return 0;
		if(this.getWeight() > c.getWeight()) return 1;
		if(this.getWeight() < c.getWeight()) return -1;
		return 0;
	}

}
