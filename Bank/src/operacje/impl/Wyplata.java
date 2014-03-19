package operacje.impl;

import operacje.Operacja;
import commons.Rachunek;

public class Wyplata extends Operacja {

	private Rachunek cel;
	private double kwota;
	
	public Wyplata(Rachunek cel, double kwota) {
		this.cel = cel;
		this.kwota = kwota;
	}

	@Override
	public boolean wykonajOperacje() {
		return cel.odejmijOdSalda(kwota);
	}

}
