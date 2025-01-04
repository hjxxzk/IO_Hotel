package ModelHotelu;

/**
 * Factory Method
 */
public abstract class GoœæFactoryMethod {

	private string imie_nazwisko;
	private string numer_telefonu;
	private string adres_email;
	private boolean Czy_dla_kogos;
	private List<Wspó³lokatorzy> wspollokatorzy;
	private string specjalne_zyczenia;

	public string getImie_nazwisko() {
		return this.imie_nazwisko;
	}

	public void setImie_nazwisko(string imie_nazwisko) {
		this.imie_nazwisko = imie_nazwisko;
	}

	public string getNumer_telefonu() {
		return this.numer_telefonu;
	}

	public void setNumer_telefonu(string numer_telefonu) {
		this.numer_telefonu = numer_telefonu;
	}

	public string getAdres_email() {
		return this.adres_email;
	}

	public void setAdres_email(string adres_email) {
		this.adres_email = adres_email;
	}

	public boolean isCzy_dla_kogos() {
		return this.Czy_dla_kogos;
	}

	public void setCzy_dla_kogos(boolean Czy_dla_kogos) {
		this.Czy_dla_kogos = Czy_dla_kogos;
	}

	public List<Wspó³lokatorzy> getWspollokatorzy() {
		return this.wspollokatorzy;
	}

	public void setWspollokatorzy(List<Wspó³lokatorzy> wspollokatorzy) {
		this.wspollokatorzy = wspollokatorzy;
	}

	public string getSpecjalne_zyczenia() {
		return this.specjalne_zyczenia;
	}

	public void setSpecjalne_zyczenia(string specjalne_zyczenia) {
		this.specjalne_zyczenia = specjalne_zyczenia;
	}

	private void addBusinessTrip() {
		// TODO - implement GoœæFactoryMethod.addBusinessTrip
		throw new UnsupportedOperationException();
	}

	private void addRoommates() {
		// TODO - implement GoœæFactoryMethod.addRoommates
		throw new UnsupportedOperationException();
	}

	private void editContactInfo() {
		// TODO - implement GoœæFactoryMethod.editContactInfo
		throw new UnsupportedOperationException();
	}

	private void editRoomatesContactInfo() {
		// TODO - implement GoœæFactoryMethod.editRoomatesContactInfo
		throw new UnsupportedOperationException();
	}

	private void deleteRoommate() {
		// TODO - implement GoœæFactoryMethod.deleteRoommate
		throw new UnsupportedOperationException();
	}

	private Gosc createGuest() {
		// TODO - implement GoœæFactoryMethod.createGuest
		throw new UnsupportedOperationException();
	}

}