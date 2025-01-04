package InterfejsHotelu;

import ModelHotelu.*;

import java.time.LocalDate;
import java.util.List;

public interface IHotel {

	/**
	 * 
	 * @param ilosc_doroslych
	 * @param ilosc_dzieci
	 * @param platnosc
	 * @param godzina_przyjazdu
	 * @param gosc
	 * @param pokoj
	 * @param termin
	 */
	void makeReservation(int ilosc_doroslych, int ilosc_dzieci, Platnosc platnosc, String godzina_przyjazdu, Gosc gosc, Pokoj pokoj, Termin termin);

	/**
	 * 
	 * @param ilosc_doroslych
	 * @param ilosc_dzieci
	 * @param platnosc
	 * @param godzina_przyjazdu
	 * @param gosc
	 * @param pokoj
	 * @param termin
	 * @param numer_rezerwacji
	 */
	void editReservation(int ilosc_doroslych, int ilosc_dzieci, Platnosc platnosc, String godzina_przyjazdu, Gosc gosc, Pokoj pokoj, Termin termin, String numer_rezerwacji, AdresZamieszkania adresZamieszkania);

	/**
	 * 
	 * @param numer_rezerwacji
	 */
	void deleteReservation(String numer_rezerwacji);

	List<Rezerwacja> displayTodaysGuests();

	/**
	 * 
	 * @param numer_rezerwacji
	 */
	void checkInGuests(String numer_rezerwacji);

	/**
	 * 
	 * @param numer_rezerwacji
	 */
	void checkOutGuests(String numer_rezerwacji);

	boolean checkInput(Rezerwacja nowaRezerwacja, Pokoj pokoj);

}