package googlecodejam.newcalendar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * @author MinCheol Lim <lim.mincheol@nhn.com>
 * @since 2017. 02. 09.
 */
public class NewCalendar {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("./src/test/resources/googlecodejam/newcalendar/A-small-practice.in"));

		int T = Integer.parseInt(in.readLine());
		int testCase = 0;
		while (testCase++ < T) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int monthOfYear = Integer.parseInt(st.nextToken());
			int dayOfMonth = Integer.parseInt(st.nextToken());
			int dayOfWeek = Integer.parseInt(st.nextToken());

			int weekNum = 0;
			int lineNum = 0;
			for (int m = 0; m < monthOfYear; m++) {
				for (int d = 0; d < dayOfMonth; d++) {
					if (weekNum == dayOfWeek - 1) {
						lineNum++;
						weekNum = 0;
					} else {
						weekNum++;
					}
				}

				if (weekNum != 0) {
					lineNum++;
				}
			}

			System.out.println("Case #" + testCase + ": " + lineNum);
		}
	}
}
