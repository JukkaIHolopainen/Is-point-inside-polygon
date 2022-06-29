package polygoni;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TiedostonLukija {

	public String readFile(String fileName) throws IOException {
		String string;
		
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    string = sb.toString();
			}
			System.out.println(string);
		return string;
	}
}
