import java.util.ArrayList;
import java.util.List;

/**
 * @author MinCheol Lim <lim.mincheol@nhn.com>
 * @since 2017. 01. 23.
 */
public class Graph {
	public String word;
	public List<Graph> nextVertex;
	public boolean discovered;
	public int step;

	public Graph(String word) {
		this.word = word;
		nextVertex = new ArrayList<>();
		discovered = false;
		step = 1;
	}

	/**
	 * 다음 단어로 올 수 있는지 여부를 확인한다.
	 * 다음 단어의 기준은 문자가 1자만 다를 때이다.
	 *
	 * @param otherWord
	 * @return
	 */
	public boolean isNextWord(String otherWord) {
		if (word.equals(otherWord)) {
			return false;
		}

		int differenceCount = 0;
		for (int index = 0; index < word.length(); index++) {
			if (word.charAt(index) != otherWord.charAt(index)) {
				differenceCount++;

				if (differenceCount > 1) {
					return false;
				}
			}
		}

		return true;
	}
}
