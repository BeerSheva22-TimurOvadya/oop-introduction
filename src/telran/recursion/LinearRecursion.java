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
		if (b < 0) {
			throw new IllegalArgumentException();
		}
		int res = 1;
		if (b == 1) {
			res = a;
		} else if (b > 1) {
			res = multiply(a, power(a, b - 1));
		}
		return res;
	}

	private static int multiply(int x, int y) {
		int res = 0;
		if (y < 0) {
			res = multiply(-x, -y);
		}
		else if (y == 1) {
			res = x;
		} else if (y > 1) {
			res = x + multiply(x, y - 1);
		}
		return res;
	}

	
	
	static public long sum(int ar[]) {
		return sum(0, ar);
	}

	private static long sum(int firstIndex, int[] ar) {
		long res = 0;
		if (firstIndex < ar.length) {
			res = ar[firstIndex] + sum(firstIndex + 1, ar);
		}
		return res;
	}

	
	public static long square(int x) {
		if (x < 0) {
			return square(-x);
		}
		if (x == 1) {
			return 1;
		}
			return x + x - 1 + square(x - 1);
	}

	
	
	public static void reverse(int ar[]) {
		reverse(0, ar.length - 1, ar);
	}

	private static void reverse(int firstIndex, int lastIndex, int[] ar) {
		if (firstIndex < lastIndex) {
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
