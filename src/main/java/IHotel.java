public interface IHotel {

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
	void makeReservation(int ilosc_doroslych, int ilosc_dzieci, Platnosc platnosc, LocalDate godzina_przyjazdu, Gosc gosc, Pokoj pokoj, LocalDate Termin);

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
	void editReservation(int ilosc_doroslych, int ilosc_dzieci, Platnosc platnosc, LocalDate godzina_przyjazdu, Gosc gosc, Pokoj pokoj, LocalDate Termin, int numer_rezerwacji);

	/**
	 * 
	 * @param numer_rezerwacji
	 */
	void deleteReservation(int numer_rezerwacji);

	void displayTodaysGuests();

	/**
	 * 
	 * @param numer_rezerwacji
	 */
	void checkInGuests(int numer_rezerwacji);

	/**
	 * 
	 * @param numer_rezerwacji
	 */
	void checkOutGuests(int numer_rezerwacji);

	/**
	 * 
	 * @param username
	 * @param password
	 */
	void logIn(string username, string password);

	void logOut();

	void checkInput();

}