import java.util.ArrayList;

public class AverageTicketStrategy extends BuyingStrategy {
//trazi kartu srednje vrenosti//
	public Ticket findBestTicket(ArrayList<Flight> a, double m, Passenger putnik) {
		Flight let;
		let = a.get(0);
		double srednjaVrednost;
		double vrednost = 0;
		for (int i = 0; i < a.size(); i++) {
			vrednost += a.get(i).getPrice();
		}
		srednjaVrednost = vrednost / a.size();
		double najblizi = Math.abs(a.get(0).getPrice() - srednjaVrednost);
		for (int i = 1; i < a.size(); i++) {
			if (najblizi > Math.abs(a.get(i).getPrice() - srednjaVrednost)) {
				najblizi = Math.abs(a.get(i).getPrice() - srednjaVrednost);
				let = a.get(i);
			}
		}
		Ticket vrati = new Ticket(let.getPrice(), putnik);
		if (m >= najblizi) {
			let.dodajTiket(vrati);
			return vrati;
		} else {
			System.out.println("Nemate dovoljno para");
			return null;
		}

	}

	public String toString() {
		return "Average";
	}
}
