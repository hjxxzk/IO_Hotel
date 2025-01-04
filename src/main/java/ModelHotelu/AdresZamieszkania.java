package ModelHotelu;

public class AdresZamieszkania {

	private String miejscowosc;
	private String ulica;
	private String numerDomu;
	private int numerMieszkania;
	private String kodPocztowy;
	private String kraj;

	// Konstruktor
	public AdresZamieszkania(String miejscowosc, String ulica, String numerDomu, int numerMieszkania, String kodPocztowy, String kraj) {
		this.miejscowosc = miejscowosc;
		this.ulica = ulica;
		this.numerDomu = numerDomu;
		this.numerMieszkania = numerMieszkania;
		this.kodPocztowy = kodPocztowy;
		this.kraj = kraj;
	}

	// Gettery i Settery
	public String getMiejscowosc() {
		return this.miejscowosc;
	}

	public void setMiejscowosc(String miejscowosc) {
		this.miejscowosc = miejscowosc;
	}

	public String getUlica() {
		return this.ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getNumerDomu() {
		return this.numerDomu;
	}

	public void setNumerDomu(String numerDomu) {
		this.numerDomu = numerDomu;
	}

	public int getNumerMieszkania() {
		return this.numerMieszkania;
	}

	public void setNumerMieszkania(int numerMieszkania) {
		this.numerMieszkania = numerMieszkania;
	}

	public String getKodPocztowy() {
		return this.kodPocztowy;
	}

	public void setKodPocztowy(String kodPocztowy) {
		this.kodPocztowy = kodPocztowy;
	}

	public String getKraj() {
		return this.kraj;
	}

	public void setKraj(String kraj) {
		this.kraj = kraj;
	}
}
