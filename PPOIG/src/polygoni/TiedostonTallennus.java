package polygoni;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class TiedostonTallennus {

	public void tallennus(String tallenne) throws FileNotFoundException {
		try (PrintStream out = new PrintStream(new FileOutputStream("selvitys.txt"))){
			out.print(tallenne);
		}
		
	}
}
