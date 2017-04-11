package googlecodejam.revengeofthepancakes

import spock.lang.Specification

import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Collectors
/**
 * @author MinCheol Lim <lim.mincheol@nhn.com>
 * @since 2017. 04. 11.
 */
class RevengeOfThePancakesSpec extends Specification {
	def sut = new RevengeOfThePancakes();

	def "small case 테스트"() {
		given:
		def problemPath = "./src/test/resources/googlecodejam/revengeofthepancakes/B-small-practice.in";
		def resultPath = "./src/test/resources/googlecodejam/revengeofthepancakes/result.out";
		def answerPath = "./src/test/resources/googlecodejam/revengeofthepancakes/B-small-answer.out";

		when:
		sut.run(problemPath);

		then:
		def answerFile = Files.lines(Paths.get(answerPath));
		def resultFile = Files.lines(Paths.get(resultPath));

		def expect = answerFile.collect(Collectors.toList());
		def actual = resultFile.collect(Collectors.toList());

		expect == actual;
	}

	def "large case 테스트"() {
		given:
		def problemPath = "./src/test/resources/googlecodejam/revengeofthepancakes/B-large-practice.in";
		def resultPath = "./src/test/resources/googlecodejam/revengeofthepancakes/result.out";
		def answerPath = "./src/test/resources/googlecodejam/revengeofthepancakes/B-large-answer.out";

		when:
		sut.run(problemPath);

		then:
		def answerFile = Files.lines(Paths.get(answerPath));
		def resultFile = Files.lines(Paths.get(resultPath));

		def expect = answerFile.collect(Collectors.toList());
		def actual = resultFile.collect(Collectors.toList());

		expect == actual;
	}
}
