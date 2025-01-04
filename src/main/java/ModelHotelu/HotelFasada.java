package ModelHotelu;

import InterfejsHotelu.IHotel;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class HotelFasada implements IHotel {

	private List<Pokoj> pokoje;
	private List<Rezerwacja> rezerwacja;
	private HashMap<String, String> Recepcjonistki;

	public List<Pokoj> getPokoje() {
		return this.pokoje;
	}

	public List<Rezerwacja> getRezerwacja() {
		return this.rezerwacja;
	}

	public HashMap<String, String> getRecepcjonistki() {
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
	public void makeReservation(int ilosc_doroslych, int ilosc_dzieci, Platnosc platnosc, LocalDate godzina_przyjazdu, Gosc gosc, Pokoj pokoj, LocalDate Termin) {
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
	public void editReservation(int ilosc_doroslych, int ilosc_dzieci, Platnosc platnosc, LocalDate godzina_przyjazdu, Gosc gosc, Pokoj pokoj, LocalDate Termin, int numer_rezerwacji) {
		// TODO - implement HotelFasada.editReservation
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numer_rezerwacji
	 */
	public void deleteReservation(int numer_rezerwacji) {
		// TODO - implement HotelFasada.deleteReservation
		throw new UnsupportedOperationException();
	}

	public void displayTodaysGuests() {
		// TODO - implement HotelFasada.displayTodaysGuests
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numer_rezerwacji
	 */
	public void checkInGuests(int numer_rezerwacji) {
		// TODO - implement HotelFasada.checkInGuests
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numer_rezerwacji
	 */
	public void checkOutGuests(int numer_rezerwacji) {
		// TODO - implement HotelFasada.checkOutGuests
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param username
	 * @param password
	 */
	public void logIn(String username, String password) {
		// TODO - implement HotelFasada.logIn
		throw new UnsupportedOperationException();
	}

	public void logOut() {
		// TODO - implement HotelFasada.logOut
		throw new UnsupportedOperationException();
	}

	public void checkInput() {
		// TODO - implement HotelFasada.checkInput
		throw new UnsupportedOperationException();
	}

}