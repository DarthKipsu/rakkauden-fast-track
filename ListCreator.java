
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ListCreator {
	private Scanner reader;
	private List<String> list;
	
	public List<String> nameList(String filename) throws Exception {
		reader = new Scanner(new FileReader(filename));
		list = new ArrayList<>();
		readFileToList();
		return list;
	}

	private void readFileToList() {
		while (reader.hasNextLine()) {
			list.add(reader.nextLine().toLowerCase().trim());
		}
	}
	
}
