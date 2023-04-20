import java.util.ArrayList;

enum Status {
	READY, ONFLIGHT, FINISHED
}

public class Plane {
	private int brojMesta;
	public Status status;
	ArrayList<Passenger> putnici;
	ArrayList<CrewMember> clanoviPosade;

	public int getBrojMesta() {
		return brojMesta;
	}

	public Plane(int brojMesta) {
		this.brojMesta = brojMesta;
		status = Status.FINISHED;
		putnici = new ArrayList<Passenger>();
		clanoviPosade = new ArrayList<CrewMember>();

	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void addPassenger(Passenger putnik) {
		if (putnici.size() < brojMesta) {
			putnici.add(putnik);
		} else {
			System.out.println("Nema vise mesta");
		}
	}

	public void clearPassengers() {
		putnici.clear();
	}

	public void addCrewMember(CrewMember clanPosade) {
		int pozicija = 0;
		if (clanPosade.getRole() == Role.pilot || clanPosade.getRole() == Role.copilot) {
			for (int i = 0; i < clanoviPosade.size(); i++) {
				if (clanoviPosade.get(i).getRole() == clanPosade.getRole()) {
					System.out.println("Ova pozicija je vecpopunjena");
					pozicija++;
				}
			}
			if (pozicija == 0) {
				clanoviPosade.add(clanPosade);
			}
		} else {
			clanoviPosade.add(clanPosade);
		}
	}

	public boolean removeCrewMember(CrewMember clanPosade) {
		for (int i = 0; i <= clanoviPosade.size(); i++) {
			if (clanoviPosade.get(i) == clanPosade) {
				clanoviPosade.remove(i);
				return true;
			}
		}
		return false;
	}

	public String toString() {
		String planeString = ("Plane: Slots: " + brojMesta + " Status: " + status + "\r\n");
		planeString += "Crew: \r\n";
		for (int i = 0; i < clanoviPosade.size(); i++) {
			planeString += (clanoviPosade.get(i).toString() + "\r\n");
		}
		planeString += "Passengers: \r\n";
		for (int i = 0; i < putnici.size(); i++) {
			planeString += (putnici.get(i).toString() + "\r\n");
		}
		return planeString;
	}
}
