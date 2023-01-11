package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.*;


import telran.util.*;

public class SetTest extends CollectionTest {
	
	Set<Integer> set ;
	@BeforeEach
	void setUp() throws Exception {
		super.setUp();
		set = (Set<Integer>) collection;
	}

	@Override
	@Test
	void testAdd() {
		assertTrue(set.add(Integer.MAX_VALUE));
		assertFalse(set.add(Integer.MAX_VALUE));

	}

	@Override
	@Test
	void testIterator() {
				
		Integer[] actual = new Integer[numbers.length];
		int currentIndex = 0;
		Iterator<Integer> iter = set.iterator();
		while (iter.hasNext()) {
			actual[currentIndex++] = iter.next();
		}
		
		Integer[] array = new Integer[numbers.length];
		int index = 0;
		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			array[index++] = iterator.next();
		}

		assertEquals(set.size(), index);
		Arrays.sort(numbers);
		Arrays.sort(array);
		assertArrayEquals(numbers, array);
		assertThrowsExactly(NoSuchElementException.class, () -> iter.next());

	}
	
	
}