import java.util.ArrayList;

public class FlightControl {

	int brojPisti;
	int zauzetePiste = 0;
	ArrayList<Plane> avioniNaPisti = new ArrayList<Plane>();
	Airport aerodrom;

	public FlightControl(int brojPisti) {
		this.brojPisti = brojPisti;
	}

	public void setAirport(Airport aerodrom) {
		this.aerodrom = aerodrom;
	}

	public void setOnRunway(Plane avion) {
		int imaGaAvion = 0;
		ArrayList<Flight> gdeJeSve;
		gdeJeSve = aerodrom.celaBaza().findByPlane(avion);
		for (int i = 0; i < gdeJeSve.size(); i++) {
			if (gdeJeSve.get(i).getSource() == aerodrom) {
				imaGaAvion++;
			}
		}
		if (imaGaAvion > 0) {
			if (avion.getStatus() == Status.FINISHED) {
				if (zauzetePiste < brojPisti) {
					avion.setStatus(Status.READY);
					avioniNaPisti.add(avion);
					zauzetePiste++;
					for (int i = 0; i < gdeJeSve.get(0).getProdateKarte().size(); i++) {
						avion.addPassenger(gdeJeSve.get(0).getProdateKarte().get(i).getPassenger());
					}
				} else {
					System.out.println("Nema slobodna pista za poletanje");
				}
			} else if (avion.getStatus() == Status.READY) {
				System.out.println("Avion je vec na pisti");
			} else {
				System.out.println("Avion je u letu");
			}
		} else {
			System.out.println("Taj let ne postoji");
		}
	}

	public void removeFromRunway(Plane avion) {
		int sklonjen = 0;
		for (int i = 0; i < avioniNaPisti.size(); i++) {
			if (avioniNaPisti.get(i) == avion) {
				avioniNaPisti.remove(i);
				avion.setStatus(Status.FINISHED);
				zauzetePiste--;
				sklonjen++;
			}
		}
		if (sklonjen == 0) {
			System.out.println("Avion nije na pisti");
		}
	}

	public void allowTakeOff(Plane avion) {
		int pilot = 0;
		int kopilot = 0;
		int radnici = 0;
		for (int i = 0; i < avion.clanoviPosade.size(); i++) {
			if (avion.clanoviPosade.get(i).getRole() == Role.pilot) {
				pilot++;
			}
			if (avion.clanoviPosade.get(i).getRole() == Role.copilot) {
				kopilot++;
			}
			if (avion.clanoviPosade.get(i).getRole() == Role.other) {
				radnici++;
			}
		}
		if (avion.getStatus() == Status.READY) {
			if (pilot == 1 && kopilot == 1 && radnici >= 5) {
				// TODO: Ne znam sta je ovo uradi sutra da ne menja status na avioni koji nisu
				// na pistu od aerodorm koj ih poziva...
				removeFromRunway(avion);
				avion.setStatus(Status.ONFLIGHT);
			} else {
				System.out.println("Nema dovoljno clana posade");
			}
		} else {
			System.out.println("Avion nije spreman za poletanje");
		}
	}

	public void allowLanding(Plane avion) {

		FlightDatabase novaBaza;
		novaBaza = aerodrom.celaBaza();
		ArrayList<Flight> let;
		let = novaBaza.findByPlane(avion);

		if (let.get(0).getDestination() == aerodrom) {
			if (avion.getStatus() == Status.ONFLIGHT) {
				avion.clearPassengers();
				avion.setStatus(Status.FINISHED);
				for (int i = 0; i < avion.putnici.size(); i++) {
					avion.putnici.get(i).PonistavanjeKarte();
				}
			} else {
				System.out.println("Avion nije spreman za sletanje");
			}
		} else {
			System.out.println("Avion ne leti na ovu destinaciju");
		}
	}

	public ArrayList<Plane> readyForTakeOff() {
		return avioniNaPisti;
	}

	public ArrayList<Plane> readyForLanding() {
		FlightDatabase novaBaza;
		novaBaza = aerodrom.celaBaza();
		ArrayList<Flight> let;
		let = novaBaza.findByDestAirport(aerodrom);
		ArrayList<Plane> vracam = new ArrayList<Plane>();

		for (int i = 0; i < let.size(); i++) {
			if (let.get(i).getDestination() == aerodrom && let.get(i).getAvion().getStatus() == Status.ONFLIGHT) {
				vracam.add(let.get(i).getAvion());
			}
		}
		return vracam;
	}
}
