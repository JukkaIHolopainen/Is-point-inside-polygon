package polygoni;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LogiikkaTestaus {
	
	private String polynomi =  "(1,1)(1,4)(4,4)(4,1)";
	private Logiikka logiikka = new Logiikka(polynomi);
	
	@BeforeEach
	void setPolynomi() {
		logiikka.setPolynomi(polynomi);
	}
	
	
	@Test
	@DisplayName("piste on sisalla")
	void testSisalla() {
		String vastaus = logiikka.pisteTarkistus("(2,3");
		assertEquals(vastaus, "sisällä, ");
	}
	
	@Test
	@DisplayName("piste on ulkona")
	void testUlkona() {
		String vastaus = logiikka.pisteTarkistus("(0,0");
		assertEquals(vastaus, "ulkona, ");
	}

	@Test
	@DisplayName("piste on viivalla")
	void testViivalla() {
		String vastaus = logiikka.pisteTarkistus("(1,3");
		assertEquals(vastaus, "reunaviivalla, ");
	}
}
