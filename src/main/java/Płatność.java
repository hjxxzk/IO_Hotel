import InterfejsHotelu.*;

public class P³atnoœæ implements IP³atnoœæ {

	private float przedplata;
	private float koszt;
	private Enum forma_platnosci;
	private LocalDate data_platnosci;
	private LocalDate data_przedplaty;

	public float getPrzedplata() {
		return this.przedplata;
	}

	public void setPrzedplata(float przedplata) {
		this.przedplata = przedplata;
	}

	public float getKoszt() {
		return this.koszt;
	}

	public void setKoszt(float koszt) {
		this.koszt = koszt;
	}

	public Enum getForma_platnosci() {
		return this.forma_platnosci;
	}

	public void setForma_platnosci(Enum forma_platnosci) {
		this.forma_platnosci = forma_platnosci;
	}

	public LocalDate getData_platnosci() {
		return this.data_platnosci;
	}

	public void setData_platnosci(LocalDate data_platnosci) {
		this.data_platnosci = data_platnosci;
	}

	public LocalDate getData_przedplaty() {
		return this.data_przedplaty;
	}

	public void setData_przedplaty(LocalDate data_przedplaty) {
		this.data_przedplaty = data_przedplaty;
	}

	/**
	 * 
	 * @param przedplata
	 */
	private void payInAdvance(float przedplata) {
		// TODO - implement P³atnoœæ.payInAdvance
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param forma_platnosci
	 */
	private void payFullPrice(forma_platnosci forma_platnosci) {
		// TODO - implement P³atnoœæ.payFullPrice
		throw new UnsupportedOperationException();
	}

	private float calculatePriceLeftToPay() {
		// TODO - implement P³atnoœæ.calculatePriceLeftToPay
		throw new UnsupportedOperationException();
	}

}