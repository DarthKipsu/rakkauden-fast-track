
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ListCreator {
	private Scanner reader;
	private List<int[]> list;
	
	public List<int[]> nameList(String filename) throws Exception {
		reader = new Scanner(new FileReader(filename));
		list = new ArrayList<>();
		readFileToList();
		return list;
	}

	private void readFileToList() {
		while (reader.hasNextLine()) {
            String name = reader.nextLine().toLowerCase().trim();
			list.add(Pairs.calculatePairs(name, new int[5]));
		}
	}
	
}
