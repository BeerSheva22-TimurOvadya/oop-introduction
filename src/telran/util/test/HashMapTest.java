package telran.util.test;



import org.junit.jupiter.api.BeforeEach;


import telran.util.HashMap;

class HashMapTest extends MapTest {

	@Override
	@BeforeEach
	void setUp() throws Exception {
		map= new HashMap<>();
		super.setUp();
	}


}