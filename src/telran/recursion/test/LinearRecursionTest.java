package telran.recursion.test;

import static org.junit.jupiter.api.Assertions.*;
import static telran.recursion.LinearRecursion.*;

import org.junit.jupiter.api.Test;

public class LinearRecursionTest {
	
	@Test
	void fTest() {
		f(6);
	}
	
	void f(int a) {
		if (a > 5) {
			f(a - 1);
		}
	}
	
	@Test
	void factorialTest() {
		assertEquals(24, factorial(4));		
		assertEquals(24 * 5* 6, factorial(6));
		assertEquals(24, factorial(-4));
	}
	
	@Test
	void powerTest() {
		assertEquals(1, power(1000, 0));
		assertThrowsExactly(IllegalArgumentException.class, () ->power(1000, -1));
		assertEquals(1000, power(10, 3));
		assertEquals(-1000, power(-10, 3));
	}
	@Test
	void sumTest() {
		int ar[] = {1, 2, 3, 4, 5, 6};
		assertEquals(21, sum(ar));
		assertEquals(0, sum(new int [0]));
	}
	@Test
	void reverseTest() {
		int ar[] = {1, 2, 3, 4, 5, 6};
		int expected [] = {6, 5, 4, 3, 2, 1};		
		int ar1[] = {1, 2, 3, 4, 5, 6, 7};
		int expected1 [] = {7, 6, 5, 4, 3, 2, 1};	
		reverse(ar);
		reverse(ar1);
		assertArrayEquals(expected, ar);
		assertArrayEquals(expected1, ar1);	
		
	}
	@Test
	void squareTest() {
		assertEquals(100, square(10));
		assertEquals(100, square(-10));
		assertEquals(0, square(0));
		assertEquals(1, square(1));
	}
	
	@Test
	void testIsSubstring() {
		String expected = "Hello World 123";
		assertTrue(isSubstring(expected, "Hello World 123"));
		assertTrue(isSubstring(expected, "Hello"));
		assertTrue(isSubstring(expected, "World"));
		assertTrue(isSubstring(expected, "123"));
		assertTrue(isSubstring(expected, "H"));
		assertTrue(isSubstring(expected, "l"));
		assertTrue(isSubstring(expected, "He"));		
		assertTrue(isSubstring(expected, " "));
		assertTrue(isSubstring(expected, "o W"));
		assertTrue(isSubstring(expected, "orl"));
		assertTrue(isSubstring("tgrorttreforltreftgo", "orl"));
		assertTrue(isSubstring("tgrorttreforltreftgo", "tre"));
		
		assertFalse(isSubstring(expected, "321 dlroW olleH"));
		assertFalse(isSubstring(expected, ""));
		assertFalse(isSubstring(expected, " HelloWorld123 "));
		assertFalse(isSubstring(expected, "hello world 123"));
		assertFalse(isSubstring(expected, "Helllo Word 123"));
		assertFalse(isSubstring(expected, "o W "));
		assertFalse(isSubstring(expected, "HELLO WORLD 123"));
		assertFalse(isSubstring(expected, "h"));
		assertFalse(isSubstring("", " "));		
	}
	
	
}