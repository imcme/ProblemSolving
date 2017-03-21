package codingdojang.twoprinters;

/**
 * http://codingdojang.com/scode/449?answer_mode=hide
 *
 * x, y의 값이 나와있지 않기때문에 int로 가정하였으며
 * 최종 결과의 숫자역시 int를 넘지 않는다고 가정한다.
 *
 * @author MinCheol Lim <lim.mincheol@nhn.com>
 * @since 2017. 03. 21.
 */
public class TwoPrinters {
	public int run(int x, int y, int n) {
		int xTime = 0;
		int yTime = 0;

		while (n-- > 0) {
			int estimatedXTime = xTime + x;
			int estimatedYTime = yTime + y;

			if (estimatedXTime == estimatedYTime) {
				if (x < y) {
					xTime += x;
				} else {
					yTime += y;
				}
			} else if (estimatedXTime < estimatedYTime) {
				xTime += x;
			} else {
				yTime += y;
			}
		}

		return Math.max(xTime, yTime);
	}
}
