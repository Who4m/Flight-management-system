import java.util.ArrayList;

public class FlightDatabase {
	private ArrayList<Flight> bazaLetova;
	private SequenceGenerator sekvence;

	public FlightDatabase() {
		bazaLetova = new ArrayList<Flight>();
	}

	public void setGenerator(SequenceGenerator novi) {
		this.sekvence = novi;
	}

	public void insertFlight(Flight let) {
		int moze = 0;
		for (int i = 0; i < bazaLetova.size(); i++) {
			if (bazaLetova.get(i).getId() == let.getId()) {
				System.out.println("Ovaj ID vec postoji u bazi podataka ne mozemo da kreiramo ovaj let");
				moze = 1;
			}
		}
		if (moze == 0) {
			if (Airport.connected(let.getSource(), let.getDestination()) == true) {
				bazaLetova.add(let);
			} else {
				System.out.println("Aerodromi nisu povezani");
			}
		}
	}

	public void deleteFlight(Flight let) {
		int imaGa = 0;
		for (int i = 0; i < bazaLetova.size(); i++) {
			if (bazaLetova.get(i) == let) {
				bazaLetova.remove(i);
				imaGa = 1;
			}
		}
		if (imaGa == 0) {
			System.out.println("Ovaj let nije u bazi podataka");
		}
	}

	public ArrayList<Flight> getFlightList() {
		return bazaLetova;
	}

	public ArrayList<Flight> findBySrcAirport(Airport source) {
		ArrayList<Flight> vracam = new ArrayList<Flight>();
		for (int i = 0; i < bazaLetova.size(); i++) {
			if (bazaLetova.get(i).getSource() == source) {
				vracam.add(bazaLetova.get(i));
			}
		}
		return vracam;
	}

	public ArrayList<Flight> findByDestAirport(Airport destination) {
		ArrayList<Flight> vracam = new ArrayList<Flight>();
		for (int i = 0; i < bazaLetova.size(); i++) {
			if (bazaLetova.get(i).getDestination() == destination) {
				vracam.add(bazaLetova.get(i));
			}
		}
		return vracam;
	}

	public ArrayList<Flight> findByPlane(Plane avion) {
		ArrayList<Flight> vracam = new ArrayList<Flight>();
		for (int i = 0; i < bazaLetova.size(); i++) {
			if (bazaLetova.get(i).getAvion() == avion) {
				vracam.add(bazaLetova.get(i));
			}
		}
		return vracam;
	}

	public ArrayList<Flight> findByPlaneStatus(Status statusAviona) {
		ArrayList<Flight> vracam = new ArrayList<Flight>();
		for (int i = 0; i < bazaLetova.size(); i++) {
			if (bazaLetova.get(i).getAvion().getStatus() == statusAviona) {
				vracam.add(bazaLetova.get(i));
			}
		}
		return vracam;
	}

	public ArrayList<Flight> findByMaxPrice(double max) {
		ArrayList<Flight> vracam = new ArrayList<Flight>();
		for (int i = 0; i < bazaLetova.size(); i++) {
			if (bazaLetova.get(i).getPrice() <= max) {
				vracam.add(bazaLetova.get(i));
			}
		}
		return vracam;
	}

	public Flight createFlight(Airport source, Airport destination, Plane avion, double pricePerUnit) {
		Flight let = new Flight(source, destination, avion, pricePerUnit);
		let.setId(sekvence.next());

		return let;
	}

	public String toString() {
		String databaseString = "";
		for (int i = 0; i < bazaLetova.size(); i++) {
			databaseString += (bazaLetova.get(i).toString() + "\r\n");
		}
		return databaseString;
	}
}
