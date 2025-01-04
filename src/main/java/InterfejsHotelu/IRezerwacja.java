package InterfejsHotelu;

import ModelHotelu.FormaPlatnosci;

import java.time.LocalDate;

public interface IRezerwacja {

	void generateReservationNumber();

	/**
	 * Dodaje informacje o płatności.
	 * @param formaPlatnosci Forma płatności
	 * @param przedplata Kwota przedpłaty
	 */
	void addPaymentInformation(FormaPlatnosci formaPlatnosci, float przedplata);

	/**
	 * Ustawia termin rezerwacji.
	 * @param dataRozpoczecia Data rozpoczęcia rezerwacji
	 * @param dataZakonczenia Data zakończenia rezerwacji
	 */
	void setTermin(LocalDate dataRozpoczecia, LocalDate dataZakonczenia);

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
	void editTermin(LocalDate dataRozpoczecia, LocalDate dataZakonczenia);
}