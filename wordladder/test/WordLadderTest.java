/**
 * @author MinCheol Lim <lim.mincheol@nhn.com>
 * @since 2017. 01. 23.
 */
public class WordLadderTest {
	public static void main(String[] args){
		// 워드레더 호출
		WordLadder wordLadder = new WordLadder("hit", "cog", "hot", "dot", "dog", "lot", "log");
//		WordLadder wordLadder = new WordLadder("aa", "zz", "za", "az", "kk", "wq");
//		WordLadder wordLadder = new WordLadder("aaa", "zzz", "zaa", "zaz", "aaz", "zaz", "zza", "azz");
		System.out.println(wordLadder.run());
	}
}
