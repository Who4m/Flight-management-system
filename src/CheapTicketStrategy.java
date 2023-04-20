import java.util.ArrayList;

public class CheapTicketStrategy extends BuyingStrategy {

	public Ticket findBestTicket(ArrayList<Flight> a, double m, Passenger putnik) {
		Flight let;
		let = a.get(0);
		double cena = a.get(0).getPrice();
		for (int i = 1; i < a.size(); i++) {
			if (cena > a.get(i).getPrice()) {
				let = a.get(i);
				cena = a.get(i).getPrice();
			}
		}
		Ticket vrati = new Ticket(let.getPrice(), putnik);
		if (m >= cena) {
			let.dodajTiket(vrati);
			return vrati;
		} else {
			System.out.println("Nemate dovoljno para");
			return null;
		}

	}

	public String toString() {
		return "Cheep";
	}
}
