package opdracht3;

public class Vak {
	private String modulecode;
	private double cijfer = -1;
	private int jaar;
	
	public Vak(String modulecode, int jaar){
		this.setModulecode(modulecode);
		this.setJaar(jaar);
	}

	public int getJaar() {
		return this.jaar;
	}

	public void setJaar(int jaar) {
		this.jaar = jaar;
	}

	public double getCijfer() {
		return cijfer;
	}

	public void setCijfer(double cijfer) {
		this.cijfer = cijfer;
	}

	public String getModulecode() {
		return modulecode;
	}

	public void setModulecode(String modulecode) {
		this.modulecode = modulecode;
	}

}
