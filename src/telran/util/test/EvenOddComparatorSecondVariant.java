package telran.util.test;

import java.util.Comparator;

public class EvenOddComparatorSecondVariant implements Comparator<Integer> {

	@Override
	public int compare(Integer a, Integer b) {
		int res = 0;
		if ((a & 1) == 0 && (b & 1) == 0) {
			res = a - b;
		} else if ((a & 1) == 1 && (b & 1) == 1) {
			res = b - a;
		} else if ((a & 1) == 0) {
			res = -1;
		} else {
			res = 1;
		}
		return res;
	}

}