package codingdojang.palindromenumber;

import javafx.util.Pair;

/**
 * 코딩도장
 * 앞뒤가 같은 수 - http://codingdojang.com/scode/401
 *
 * @author MinCheol Lim <lim.mincheol@nhn.com>
 * @since 2017. 01. 30.
 */
public class PalindromeNumber {
	public String run(int count) {
		Pair<Integer, Integer> digitAndStartNum = calculateDigitAndRemainCount(count);

		int digit = digitAndStartNum.getKey();
		int remainCount = digitAndStartNum.getValue();

		int halfNumber = calculateHalfNumber(digit, remainCount);

		return makeFullNumber(digit, halfNumber);
	}

	/**
	 * 해당하는 count가 몇개의 자리수 인지와
	 * 해당 자리수를 전부 계산하고 나머지 count를 반환
	 *
	 * @param count
	 * @return
	 */
	private Pair<Integer, Integer> calculateDigitAndRemainCount(int count) {
		if (count < 10) {
			return new Pair<>(1, count);
		}

		int remainCount = count - 10;

		int digit = 2;
		while (true) {
			int digitEndCount = 9 * (int)Math.pow(10, (digit - 1) / 2);

			if (remainCount < digitEndCount) {
				return new Pair<>(digit, remainCount);
			}

			remainCount -= digitEndCount;
			digit++;
		}
	}

	/**
	 * 해당 count에 해당하는 숫자의 앞 절반을 계산한다.
	 *
	 * @param digit
	 * @param remainCount
	 * @return
	 */
	private int calculateHalfNumber(int digit, int remainCount) {
		if (digit == 1) {
			return remainCount - 1;
		}

		int halfDigit = (digit - 1) / 2;
		int halfNumber = (int)Math.pow(10, halfDigit);

		halfNumber += remainCount - 1;

		return halfNumber;
	}

	/**
	 * 전체 숫자를 만들기 위해, 계산한 값의 절반을 중앙을 기점으로 데칼코마니한다.
	 *
	 * @param digit
	 * @param halfNumber
	 * @return
	 */
	private String makeFullNumber(int digit, int halfNumber) {
		String number = Integer.toString(halfNumber);
		String fullNumber;

		if (digit % 2 == 0) {
			fullNumber = number + new StringBuilder(number).reverse();
		} else {
			fullNumber = number + new StringBuffer(number.substring(0, number.length() - 1)).reverse();
		}

		return fullNumber;
	}
}
