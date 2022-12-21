package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import telran.util.MyArrays;

class MyArraysTest {

	@Test
//	@Disabled
	void sortTest() {
		String[] strings = {"abcd", "lmn" , "zz"};
		String[] expected = {"zz", "lmn", "abcd"};
		
		MyArrays.sort(strings, new StringLengthComporator());
		assertArrayEquals(expected, strings);
	}
	
	@Test
//	@Disabled
	void evenOddTest() {
		Integer numbers[] = {13, 2, -8, 47, 100, 10, 7};
		Integer expected[] = {-8, 2, 10, 100, 47, 13, 7}; 		
		MyArrays.sort(numbers, new EvenOddComparator());
		assertArrayEquals(expected, numbers);
		
		Integer numbers1[] = {1, 2, 3, 4, 5, 6, 7 , 8 ,9};
		Integer expected1[] = {2, 4, 6, 8, 9, 7, 5, 3, 1};
		MyArrays.sort(numbers1, new EvenOddComparator());
		assertArrayEquals(expected1, numbers1);
		
		Integer numbers2[] = {55, 10, 9, 7, 2, -9 , 62, 11, 6, 3, 81};
		Integer expected2[] = {2, 6, 10, 62, 81,55, 11, 9, 7, 3, -9};
		MyArrays.sort(numbers2, new EvenOddComparator());
		assertArrayEquals(expected2, numbers2);
		
	}
			
	@Test
//	@Disabled
	void binarySearchTest() {		
		Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		assertEquals(7, MyArrays.BinarySearchComparator(numbers, 8, Integer::compare));
		
		Integer[] numbers1 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		assertEquals(0, MyArrays.BinarySearchComparator(numbers1, 10, Integer::compare));		
		assertEquals(9, MyArrays.BinarySearchComparator(numbers1, 100, Integer::compare));		
		assertEquals(-3, MyArrays.BinarySearchComparator(numbers1, 25, Integer::compare));
		assertEquals(-11, MyArrays.BinarySearchComparator(numbers1, 101, Integer::compare));	
		assertEquals(-1, MyArrays.BinarySearchComparator(numbers1, -1, Integer::compare));
		assertEquals(-1, MyArrays.BinarySearchComparator(numbers1, -55, Integer::compare));
	}
	
	
}

