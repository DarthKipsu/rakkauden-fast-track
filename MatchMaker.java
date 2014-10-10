
import java.util.Arrays;
import java.util.List;


public class MatchMaker {
	private List<int[]> pairs;
	private int compatibilityPercent;

	public MatchMaker(List<int[]> pairs) {
		this.pairs = pairs;
		compatibilityPercent = 0;
	}
	
	public int matchesWithCompatibility(int percent) {		
		compatibilityPercent = percent;
		return findMatches();
	}

	private int findMatches() {
		int matches = 0;
		for (int i=0; i<pairs.size()-1; i++) {
			matches += matchesFor(i);
		}		
		return matches;
	}

	private int matchesFor(int i) {
		int matches = 0;
		for (int j=i+1; j<pairs.size(); j++) {
			if (matchFound(pairs.get(i), pairs.get(j))) {
				matches++;
			}
		}
		return matches;
	}
	
	private boolean matchFound(int[] name1, int[] name2) {
		int[] pairs = Pairs.combine(name1, name2);
		int compatibility = compare(pairs);
		
		return compatibility >= compatibilityPercent;
	}
	
	private int compare(int[] pairs) {
		checkForLargeNumbers(pairs);
		if (pairs.length == 2) {
			return Integer.parseInt("" + pairs[0] + pairs[1]);
		}
		int[] newPairs = sumUpPairs(pairs);
		return compare(newPairs);
	}

	private void checkForLargeNumbers(int[] pairs) {
		for (int i=0; i<pairs.length; i++) {
			if (pairs[i] > 9) pairs[i] = breakToSmallerNumber(pairs[i]);
		}
	}
	
	private int breakToSmallerNumber(int n) {
		String number = Integer.toString(n);
		int sum = Integer.parseInt(number.substring(1)) +
				  Integer.parseInt(number.substring(0, 1));
		
		if (sum > 9) return breakToSmallerNumber(sum);
		else return sum;
	}
	
	private int[] sumUpPairs(int[] pairs) {
		int[] newPairs = new int[pairs.length - 1];
		for (int i=1; i<pairs.length; i++) {
			newPairs[i-1] = pairs[i] + pairs[i-1];
		}
		return newPairs;
	}
	
}
