package codingdojang.howmanypeopleatthattime;

/**
 * @author MinCheol Lim <lim.mincheol@nhn.com>
 * @since 2017. 02. 06.
 */
public class PeopleCountTest {
	public static void main(String[] args) {
		String filePath = "./src/test/resources/howmanypeopleatthattime/workLog.txt";
		PeopleCount peopleCount = new PeopleCount(filePath);

		System.out.println(peopleCount.getPeopleCountOnDuty("00:01:26")); //1
		System.out.println(peopleCount.getPeopleCountOnDuty("03:59:15")); //85
		System.out.println(peopleCount.getPeopleCountOnDuty("04:57:35")); //96
		System.out.println(peopleCount.getPeopleCountOnDuty("06:35:35")); //114
		System.out.println(peopleCount.getPeopleCountOnDuty("07:55:16")); //122
		System.out.println(peopleCount.getPeopleCountOnDuty("09:20:55")); //141
		System.out.println(peopleCount.getPeopleCountOnDuty("10:17:02")); //144
		System.out.println(peopleCount.getPeopleCountOnDuty("12:33:01")); //147
		System.out.println(peopleCount.getPeopleCountOnDuty("17:25:03")); //112
		System.out.println(peopleCount.getPeopleCountOnDuty("21:10:01")); //36

		//		for (int h = 0; h < 24; h++) {
		//			for (int m = 0; m < 60; m++) {
		//				for (int s = 0; s < 60; s++) {
		//					String dutyTime = (h < 10 ? "0" + h : "" + h);
		//					dutyTime += ":" + (m < 10 ? "0" + m : "" + m);
		//					dutyTime += ":" + (s < 10 ? "0" + s : "" + s);
		//
		//					System.out.println(peopleCount.getPeopleCountOnDuty(dutyTime));
		//				}
		//			}
		//		}
	}
}