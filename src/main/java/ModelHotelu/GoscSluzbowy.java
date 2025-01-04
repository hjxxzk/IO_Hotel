package ModelHotelu;

public class GoscSluzbowy extends GoœæFactoryMethod {

	private string nazwa_firmy;
	private int numer_vat;
	private int numer_nip;
	private string imie_nazwisko;
	private string numer_telefonu;
	private string adres_email;
	private boolean Czy_dla_kogos;
	private List<Wspollokatorzy> wspollokatorzy;
	private string specjalne_zyczenia;

	public string getNazwa_firmy() {
		return this.nazwa_firmy;
	}

	public void setNazwa_firmy(string nazwa_firmy) {
		this.nazwa_firmy = nazwa_firmy;
	}

	public int getNumer_vat() {
		return this.numer_vat;
	}

	public void setNumer_vat(int numer_vat) {
		this.numer_vat = numer_vat;
	}

	public int getNumer_nip() {
		return this.numer_nip;
	}

	public void setNumer_nip(int numer_nip) {
		this.numer_nip = numer_nip;
	}

	private void addRoommates() {
		// TODO - implement GoscSluzbowy.addRoommates
		throw new UnsupportedOperationException();
	}

	private void editContactInfo() {
		// TODO - implement GoscSluzbowy.editContactInfo
		throw new UnsupportedOperationException();
	}

	private void deleteRoommate() {
		// TODO - implement GoscSluzbowy.deleteRoommate
		throw new UnsupportedOperationException();
	}

}