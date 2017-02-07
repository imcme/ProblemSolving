package codingdojang.wordladder

import spock.lang.Specification

/**
 * @author MinCheol Lim <lim.mincheol@nhn.com>
 * @since 2017. 02. 07.
 */
class WordLadderSpec extends Specification {
    def "wordladderTest"() {
        given:
        def wordLadder = new WordLadder("hit", "cog", "hot", "dot", "dog", "lot", "log")

        when:
        def result = wordLadder.run()

        then:
        result == ["hit hot dot dog cog", "hit hot lot log cog"]
    }
}
