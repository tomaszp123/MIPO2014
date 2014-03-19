package commons;
import java.util.HashSet;

import odsetki.MechanizmOdsetkowy;


public class Rachunek {

	private static int lastnumer = 10101010;
	
	private double saldo;
	private long numer;
	private HashSet<Klient> listaWlascicieli;
	private MechanizmOdsetkowy mechanizmOdsetkowy;
	
	
	public Rachunek() {
		this.saldo = 0.0;
		this.numer = lastnumer++;
		this.listaWlascicieli = new HashSet<Klient>();
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public long getNumer() {
		return numer;
	}

	public void dodajDoSalda(double delta) {
		this.saldo += delta;
	}
	
	public boolean odejmijOdSalda(double delta) {
		if (saldo >= delta)
		{
			this.saldo -= delta;
			return true;
		}
		
		return false;
	}

	public HashSet<Klient> getListaWlascicieli() {
		return listaWlascicieli;
	}
	
	/** Zarzadzanie wlascicielami tylko w Kliencie
	 * @param wlasciciel
	 * @return boolean
	 */
	public boolean __dodajWlasciciela(Klient wlasciciel)
	{
		return this.listaWlascicieli.add(wlasciciel);
	}
	
	/** Zarzadzanie wlascicielami tylko w Kliencie
	 * @param wlasciciel
	 * @return boolean
	 */
	public boolean __usunWlasciciela(Klient wlasciciel)
	{
		return this.listaWlascicieli.remove(wlasciciel);
	}

	public void zmienMechanizmOdsetkowy(MechanizmOdsetkowy mo)
	{
		mechanizmOdsetkowy = mo;
	
	}
	
	public void dodajOdsetki()
	{
		if (mechanizmOdsetkowy != null)
		{
			double kwota = mechanizmOdsetkowy.naliczOdsetki(this);
			dodajDoSalda(kwota);
		}	
	}
}
