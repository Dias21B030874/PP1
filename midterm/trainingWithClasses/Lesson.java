package trainingWithClasses;

import java.util.Vector;

public class Lesson {
	String name;
	private int id; // read only
	Days day;
	private Time time;
	Format format;
	static int cnt;
	static Vector<Lesson> lessons;
	
	static{
		lessons = new Vector<Lesson>();
	}
	{
		id = cnt++;
		lessons.add(this);
	}
	public Lesson() {
		
	}
	public Lesson(String name, Days day, Time time) {
		this.name = name;
		this.day = day;
		this.time = time;
	}
	public Lesson(String name, Days day, Time time, Format format)
	{
		this(name, day, time);
		this.format = format;
	}
	public int getId() {
		return id;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public String toString() {
		return "Lesson "+ name+ ", "+ id + ", "+day + ", "+format + ", "+time + ".";
	}
	public boolean checkCollision(Lesson b) {
		return checkCollision(this,b);
	}
	static boolean checkCollision(Lesson a, Lesson b) {
		return a.day==b.day && a.time.equals(b.time);
	}
}
