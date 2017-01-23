import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 글자의 개수는 모두 동일하다고 가정한다.
 *
 * @author MinCheol Lim <lim.mincheol@nhn.com>
 * @since 2017. 01. 23.
 */
public class WordLedder {
	String start;
	String end;
	String dict[];

	public WordLedder(String start, String end, String... dict) {
		this.start = start;
		this.end = end;
		this.dict = dict;
	}

	public int run() {
		List<Graph> wordGraph = makeGraph();

		Queue<Graph> queueToVisit = new LinkedList<>();
		queueToVisit.add(wordGraph.get(0));

		while (!queueToVisit.isEmpty()) {
			Graph current = queueToVisit.poll();

			// 방문
			// 다음 정점에 경로 길이 기록, 다음이 end인가 검사
			for (Graph vertex : current.nextVertex) {
				vertex.step = current.step + 1;
				if (vertex.word.equals(end)) {
					return vertex.step;
				}
			}

			// 다음에 방문할 정점을 넣는다.
			for (Graph nextWord : current.nextVertex) {
				if (!nextWord.discovered) {
					queueToVisit.add(nextWord);
				}
			}
		}

		return -1;
	}

	/**
	 * 다음 정점으로 향하는 그래프를 생성한다.
	 * @return
	 */
	private List<Graph> makeGraph() {
		// 그래프를 만들기위한 일자 리스트 생성
		List<Graph> wordGraph = new ArrayList<>();
		wordGraph.add(new Graph(start));
		for (String word : dict) {
			wordGraph.add(new Graph(word));
		}
		wordGraph.add(new Graph(end));

		// 그래프 생성
		for (Graph vertex : wordGraph) {
			for (Graph othertVertex : wordGraph) {
				if (vertex.isNextWord(othertVertex.word)) {
					vertex.nextVertex.add(othertVertex);
				}
			}
		}

		return wordGraph;
	}
}
