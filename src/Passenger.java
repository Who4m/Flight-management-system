import java.util.ArrayList;

public class Passenger extends Person {
	private double money;
	private Ticket karta;
	private BuyingStrategy strategija;

	public String kojaKarta() {
		return karta.toString();
	}

	public void PonistavanjeKarte() {
		this.karta = null;
	}

	public Passenger(String ime, String prezime, double money) {
		super(ime, prezime);
		this.money = money;
	}

	public void giveMoney(double money) {
		this.money += money;
	}

	public void takeMoney(double money) {
		if (this.money - money < 0) {
			System.out.println("Nemate dovoljno novca");
		} else {
			this.money -= money;
		}
	}

	public void setStrategy(BuyingStrategy strategija) {
		this.strategija = strategija;
	}

	public boolean buyTicket(Airport src, Airport dst) {

		if (this.karta == null) {
			ArrayList<Flight> GdeMozDaOdes = new ArrayList<Flight>();
			for (int i = 0; i < src.getDataBase().size(); i++) {
				if (src.getDataBase().get(i).getSource() == src && src.getDataBase().get(i).getDestination() == dst) {
					GdeMozDaOdes.add(src.getDataBase().get(i));
				}
			}
			for (int i = 0; i < GdeMozDaOdes.size(); i++) {
				if (GdeMozDaOdes.get(i).getProdateKarte().size() == GdeMozDaOdes.get(i).getAvion().getBrojMesta()) {
					GdeMozDaOdes.remove(GdeMozDaOdes.get(i));
				}
			}
			if (GdeMozDaOdes.size() == 0) {
				System.out.println("Ne mozes da kupis kartu!");
				return false;
			} else {
				Ticket a = strategija.findBestTicket(GdeMozDaOdes, money, this);

				if (a == null) {
					System.out.println("Nista nisi kupio bozijaku");
					return false;
				} else {
					takeMoney(a.getPrice());
					this.karta = a;
					return true;
				}
			}
		} else {
			System.out.println("Vec imate kartu");
			return false;
		}
	}

	public String toString() {
		String passengerString;
		if (strategija != null) {
			passengerString = String.format("P:%s: %.2f, %s", super.toString(), money, strategija.toString());
		} else {
			passengerString = String.format("P:%s: %.2f, %s", super.toString(), money, "NoStrategy");
		}
		if (karta == null) {
			passengerString += " NO TICKET!";
		}
		return passengerString;
	}
}