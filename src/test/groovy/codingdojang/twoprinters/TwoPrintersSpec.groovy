package codingdojang.twoprinters

import spock.lang.Specification

/**
 * @author MinCheol Lim <lim.mincheol@nhn.com>
 * @since 2017. 03. 21.
 */
class TwoPrintersSpec extends Specification {
	def "test TwoPrinters"() {
		def twoPrinters = new TwoPrinters();

		expect:
		twoPrinters.run(x, y, n) == answer;

		where:
		x  | y  | n   | answer
		1  | 1  | 5   | 3
		3  | 5  | 4   | 9
		23 | 17 | 30  | 299
		82 | 31 | 500 | 11253
	}
}
