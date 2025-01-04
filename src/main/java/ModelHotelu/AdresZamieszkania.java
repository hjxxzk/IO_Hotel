package ModelHotelu;

public class AdresZamieszkania {

	private string miejscowosc;
	private string ulica;
	private string numer_domu;
	private int numer_mieszkania;
	private string kod_pocztowy;
	private string kraj;

	public string getMiejscowosc() {
		return this.miejscowosc;
	}

	public void setMiejscowosc(string miejscowosc) {
		this.miejscowosc = miejscowosc;
	}

	public string getUlica() {
		return this.ulica;
	}

	public void setUlica(string ulica) {
		this.ulica = ulica;
	}

	public string getNumer_domu() {
		return this.numer_domu;
	}

	public void setNumer_domu(string numer_domu) {
		this.numer_domu = numer_domu;
	}

	public int getNumer_mieszkania() {
		return this.numer_mieszkania;
	}

	public void setNumer_mieszkania(int numer_mieszkania) {
		this.numer_mieszkania = numer_mieszkania;
	}

	public string getKod_pocztowy() {
		return this.kod_pocztowy;
	}

	public void setKod_pocztowy(string kod_pocztowy) {
		this.kod_pocztowy = kod_pocztowy;
	}

	public string getKraj() {
		return this.kraj;
	}

	public void setKraj(string kraj) {
		this.kraj = kraj;
	}

}