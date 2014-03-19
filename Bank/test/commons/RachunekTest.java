package commons;
import static org.junit.Assert.*;

import odsetki.impl.Lokata3Mies2Proc;

import org.junit.Test;

import commons.Rachunek;


public class RachunekTest {

	@Test
	public void testRachunek() {
		Rachunek rachunek = new Rachunek();
		assertTrue(rachunek.getSaldo() == 0.0);
	}
	
	@Test
	public void testUniqueNumer() {
		Rachunek rachunek1 = new Rachunek();
		Rachunek rachunek2 = new Rachunek();
		assertFalse(rachunek1.getNumer() == rachunek2.getNumer());
	}

	@Test
	public void testDodajDoSalda() {
		double delta = 50.0;
		Rachunek rachunek = new Rachunek();
		rachunek.dodajDoSalda(delta);
		assertEquals(delta, rachunek.getSaldo(), 0.0001);
	}
	
	@Test
	public void testOdejmijOdSalda() {
		double delta = 50.0;
		Rachunek rachunek = new Rachunek();
		rachunek.dodajDoSalda(2*delta);
		boolean wynik = rachunek.odejmijOdSalda(delta);
		assertEquals(delta, rachunek.getSaldo(), 0.0001);
		assertTrue(wynik);
	}
	
	
	@Test
	public void testOdejmijOdSaldaWartoscPrzekraczaSaldo() {
		double delta = 50.0;
		Rachunek rachunek = new Rachunek();
		rachunek.dodajDoSalda(delta);
		boolean wynik = rachunek.odejmijOdSalda(delta+1);
		assertEquals(delta, rachunek.getSaldo(), 0.0001);
		assertFalse(wynik);
	}
	
	
}
