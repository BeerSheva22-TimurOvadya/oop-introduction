package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import telran.util.MyArrays;

class MyArraysTest {
	Integer numbers[] = {13, 2, -8, 47, 100, 10, -7, 7, 13, 47, 7, -7};
	static final int  N_NUMBERS = 10000;
	static final int  N_RUNS = 1000;
	String strings[] = { "ab", "abm", "abmb", "abmbc"};
				
		
	Comparator<Integer> evenOddComparator = this::evenOddCompare;
	@Test
	@Disabled
	void sortTest() {
		String[] strings = {"abcd", "lmn", "zz"};
		String[] expected = {"zz", "lmn", "abcd"};
		
		
		MyArrays.sort(strings, new StringLengthComparator());
		assertArrayEquals(expected, strings);
		
		
	}
	@Test
	@Disabled
	void evenOddTest() {
		
		Integer expected[] = {-8, 2, 10, 100, 47, 13, 7, -7};
		MyArrays.sort(numbers, evenOddComparator);
		assertArrayEquals(expected, numbers);
	}
	@Test
	@Disabled
	void binarySearchTest() {
		String strings[] = {
			"ab", "abm", "abmb", "abmbc"	
		};
		Comparator<String> comp = new StringsComparator();
		assertEquals(0, MyArrays.binarySearch(strings, "ab", comp));
		assertEquals(2, MyArrays.binarySearch(strings, "abmb", comp));
		assertEquals(3, MyArrays.binarySearch(strings, "abmbc", comp));
		assertEquals(-1, MyArrays.binarySearch(strings, "a", comp));
		assertEquals(-3, MyArrays.binarySearch(strings, "abma", comp));
		assertEquals(-5, MyArrays.binarySearch(strings, "lmn", comp));
	}
	@Test
	@Disabled
	void filterTest() {
		int dividor = 2;
		String subStr = "m";
		Predicate<Integer> predEven = t -> t % dividor == 0;
		Predicate<String> predSubstr = s -> s.contains(subStr);
		String expectedStr[] = { "abm", "abmb", "abmbc"	};				
		Integer expectedNumbers[] ={2, -8, 100, 10};
		assertArrayEquals(expectedStr, MyArrays.filter(strings, predSubstr));
		assertArrayEquals(expectedNumbers, MyArrays.filter(numbers, predEven));
		
	}
	int evenOddCompare(Integer o1, Integer o2) {
		int remainder =  Math.abs(o1) % 2;
		int res = remainder - Math.abs(o2) %2;
		if (res == 0) {
			res = remainder != 0 ? Integer.compare(o2, o1) : Integer.compare(o1, o2);
		}
		return res;
	}
	
	@Test
	@Disabled
	void removeIfTest() {
		Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, -7, -4};
		Integer[] expectedNumbers = { 1, 3, 5, 7, 9, -7 };
		assertArrayEquals(expectedNumbers, MyArrays.removeIf(numbers, t -> (t % 2) == 0));
		
		Integer[] numbers1 = {-2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		Integer[] expectedNumbers1 = {-2, -1, 0, 1, 2};
		assertArrayEquals(expectedNumbers1, MyArrays.removeIf(numbers1, t -> t >= 3));
		
		String[] expectedStr = {  "ab", "abm", "abmb" };		
		assertArrayEquals(expectedStr, MyArrays.removeIf(strings, t -> t.contains("c")));
	}
	
	@Test
	@Disabled
	void removeRepeatedTest() {
		Integer[] numbersRepeat = {1, 1, -2, 2, 0, 3, 4, 5, 6, 5, 5,  2, 7, 8, -2, 9, 0};
		Integer[] expectedNumbers = {1, -2, 2, 0, 3, 4, 5, 6, 7, 8,  9 };
		assertArrayEquals(expectedNumbers, MyArrays.removeRepeated(numbersRepeat));
		
		String[] stringsRepeat = { "abab", "8gTreWlkj", "abba", "abab", "ttt", "zzzz","8gTreWlkj", "zzz", "tTt", "tTt" };
		String[] expectedStr = {"abab", "8gTreWlkj", "abba", "ttt", "zzzz", "zzz", "tTt"};		
		assertArrayEquals(expectedStr, MyArrays.removeRepeated(stringsRepeat));
		
		Integer[] numbersRepeat1 = {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, -1};
		Integer[] expectedNumbers1 = {1, 0, -1};
		assertArrayEquals(expectedNumbers1, MyArrays.removeRepeated(numbersRepeat1));
	}	
	@Test
	@Disabled
	void containsTest() {
		Integer[] numbers = {1, 0, 2, 3, 4, 5};
		assertTrue(MyArrays.contains(numbers, 0));
		assertFalse(MyArrays.contains(numbers, -4));
		
		Integer[] numbers1 = {55, 55, 1, 55, -5, 6, 9, -55, 8};
		assertTrue(MyArrays.contains(numbers1, -55));
		assertFalse(MyArrays.contains(numbers1, 5));
		
		String[] strings = {  "ab", "abm", "abmb" };
		assertTrue(MyArrays.contains(strings, "ab"));
		assertFalse(MyArrays.contains(strings, "abc"));
	}
	@Test
	void joinFunctionalTest() {
		String expected = "13,2,-8,47,100,10,-7,7,13,47,7,-7";
		assertEquals(expected, MyArrays.join(numbers, ","));
	}
	@Test
	void joinPerformanceTest() {
		Integer largeArray[] = getLargeNumbersArray();
		for(int i = 0; i < N_RUNS; i++) {
			MyArrays.join(largeArray, ",");
		}
	}
	Integer[] getLargeNumbersArray() {
		Integer[] res = new Integer [N_NUMBERS];
		Arrays.fill(res, 1000);
		return res;
	}

}