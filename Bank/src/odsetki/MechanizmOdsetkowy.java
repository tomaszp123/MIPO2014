package odsetki;

import java.util.Date;

import commons.Rachunek;

public abstract class MechanizmOdsetkowy {

protected Date dataNastNaliczenia;
	
	protected double procent;
	
	public abstract double naliczOdsetki(Rachunek rachunek);
	
}
