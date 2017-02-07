package codingdojang.palindromenumber

import spock.lang.Specification

/**
 * @author MinCheol Lim <lim.mincheol@nhn.com>
 * @since 2017. 02. 07.
 */
class PalindromeNumberSpec extends Specification {
    def "앞뒤가 같은 수 테스트"() {
        def palindromeNumber = new PalindromeNumber()

        expect:
        palindromeNumber.run(count) == number

        where:
        count   | number
        1       | "0"
        5       | "4"
        14      | "44"
        24      | "141"
        32      | "222"
        39      | "292"
        122     | "2222"
        1958    | "958859"
        30000   | "200000002"
        1000000 | "90000000009"
    }
}
