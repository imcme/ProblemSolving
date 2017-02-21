package googlecodejam.newcalendar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * @author MinCheol Lim <lim.mincheol@nhn.com>
 * @since 2017. 02. 09.
 */
public class NewCalendar {
	public void run(String filePath) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(filePath));
		BufferedWriter out = new BufferedWriter(new FileWriter("./src/test/resources/googlecodejam/newcalendar/result.out"));

		int T = Integer.parseInt(in.readLine());
		int caseCount = 0;
		while (caseCount++ < T) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			long totalMonth = Long.parseLong(st.nextToken());
			long dayPerMonth = Long.parseLong(st.nextToken());
			long dayPerWeek = Long.parseLong(st.nextToken());

			long totalLine = 0;

			// 싸이클 및 싸이클당 라인 수 구하기
			long monthPerCycle = 0;
			long dayCount = dayPerMonth;
			for (long month = 0; month < totalMonth; month++) {
				totalLine += dayCount / dayPerWeek;

				long remainDay = dayCount % dayPerWeek;
				if (remainDay == 0) {
					monthPerCycle = month + 1;
					break;
				}

				totalLine++;
				dayCount = remainDay + dayPerMonth;
			}

			// 일수 계산
			if (monthPerCycle > 0) {
				long cycleCount = totalMonth / monthPerCycle;
				long remainMonth = totalMonth % monthPerCycle;

				totalLine = totalLine * cycleCount;

				dayCount = dayPerMonth;
				while (remainMonth-- > 0) {
					totalLine += dayCount / dayPerWeek + 1;
					dayCount = (dayCount % dayPerWeek) + dayPerMonth;
				}
			}

			out.write("Case #" + caseCount + ": " + totalLine);
			out.newLine();
		}

		out.close();
		in.close();
	}
}
