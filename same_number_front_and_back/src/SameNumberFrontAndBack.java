import javafx.util.Pair;

/**
 * 코딩도장
 * 앞뒤가 같은 수 - http://codingdojang.com/scode/401
 * @author MinCheol Lim <lim.mincheol@nhn.com>
 * @since 2017. 01. 30.
 */
public class SameNumberFrontAndBack {
	private int numberOfCount;

	public SameNumberFrontAndBack(int numberOfCount) {
		this.numberOfCount = numberOfCount;
	}

	public String run() {
		Pair<Integer, Integer> digitAndStartNum = calculateDigitAndStartCount(numberOfCount);
		int digit = digitAndStartNum.getKey();
		int startCount = digitAndStartNum.getValue();

		int halfNumber = calculateHalfNumber(digit, startCount);

		return makeFullNumber(digit, halfNumber);
	}

	/**
	 * 해당하는 count가 몇개의 자리수 인지와 해당 자리수의 첫번째 count를 반환
	 *
	 * @param numberOfCount
	 * @return
	 */
	private Pair<Integer, Integer> calculateDigitAndStartCount(int numberOfCount) {
		if (numberOfCount < 10) {
			return new Pair<>(1, 1);
		}

		int digit = 2;
		double startCount = 10;
		while (true) {
			double endCount = startCount + 9 * Math.pow(10, (digit - 1) / 2);

			if (numberOfCount < endCount) {
				return new Pair<>(digit, (int)(startCount + 1));
			}

			startCount = endCount;
			digit++;
		}
	}

	/**
	 * 해당 count에 해당하는 숫자를 계산한다.
	 * 전체숫자의 절반을 나눈 숫자를 리턴한다.
	 *
	 * @param digit
	 * @param startCount
	 * @return
	 */
	private int calculateHalfNumber(int digit, int startCount) {
		int sameNumber = 0;

		if (digit > 1) {
			sameNumber = (int)(Math.pow(10, (digit - 1) / 2));
		}

		for (int count = startCount; count < numberOfCount; count++) {
			sameNumber++;
		}

		return sameNumber;
	}

	/**
	 * 전체 숫자를 만들기 위해, 계산한 값의 절반을 중앙을 기점으로 복제한다.
	 *
	 * @param digit
	 * @param halfNumber
	 * @return
	 */
	private String makeFullNumber(int digit, int halfNumber) {
		String number = Integer.toString(halfNumber);
		String fullNumber = number;

		if (digit % 2 == 0) {
			for (int i = number.length() - 1; i >= 0; i--) {
				fullNumber += number.charAt(i);
			}
		} else {
			for (int i = number.length() - 2; i >= 0; i--) {
				fullNumber += number.charAt(i);
			}
		}

		return fullNumber;
	}
}
