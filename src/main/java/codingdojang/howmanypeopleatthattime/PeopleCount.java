package codingdojang.howmanypeopleatthattime;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author MinCheol Lim <lim.mincheol@nhn.com>
 * @since 2017. 02. 06.
 */
public class PeopleCount {
	List<String> clockInTime;
	List<String> clockOutTime;

	public PeopleCount(String filePath) {
		Stream<String> timeStream = null;
		try {
			timeStream = Files.lines(Paths.get(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}

		clockInTime = new ArrayList<>();
		clockOutTime = new ArrayList<>();
		convertAndSortTime(timeStream);
	}

	private void convertAndSortTime(Stream<String> timeStream) {
		timeStream.forEach(lines -> {
			String workTime[] = lines.split(" ");
			clockInTime.add(workTime[0]);
			clockOutTime.add(workTime[1]);
		});

		clockInTime = clockInTime.stream().sorted().collect(Collectors.toList());
		clockOutTime = clockOutTime.stream().sorted().collect(Collectors.toList());
	}

	/**
	 * 근무중인 사람은 clockIntime <= dutyTime < clockOutTime을 만족하는 경우로 가정한다.
	 *
	 * @param dutyTime
	 * @return
	 */
	public int getPeopleCountOnDuty(String dutyTime) {
		int workInPeoleCount = Collections.binarySearch(clockInTime, dutyTime);
		int workOutPeopleCount = Collections.binarySearch(clockOutTime, dutyTime);

		if (workInPeoleCount < 0) {
			workInPeoleCount = Math.abs(workInPeoleCount) - 2;
		}

		if (workOutPeopleCount < 0) {
			workOutPeopleCount = Math.abs(workOutPeopleCount) - 2;
		}

		return workInPeoleCount - workOutPeopleCount;
	}
}
