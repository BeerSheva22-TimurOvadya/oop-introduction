package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.util.TreeSet;

class TreeSetTest extends SetTest {
	@Override
	@BeforeEach
	void setUp() throws Exception {
		collection = new TreeSet<>();
		super.setUp();
	}

	@Override
	@Test
	void testIterator() {
		Iterator<Integer> it = collection.iterator();
		Integer[] actual = new Integer[numbers.length];
		Arrays.fill(actual, null);
		int i = 0;
		while (it.hasNext()) {
			actual[i++] = it.next();
		}
		Arrays.sort(numbers);
		assertArrayEquals(numbers, actual);
		assertThrowsExactly(NoSuchElementException.class, () -> it.next());
	}

}