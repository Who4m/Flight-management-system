
public class Ticket {
	private double price;
	private Passenger putnik;

	public Passenger getPassenger() {
		return putnik;
	}

	public double getPrice() {
		return price;
	}

	public Ticket() {

	}

	public Ticket(double price) {
		this.price = price;
	}

	public void setPutnik(Passenger putnik) {
		this.putnik = putnik;
	}

	public Ticket(double price, Passenger putnik) {
		this.price = price;
		this.putnik = putnik;
	}

	public String toString() {
		String ticketString;
		ticketString = String.format("Ticket: %.2f", price);
		if (putnik == null) {
			ticketString += ", no owner!";
		} else {
			ticketString += (", belongs to " + putnik.toString());
		}
		return ticketString;
	}
}
