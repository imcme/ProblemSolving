package googlecodejam.revengeofthepancakes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * https://code.google.com/codejam/contest/6254486/dashboard#s=p1&a=1
 *
 * 예시에 함정이 있다. 5번 test case가 꼭 풀이 예시처럼 풀 필요는 없다.
 *
 * 위에서부터 차례로 모양이 달라질때, 뒤집으면 최소가 된다.
 *
 * @author MinCheol Lim <lim.mincheol@nhn.com>
 * @since 2017. 04. 10.
 */
public class RevengeOfThePancakes {
	public void run(String inputFilePath) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(inputFilePath));
		BufferedWriter out = new BufferedWriter(new FileWriter("./src/test/resources/googlecodejam/revengeofthepancakes/result.out"));

		int T = Integer.parseInt(in.readLine());
		int t = 0;
		while (t++ < T) {
			String S = in.readLine();

			char[] pancakes = S.toCharArray();
			int count = 0;
			for (int i = 1; i < pancakes.length; i++) {
				// 처음 것과 달라지면 그 인덱스전까지 뒤집는다.
				// 어차피 2지선다이기때문에, 코드를 줄여보려 i번째것을 j번째로 넣는것으로 만들었다.
				if (pancakes[0] != pancakes[i]) {
					for (int j = 0; j < i; j++) {
						pancakes[j] = pancakes[i];
					}

					count++;
				}
			}

			if (pancakes[0] == '-') {
				count++;
			}

			out.write("Case #" + t + ": " + count);
			out.newLine();
		}

		out.close();
		in.close();
	}
}
