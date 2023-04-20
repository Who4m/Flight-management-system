enum Role {
	pilot, copilot, other
}

public class CrewMember extends Person {
	private Role role;

	public CrewMember(String ime, String prezime, Role role) {
		super(ime, prezime);
		this.role = role;
	}

	public Role getRole() {
		return role;
	}

	public String getIme() {
		return super.getIme();
	}

	public String getPrezime() {
		return super.getPrezime();
	}

	public String toString() {
		return String.format("CM:%s: %s", super.toString(), role);
	}
}
