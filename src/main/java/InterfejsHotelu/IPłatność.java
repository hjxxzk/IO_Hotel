package InterfejsHotelu;

public interface IP�atno�� {

	/**
	 * 
	 * @param przedplata
	 */
	void payInAdvance(float przedplata);

	/**
	 * 
	 * @param forma_platnosci
	 */
	void payFullPrice(forma_platnosci forma_platnosci);

	float calculatePriceLeftToPay();

}