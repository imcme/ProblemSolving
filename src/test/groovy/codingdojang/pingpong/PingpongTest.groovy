package codingdojang.pingpong

import spock.lang.Specification

/**
 * @author MinCheol Lim <lim.mincheol@nhn.com>
 * @since 2017. 03. 31.
 */
class PingpongTest extends Specification {
	def sut = new Pingpong()

	def "본문 테스트"() {
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
//		100000 | 212  // 이것은 스택오버플로우 발생
	}

	def "방향 테스트"() {
		expect:
		sut.makeDirection(x) == answer

		where:
		x | answer
		1|1
		2|1
		3|1
		4|1
		5|1
		6|1
		7|-1
		8|-1
	}
}
