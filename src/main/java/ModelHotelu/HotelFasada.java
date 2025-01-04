package ModelHotelu;

import InterfejsHotelu.IHotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelFasada implements IHotel {

	private List<Pokoj> pokoje;
	private List<Rezerwacja> rezerwacje;

	public List<Pokoj> getPokoje() {
		return this.pokoje;
	}

	public List<Rezerwacja> getRezerwacje() {
		return this.rezerwacje;
	}

	public void setPokoje(List<Pokoj> pokoje) {
		this.pokoje = pokoje;
	}

	public void setRezerwacje(List<Rezerwacja> rezerwacje) {
		this.rezerwacje = rezerwacje;
	}

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
	public void makeReservation(int ilosc_doroslych, int ilosc_dzieci, Platnosc platnosc, String godzina_przyjazdu, Gosc gosc, Pokoj pokoj, Termin termin) {
		Rezerwacja nowaRezerwacja = new Rezerwacja(ilosc_doroslych, ilosc_dzieci, platnosc, godzina_przyjazdu, gosc, pokoj, termin);
		rezerwacje.add(nowaRezerwacja);
		for (Pokoj pokojZListy : pokoje) {
			if (pokojZListy.equals(pokoj)) {
				pokojZListy.addReservationDate(termin);
				break;
			}
		}
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
	public void deleteReservation(String numer_rezerwacji) {
		for (Rezerwacja rezerwacja : rezerwacje) {
			if (rezerwacja.getNumerRezerwacji().equals(numer_rezerwacji)) {
				rezerwacje.remove(rezerwacja);
				break;
			}
		}
	}

	public List<Rezerwacja> displayTodaysGuests() {
		List<Rezerwacja> todaysGuests = new ArrayList<>();
		LocalDate today = LocalDate.now();

		for (Rezerwacja rezerwacja : rezerwacje) {
			Termin termin = rezerwacja.getTermin();
			LocalDate startDate = LocalDate.parse(termin.getData_rozpoczecia_pobytu());
			LocalDate endDate = LocalDate.parse(termin.getData_zakonczenia_pobytu());

			if (startDate.equals(today) || endDate.equals(today)) {
				todaysGuests.add(rezerwacja);
			}
		}
		return todaysGuests;
	}

	/**
	 * 
	 * @param numer_rezerwacji
	 */
	public void checkInGuests(String numer_rezerwacji) {
		for (Rezerwacja rezerwacja : rezerwacje) {
			if (rezerwacja.getNumerRezerwacji().equals(numer_rezerwacji)) {
				rezerwacja.checkIn();
			}
		}
	}

	/**
	 * 
	 * @param numer_rezerwacji
	 */
	public void checkOutGuests(String numer_rezerwacji) {
		for (Rezerwacja rezerwacja : rezerwacje) {
			if (rezerwacja.getNumerRezerwacji().equals(numer_rezerwacji)) {
				rezerwacja.checkOut();
			}
		}
	}
	public void checkInput() {
		// TODO - implement HotelFasada.checkInput
		throw new UnsupportedOperationException();
	}

}