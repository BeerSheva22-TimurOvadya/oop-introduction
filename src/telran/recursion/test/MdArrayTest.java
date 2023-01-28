package telran.recursion.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

import telran.recursion.*;

class MdArrayTest {

	MdArray<Integer> arrayInteger = new MdArray<>(new int[] { 10, 5, 7 }, 50);
	MdArray<String> arrayString = new MdArray<>(new int[] { 3, 15, 7, 2, 10 }, "hello");

	@Test
	void toArrayTest() {

		Integer[] numbers = arrayInteger.toArray(new Integer[0]);
		assertEquals(350, numbers.length); // 10*5*7 = 350
		Integer[] expected = new Integer[350];
		Arrays.fill(expected, 50);
		assertArrayEquals(expected, numbers);

		String[] stringsArray = arrayString.toArray(new String[0]);
		assertEquals(6300, stringsArray.length); // 3 * 15 * 7 * 2 * 10 = 6300
	}

	@Test
	void forEachTest() {

		Integer[] sum = { 0 };
		arrayInteger.forEach(num -> sum[0] += num);
		assertEquals(17500, sum[0]); // 10 * 5 * 7 * 50 = 17500

		Integer[] length = { 0 };
		arrayString.forEach(str -> length[0] += str.length());
		assertEquals(31500, length[0]); // 3 * 15 * 7 * 2 * 10 * 5 = 31500

	}

	@Test
	void getValueTest() {

		assertEquals(50, arrayInteger.getValue(new int[] { 3, 4, 6 }));
		assertThrows(IllegalStateException.class, () -> arrayInteger.getValue(new int[] { 3, 4 }));
		assertThrows(NoSuchElementException.class, () -> arrayInteger.getValue(new int[] { 3, 4, 6, 0 }));
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> arrayInteger.getValue(new int[] { 3, 4, 7 }));
	}

	@Test
	void setValueTest() {

		arrayInteger.setValue(new int[] { 3, 4, 6 }, 100);
		assertEquals(100, arrayInteger.getValue(new int[] { 3, 4, 6 }));
		assertThrows(IllegalStateException.class, () -> arrayInteger.setValue(new int[] { 3, 4 }, 100));
		assertThrows(NoSuchElementException.class, () -> arrayInteger.setValue(new int[] { 3, 4, 6, 0 }, 100));
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> arrayInteger.setValue(new int[] { 3, 4, 7 }, 100));
	}
}