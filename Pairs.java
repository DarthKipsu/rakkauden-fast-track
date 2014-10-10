

public class Pairs {
	
	public static int[] combine(int[] name1, int[] name2) {
		int[] pairs = new int[5];
		
        for (int i=0; i<pairs.length; i++) {
            pairs[i] = name1[i] + name2[i];
        }
		
		return pairs;
	}
	
	public static int[] calculatePairs(String name, int[] pairs) {
		for (int i=0; i<name.length(); i++) {
			switch (name.charAt(i)) {
				case 'p': pairs[0]++; break;
				case 'a': pairs[1]++; break;
				case 'i': pairs[2]++; break;
				case 'r': pairs[3]++; break;
				case 's': pairs[4]++; break;
			}
		}
        return pairs;
	}
}
