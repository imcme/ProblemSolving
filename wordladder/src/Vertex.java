/**
 * @author MinCheol Lim <lim.mincheol@nhn.com>
 * @since 2017. 01. 24.
 */
public class Vertex {
	String word;
	int step;
	boolean discovered;

	public Vertex(String word) {
		this.word = word;
		this.step = 1;
		this.discovered = false;
	}
}
