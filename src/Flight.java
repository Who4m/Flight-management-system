import java.util.ArrayList;

public class Flight {
	private int ID;
	private Airport source;
	private Airport destination;
	private Plane avion;
	private double cenaPoJediniciUdaljenosti;
	private ArrayList<Ticket> prodateKarte = new ArrayList<Ticket>();

	public ArrayList<Ticket> getProdateKarte() {
		return prodateKarte;
	}

	public Flight() {

	}

	public void dodajTiket(Ticket a) {
		prodateKarte.add(a);
	}

	public Flight(Airport source, Airport destination, Plane avion, double cenaPoJediniciUdaljenosti) {
		this.source = source;
		this.destination = destination;
		this.avion = avion;
		this.cenaPoJediniciUdaljenosti = cenaPoJediniciUdaljenosti;
	}

	public void setId(int Id) {
		this.ID = Id;
	}

	public int getId() {
		return ID;
	}

	public Airport getSource() {
		return source;
	}

	public Airport getDestination() {
		return destination;
	}

	public Plane getAvion() {
		return avion;
	}

	public double getPrice() {
		double cena;
		cena = Airport.distance(source, destination) * cenaPoJediniciUdaljenosti;
		return cena;
	}

	public String toString() {
		String flightString = "ID: " + ID + "\r\n";
		flightString += "SRC Airport: \r\n";
		flightString += source.toString();
		flightString += "DST Airport: \r\n";
		flightString += destination.toString();
		flightString += "Plane: \r\n";
		flightString += avion.toString();
		flightString += "Tickets: \r\n";
		for (int i = 0; i < prodateKarte.size(); i++) {
			flightString += (prodateKarte.get(i).toString() + "\r\n");
		}
		return flightString;
	}
}
