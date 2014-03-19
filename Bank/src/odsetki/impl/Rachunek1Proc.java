package odsetki.impl;

import java.util.Calendar;
import java.util.Date;

import odsetki.MechanizmOdsetkowy;

import commons.Rachunek;

public class Rachunek1Proc extends MechanizmOdsetkowy {

	
	
	public Rachunek1Proc() {

		obliczDateNastNaliczenia();
		
		//1% w skali rocznej		
		procent = 0.01 / 12 ;

	}

	private void obliczDateNastNaliczenia() {
		
		Calendar cal = Calendar.getInstance(); 
		cal.add(Calendar.MONTH, 1);
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
