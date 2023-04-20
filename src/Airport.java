import java.util.ArrayList;

public class Airport {
	private double[] koordinate;
	private int brojPisti;
	private ArrayList<Airport> povezanSa;
	private FlightControl kontrolaleta;
	private FlightDatabase bazaLetova;

	public FlightControl getControl() {
		return kontrolaleta;
	}

	public Airport(double x, double y, int brojPisti) {
		koordinate = new double[2];
		koordinate[0] = x;
		koordinate[1] = y;
		this.brojPisti = brojPisti;
		povezanSa = new ArrayList<Airport>();
		kontrolaleta = new FlightControl(brojPisti);
		kontrolaleta.setAirport(this);
	}

	public static void connect(Airport prvi, Airport drugi) {
		if (connected(prvi, drugi) == false) {
			prvi.povezanSa.add(drugi);
			drugi.povezanSa.add(prvi);
		} else {
			System.out.println("Aerodrom je vec povezan");
		}
	}

	public void setDatabase(FlightDatabase bazaLetova) {
		this.bazaLetova = bazaLetova;
	}

	public FlightDatabase celaBaza() {
		return bazaLetova;
	}

	public ArrayList<Flight> getDataBase() {
		return bazaLetova.getFlightList();
	}

	public static boolean connected(Airport prvi, Airport drugi) {
		for (int i = 0; i < prvi.povezanSa.size(); i++) {
			if (prvi.povezanSa.get(i) == drugi) {
				return true;
			}
		}
		return false;
	}

	public static double distance(Airport prvi, Airport drugi) {
		double jedan;
		double dva;
		jedan = Math.abs((prvi.koordinate[0] - drugi.koordinate[0]) * (prvi.koordinate[0] - drugi.koordinate[0]));
		dva = Math.abs((prvi.koordinate[1] - drugi.koordinate[1]) * (prvi.koordinate[1] - drugi.koordinate[1]));
		return Math.sqrt(jedan + dva);
	}

	public String toString() {
		String airportString = (String.format("[%.2f, %.2f]: %d", koordinate[0], koordinate[1], brojPisti) + "\r\n");
		airportString += ("Connected to: \r\n");
		for (int i = 0; i < povezanSa.size(); i++) {
			airportString += (String.format("[%.2f, %.2f]: %d", povezanSa.get(i).koordinate[0],
					povezanSa.get(i).koordinate[1], povezanSa.get(i).brojPisti) + "\r\n");
		}
		return airportString;
	}
}
