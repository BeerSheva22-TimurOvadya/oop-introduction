package telran.util.test;

import org.junit.jupiter.api.*;

import telran.util.*;

import static org.junit.Assert.*;

class LinkedListTest extends ListTest{
	LinkedList<Integer> linkedList;
	
	@BeforeEach
	@Override
	void setUp() throws Exception {
		collection = new LinkedList<>();
		super.setUp();
	}

	@Test
	void hasLoopTest() {
		linkedList = (LinkedList<Integer>) collection;		
		assertFalse(linkedList.hasLoop());
		linkedList.setNext(6, 2);
		assertTrue(linkedList.hasLoop());	
		
	}
}