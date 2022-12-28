package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.util.ArrayList;
import telran.util.List;

class ArrayListTest {

	@Test
	void test() {
		List<String> list = new ArrayList<>();	
		
		list.add("a");
		list.add("b");
		list.add(2, "c");
		list.add(3, "8");		
		assertEquals(4, list.size());
		
		assertEquals("a", list.get(0));
		assertEquals("b", list.get(1));
		assertEquals("c", list.get(2));
		assertEquals("8", list.get(3));
		
		assertEquals(2, list.indexOf("c"));
		assertEquals(4, list.size());
		
		assertEquals(3, list.lastIndexOf("8"));
		
		list.remove(3);
		assertEquals(3, list.size());
		
		assertEquals("c", list.get(2));
		assertTrue(list.removeIf(t -> t.contains("c")));		
		assertEquals(2, list.size());
		
		list.add(0, null);
		list.add(1, "0");
		list.add(2, "1");
		list.add(3, null);
		list.add(null);
		
		assertEquals(7, list.size());
		
		assertEquals(null, list.get(0));		
		assertEquals("0", list.get(1));
		assertEquals("1", list.get(2));
		assertEquals(null, list.get(3));
		assertEquals("a", list.get(4));	
		assertEquals("b", list.get(5));	
		assertEquals(null, list.get(6));
		
		String[] expected = {null, "0", "1", null, "a", "b", null};
		String[] expectedWithNullInEnd = {null, "0",  "1", null, "a", "b", null, null, null, null};
		
		assertArrayEquals(expected, list.toArray(new String[0]));
		assertArrayEquals(expectedWithNullInEnd, list.toArray(new String[10]));			
	}

}