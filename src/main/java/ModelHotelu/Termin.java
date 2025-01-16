package ModelHotelu;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Termin {

	private String data_rozpoczecia_pobytu;
	private String data_zakonczenia_pobytu;

	@JsonCreator
	public Termin(
			@JsonProperty("od") String data_rozpoczecia_pobytu,
			@JsonProperty("do") String data_zakonczenia_pobytu) {
		validateDates(data_rozpoczecia_pobytu, data_zakonczenia_pobytu);
		this.data_rozpoczecia_pobytu = data_rozpoczecia_pobytu;
		this.data_zakonczenia_pobytu = data_zakonczenia_pobytu;
	}

	protected void validateDates(String dataRozpoczecia, String dataZakonczenia) {
		try {
			LocalDate startDate = LocalDate.parse(dataRozpoczecia);
			LocalDate endDate = LocalDate.parse(dataZakonczenia);

			if (!startDate.isBefore(endDate)) {
				System.out.println(dataRozpoczecia + " " + dataZakonczenia);
				throw new IllegalArgumentException("Data rozpoczęcia musi być wcześniejsza niż data zakończenia.");
			}
		} catch (DateTimeParseException e) {
			throw new IllegalArgumentException("Nieprawidłowy format daty. Użyj formatu RRRR-MM-DD.", e);
		}
	}

	public String getData_rozpoczecia_pobytu() {
		return this.data_rozpoczecia_pobytu;
	}

	public void setData_rozpoczecia_pobytu(String data_rozpoczecia_pobytu) {
		this.data_rozpoczecia_pobytu = data_rozpoczecia_pobytu;
	}

	public String getData_zakonczenia_pobytu() {
		return this.data_zakonczenia_pobytu;
	}

	public void setData_zakonczenia_pobytu(String data_zakonczenia_pobytu) {
		this.data_zakonczenia_pobytu = data_zakonczenia_pobytu;
	}

}