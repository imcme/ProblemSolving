package googlecodejam.newcalendar

import spock.lang.Specification

import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Collectors

/**
 * @author MinCheol Lim <lim.mincheol@nhn.com>
 * @since 2017. 02. 20.
 */
class NewCalendarSpec extends Specification {
	def "small case 테스트"() {
		given:
		def problemPath = "./src/test/resources/googlecodejam/newcalendar/A-small-practice.in";
		def resultPath = "./src/test/resources/googlecodejam/newcalendar/result.out";
		def answerPath = "./src/test/resources/googlecodejam/newcalendar/A-small-answer.out";

		when:
		new NewCalendar().run(problemPath);

		then:
		def answerFile = Files.lines(Paths.get(answerPath));
		def resultFile = Files.lines(Paths.get(resultPath));

		def expect = resultFile.collect(Collectors.toList());
		def actual = answerFile.collect(Collectors.toList());

		expect == actual;
	}

	def "large case 테스트"() {
		given:
		def problemPath = "./src/test/resources/googlecodejam/newcalendar/A-large-practice.in";
		def resultPath = "./src/test/resources/googlecodejam/newcalendar/result.out";
		def answerPath = "./src/test/resources/googlecodejam/newcalendar/A-large-answer.out";

		when:
		new NewCalendar().run(problemPath);

		then:
		def answerFile = Files.lines(Paths.get(answerPath));
		def resultFile = Files.lines(Paths.get(resultPath));

		def expect = resultFile.collect(Collectors.toList());
		def actual = answerFile.collect(Collectors.toList());

		expect == actual;
	}
}
