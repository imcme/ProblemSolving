package codingdojang.pingpong;

/**
 * http://codingdojang.com/scode/514?answer_mode=hide
 *
 * @author MinCheol Lim <lim.mincheol@nhn.com>
 * @since 2017. 03. 31.
 */
public class Pingpong {
	public int run(int x) {
		int num = 1;
		int direction = 1;

		for (int ordinal = 2; ordinal <= x; ordinal++) {
			num += direction;

			if (ordinal % 7 == 0 || isContainsSeven(ordinal)) {
				direction *= -1;
			}
		}

		return num;
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
