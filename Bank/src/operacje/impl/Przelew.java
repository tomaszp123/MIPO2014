package operacje.impl;
import operacje.Operacja;
import commons.Rachunek;


public class Przelew extends Operacja {

	private Rachunek zrodlo;
	private Rachunek cel;
	private double kwota;
	
	public static final String typ="PRZELEW";
	
	public Przelew(Rachunek zrodlo, Rachunek cel, double kwota) {
		this.zrodlo = zrodlo;
		this.cel = cel;
		this.kwota = kwota;
	}

	@Override
	public boolean wykonajOperacje() {
		
		boolean wynik = zrodlo.odejmijOdSalda(kwota);
		if (wynik)
		{
			cel.dodajDoSalda(kwota);
		}
		
		return wynik;
	}

}
