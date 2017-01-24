import java.util.ArrayList;
import java.util.List;

/**
 * @author MinCheol Lim <lim.mincheol@nhn.com>
 * @since 2017. 01. 24.
 */
public class Vertex {
	String word;
	int step;
	boolean discovered;
	List<Vertex> prevVertex;

	public Vertex(String word, int step) {
		this.word = word;
		this.step = step;
		this.discovered = false;
		prevVertex = new ArrayList<>();
	}
}
