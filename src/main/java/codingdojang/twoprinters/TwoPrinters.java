package codingdojang.twoprinters;

/**
 * http://codingdojang.com/scode/449?answer_mode=hide
 *
 * 데이터 범위:
 * x, y의 값이 나와있지 않기때문에 int로 가정하였으며
 * 최종 결과의 숫자역시 int를 넘지 않는다고 가정한다.
 *
 * 풀이:
 * n = a + b라고 가정한다.
 * 총 시간인 T = ax 또는 bx 이다.
 *
 * T = ax라고 가정한다.
 * 이때 T가 최소가 되는 경우는 ax - by = 0 인경우이다. 이를 수식으로 풀면
 *
 * ax - (n - a)y = 0
 * ax - ny + ay = 0
 * a(x + y) = ny
 * a = ny / (x + y)
 *
 * 수식상 a는 실수지만, 문제상 정수이어야하기때문에,
 * 내림과 올림 둘다 계산하여 작은 수를 리턴한다.
 *
 * @author MinCheol Lim <lim.mincheol@nhn.com>
 * @since 2017. 03. 21.
 */
public class TwoPrinters {
	public int run(int x, int y, int n) {
		int floor = (n * y) / (x + y);
		int ceil = floor + 1;

		int floorAnswer = Math.max(floor * x, (n - floor) * y);
		int ceilAnswer = Math.max(ceil * x, (n - ceil) * y);

		return Math.min(floorAnswer, ceilAnswer);
	}
}
