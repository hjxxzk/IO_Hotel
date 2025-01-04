package PrezenterHotelu;

public interface IRecepjonistkaAutoryzacja {

	/**
	 * Gets the first name of the receptionist.
	 *
	 * @return the first name of the receptionist
	 */
	String getImie();

	/**
	 * Gets the last name of the receptionist.
	 *
	 * @return the last name of the receptionist
	 */
	String getNazwisko();

	/**
	 * Gets the unique identifier of the receptionist.
	 *
	 * @return the ID of the receptionist
	 */
	int getId();

	/**
	 * Gets the currently logged-in receptionist.
	 *
	 * @return the logged-in receptionist or null if no one is logged in
	 */
	IRecepjonistkaAutoryzacja getZalogowany();

	/**
	 * Sets the currently logged-in receptionist.
	 *
	 * @param obecnieZalogowany the receptionist who is logging in
	 */
	void setZalogowany(IRecepjonistkaAutoryzacja obecnieZalogowany);
}
