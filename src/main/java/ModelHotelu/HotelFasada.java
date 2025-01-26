package ModelHotelu;

import InterfejsHotelu.IHotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class HotelFasada implements IHotel {
	private List<Pokoj> pokoje;
	private List<Rezerwacja> rezerwacje = new ArrayList<>();

	private Pokoj pokojDoZarezerwowania;

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

	public Pokoj getPokojDoZarezerwowania() {
		return pokojDoZarezerwowania;
	}

	public void setPokojDoZarezerwowania(Pokoj pokojDoZarezerwowania) {
		this.pokojDoZarezerwowania = pokojDoZarezerwowania;
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
		if(checkInput(nowaRezerwacja, pokoj) && validateDates(termin.getData_rozpoczecia_pobytu(), termin.getData_zakonczenia_pobytu()))	{
			rezerwacje.add(nowaRezerwacja);
			for (Pokoj pokojZListy : pokoje) {
				if (pokojZListy.equals(pokoj)) {
					pokojZListy.addReservationDate(termin);
					break;
				}
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
	 * @param termin
	 * @param numer_rezerwacji
	 */
	public void editReservation(int ilosc_doroslych, int ilosc_dzieci, Platnosc platnosc, String godzina_przyjazdu, Gosc gosc, Pokoj pokoj, Termin termin, String numer_rezerwacji, AdresZamieszkania adresZamieszkania) {
		for (Rezerwacja rezerwacja : rezerwacje) {
			if (rezerwacja.getNumerRezerwacji().equals(numer_rezerwacji)) {
				for (Pokoj pokojZListy : pokoje) {
					if (pokojZListy.getNumer().equals(pokoj.getNumer())) {
						pokojZListy.editReservationDate(rezerwacja.getTermin().getData_rozpoczecia_pobytu(), rezerwacja.getTermin().getData_zakonczenia_pobytu(),
								termin.getData_rozpoczecia_pobytu(), termin.getData_zakonczenia_pobytu());
						break;
					}
				}
				rezerwacja.setTermin(termin);
				rezerwacja.setPlatnosc(platnosc);
				rezerwacja.setGodzinaPrzyjazdu(godzina_przyjazdu);
				rezerwacja.setGosc(gosc);
				rezerwacja.getGosc().setAdresZamieszkania(adresZamieszkania);
			}
		}
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
			if ((startDate.equals(today) && !rezerwacja.isZameldowanie()) || (endDate.equals(today) && !rezerwacja.isWymeldowanie())) {
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

	public List<Pokoj> listaDostepnychPokoi(String dataPrzyjazdu, String dataWyjazdu, int iloscDzieci, int iloscDoroslych)	{
		List<Pokoj> dostepnePokoje = new ArrayList<>();
		for(Pokoj pokoj : pokoje)	{
			if(czyTerminJestWolny(dataPrzyjazdu, dataWyjazdu, pokoj) && (iloscDoroslych + iloscDzieci) <= pokoj.getLiczbaGosci())	{
				dostepnePokoje.add(pokoj);
			}
		}
		return dostepnePokoje;
	}

	public boolean checkInput(Rezerwacja nowaRezerwacja, Pokoj pokoj) {
        return czyTerminJestWolny(nowaRezerwacja.getTermin().getData_rozpoczecia_pobytu(), nowaRezerwacja.getTermin().getData_zakonczenia_pobytu(), pokoj) && czyIloscMiejscSieZgadza(nowaRezerwacja, pokoj);
	}

	public boolean czyIloscMiejscSieZgadza(Rezerwacja nowaRezerwacja, Pokoj pokoj)	{
		return nowaRezerwacja.getIloscDzieci() + nowaRezerwacja.getIloscDoroslych() <= pokoj.getLiczbaGosci();
	}

	public boolean czyTerminJestWolny(String dataPrzyjazdu, String dataWyjazdu, Pokoj pokoj)	{

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate nowyStart = LocalDate.parse(dataPrzyjazdu, formatter);
		LocalDate nowyEnd = LocalDate.parse(dataWyjazdu, formatter);

		for (Termin t : pokoj.getTerminy()) {
			LocalDate start = LocalDate.parse(t.getData_rozpoczecia_pobytu(), formatter);
			LocalDate end = LocalDate.parse(t.getData_zakonczenia_pobytu(), formatter);

			if ((nowyStart.isBefore(end) && nowyEnd.isAfter(start)) ||
					(nowyStart.isEqual(start) || nowyEnd.isEqual(end))) {
				return false;
			}
		}
		return true;
	}

	protected boolean validateDates(String dataRozpoczecia, String dataZakonczenia) {
		try {
			LocalDate startDate = LocalDate.parse(dataRozpoczecia);
			LocalDate endDate = LocalDate.parse(dataZakonczenia);

			if (!startDate.isBefore(endDate)) {
				return false;
			}
		} catch (DateTimeParseException e) {
			return false;
		}

		return true;
	}


}