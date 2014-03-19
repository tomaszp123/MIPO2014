package odsetki;

import java.util.Date;

import commons.Rachunek;

// tu by się przydały komentarze ...
// a teraz komentarz napisany na MacHub pod Xcode

public abstract class MechanizmOdsetkowy {

protected Date dataNastNaliczenia;
	
	protected double procent;
	
	public abstract double naliczOdsetki(Rachunek rachunek);
	
}
