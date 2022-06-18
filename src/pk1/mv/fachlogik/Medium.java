package pk1.mv.fachlogik;

import java.io.OutputStream;
import java.time.LocalDate;
import java.util.Objects;
import java.io.Serializable;

public abstract class Medium implements Serializable {
	public String titel;
	public int jahr;
	public final int id;
	private static int idCounter = 0;
	private static final long serialVersionUID = 56L;
	
	public Medium() {
		this.id = idCounter++;
		this.titel = "";
		this.jahr = 0;
	}

	public Medium(String titel, int jahr) {
		this.titel = titel;
		this.jahr = jahr;
		this.id = idCounter++;
	}
	
	public int alter() {
		return LocalDate.now().getYear() - this.jahr;
	}
	
	public abstract void druckeDaten(OutputStream stream);
	
	public String getTitel() {
		return this.titel;
	}
	
	public void setTitel(String titel) {
		this.titel = titel;
	}
	
	public int getJahr() {
		return this.jahr;
	}
	
	public void setJahr(int jahr) {
		this.jahr = jahr;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;
		Medium m = (Medium) obj;
		if(this.titel != m.titel)
			return false;
		if(this.jahr != m.jahr)
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(titel, jahr);
	}
}