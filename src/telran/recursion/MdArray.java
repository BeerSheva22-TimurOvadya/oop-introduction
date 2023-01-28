package telran.recursion;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class MdArray<T> {
	private MdArray<T>[] array;
	private T value;

	public MdArray(int dimensions[], T value) {
		this(dimensions, 0, value);
	}

	@SuppressWarnings("unchecked")
	public MdArray(int[] dimensions, int firstDim, T value) {
		if (firstDim == dimensions.length) {
			this.value = value;
			array = null;
		} else {
			this.value = null;
			array = new MdArray[dimensions[firstDim]];
			for (int i = 0; i < array.length; i++) {
				array[i] = new MdArray<>(dimensions, firstDim + 1, value);
			}

		}
	}

	public void forEach(Consumer<T> consumer) {
		forEach(array, consumer);
	}

	private void forEach(MdArray<T>[] array, Consumer<T> consumer) {
		for (MdArray<T> mdArray : array) {
			if (mdArray.array != null) {
				forEach(mdArray.array, consumer);
			} else {
				consumer.accept(mdArray.value);
			}
		}
	}

	public T[] toArray(T[] ar) {
		ArrayList<T> list = new ArrayList<>();
		forEach(array, mdArray -> list.add(mdArray));
		return list.toArray(ar);
	}

	public T getValue(int[] dimensions) {
		MdArray<T> mdArray = getScalarArray(dimensions);
		if (mdArray.value == null) {
			throw new IllegalStateException();
		}
		return mdArray.value;
	}

	public void setValue(int[] dimensions, T value) {
		MdArray<T> mdArray = getScalarArray(dimensions);
		if (mdArray.array != null) {
			throw new IllegalStateException();
		}
		mdArray.value = value;
	}

	private MdArray<T> getScalarArray(int[] dimensions) {
		MdArray<T> mdArray = array[dimensions[0]];
		for (int i = 1; i < dimensions.length; i++) {
			if (mdArray.array != null) {
				mdArray = mdArray.array[dimensions[i]];
			} else {
				throw new NoSuchElementException();
			}
		}

		return mdArray;
	}

}
