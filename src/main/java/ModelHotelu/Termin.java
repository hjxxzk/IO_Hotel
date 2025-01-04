package ModelHotelu;

public class Termin {

	private LocalDate data_rozpoczecia_pobytu;
	private LocalDate data_zakonczenia_pobytu;

	public LocalDate getData_rozpoczecia_pobytu() {
		return this.data_rozpoczecia_pobytu;
	}

	public void setData_rozpoczecia_pobytu(LocalDate data_rozpoczecia_pobytu) {
		this.data_rozpoczecia_pobytu = data_rozpoczecia_pobytu;
	}

	public LocalDate getData_zakonczenia_pobytu() {
		return this.data_zakonczenia_pobytu;
	}

	public void setData_zakonczenia_pobytu(LocalDate data_zakonczenia_pobytu) {
		this.data_zakonczenia_pobytu = data_zakonczenia_pobytu;
	}

}