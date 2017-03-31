package codingdojang.pingpong

import spock.lang.Specification

/**
 * @author MinCheol Lim <lim.mincheol@nhn.com>
 * @since 2017. 03. 31.
 */
class PingpongTest extends Specification {
	def "test"() {
		def sut = new Pingpong()

		expect:
		sut.run(x) == answer

		where:
		x      | answer
		1      | 1
		7      | 7
		8      | 6
		14     | 0
		17     | 3
		21     | -1
		22     | 0
		68     | 2
		100    | 2
		10000  | -122
		100000 | 212
	}
}
