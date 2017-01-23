import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 코딩도장
 * Word Ladder - http://codingdojang.com/scode/499?answer_mode=hide
 *
 * 글자의 개수는 모두 동일하며,
 * 동일한 글자가 들어오지 않는다고 가정한다.
 *
 * @author MinCheol Lim <lim.mincheol@nhn.com>
 * @since 2017. 01. 23.
 */
public class WordLadder {
	Vertex start;
	Vertex end;
	List<Vertex> dict;

	public WordLadder(String start, String end, String... dict) {
		this.start = new Vertex(start);
		this.end = new Vertex(end);

		this.dict = new ArrayList<>();
		for (String word : dict) {
			this.dict.add(new Vertex(word));
		}
	}

	public int run() {
		dict.add(end);

		Queue<Vertex> queue = new LinkedList<>();
		queue.add(start);

		while (!queue.isEmpty()) {
			Vertex current = queue.poll();
			for (Vertex vertex : dict) {
				if (!vertex.discovered && isOneLetterDiffrent(current.word, vertex.word)) {
					vertex.discovered = true;
					vertex.step = current.step + 1;
					queue.add(vertex);

					// 종료 조건
					if (vertex.word.equals(end.word)) {
						return end.step;
					}
				}
			}
		}

		return -1;
	}

	/**
	 * 두 문자열을 비교하여 한 문자만 다를 경우 true를 리턴한다.
	 *
	 * 가정
	 * - 두 문자열의 길이 같다
	 * - 같은 문자가 들어오지 않는다
	 *
	 * @param first
	 * @param second
	 * @return
	 */
	private boolean isOneLetterDiffrent(String first, String second) {
		int differenceCount = 0;
		int length = first.length();

		for (int i = 0; i < length; i++) {
			if (first.charAt(i) != second.charAt(i)) {
				differenceCount++;

				if (differenceCount > 1) {
					return false;
				}
			}
		}

		return true;
	}
}



