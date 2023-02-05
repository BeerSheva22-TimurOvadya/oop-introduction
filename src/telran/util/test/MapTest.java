package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.Map;

abstract class MapTest {

	Map<Integer, String> map;

	@BeforeEach
	void setUp() throws Exception {
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
	}

	@Test
	void putTest() {
		assertEquals("One", map.put(1, "אחד"));
		assertEquals("אחד", map.get(1));
		assertNull(map.put(4, "Four"));
		assertEquals("Four", map.get(4));

	}

	@Test
	void putIfAbsentTest() {
		assertEquals("Three", map.putIfAbsent(3, "Три"));
		assertEquals("Three", map.get(3));
		assertNull(map.putIfAbsent(5, "Five"));
	}

	@Test
	void getTest() {
		assertEquals("One", map.get(1));
		assertNull(map.get(1000));
	}

	@Test
	void getOrDefaultTest() {
		assertEquals("Two", map.getOrDefault(2, "String"));
		assertEquals("String", map.getOrDefault(5, "String"));
	}

	@Test
	void containsKeyTest() {
		assertTrue(map.containsKey(1));
		assertFalse(map.containsKey(5));
	}

	@Test
	void containsValueTest() {
		assertTrue(map.containsValue("Two"));
		assertFalse(map.containsValue("Five"));
	}

	@Test
	void valuesTest() {
		map.values().forEach(n -> assertTrue(map.containsValue(n)));
	}

	@Test
	void keySetTest() {
		map.keySet().forEach(n -> assertTrue(map.containsKey(n)));
	}

	@Test
	void entrySetTest() {
		map.entrySet().forEach(n -> assertTrue(map.containsKey(n.getKey())));		
	}

	@Test
	void removeTest() {
		assertEquals("Two", map.remove(2));
		assertNull(map.get(2));
		assertFalse(map.containsKey(2));
		assertFalse(map.containsValue("Two"));
	}

}