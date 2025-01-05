package InterfejsHotelu;

import ModelHotelu.FormaPlatnosci;

public interface IRezerwacja {

	String generateReservationNumber();

	/**
	 * Ustawia termin rezerwacji.
	 * @param dataRozpoczecia Data rozpoczęcia rezerwacji
	 * @param dataZakonczenia Data zakończenia rezerwacji
	 */
	void setTermin(String dataRozpoczecia, String dataZakonczenia);

	/**
	 * Realizuje proces zameldowania.
	 */
	void checkIn();

	/**
	 * Realizuje proces wymeldowania.
	 */
	void checkOut();

	/**
	 * Edytuje termin rezerwacji.
	 * @param dataRozpoczecia Nowa data rozpoczęcia
	 * @param dataZakonczenia Nowa data zakończenia
	 */
	void editTermin(String dataRozpoczecia, String dataZakonczenia);
}
