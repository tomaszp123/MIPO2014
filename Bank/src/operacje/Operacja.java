package operacje;
import java.util.Date;


public abstract class Operacja {

	public static final String typ="";
	private Date dataWykonaniaOperacji;
	
	public final void ustawDate() {
		dataWykonaniaOperacji = new Date();
	}
	
	public abstract boolean wykonajOperacje();
	
	public final boolean wykonaj() {
		ustawDate();
		return wykonajOperacje();
	}
	
}
