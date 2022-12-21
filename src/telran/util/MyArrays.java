package telran.util;


import java.util.Comparator;

public class MyArrays {
	static public <T> void sort(T[] objects, Comparator<T> comporator) {
		int length = objects.length;
		do {
			length--;
		} while (moveMaxAtEnd(objects, length, comporator));
	}

	private static <T> boolean moveMaxAtEnd(T[] objects, int length, Comparator<T> comp) {
		boolean res = false;
		for (int i = 0; i < length; i++) {
			if (comp.compare(objects[i], objects[i + 1]) > 0) {
				swap(objects, i, i + 1);
				res = true;
			}
		}
		return res;
	}

	private static <T> void swap(T[] objects, int i, int j) {
		T tmp = objects[i];
		objects[i] = objects[j];
		objects[j] = tmp;

	}

	public static <T> int BinarySearchComparator(T[] arraySorted, T searchedValue, Comparator<T> comp) {
		int position;
		int left = 0;
		int right = arraySorted.length - 1;
		int middle = arraySorted.length / 2;
		do {
			if (comp.compare(searchedValue, arraySorted[middle]) <= 0) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
			middle = (left + right) / 2;
		} while (left <= right && comp.compare(arraySorted[left], searchedValue) != 0);
		
		if (left < arraySorted.length && comp.compare(arraySorted[left], searchedValue) == 0) {
			position = left;
		} else {
			position = -(left + 1);
		}
		return position;
	}

	
	

}
