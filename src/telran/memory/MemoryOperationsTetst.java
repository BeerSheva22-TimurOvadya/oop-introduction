package telran.memory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MemoryOperationsTest {
byte ar[];

	@Test
	void maxMemoryTest() {
		int maxMemory = MemoryOperations.getMaxAvaibleMemory();
		ar = new byte[maxMemory];
	}

}
