package operacje;
import static org.junit.Assert.*;


import operacje.impl.Przelew;

import org.junit.Before;
import org.junit.Test;

import commons.Rachunek;


public class PrzelewTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testWykonajGdySaSrodki() {
		
		Rachunek zrodlo = new Rachunek();
		Rachunek cel = new Rachunek();
		
		double saldopocz = 100.0;
		zrodlo.dodajDoSalda(saldopocz);
		double kwota = 23;
		Operacja p = new Przelew(zrodlo, cel, kwota);
		boolean wynik = p.wykonaj();
		
		assertTrue(wynik);
		assertEquals(kwota, cel.getSaldo(), 0.001);
		assertEquals(saldopocz - kwota, zrodlo.getSaldo(), 0.001);
	}
	
	@Test
	public void testWykonajGdyBrakSrodkow() {
		
		Rachunek zrodlo = new Rachunek();
		Rachunek cel = new Rachunek();
		
		double saldopocz = 100.0;
		zrodlo.dodajDoSalda(saldopocz);
		double kwota = 123;
		Operacja p = new Przelew(zrodlo, cel, kwota);
		boolean wynik = p.wykonaj();
		
		assertFalse(wynik);
		assertEquals(0.0, cel.getSaldo(), 0.001);
		assertEquals(saldopocz, zrodlo.getSaldo(), 0.001);
	}

}
