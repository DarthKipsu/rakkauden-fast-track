

public class Pairs {
	
	public static int[] getPairs(String name1, String name2) {
		int[] pairs = new int[5];
		
		calculatePairs(name1, pairs);
		calculatePairs(name2, pairs);
		
		return pairs;
	}
	
	private static void calculatePairs(String name, int[] pairs) {
		for (int i=0; i<name.length(); i++) {
			switch (name.charAt(i)) {
				case 'p': pairs[0]++; break;
				case 'a': pairs[1]++; break;
				case 'i': pairs[2]++; break;
				case 'r': pairs[3]++; break;
				case 's': pairs[4]++; break;
			}
		}
	}
}
