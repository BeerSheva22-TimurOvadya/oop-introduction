package telran.memory;

public class MemoryOperations {
			public static int getMaxAvailableMemory() {
				int left = 0;
				int right = Integer.MAX_VALUE;
				int res = (right + left) / 2;
				byte[] ar = null;
				while (left <= right) {
					ar = null;
					try {
						ar = new byte[res];
						left = res + 1;
					} catch (Throwable e) {
						right = res - 1;
					}					
					res =  (right + left) / 2;
				} 
				return res;
			}
}
