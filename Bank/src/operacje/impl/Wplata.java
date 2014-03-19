package operacje.impl;

import operacje.Operacja;
import commons.Rachunek;

public class Wplata extends Operacja {

	private Rachunek cel;
	private double kwota;
	
	public Wplata(Rachunek cel, double kwota) {
		this.cel = cel;
		this.kwota = kwota;
	}

	@Override
	public boolean wykonajOperacje() {
		cel.dodajDoSalda(kwota);
		return true;
	}

}
