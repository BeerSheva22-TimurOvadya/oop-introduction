package telran.util;

import java.util.Arrays;
import java.util.function.Predicate;

public class ArrayList<T> implements List<T> {
	static final int DEFAULT_CAPACITY = 16;
private T[] array;
private int size;

@SuppressWarnings("unchecked")
public ArrayList(int capacity) {
	array = (T[]) new Object[capacity];
}
public ArrayList() {
	this(DEFAULT_CAPACITY);
	
}
	@Override
	public boolean add(T element) {
		if(size == array.length) {
			reallocate();
		}
		array[size++] = element;
		return true;
	}
	
	private void reallocate() {
		array = Arrays.copyOf(array,array.length * 2);		
	}
	
	@Override
	public boolean remove(T pattern) {
		boolean res = false;
		int index = indexOf(pattern);
		if (index > -1) {			
			removeByIndex(index);
			res = true;
		}		
		return res;
	}

	@Override
	public boolean removeIf(Predicate<T> predicate) {
		boolean res = false;
		int place = 0;
		int sizeDel = size;
		for (int i = 0; i < size; i++) {
			if (predicate.test(array[i])) {
				sizeDel--;
			} else {
				array[place++] = array[i];
			}
		}
		res = shift(sizeDel);
		return res;
	}

	private boolean shift(int sizeDel) {
		boolean res = false;
		if (sizeDel < size) {
			res = true;
			for (int i = sizeDel; i < size; i++) {
				array[i] = null;
			}
			size = sizeDel;
		}
		return res;
	}
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {		
		return size;
	}

	@Override
	public boolean contains(T pattern) {
		int index = 0;
		while (index < size && !isEquals(index, pattern)) {
			index++;
		}
		return index < size;
	}
	
	private boolean isEquals(int index, T pattern) {
		return pattern == null ?  array[index] == null : pattern.equals(array[index]);
	}

	@Override
	public T[] toArray(T[] ar) {
		if (size > ar.length) {
			ar = Arrays.copyOf(ar, size);	
		}
		System.arraycopy(array, 0, ar, 0, size);		
		for (int i = size; i < ar.length; i++) {
			ar[i] = null;
		}	
		return ar;
	}
	

	@Override
	public void add(int index, T element) {
		if (size == array.length) {
			reallocate();
		}
		System.arraycopy(array, index, array, index + 1, size - index);
		array[index] = element;
		size++;
	}

	@Override
	public T remove(int index) {
		T res = null;
		if (size() > index && index > -1) {
			res = array[index];
			removeByIndex(index);			
		}
		return res;
	}
	
	private void removeByIndex(int index) {
		size--;
		System.arraycopy(array, index+1, array, index, size - index);		
		array[size] = null;		
	}
	
	@Override
	public int indexOf(T pattern) {
		int index = 0;
		while (index < size && !isEquals(index, pattern)) {
			index++;
		}
		return index < size ? index : -1;
	}
	
	@Override
	public int lastIndexOf(T pattern) {
		int index = size - 1;
		while (index > -1 && !isEquals(index, pattern)) {
			index--;
		}
		return index;
	}

	@Override
	public T get(int index) {		
		return (size() > index && index >= 0) ? array[index] : null;
	}

	@Override
	public T set(int index, T element) {
		T res = get(index);
		array[index] = element;
		return res;
	}

}
