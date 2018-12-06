// There was a bad smell called "Comments", "Long Method"
// I refactored it to be self-commented. I used Extract Method and Change Method Signature.
public class Matcher {
	public Matcher() {
	}

	public boolean match(int[] expected, int[] actual, int clipLimit, int delta) {

		clipTooLarge(actual, clipLimit);

		return checkDifference(expected, actual) ? checkWithinDelta(expected, actual, delta) : false;
	}

	private boolean checkWithinDelta(int[] expected, int[] actual, int delta) {
		for (int i = 0; i < actual.length; i++)
			if (Math.abs(expected[i] - actual[i]) > delta)
				return false;
		return true;
	}

	private boolean checkDifference(int[] expected, int[] actual) {
		if (actual.length != expected.length)
			return false;
		return true;
	}

	private void clipTooLarge(int[] actual, int clipLimit) {
		for (int i = 0; i < actual.length; i++)
			if (actual[i] > clipLimit)
				actual[i] = clipLimit;
	}
}