package commons;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import commons.Klient;
import commons.Rachunek;

// komentarz testowy

public class KlientTest {

	private Klient klient;
	
	@Before
	public void setUp() throws Exception {
		klient = new Klient(null, null, null, null);
	}
	
	@Test
	public void testKlient() {
		String imie = "Jan";
		String nazwisko = "Kowalski";
		String pesel = "80010101111";
		String adres = "ul. Zielona 8/18, 00-101 Czerwonka";
		Klient klient = new Klient(imie, nazwisko, pesel, adres);
		assertEquals(imie, klient.getImie());
		assertEquals(nazwisko, klient.getNazwisko());
		assertEquals(pesel, klient.getPesel());
		assertEquals(adres, klient.getAdres());
	}

	@Test
	public void testSetImie() {
		String imie = "Jan";
		klient.setImie(imie);
		assertEquals(imie, klient.getImie());
	}

	@Test
	public void testSetNazwisko() {
		String nazwisko = "Kwiatkowski";
		klient.setNazwisko(nazwisko);
		assertEquals(nazwisko, klient.getNazwisko());
	}

	@Test
	public void testSetAdres() {
		String adres = "ul. Zielona 8/18, 00-101 Czerwonka";
		klient.setAdres(adres);
		assertEquals(adres, klient.getAdres());
	}
	
	@Test
	public void testUniqueID() {
		Klient klient1 = new Klient(null, null, null, null);
		Klient klient2 = new Klient(null, null, null, null);
		assertFalse(klient1.getId() == klient2.getId());
	}
	
	@Test
	public void testDodajRachunek()
	{
		Klient klient = new Klient(null, null, null, null);
		Rachunek rachunek = new Rachunek();
		boolean wynik = klient.dodajRachunek(rachunek);
		assertTrue(wynik);
		assertTrue(klient.getListaRachunkow().size() == 1);
		assertTrue(klient.getListaRachunkow().contains(rachunek));
		assertTrue(rachunek.getListaWlascicieli().contains(klient));
	}

	@Test
	public void testUsunRachunek()
	{
		Klient klient = new Klient(null, null, null, null);
		Rachunek rachunek1 = new Rachunek();
		Rachunek rachunek2 = new Rachunek();
		klient.dodajRachunek(rachunek1);
		klient.dodajRachunek(rachunek2);
		boolean wynik = klient.usunRachunek(rachunek1);
		assertTrue(wynik);
		assertTrue(klient.getListaRachunkow().size() == 1);
		assertTrue(klient.getListaRachunkow().contains(rachunek2));
		
	}
	
	@Test
	public void testDodajTenSamRachunekDwukrotnie()
	{
		Klient klient = new Klient(null, null, null, null);
		Rachunek rachunek1 = new Rachunek();
		klient.dodajRachunek(rachunek1);
		boolean wynik = klient.dodajRachunek(rachunek1);
		assertFalse(wynik);
		assertTrue(klient.getListaRachunkow().size() == 1);
		assertTrue(klient.getListaRachunkow().contains(rachunek1));
	}
	
	@Test
	public void testDodajRachunekDoDwochKlientow() {
		
		Klient klient1 = new Klient(null, null, null, null);
		Klient klient2 = new Klient(null, null, null, null);
		
		Rachunek rachunek1 = new Rachunek();
		
		klient1.dodajRachunek(rachunek1);
		klient2.dodajRachunek(rachunek1);
		assertTrue(rachunek1.getListaWlascicieli().size() == 2);
		assertTrue(rachunek1.getListaWlascicieli().contains(klient1));
		assertTrue(rachunek1.getListaWlascicieli().contains(klient2));
	}
}
