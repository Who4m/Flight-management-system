
public class SequenceGenerator {
	private static int a;

	public SequenceGenerator() {
		a = 1;
	}

	public int next() {
		return a++;
	}
}
