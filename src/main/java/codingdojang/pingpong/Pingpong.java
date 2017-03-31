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

			if (ordinal % 7 == 0 || (ordinal + "").contains("7")) {
				direction *= -1;
			}
		}

		return num;
	}
}
