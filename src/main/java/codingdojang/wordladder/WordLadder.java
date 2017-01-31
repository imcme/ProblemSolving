package codingdojang.wordladder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 코딩도장
 * Word Ladder - http://codingdojang.com/scode/499?answer_mode=hide
 *
 * 문자열의 길이는 모두 동일하며,
 * 동일한 문자열이 들어오지 않는다고 가정한다.
 *
 * @author MinCheol Lim <lim.mincheol@nhn.com>
 * @since 2017. 01. 23.
 */
public class WordLadder {
	Vertex start;
	Vertex end;
	List<Vertex> dict;

	List<String> minLadderList;

	public WordLadder(String start, String end, String... dict) {
		this.start = new Vertex(start, 1);
		this.end = new Vertex(end, -1);

		this.dict = new ArrayList<>();
		for (String word : dict) {
			this.dict.add(new Vertex(word, -1));
		}

		minLadderList = new ArrayList<>();
	}

	public List<String> run() {
		boolean finished = false;
		int minStep = Integer.MAX_VALUE;

		dict.add(end);

		Queue<Vertex> queue = new LinkedList<>();
		queue.add(start);

		while (!queue.isEmpty()) {
			Vertex current = queue.poll();

			// 최소 경로가 발견되었으며, 같은 최소 길이를 넘는 정점을 방문할 경우, 종료
			if (finished && current.step >= minStep) {
				break;
			}

			for (Vertex vertex : dict) {
				if (!vertex.discovered && isOneLetterDiffrent(current.word, vertex.word)) {
					vertex.step = current.step + 1;
					vertex.prevVertex.add(current);

					// 최소경로를 탐색하였을 경우 처리
					if (vertex.word.equals(end.word)) {
						finished = true;
						minStep = end.step;
						continue;
					}

					vertex.discovered = true;
					queue.add(vertex);
				}
			}
		}

		makeMinLadderList(end, new Stack<>());
		return minLadderList;
	}

	/**
	 * 두 문자열을 비교하여 한 문자만 다를 경우 true를 리턴한다.
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

	/**
	 * end 정점을 이용하여, 깊이 우선 탐색을 하며,
	 * 모든 최단 경로를 minLadderList에 추가한다.
	 * @return
	 */
	private void makeMinLadderList(Vertex current, Stack<String> routeStack) {
		routeStack.push(current.word);

		for (Vertex prev : current.prevVertex) {
			makeMinLadderList(prev, routeStack);
			routeStack.pop();
		}

		if (routeStack.peek().equals(start.word)) {
			minLadderList.add(printLadder((Stack<String>)routeStack.clone()));
		}
	}

	private String printLadder(Stack<String> stack) {
		String result = stack.pop();

		while (!stack.isEmpty()) {
			result += " " + stack.pop();
		}

		return result;
	}
}



