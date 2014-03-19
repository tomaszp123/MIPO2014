package odsetki.impl;

import java.util.Calendar;
import java.util.Date;

import odsetki.MechanizmOdsetkowy;

import commons.Rachunek;

public class Lokata3Mies2Proc extends MechanizmOdsetkowy {

	
	
	public Lokata3Mies2Proc() {

		obliczDateNastNaliczenia();
		
		//2% w skali rocznej		
		procent = 0.02 / 4 ;

	}

	private void obliczDateNastNaliczenia() {
		
		Calendar cal = Calendar.getInstance(); 
		cal.add(Calendar.MONTH, 3);
		dataNastNaliczenia = cal.getTime();
	}

	@Override
	public double naliczOdsetki(Rachunek rachunek) {
		
		double kwota = 0;
		
		if (dataNastNaliczenia.getTime() <= new Date().getTime())
		{
			kwota = rachunek.getSaldo() * procent;
			
			obliczDateNastNaliczenia();
		}
		return kwota;
	}

}
