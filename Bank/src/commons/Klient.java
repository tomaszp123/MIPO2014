package commons;
import java.util.HashSet;


public class Klient {

	private static int lastid = 0;
	private int id;

	private String imie;
	private String nazwisko;
	private String pesel;
	private String adres;
	
	HashSet<Rachunek> listaRachunkow;
	
	
	public Klient(String imie, String nazwisko, String pesel, String adres) {
		this.id = lastid++;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.pesel = pesel;
		this.adres = adres;
		this.listaRachunkow = new HashSet<Rachunek>();
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getPesel() {
		return pesel;
	}
	
	public int getId() {
		return id;
	}
	
	public boolean dodajRachunek(Rachunek rachunek)
	{
		boolean wynik = rachunek.__dodajWlasciciela(this);
		if (wynik)
		{
			wynik = this.listaRachunkow.add(rachunek);
			if (wynik)
			{ 
			  return true;
			}
			else
			{
				rachunek.__usunWlasciciela(this);
				return false;
			}
		}
		
		return false;
		
	}
	
	public boolean usunRachunek(Rachunek rachunek)
	{
		return (rachunek.__usunWlasciciela(this) && this.listaRachunkow.remove(rachunek));
	}
	
	public HashSet<Rachunek> getListaRachunkow() {
		return listaRachunkow;
	}
}
