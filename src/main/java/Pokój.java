import ModelHotelu.*;

public class Pok�j implements IPok�j {

	public string numer;
	public int pi�tro;
	public int liczba_gosci;
	public string standard;
	public string udogodnienia;
	private list<LocalDate> terminy;
	public int koszt;

	public string getNumer() {
		return this.numer;
	}

	public int getPi�tro() {
		return this.pi�tro;
	}

	public int getLiczba_gosci() {
		return this.liczba_gosci;
	}

	public string getStandard() {
		return this.standard;
	}

	public string getUdogodnienia() {
		return this.udogodnienia;
	}

	public list<LocalDate> getTerminy() {
		return this.terminy;
	}

	public int getKoszt() {
		return this.koszt;
	}

	/**
	 * 
	 * @param data_rozpoczecia
	 * @param data_zakonczenia
	 */
	protected void deleteReservationDate(LocalDate data_rozpoczecia, LocalDate data_zakonczenia) {
		// TODO - implement Pok�j.deleteReservationDate
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param data_rozpoczecia
	 * @param data_zakonczenia
	 * @param zmieniona_data_rozpoczecia
	 * @param zmieniona_data_zakonczenia
	 */
	protected void editReservationdate(LocalDate data_rozpoczecia, LocalDate data_zakonczenia, LocalDate zmieniona_data_rozpoczecia, LocalDate zmieniona_data_zakonczenia) {
		// TODO - implement Pok�j.editReservationdate
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param data_rozpoczecia
	 * @param data_zakonczenia
	 */
	protected float calculateCost(LocalDate data_rozpoczecia, LocalDate data_zakonczenia) {
		// TODO - implement Pok�j.calculateCost
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param data_rozpoczecia
	 * @param data_zakonczenia
	 */
	protected void addReservationDate(LocalDate data_rozpoczecia, LocalDate data_zakonczenia) {
		// TODO - implement Pok�j.addReservationDate
		throw new UnsupportedOperationException();
	}

}