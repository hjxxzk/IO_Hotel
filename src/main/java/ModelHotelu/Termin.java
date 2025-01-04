package ModelHotelu;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Termin {

	private String data_rozpoczecia_pobytu;
	private String data_zakonczenia_pobytu;

	@JsonCreator
	public Termin(
			@JsonProperty("od") String data_rozpoczecia_pobytu,
			@JsonProperty("do") String data_zakonczenia_pobytu) {
		this.data_rozpoczecia_pobytu = data_rozpoczecia_pobytu;
		this.data_zakonczenia_pobytu = data_zakonczenia_pobytu;
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