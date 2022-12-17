package telran.memory;

public class MemoryOperations {
			public static int getMaxAvailableMemory() {
				int left = 0;
				int right = Integer.MAX_VALUE;
				int res = left + (right - left) / 2;
				byte[] ar = null;
				while (left < right) {
					try {
						ar = new byte[res];
						left = res + 1;
					} catch (Throwable e) {
						right = res - 1;
					}
					ar = null;
					res = left + (right - left) / 2;
				} 
				return res;
			}
}
