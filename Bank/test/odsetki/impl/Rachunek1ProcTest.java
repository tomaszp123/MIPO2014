package odsetki.impl;

import static org.junit.Assert.*;

import odsetki.MechanizmOdsetkowy;

import org.junit.Before;
import org.junit.Test;

import commons.Rachunek;

public class Rachunek1ProcTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testNaliczOdsetki() {
		
		Rachunek rachunek = new Rachunek();
		
		MechanizmOdsetkowy mo = new Rachunek1Proc();
		
		rachunek.zmienMechanizmOdsetkowy(mo);
		rachunek.dodajOdsetki();
		
		
	}
}
