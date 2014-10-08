
import java.util.Arrays;
import java.util.List;


public class MatchMaker {
	private List<String> names;
	private int compatibilityPercent;

	public MatchMaker(List<String> names) {
		this.names = names;
		compatibilityPercent = 0;
	}
	
	public int matchesWithCompatibility(int percent) {		
		compatibilityPercent = percent;
		return findMatches();
	}

	private int findMatches() {
		int matches = 0;
		for (int i=0; i<names.size()-1; i++) {
			matches += matchesFor(i);
		}		
		return matches;
	}

	private int matchesFor(int i) {
		int matches = 0;
		for (int j=i+1; j<names.size(); j++) {
			if (matchFound(names.get(i), names.get(j))) {
				matches++;
			}
		}
		return matches;
	}
	
	private boolean matchFound(String name1, String name2) {
		int[] pairs = Pairs.getPairs(name1, name2);
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
