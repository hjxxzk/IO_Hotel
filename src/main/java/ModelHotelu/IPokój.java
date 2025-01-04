package ModelHotelu;

public interface IPokój {

	/**
	 * 
	 * @param data_rozpoczecia
	 * @param data_zakonczenia
	 */
	void addReservationDate(LocalDate data_rozpoczecia, LocalDate data_zakonczenia);

	/**
	 * 
	 * @param data_rozpoczecia
	 * @param data_zakonczenia
	 */
	void deleteReservationDate(LocalDate data_rozpoczecia, LocalDate data_zakonczenia);

	/**
	 * 
	 * @param data_rozpoczecia
	 * @param data_zakonczenia
	 * @param zmieniona_data_rozpoczecia
	 * @param zmieniona_data_zakonczenia
	 */
	void editReservationdate(LocalDate data_rozpoczecia, LocalDate data_zakonczenia, LocalDate zmieniona_data_rozpoczecia, LocalDate zmieniona_data_zakonczenia);

	/**
	 * 
	 * @param data_rozpoczecia
	 * @param data_zakonczenia
	 */
	float calculateCost(LocalDate data_rozpoczecia, LocalDate data_zakonczenia);

}