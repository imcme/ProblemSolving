/**
 * @author MinCheol Lim <lim.mincheol@nhn.com>
 * @since 2017. 01. 23.
 */
public class WordLedderTest {
	public static void main(String[] args){
		// 워드레더 호출
//		WordLedder wordLadder = new WordLedder("hit", "cog", "hot", "dot", "dog", "lot", "log");
//		WordLedder wordLadder = new WordLedder("aa", "zz", "za", "az", "kk", "wq");
		WordLedder wordLadder = new WordLedder("aaa", "zzz", "zaa", "zaz", "aaz", "zaz", "zza", "azz");
		System.out.println(wordLadder.run());
	}
}
