package opdracht2;

public class Student {
	private int studentNummer;
	private String naam;
	private int leeftijd;
	private String geslacht;

	public Student(int studentNummer, String naam, int leeftijd, String geslacht){
		this.studentNummer = studentNummer;
		this.naam = naam;
		this.leeftijd = leeftijd;
		this.geslacht = geslacht;
	}
		
	public int getStudentNummer() {
		return studentNummer;
	}

	public void setStudentNummer(int studentNummer) {
		this.studentNummer = studentNummer;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public int getLeeftijd() {
		return leeftijd;
	}

	public void setLeeftijd(int leeftijd) {
		this.leeftijd = leeftijd;
	}

	public String getGeslacht() {
		return geslacht;
	}

	public void setGeslacht(String geslacht) {
		if (geslacht.matches("M") || geslacht.matches("V"))
			this.geslacht = geslacht;
	}

	public void printStudent() {
		System.out.println("Student#:\t" + this.studentNummer + "\n" + "Naam:\t\t" + this.naam + "\n" + "Leeftijd:\t" + this.leeftijd
				+ "\n" + "Gelacht:\t" + this.geslacht);
	}

	public String toString() {
		return "Student#:\t" + this.studentNummer + "\n" + "Naam:\t\t" + this.naam + "\n" + "Leeftijd:\t" + this.leeftijd
				+ "\n" + "Gelacht:\t" + this.geslacht + "\n";
	}
}
