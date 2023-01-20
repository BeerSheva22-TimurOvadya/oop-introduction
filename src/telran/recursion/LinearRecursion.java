package telran.recursion;

public class LinearRecursion {
	static public long factorial(int n) {
		long res = 0;
		if (n < 0) {
			res = factorial(-n);
		} else if (n < 2) {
			res = 1;
		} else {
			res = n * factorial(n - 1);
		}
		return res;
	}

	static public int power(int a, int b) {
		// TODO
		// your code cannot use cycles and *, / operators

//	if (b < 0) {
//		throw new IllegalArgumentException();
//	}
		int res = 1;
//	if(b == 1) {
//		res = a;
//	} else if(b > 1) {
//		res = a * power(a, b - 1);
//	}
		return res;
	}

	static public long sum(int ar[]) {		
		return sum(0, ar);
	}

	private static long sum(int firstIndex, int[] ar) {
		long res = 0;
		if(firstIndex < ar.length) {
			res = ar[firstIndex] + sum(firstIndex + 1, ar);
		}
		return res;
	}
	public static long square(int x) {
		
		//TODO
		// no cycles, no *, / operations, no additional functions, no static fields
		// квадрат от X умножить и делить нет, циклы - нет, доп функции нет
		return 0;
	}
	public static void reverse(int ar[]) {
		reverse(0, ar.length - 1, ar);
		}

	private static void reverse(int firstIndex, int lastIndex, int[] ar) {
		if(firstIndex < lastIndex) {
			swap(ar, firstIndex, lastIndex);
			reverse(firstIndex + 1, lastIndex - 1, ar);
		}
		
	}

	private static void swap(int[] ar, int firstIndex, int lastIndex) {
		int tmp = ar[firstIndex];
		ar[firstIndex] = ar[lastIndex];
		ar[lastIndex] = tmp;		
	}	
	
}
