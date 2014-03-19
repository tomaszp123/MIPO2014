package operacje;

import static org.junit.Assert.*;

import operacje.impl.Wplata;

import org.junit.Before;
import org.junit.Test;

import commons.Rachunek;

public class WplataTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testWykonajOperacje() {
		Rachunek cel = new Rachunek();
		
		double saldopocz = 100.0;
		cel.dodajDoSalda(saldopocz);
		double kwota = 23;
		Operacja p = new Wplata(cel, kwota);
		boolean wynik = p.wykonaj();
		
		assertTrue(wynik);
		assertEquals(saldopocz + kwota, cel.getSaldo(), 0.001);
	}

}
