package codingdojang.howmanypeopleatthattime

import spock.lang.Specification

/**
 * @author MinCheol Lim <lim.mincheol@nhn.com>
 * @since 2017. 02. 07.
 */
class PeopleCountSpec extends Specification {
    def "해당 시간내에 근무중인 인원을 가져온다."() {
        def filePath = "./src/test/resources/howmanypeopleatthattime/workLog.txt";
        def PeopleCount peopleCount = new PeopleCount(filePath)

        expect:
        peopleCount.getPeopleCountOnDuty(time) == count

        where:
        time       | count
        "00:01:26" | 1
        "03:59:15" | 85
        "04:57:35" | 96
        "06:35:35" | 114
        "07:55:16" | 122
        "09:20:55" | 141
        "10:17:02" | 145
        "12:33:01" | 147
        "17:25:03" | 112
        "21:10:01" | 36
    }
}
