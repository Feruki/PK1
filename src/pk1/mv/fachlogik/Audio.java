package pk1.mv.fachlogik;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Objects;

public class Audio extends Medium {
	public String interpret;
	public int dauer;

	public Audio() {
		super();
		this.interpret = "";
		this.dauer = 0;
	}
	
	public Audio(String titel, int jahr, String interpret, int dauer) {
		super(titel, jahr);
		this.interpret = interpret;
		this.dauer = dauer;
	}
	
	public void druckeDaten(OutputStream stream) {
		PrintStream out = new PrintStream(stream);
		out.printf("ID = %d \"%s\" von %s aus %d Spieldauer: %d sek.\n", this.id, this.titel, this.interpret, this.jahr, this.dauer);
	}
	
	public String getInterpret() {
		return this.interpret;
	}
	
	public void setInterpret(String interpret) {
		this.interpret = interpret;
	}
	
	public int getDauer() {
		return this.dauer;
	}
	
	public void setDauer(int dauer) {
		this.dauer = dauer;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj))
			return false;
		Audio a = (Audio) obj;
		if(this.interpret != a.interpret)
			return false;
		if(this.dauer != a.dauer)
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), interpret, dauer);
	}

	@Override
	public String toString() {
		return String.format("ID = %d \"%s\" von %s aus %d Spieldauer: %d sek.\n", this.id, this.titel, this.interpret, this.jahr, this.dauer);
	}
}