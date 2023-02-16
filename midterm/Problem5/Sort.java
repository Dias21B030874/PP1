package Problem5;
import java.util.Arrays;

public class Sort {
	static <E> void swap(E [] array , int i, int j) {
		E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
	}
	
	public static <E extends Comparable> void quickSort(E [] array, int low, int high) {
		if (low < high) {
			E pivot = array[high];
	        int i = (low - 1);
	        for (int j = low; j <= high - 1; j++) {
	            if (array[j].compareTo(pivot) < 0) {
	                i++;
	                swap(array, i, j);
	            }
	        }
	        swap(array, i + 1, high);
            int pi = (i + 1);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
	}
	public static <E extends Comparable> void STLSort(E [] array) {
		Arrays.sort(array);
	}

}
