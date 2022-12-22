package telran.util.test;

import java.util.Comparator;

public class EvenOddComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer a, Integer b) {
		int res = 0;
		if (a % 2 == 0 && b % 2 == 0) {
			res = Integer.compare(a, b);
		} else if (a % 2 != 0 && b % 2 != 0) {
			res = -Integer.compare(a, b);
		} else if (a % 2 == 0) {
			res = -1;
		} else {
			res = 1;
		}
		return res;
	}

}
