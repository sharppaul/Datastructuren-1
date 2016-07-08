package opdracht3;

public class App {
	public static void main(String[] args) {
		Administratie a = Administratie.administratie;
		System.out.println("--");
		a.printBehaaldeVakken("1");
		System.out.println("--");
		a.printBeterGeslacht("PROG01");
		System.out.println("--");
		System.out.println(a.somAlleVoldoendes("1"));
		System.out.println("--");
		a.printStudentenMetGehaaldVak("PROG01");
		System.out.println("--");
		a.printVakGemiddelde("PROG01");
		System.out.println("--");
		System.out.println("Standaard deviatie student 3"+a.standaardDeviatie("3"));
		System.out.println("--");
		System.out.println("Variantie PROG01:"+ a.variantie("PROG01"));
	}
}
