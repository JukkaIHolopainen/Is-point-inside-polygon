package polygoni;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TiedostonLukijaTest {

	private TiedostonLukija lukija = new TiedostonLukija();
	
	@Test
	@DisplayName("pisteet.txt testaus")
	void testFileReading() throws IOException {
		String pisteet = lukija.readFile("pisteet.txt");
		char ekaLuku = pisteet.charAt(0);
		assertEquals("(".charAt(0), ekaLuku);
	}
	
	@Test
	@DisplayName("polygoni.txt testaus")
	void testFileReading2() throws IOException {
		String poligoni = lukija.readFile("polygoni.txt");
		char ekaLuku = poligoni.charAt(0);
		assertEquals("(".charAt(0), ekaLuku);
	}
	
	

}
