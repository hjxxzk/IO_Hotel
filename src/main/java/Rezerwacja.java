import ModelHotelu.*;
import InterfejsHotelu.*;

public class Rezerwacja implements IRezerwacja {

	private LocalDate data_rezerwacji;
	private boolean zameldowanie;
	private boolean wymeldowanie;
	private int numer_rezerwacji;
	private int ilosc_doroslych;
	private int ilosc_dzieci;
	private P�atno�� platnosc;
	private LocalDate godzina_przyjazdu;
	private Go��FactoryMethod gosc;
	private Pok�j pokoj;
	private LocalDate Termin;

	public LocalDate getData_rezerwacji() {
		return this.data_rezerwacji;
	}

	public void setData_rezerwacji(LocalDate data_rezerwacji) {
		this.data_rezerwacji = data_rezerwacji;
	}

	public boolean isZameldowanie() {
		return this.zameldowanie;
	}

	public void setZameldowanie(boolean zameldowanie) {
		this.zameldowanie = zameldowanie;
	}

	public boolean isWymeldowanie() {
		return this.wymeldowanie;
	}

	public void setWymeldowanie(boolean wymeldowanie) {
		this.wymeldowanie = wymeldowanie;
	}

	public int getNumer_rezerwacji() {
		return this.numer_rezerwacji;
	}

	public int getIlosc_doroslych() {
		return this.ilosc_doroslych;
	}

	public int getIlosc_dzieci() {
		return this.ilosc_dzieci;
	}

	public P�atno�� getPlatnosc() {
		return this.platnosc;
	}

	public void setPlatnosc(P�atno�� platnosc) {
		this.platnosc = platnosc;
	}

	public LocalDate getGodzina_przyjazdu() {
		return this.godzina_przyjazdu;
	}

	public void setGodzina_przyjazdu(LocalDate godzina_przyjazdu) {
		this.godzina_przyjazdu = godzina_przyjazdu;
	}

	public Go��FactoryMethod getGosc() {
		return this.gosc;
	}

	public void setGosc(Go��FactoryMethod gosc) {
		this.gosc = gosc;
	}

	public Pok�j getPokoj() {
		return this.pokoj;
	}

	public void setPokoj(Pok�j pokoj) {
		this.pokoj = pokoj;
	}

	public LocalDate getTermin() {
		return this.Termin;
	}

	public void setTermin(LocalDate Termin) {
		this.Termin = Termin;
	}

	private void generateReservationNumber() {
		// TODO - implement Rezerwacja.generateReservationNumber
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param forma_platnosci
	 * @param przedplata
	 */
	private void addPaymentInformation(forma_platnosci forma_platnosci, float przedplata) {
		// TODO - implement Rezerwacja.addPaymentInformation
		throw new UnsupportedOperationException();
	}

	protected void checkIn() {
		// TODO - implement Rezerwacja.checkIn
		throw new UnsupportedOperationException();
	}

	protected void checkOut() {
		// TODO - implement Rezerwacja.checkOut
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param data_rozpoczecia
	 * @param data_zakonczenia
	 */
	private void editTermin(LocalDate data_rozpoczecia, LocalDate data_zakonczenia) {
		// TODO - implement Rezerwacja.editTermin
		throw new UnsupportedOperationException();
	}

}