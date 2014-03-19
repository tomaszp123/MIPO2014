package operacje;

import static org.junit.Assert.*;

import operacje.impl.Wyplata;

import org.junit.Before;
import org.junit.Test;

import commons.Rachunek;

public class WyplataTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testWykonajWyplateGdySaSrodki() {
		Rachunek cel = new Rachunek();
		
		double saldopocz = 100.0;
		cel.dodajDoSalda(saldopocz);
		double kwota = 23;
		Operacja p = new Wyplata(cel, kwota);
		boolean wynik = p.wykonaj();
		
		assertTrue(wynik);
		assertEquals(saldopocz - kwota, cel.getSaldo(), 0.001);
	}
	
	@Test
	public void testWykonajWyplateGdyNieMaSrodkow() {
		Rachunek cel = new Rachunek();
		
		double saldopocz = 50.0;
		cel.dodajDoSalda(saldopocz);
		double kwota = 100.0;
		Operacja p = new Wyplata(cel, kwota);
		boolean wynik = p.wykonaj();
		
		assertFalse(wynik);
		assertEquals(saldopocz, cel.getSaldo(), 0.001);
	}

}
