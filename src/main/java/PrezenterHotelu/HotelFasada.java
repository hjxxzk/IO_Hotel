package PrezenterHotelu;

public class HotelFasada implements IHotel {

	private list<Pokój> pokoje;
	private list<Rezerwacja> rezerwacja;
	private HashMap<string, string> Recepcjonistki;

	public list<Pokój> getPokoje() {
		return this.pokoje;
	}

	public list<Rezerwacja> getRezerwacja() {
		return this.rezerwacja;
	}

	public HashMap<string, string> getRecepcjonistki() {
		return this.Recepcjonistki;
	}

	/**
	 * 
	 * @param ilosc_doroslych
	 * @param ilosc_dzieci
	 * @param platnosc
	 * @param godzina_przyjazdu
	 * @param gosc
	 * @param pokoj
	 * @param Termin
	 */
	private void makeReservation(int ilosc_doroslych, int ilosc_dzieci, Platnosc platnosc, LocalDate godzina_przyjazdu, Gosc gosc, Pokoj pokoj, LocalDate Termin) {
		// TODO - implement HotelFasada.makeReservation
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ilosc_doroslych
	 * @param ilosc_dzieci
	 * @param platnosc
	 * @param godzina_przyjazdu
	 * @param gosc
	 * @param pokoj
	 * @param Termin
	 * @param numer_rezerwacji
	 */
	private void editReservation(int ilosc_doroslych, int ilosc_dzieci, Platnosc platnosc, LocalDate godzina_przyjazdu, Gosc gosc, Pokoj pokoj, LocalDate Termin, int numer_rezerwacji) {
		// TODO - implement HotelFasada.editReservation
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numer_rezerwacji
	 */
	private void deleteReservation(int numer_rezerwacji) {
		// TODO - implement HotelFasada.deleteReservation
		throw new UnsupportedOperationException();
	}

	protected void displayTodaysGuests() {
		// TODO - implement HotelFasada.displayTodaysGuests
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numer_rezerwacji
	 */
	protected void checkInGuests(int numer_rezerwacji) {
		// TODO - implement HotelFasada.checkInGuests
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numer_rezerwacji
	 */
	protected void checkOutGuests(int numer_rezerwacji) {
		// TODO - implement HotelFasada.checkOutGuests
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param username
	 * @param password
	 */
	protected void logIn(string username, string password) {
		// TODO - implement HotelFasada.logIn
		throw new UnsupportedOperationException();
	}

	protected void logOut() {
		// TODO - implement HotelFasada.logOut
		throw new UnsupportedOperationException();
	}

	private void checkInput() {
		// TODO - implement HotelFasada.checkInput
		throw new UnsupportedOperationException();
	}

}