
import java.util.ArrayList;

public class Main {

	public static void test() {
		CheapTicketStrategy cheapTS = new CheapTicketStrategy();
		ExpensiveTicketStrategy expensiveTS = new ExpensiveTicketStrategy();
		AverageTicketStrategy averageTS = new AverageTicketStrategy();
		Passenger p1 = new Passenger("Denis", "Ristic", 7000);
		Passenger p2 = new Passenger("Dusan", "Jovanovic", 100);
		Passenger p3 = new Passenger("Petar", "Simic", 20000);
		Passenger p4 = new Passenger("Bogdan", "Stankovic", 10);
		Passenger p5 = new Passenger("Ivan", "Maksimovic", 231254);
		Passenger p6 = new Passenger("Ado", "Gegaj", 500);
		Passenger p7 = new Passenger("Seka", "Aleksic", 1000000);
		Passenger p8 = new Passenger("Ana", "Nikolic", 52);
		Passenger p9 = new Passenger("Stefan", "Rasta", 29982);
		Passenger p10 = new Passenger("Mitar", "Gol", 190);
		Passenger p11 = new Passenger("Abigail", "Mokasin", 18552);
		Passenger p12 = new Passenger("Vodonosa", "Vlaisic", 88888);
		Passenger p13 = new Passenger("Milos", "Petar", 130100);
		Passenger p14 = new Passenger("Roki", "Djole", 7777);
		CrewMember cm_p1 = new CrewMember("Adam", "Adamov", Role.pilot);
		CrewMember cm_p2 = new CrewMember("Milos", "Milosevic", Role.pilot);
		CrewMember cm_p3 = new CrewMember("Abram", "Nikolic", Role.pilot);
		CrewMember cm_cp1 = new CrewMember("Felix", "Brat", Role.copilot);
		CrewMember cm_cp2 = new CrewMember("Strogi", "Istok", Role.copilot);
		CrewMember cm_cp3 = new CrewMember("Milivoje", "Djuric", Role.copilot);
		CrewMember cm_o1 = new CrewMember("Kovid", "Sisojevic", Role.other);
		CrewMember cm_o2 = new CrewMember("Divok", "Molina", Role.other);
		CrewMember cm_o3 = new CrewMember("Afro", "Milosevic", Role.other);
		CrewMember cm_o4 = new CrewMember("Sima", "Stamenkovic", Role.other);
		CrewMember cm_o5 = new CrewMember("Boris", "Milosavljevic", Role.other);
		p1.setStrategy(cheapTS);
		p2.setStrategy(expensiveTS);
		p3.setStrategy(averageTS);
		p4.setStrategy(expensiveTS);
		p5.setStrategy(cheapTS);
		p6.setStrategy(cheapTS);
		p7.setStrategy(expensiveTS);
		p8.setStrategy(averageTS);
		p9.setStrategy(expensiveTS);
		p10.setStrategy(cheapTS);
		p11.setStrategy(expensiveTS);
		p12.setStrategy(expensiveTS);
		p13.setStrategy(expensiveTS);
		p14.setStrategy(averageTS);

		System.out.println("Treba sad da pise da nema pare covek: ");
		p3.takeMoney(27000);
		p3.takeMoney(1500);
		System.out.println("Treba sad da ispise 5 passengera, treci treba da ima 18500: ");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
		System.out.println(p5);
		System.out.println("Treba sad da ispise jednu posadu: ");
		System.out.println(cm_p1);
		System.out.println(cm_cp1);
		System.out.println(cm_o1);

//		pl1.addPassenger(p5);
//		pl1.addPassenger(p2);
//		pl1.addPassenger(p1);
//		pl1.addCrewMember(cm1);
//		pl1.addCrewMember(cm3);
//		pl1.addCrewMember(cm4);
//		pl1.addCrewMember(cm5);
//		if (pl1.removeCrewMember(cm2)) {
//			System.out.println("SUCCESS");
//		} else {
//			System.out.println("FAIL");
//		}
//		System.out.println(pl1);

		Airport a1 = new Airport(2, 7, 5);
		Airport a2 = new Airport(-4, -1, 8);
		Airport a3 = new Airport(2, 3, 5);
		Airport a4 = new Airport(-9, 1, 2);
		Airport a5 = new Airport(0, -6, 2);
		Airport a6 = new Airport(18, -5, 4);
		System.out.println("Treba sad da ispise 10: ");
		System.out.println(Airport.distance(a2, a1));
		Airport.connect(a1, a2);
		Airport.connect(a1, a3);
		Airport.connect(a1, a4);
		Airport.connect(a1, a5);
		Airport.connect(a1, a6);
		Airport.connect(a2, a4);
		Airport.connect(a4, a6);
		Airport.connect(a3, a6);
		System.out.println("Treba sad da ispise da su aerodromi vec povezani: ");
		Airport.connect(a2, a1);

		System.out.println("Treba sad da ispise Aerodrom 1, povezan je sa 5 komada: ");
		System.out.println(a1);
		System.out.println("Treba sad da ispise Aerodrom 2, povezan je sa 2 komada: ");
		System.out.println(a2);
		System.out.println("Treba sad da ispise Aerodrom 4, povezan je sa 3 komada: ");
		System.out.println(a4);

		Plane pl1 = new Plane(3);
		Plane pl2 = new Plane(3);
		Plane pl3 = new Plane(3);
		Plane pl4 = new Plane(3);
		Plane pl5 = new Plane(3);
		Plane pl6 = new Plane(3);
		Plane pl7 = new Plane(3);
		Plane pl8 = new Plane(3);
		Plane pl9 = new Plane(3);
		Plane pl10 = new Plane(3);
		Plane pl11 = new Plane(3);

		SequenceGenerator seqGen = new SequenceGenerator();
		FlightDatabase database = new FlightDatabase();
		database.setGenerator(seqGen);
		a1.setDatabase(database);
		a2.setDatabase(database);
		a3.setDatabase(database);
		a4.setDatabase(database);
		a5.setDatabase(database);
		a6.setDatabase(database);
		database.insertFlight(database.createFlight(a1, a2, pl1, 24.5));
		database.insertFlight(database.createFlight(a4, a6, pl1, 2.33));
		System.out.println("Treba sad da ispise da nisu povezani: ");
		database.insertFlight(database.createFlight(a2, a6, pl1, 2.33));
		System.out.println("Treba sad da ispise da flight not in database: ");
		database.deleteFlight(database.createFlight(a3, a6, pl1, 230));
		database.insertFlight(database.createFlight(a4, a6, pl2, 3.33));
		database.insertFlight(database.createFlight(a4, a6, pl3, 4.33));
		database.insertFlight(database.createFlight(a4, a6, pl4, 2.30));
		database.insertFlight(database.createFlight(a4, a6, pl5, 2.37));
		database.insertFlight(database.createFlight(a4, a2, pl6, 12.33)); // 9
		database.insertFlight(database.createFlight(a4, a2, pl7, 32.33)); // 10
		database.insertFlight(database.createFlight(a4, a2, pl8, 22.33));
		database.insertFlight(database.createFlight(a4, a2, pl9, 42.33)); // 12
		database.insertFlight(database.createFlight(a4, a2, pl10, 222.33)); // 13
		database.insertFlight(database.createFlight(a3, a1, pl11, 18.33));
		System.out.println("Treba sad da ispise 10: ");
		System.out.println(database.findBySrcAirport(a4).size());
		System.out.println("Treba sad da ispise 1: ");
		System.out.println(database.findBySrcAirport(a1).size());
		System.out.println("Treba sad da ispise 0: ");
		System.out.println(database.findBySrcAirport(a2).size());
		System.out.println("Treba sad da ispise 6: ");
		System.out.println(database.findByDestAirport(a2).size());
		System.out.println("Treba sad da ispise 2: ");
		System.out.println(database.findByPlane(pl1).size());
		System.out.println("Treba sad da ispise 1: ");
		System.out.println(database.findByPlane(pl10).size());
		System.out.println("Treba sad da ispise 12: ");
		System.out.println(database.findByPlaneStatus(Status.FINISHED).size());
		System.out.println("Treba sad da ispise 0: ");
		System.out.println(database.findByPlaneStatus(Status.READY).size());
		System.out.println("Treba sad da ispise 11: ");
		System.out.println(database.findByMaxPrice(1000).size());
		System.out.println("Treba sad da ispise 6: ");
		System.out.println(database.findByMaxPrice(100).size());

		p1.buyTicket(a4, a2); // ID9
		System.out.println("Treba sad da ispise da ne moze da kupi tiket: ");
		p2.buyTicket(a4, a2);
		p7.buyTicket(a4, a2); // ID13
		p3.buyTicket(a4, a2); // ID12
		p11.buyTicket(a4, a2); // ID13, drugi putnik
		p12.buyTicket(a4, a2); // ID13, treci putnik - FULL JE
		// Sad je full ta voznja i treba da mi sledece expensive kupovina na tu liniju
		// da vrati u ID12
		p13.buyTicket(a4, a2); // ID12
		// A sad se i avg pomera u ID10
		p14.buyTicket(a4, a2); // ID10

		System.out.println(
				"Treba sad da ispise svi letovi (14): u 9 ima 1 covek, u 13 ima 3 coveka, u 12 ima 2 i u 10 ima 1 (s kupljene karte): ");
		System.out.println(database);

		System.out.println("Treba sad da ispise da vec ima tiket: ");
		p3.buyTicket(a5, a6);
		System.out.println("Treba sad da ispise da ne moze da kupi tiket: ");
		p4.buyTicket(a5, a6);

		System.out.println("Treba sad da ispise da ne postoji let: ");
		a4.getControl().setOnRunway(pl11);

		a4.getControl().setOnRunway(pl6); // 1 putnik
		a4.getControl().setOnRunway(pl10); // 3 putnik
		System.out.println("Treba sad da ispise da nema slobodne piste: ");
		a4.getControl().setOnRunway(pl7); // 1 putnik

		System.out.println("Treba sad da ispise da ovaj avion nije na pisti: ");
		a4.getControl().removeFromRunway(pl7);

		System.out.println(
				"Treba sad da ispise svi letovi opet: Samo ovaj put su avioni za letovi sa ID 9 i 13 READY i putnici treba da su ukrcani:  ");
		System.out.println(database);

		System.out.println("Treba sad da ispise da avion nije spreman za poletanje: ");
		a4.getControl().allowTakeOff(pl7);

		System.out.println("Treba sad da ispise da posada nije adekvatna: ");
		a4.getControl().allowTakeOff(pl6);

		// Sad stavljam avion na neki drugi aerodrom cisto da postane ready. Pa onda
		// probam njega na poletim na a4 i treba mi kaze da nije na pistu
		a1.getControl().setOnRunway(pl1);
		pl1.addCrewMember(cm_p1);
		pl1.addCrewMember(cm_cp1);
		pl1.addCrewMember(cm_o1);
		pl1.addCrewMember(cm_o2);
		pl1.addCrewMember(cm_o3);
		pl1.addCrewMember(cm_o4);
		pl1.addCrewMember(cm_o5);
		System.out.println("Treba sad da ispise da avion nije na pisti: ");
		a4.getControl().allowTakeOff(pl1);

		// Sad cu da posaljem jedan od letova. pl6(ID9) saljem pl10(ID13) ne
		pl6.addCrewMember(cm_p1);
		pl6.addCrewMember(cm_cp1);
		pl6.addCrewMember(cm_o1);
		pl6.addCrewMember(cm_o2);
		pl6.addCrewMember(cm_o3);
		pl6.addCrewMember(cm_o4);
		pl6.addCrewMember(cm_o5);
		pl10.addCrewMember(cm_p1);
		pl10.addCrewMember(cm_cp1);
		pl10.addCrewMember(cm_o1);
		pl10.addCrewMember(cm_o2);
		pl10.addCrewMember(cm_o3);
		pl10.addCrewMember(cm_o4);
		pl10.addCrewMember(cm_o5);
		a4.getControl().allowTakeOff(pl6);

		System.out.println("Ovaj put databaza treba da pokaze da je let ID9 u ONFLIGHT:  ");
		System.out.println(database);

		System.out.println("Treba sad da ispise da je avion vec na pistu pa onda da kaze da je u letu: ");
		a4.getControl().setOnRunway(pl10);
		a4.getControl().setOnRunway(pl6);

		System.out.println(
				"Treba sad da ispise svi avioni na a4 pistu: znaci JEDAN AVION samo pl10: to je onaj s 3 putnika");
		ArrayList<Plane> listPlane = a4.getControl().readyForTakeOff();
		System.out.println(listPlane.size());
		for (int i = 0; i < listPlane.size(); i++) {
			System.out.println(listPlane.get(i));
		}
		System.out.println("Treba sad da ispise 'PRAZNO'");
		listPlane = a4.getControl().readyForLanding();
		if (listPlane.size() == 0) {
			System.out.println("PRAZNO");
		}
		System.out.println(
				"Treba sad da ispise svi avioni spremni da slete na a2: znaci JEDAN AVION samo pl6: to je onaj s 1 putnika (mene)");
		listPlane = a2.getControl().readyForLanding();
		System.out.println(listPlane.size());
		for (int i = 0; i < listPlane.size(); i++) {
			System.out.println(listPlane.get(i));
		}

		System.out.println("Treba sad da ispise ovaj avion ne leti ka tamo: ");
		a4.getControl().allowLanding(pl6);
		System.out.println("Treba sad da ispise ovaj avion ne leti ka tamo: ");
		a2.getControl().allowLanding(pl11);
		a2.getControl().allowLanding(pl6);

		// Konacno!!!!!
		System.out.println(
				"ZA KRAJ: Treba sad da ispise svi letovi opet: Samo ovaj put ID9 je sleteo: nema vise putnika, finished je, i tiketi cisti:  ");
		System.out.println(database);

		System.out.println("Sad treba isprinta mene.. bez tiket, i 6933 dinara:");
		System.out.println(p1);

		System.out.println("Dva puta treba da kaze da ima previse pilota il kopilota: ");
		pl1.addCrewMember(cm_p2);
		pl1.addCrewMember(cm_cp1);
		a1.getControl().allowTakeOff(pl1);
		// KRAJ
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}

}
