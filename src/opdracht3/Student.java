package opdracht3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Student {
	private String studentnummer;
	private String naam;
	private char geslacht;
	private String klas;
	private String studierichting;
	//set omdat daar alleen unieke waardes in kunnen, voorkomt dubbele vakken. Plus, het is afgeleid van een collection (handig voor linked list etc later)
	private Set<Vak> vakken = new HashSet<>();
	
	public Student(String studentnummer, String naam, char geslacht, String klas, String richting) {
		this.setStudentnummer(studentnummer);
		this.setNaam(naam);
		this.setGeslacht(geslacht);
		this.setKlas(klas);
		this.setStudierichting(richting);
	}
	
	public double getGemiddelde(){
		if(vakken.isEmpty())
			return -1;
		
		double average = 0;
		int aantal = 0;
		for(Vak vak : this.vakken){
			if(vak.getCijfer() > 0){
				aantal++;
				average += vak.getCijfer();
			}
		}
		return average/(double)aantal;
	}
	
	public boolean addVak(Vak vak){
		return vakken.add(vak);
	}
	
	public List<Vak> getVakken(){
		List<Vak> vakken = new LinkedList<>();
		vakken.addAll(this.vakken);
		return vakken;
	}
	
	public List<Vak> getVakken(int jaar){
		List<Vak> vakken = new LinkedList<>();
		//for (Vak vak in vakken)
		for(Vak vak : this.vakken){
			if(vak.getJaar() == jaar)
				vakken.add(vak);
		}
		return vakken;
	}
	
	public String getStudentnummer() {
		return studentnummer;
	}

	public void setStudentnummer(String studentnummer) {
		this.studentnummer = studentnummer;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public char getGeslacht() {
		return geslacht;
	}

	public void setGeslacht(char geslacht) {
		if(geslacht == 'V' || geslacht == 'M')
			this.geslacht = geslacht;
		else 
			System.err.println("Invalid gender.");
	}

	public String getKlas() {
		return klas;
	}

	public void setKlas(String klas) {
		this.klas = klas;
	}

	public String getStudierichting() {
		return studierichting;
	}

	public void setStudierichting(String studierichting) {
		this.studierichting = studierichting;
	}
}
