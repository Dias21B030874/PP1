package Problem3;

public interface MyCollection{
	boolean add(Object o);
	boolean addAll(MyCollection col);
	int size();
	
	boolean isEmpty();
	
	void clear();
	
	void remove(Object o);
	
	boolean contains(Object o);
	
	String toString();
}
