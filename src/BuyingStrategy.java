import java.util.ArrayList;

abstract public class BuyingStrategy {
	public Ticket findBestTicket(ArrayList<Flight> a, double m, Passenger putnik) {
		return new Ticket();
	}
}
