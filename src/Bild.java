import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Objects;

public class Bild extends Medium {
	public String ort;
	
	public Bild(String titel, int jahr, String ort) {
		super(titel, jahr);
		this.ort = ort;
	}
	
	public void druckeDaten(OutputStream stream) {
		PrintStream out = new PrintStream(stream);
		out.printf("ID = %d \"%s\" aufgenommen im Jahr %d in %s\n", this.id, this.titel, this.jahr, this.ort);
	}
	
	public String getOrt() {
		return this.ort;
	}
	
	public void setOrt(String ort) {
		this.ort = ort;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj))
			return false;		
		Bild b = (Bild) obj;
		if(this.ort != b.ort)
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), ort);
	}
}