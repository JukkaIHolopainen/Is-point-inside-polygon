package polygoni;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
	
		TiedostonLukija reader = new TiedostonLukija();
		TiedostonTallennus tallennus = new TiedostonTallennus();
		Logiikka logiikka;
		String lopputulos = "Pisteet järjestyksessä ovat: ";
		
		String polygoni = reader.readFile("polygoni.txt");
		logiikka = new Logiikka(polygoni);
		String pisteet = reader.readFile("pisteet.txt");
		String piste[] = pisteet.split("\\)");
		
		int i = 0;
		while(i < piste.length-1){
			lopputulos = lopputulos + logiikka.pisteTarkistus(piste[i]);
			i++;
		}
		
		tallennus.tallennus(lopputulos);
		System.out.println("Sovellus meni loppuun onnistuneesti.");
}
}

