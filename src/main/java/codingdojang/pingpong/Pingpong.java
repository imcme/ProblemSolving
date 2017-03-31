package codingdojang.pingpong;

/**
 * http://codingdojang.com/scode/514?answer_mode=hide
 *
 * @author MinCheol Lim <lim.mincheol@nhn.com>
 * @since 2017. 03. 31.
 */
public class Pingpong {
	public int run(int x) {
		if (x == 1) {
			return 1;
		}

		return run(x - 1) + makeDirection(x - 1);
	}

	private int makeDirection(int ordinal) {
		if (ordinal == 1) {
			return 1;
		}

		if (ordinal % 7 == 0 || isContainsSeven(ordinal)) {
			return -1 * makeDirection(ordinal - 1);
		} else {
			return makeDirection(ordinal - 1);
		}
	}

	private boolean isContainsSeven(int num) {
		if (num == 0) {
			return false;
		}

		if (num % 10 == 7) {
			return true;
		}

		return isContainsSeven(num / 10);
	}
}
