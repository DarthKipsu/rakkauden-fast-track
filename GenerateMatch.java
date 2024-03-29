
import java.util.List;


public class GenerateMatch {

	public static void main(String[] args) throws Exception {
		List<int[]> pairs = new ListCreator().nameList(args[0]);
		
		MatchMaker matchMaker = new MatchMaker(pairs);
        if (args.length == 1) {
	        System.out.println(matchMaker.matchesWithCompatibility(99));
        } else {
            System.out.println(matchMaker.matchesWithCompatibility(Integer.parseInt(args[1])));
        }
	}
	
}
