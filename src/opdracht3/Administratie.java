package opdracht3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class Administratie {
	private Map<String, Student> studenten = new HashMap<>();
	@SuppressWarnings("unused")
	private int aantalStudenten = studenten.size();

	// TESTING:
	//DEZE CODE IS GEKOPIEERT VAN YOSHUA NAHAR, OM TE TESTEN. 
	public static Administratie administratie = new Administratie();

	private Administratie() {
		studenten.put("1", new Student("1", "Gerard", 'M', "1", "TI"));
		studenten.put("2", new Student("2", "Marco", 'M', "1", "TI"));
		studenten.put("3", new Student("3", "Wessel", 'M', "1", "TI"));
		studenten.put("4", new Student("4", "Anna", 'V', "1", "TI"));
		studenten.put("5", new Student("5", "Elvira", 'V', "1", "TI"));
		studenten.put("6", new Student("6", "Gwen", 'V', "4", "CMD"));
		studenten.put("7", new Student("7", "Ruud", 'M', "4", "CMD"));

		aantalStudenten = studenten.size();

		addVakkenBijStudenten_WithRandomCijfer();
	}

	private void addVakkenBijStudenten_WithRandomCijfer() {
		Vak vak;
		for (Student student : studenten.values()) {
			if (student.getStudierichting().equals("TI")) {
				vak = new Vak("PROG01", 1);
				vak.setCijfer(new Random().nextInt(10) + 1);
				student.addVak(vak);
				System.out.print("Student: " + student.getNaam() + "\t- Studentnummer: " + student.getStudentnummer()
						+ " - Geslacht: " + student.getGeslacht() + " - " + vak.getModulecode() + " - Cijfer: "
						+ vak.getCijfer());
				vak = new Vak("WISK01", 1);
				vak.setCijfer(new Random().nextInt(10) + 1);
				student.addVak(vak);
				System.out.print(" - " + vak.getModulecode() + " - Cijfer: " + vak.getCijfer());
				vak = new Vak("NETW02", 1);
				vak.setCijfer(new Random().nextInt(10) + 1);
				student.addVak(vak);
				System.out.println(" - " + vak.getModulecode() + " - Cijfer: " + vak.getCijfer());
			} else if (student.getStudierichting() == "CMD") {
				vak = new Vak("LEGO16", 4);
				vak.setCijfer(new Random().nextInt(10) + 1);
				student.addVak(vak);
				System.out.println("Student: " + student.getNaam() + "\t- Studentnummer: " + student.getStudentnummer()
						+ " - Geslacht: " + student.getGeslacht() + " - " + vak.getModulecode() + " - Cijfer: "
						+ vak.getCijfer());
			}
		}
	}
	
	
	//DIT IS MIJN EIGEN CODE:
	
	// VAKKEN
	public void printStudentenMetGehaaldVak(String modulecode) {
		Iterator<Entry<String, Student>> sIterator = studenten.entrySet().iterator();
		System.out.println("OUTPUT: Studenten die het vak " + modulecode + " gehaald hebben: ");
		while (sIterator.hasNext()) {
			Entry<String, Student> studentM = sIterator.next();
			Student student = studentM.getValue();
			ListIterator<Vak> vIterator = student.getVakken().listIterator();

			while (vIterator.hasNext()) {
				Vak vak = vIterator.next();
				if (vak.getModulecode().equals(modulecode) && vak.getCijfer() > 5.5) {
					System.out.println("\tStudenten No.: " + student.getStudentnummer() + "\tStudent: " + student.getNaam());
				}
			}
		}
	}

	public void printVakGemiddelde(String modulecode) {
		Iterator<Entry<String, Student>> sIterator = studenten.entrySet().iterator();
		int entries = 0;
		double punten = 0;

		while (sIterator.hasNext()) {
			Entry<String, Student> studentM = sIterator.next();
			Student student = studentM.getValue();
			ListIterator<Vak> vIterator = student.getVakken().listIterator();

			while (vIterator.hasNext()) {
				Vak vak = vIterator.next();
				if (vak.getModulecode().equals(modulecode) && vak.getCijfer() > 0) {
					entries++;
					punten += vak.getCijfer();
				}
			}
		}
		double avg = punten / (double) entries;
		System.out.println("OUTPUT: Gemiddelde voor " + modulecode + ": " + ((double) Math.round(avg * 100.0)) / 100.0);
	}

	// STUDENT
	public void printBehaaldeVakken(String studentnummer) {
		Student student = studenten.get(studentnummer);
		if (student == null) {
			System.out.println("Student bestaat niet! (" + studentnummer + ")");
		} else {
			System.out.println("OUTPUT: Student " + studentnummer + " heeft de volgende vakken gehaald: ");

			ListIterator<Vak> vIterator = student.getVakken().listIterator();
			while (vIterator.hasNext()) {
				Vak vak = vIterator.next();
				if (vak.getCijfer() >= 5.5) {
					System.out.println("\t" + vak.getModulecode() + " (" + vak.getCijfer() + ");");
				}
			}
		}

	}

	public void printOnbehaaldeVakken(String studentnummer) {
		Student student = studenten.get(studentnummer);
		if (student == null) {
			System.out.println("Student bestaat niet! (" + studentnummer + ")");
		} else {
			System.out.println("OUTPUT: Student " + studentnummer + " heeft de volgende vakken NIET gehaald: ");

			ListIterator<Vak> vIterator = student.getVakken().listIterator();
			while (vIterator.hasNext()) {
				Vak vak = vIterator.next();
				if (vak.getCijfer() < 0) {
					System.out.println("\t" + vak.getModulecode() + ";");
				}
			}
		}
	}

	// PROGRAMMEER MET STREAMS
	public double somAlleVoldoendes(String studentnummer) {
		Student student = studenten.get(studentnummer);
		if (student == null) {
			System.out.println("Student bestaat niet! (" + studentnummer + ")");
			return 0;
		} else {
			double som = 0;

			som = student.getVakken().stream().filter(vak -> vak.getCijfer() > 5).mapToDouble(vak -> vak.getCijfer())
					.sum();

			return (((double) Math.round(som * 100.0)) / 100.0);
		}
	}

	public double standaardDeviatie(String studentnummer) {
		Student student = studenten.get(studentnummer);
		if (student == null) {
			System.out.println("Student bestaat niet! (" + studentnummer + ")");
			return 0;
		} else {
			// formule: Sqrt( Som( (getal - gemiddelde)^2 ) / aantalCijfers -1)

			int aantalVakken = (int) student.getVakken().stream().filter(vak -> vak.getCijfer() > 0).count();
			double somCijfers = student.getVakken().stream().filter(vak -> vak.getCijfer() > 0)
					.mapToDouble(vak -> vak.getCijfer()).sum();
			double avg = somCijfers / (double) aantalVakken;

			double somCijfersMinusAvg = student.getVakken().stream().filter(vak -> vak.getCijfer() > 0)
					.mapToDouble(vak -> Math.pow(vak.getCijfer() - avg, 2)).sum();

			double deviation = Math.sqrt(somCijfersMinusAvg / aantalVakken - 1);

			return (((double) Math.round(deviation * 100.0)) / 100.0);
		}
	}

	public double variantie(String modulecode) {
		// formule = Som( (getal - gemiddelde)^2 ) / aantalCijfers -1
		Iterator<Entry<String, Student>> sIterator = studenten.entrySet().iterator();

		double somCijfers = 0;
		int studentenMetCijfer = 0;

		while (sIterator.hasNext()) {
			Entry<String, Student> studentM = sIterator.next();

			double cijfer = studentM.getValue().getVakken().stream()
					.filter(vak -> vak.getModulecode().equals(modulecode)).filter(vak -> vak.getCijfer() > 0)
					.mapToDouble(vak -> vak.getCijfer()).sum();
			if (cijfer > 0) {
				studentenMetCijfer++;
				somCijfers += cijfer;
			}
		}

		double avg = somCijfers / (float) studentenMetCijfer;
		double somVariance = 0;

		sIterator = studenten.entrySet().iterator();
		while (sIterator.hasNext()) {
			Entry<String, Student> studentM = sIterator.next();

			somVariance += studentM.getValue().getVakken().stream()
					.filter(vak -> vak.getModulecode().equals(modulecode)).filter(vak -> vak.getCijfer() > 0)
					.mapToDouble(vak -> Math.pow(vak.getCijfer() - avg, 2)).sum();
		}

		double variance = somVariance / (double) studentenMetCijfer - 1;

		return variance;
	}

	public void printBeterGeslacht(String modulecode) {
		Iterator<Entry<String, Student>> sIterator = studenten.entrySet().iterator();
		int mannen = 0;
		double mannensom = 0;
		int vrouwen = 0;
		double vrouwensom = 0;

		while (sIterator.hasNext()) {
			Entry<String, Student> studentM = sIterator.next();
			if (studentM.getValue().getGeslacht() == 'M') {
				double cijfer = studentM.getValue().getVakken().stream()
						.filter(vak -> vak.getModulecode().equals(modulecode)).filter(vak -> vak.getCijfer() > 0)
						.mapToDouble(vak -> vak.getCijfer()).sum();
				if (cijfer > 0) {
					mannen++;
					mannensom += cijfer;
				}
			} else if (studentM.getValue().getGeslacht() == 'V') {
				double cijfer = studentM.getValue().getVakken().stream()
						.filter(vak -> vak.getModulecode().equals(modulecode)).filter(vak -> vak.getCijfer() > 0)
						.mapToDouble(vak -> vak.getCijfer()).sum();
				if (cijfer > 0) {
					vrouwen++;
					vrouwensom += cijfer;
				}
			}
		}

		if ((mannensom / (double) mannen) > (vrouwensom / (double) vrouwen)) {
			System.out.println("Mannen zijn beter dan vrouwen in " + modulecode);
		} else {
			System.out.println("Vrouwen zijn beter dan mannen in " + modulecode);
		}
	}

	public int getAantalStudenten() {
		return studenten.size();
	}
}
