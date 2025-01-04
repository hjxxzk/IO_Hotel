package ModelHotelu;

import InterfejsHotelu.*;
import java.time.LocalDate;

public class Rezerwacja implements IRezerwacja {

	private LocalDate dataRezerwacji;
	private boolean zameldowanie;
	private boolean wymeldowanie;
	private int numerRezerwacji;
	private int iloscDoroslych;
	private int iloscDzieci;
	private Platnosc platnosc; // Corrected to Platnosc (Payment)
	private LocalDate godzinaPrzyjazdu;
	private Gosc gosc; // Corrected to GoscFactoryMethod (Guest Factory)
	private Pokoj pokoj;
	private LocalDate termin;

	public LocalDate getDataRezerwacji() {
		return this.dataRezerwacji;
	}

	public void setDataRezerwacji(LocalDate dataRezerwacji) {
		this.dataRezerwacji = dataRezerwacji;
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

	public int getNumerRezerwacji() {
		return this.numerRezerwacji;
	}

	public int getIloscDoroslych() {
		return this.iloscDoroslych;
	}

	public int getIloscDzieci() {
		return this.iloscDzieci;
	}

	public Platnosc getPlatnosc() {
		return this.platnosc;
	}

	public void setPlatnosc(Platnosc platnosc) {
		this.platnosc = platnosc;
	}

	public LocalDate getGodzinaPrzyjazdu() {
		return this.godzinaPrzyjazdu;
	}

	public void setGodzinaPrzyjazdu(LocalDate godzinaPrzyjazdu) {
		this.godzinaPrzyjazdu = godzinaPrzyjazdu;
	}

	public Gosc getGosc() {
		return this.gosc;
	}

	public void setGosc(Gosc gosc) {
		this.gosc = gosc;
	}

	public Pokoj getPokoj() {
		return this.pokoj;
	}

	public void setPokoj(Pokoj pokoj) {
		this.pokoj = pokoj;
	}

	public LocalDate getTermin() {
		return this.termin;
	}

	public void setTermin(LocalDate dataRezerwacji, LocalDate dataZakonczenia) {
		this.termin = termin;
	}

	public void generateReservationNumber() {
		// TODO - implement Rezerwacja.generateReservationNumber
		throw new UnsupportedOperationException();
	}

	/**
	 * Adds payment information (e.g., prepayment)
	 *
	 * @param formaPlatnosci Payment method
	 * @param przedplata Prepayment amount
	 */
	public void addPaymentInformation(FormaPlatnosci formaPlatnosci, float przedplata) {
		// TODO - implement Rezerwacja.addPaymentInformation
		throw new UnsupportedOperationException();
	}

	public void checkIn() {
		// TODO - implement Rezerwacja.checkIn
		throw new UnsupportedOperationException();
	}

	public void checkOut() {
		// TODO - implement Rezerwacja.checkOut
		throw new UnsupportedOperationException();
	}

	/**
	 * Edits the reservation dates.
	 *
	 * @param dataRozpoczecia Start date of the reservation
	 * @param dataZakonczenia End date of the reservation
	 */
	public void editTermin(LocalDate dataRozpoczecia, LocalDate dataZakonczenia) {
		// TODO - implement Rezerwacja.editTermin
		throw new UnsupportedOperationException();
	}

}
