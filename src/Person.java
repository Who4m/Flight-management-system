
public class Person {
	private String ime;
	private String prezime;

	public Person(String ime, String prezime) {
		this.ime = ime;
		this.prezime = prezime;
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public String toString() {
		return String.format("[%s, %s]", prezime, ime);
	}
}
