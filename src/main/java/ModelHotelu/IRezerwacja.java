package ModelHotelu;

import InterfejsHotelu.*;

public interface IRezerwacja {

	void generateReservationNumber();

	/**
	 * 
	 * @param forma_platnosci
	 * @param przedplata
	 */
	void addPaymentInformation(forma_platnosci forma_platnosci, float przedplata);

	/**
	 * 
	 * @param data_ropzoczecia
	 * @param data_zakonczenia
	 */
	void setTermin(LocalDate data_ropzoczecia, LocalDate data_zakonczenia);

	void checkIn();

	void checkOut();

	/**
	 * 
	 * @param data_rozpoczecia
	 * @param data_zakonczenia
	 */
	void editTermin(LocalDate data_rozpoczecia, LocalDate data_zakonczenia);

}