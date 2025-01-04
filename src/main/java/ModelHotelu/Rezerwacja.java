package ModelHotelu;

import InterfejsHotelu.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Rezerwacja implements IRezerwacja {

	private String dataRezerwacji;
	private boolean zameldowanie;
	private boolean wymeldowanie;
	private String numerRezerwacji;
	private int iloscDoroslych;
	private int iloscDzieci;
	private Platnosc platnosc;
	private String godzinaPrzyjazdu;
	private Gosc gosc;
	private Pokoj pokoj;
	private Termin termin;

	@JsonCreator
	public Rezerwacja(
			@JsonProperty("dataRezerwacji") String dataRezerwacji,
			@JsonProperty("zameldowanie") boolean zameldowanie,
			@JsonProperty("wymeldowanie") boolean wymeldowanie,
			@JsonProperty("numerRezerwacji") String numerRezerwacji,
			@JsonProperty("iloscDoroslych") int iloscDoroslych,
			@JsonProperty("iloscDzieci") int iloscDzieci,
			@JsonProperty("platnosc") Platnosc platnosc,
			@JsonProperty("godzinaPrzyjazdu") String godzinaPrzyjazdu,
			@JsonProperty("gosc") Gosc gosc,
			@JsonProperty("pokoj") Pokoj pokoj,
			@JsonProperty("termin") Termin termin) {
		this.dataRezerwacji = dataRezerwacji;
		this.zameldowanie = zameldowanie;
		this.wymeldowanie = wymeldowanie;
		this.numerRezerwacji = numerRezerwacji;
		this.iloscDoroslych = iloscDoroslych;
		this.iloscDzieci = iloscDzieci;
		this.platnosc = platnosc;
		this.godzinaPrzyjazdu = godzinaPrzyjazdu;
		this.gosc = gosc;
		this.pokoj = pokoj;
		this.termin = termin;
	}

	public Rezerwacja(int iloscDoroslych, int iloscDzieci, Platnosc platnosc, String godzinaPrzyjazdu, Gosc gosc, Pokoj pokoj, Termin termin)	{
		this.dataRezerwacji = getCurrentDate();
		this.iloscDoroslych = iloscDoroslych;
		this.iloscDzieci = iloscDzieci;
		this.platnosc = platnosc;
		this.godzinaPrzyjazdu = godzinaPrzyjazdu;
		this.gosc = gosc;
		this.pokoj = pokoj;
		this.termin = termin;
		this.zameldowanie = false;
		this.wymeldowanie = false;
		this.numerRezerwacji = generateReservationNumber();
	}

	public String getCurrentDate()	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}

	public String getDataRezerwacji() {
		return this.dataRezerwacji;
	}

	public void setDataRezerwacji(String dataRezerwacji) {
		this.dataRezerwacji = dataRezerwacji;
	}

	public boolean isZameldowanie() {
		return this.zameldowanie;
	}

	public void setZameldowanie(boolean zameldowanie) {
		this.zameldowanie = zameldowanie;
	}

	public boolean isWymeldowanie() {
		return this.wymeldowanie;
	}

	public void setWymeldowanie(boolean wymeldowanie) {
		this.wymeldowanie = wymeldowanie;
	}

	public String getNumerRezerwacji() {
		return this.numerRezerwacji;
	}

	public int getIloscDoroslych() {
		return this.iloscDoroslych;
	}

	public int getIloscDzieci() {
		return this.iloscDzieci;
	}

	public Platnosc getPlatnosc() {
		return this.platnosc;
	}

	public void setPlatnosc(Platnosc platnosc) {
		this.platnosc = platnosc;
	}

	public String getGodzinaPrzyjazdu() {
		return this.godzinaPrzyjazdu;
	}

	public void setGodzinaPrzyjazdu(String godzinaPrzyjazdu) {
		this.godzinaPrzyjazdu = godzinaPrzyjazdu;
	}

	public Gosc getGosc() {
		return this.gosc;
	}

	public void setGosc(Gosc gosc) {
		this.gosc = gosc;
	}

	public Pokoj getPokoj() {
		return this.pokoj;
	}

	public void setPokoj(Pokoj pokoj) {
		this.pokoj = pokoj;
	}

	public Termin getTermin() {
		return this.termin;
	}

	public void setTermin(String dataRezerwacji, String dataZakonczenia) {
		this.termin = termin;
	}

	public String generateReservationNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(100000);
		return getCurrentDate() + "-" + String.format("%05d", randomNumber);
	}

	public void checkIn() {
		this.zameldowanie = true;
	}

	public void checkOut() {
		this.wymeldowanie = true;
	}

	/**
	 * Edits the reservation dates.
	 *
	 * @param dataRozpoczecia Start date of the reservation
	 * @param dataZakonczenia End date of the reservation
	 */
	@Override
	public void editTermin(String dataRozpoczecia, String dataZakonczenia) {
		this.termin.setData_rozpoczecia_pobytu(dataRozpoczecia);
		this.termin.setData_zakonczenia_pobytu(dataZakonczenia);
	}

}
