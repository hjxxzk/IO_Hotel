package ModelHotelu;

import java.util.List;

public class GoscPrywatny extends Gosc {

	private String imieNazwisko;
	private String numerTelefonu;
	private String adresEmail;
	private boolean czyDlaKogos;
	private List<Wspollokator> wspollokatorzy;
	private String specjalneZyczenia;

	public GoscPrywatny(String imieNazwisko, String numerTelefonu, String adresEmail, boolean czyDlaKogos, String specjalneZyczenia) {
		setImieNazwisko(imieNazwisko);
		setNumerTelefonu(numerTelefonu);
		setAdresEmail(adresEmail);
		setCzyDlaKogos(czyDlaKogos);
		setSpecjalneZyczenia(specjalneZyczenia);
	}

	private void setAddress() {
		// TODO - implement GoscPrywatny.setAddress
		throw new UnsupportedOperationException();
	}

	private void addRoommates() {
		// TODO - implement GoscPrywatny.addRoommates
		throw new UnsupportedOperationException();
	}

	private void editContactInfo() {
		// TODO - implement GoscPrywatny.editContactInfo
		throw new UnsupportedOperationException();
	}

	private void deleteRoommate() {
		// TODO - implement GoscPrywatny.deleteRoommate
		throw new UnsupportedOperationException();
	}

	public String getImieNazwisko() {
		return this.imieNazwisko;
	}

	public void setImieNazwisko(String imieNazwisko) {
		this.imieNazwisko = imieNazwisko;
	}

	public String getNumerTelefonu() {
		return this.numerTelefonu;
	}

	public void setNumerTelefonu(String numerTelefonu) {
		this.numerTelefonu = numerTelefonu;
	}

	public String getAdresEmail() {
		return this.adresEmail;
	}

	public void setAdresEmail(String adresEmail) {
		this.adresEmail = adresEmail;
	}

	public boolean getCzyDlaKogos() {
		return this.czyDlaKogos;
	}

	public void setCzyDlaKogos(boolean czyDlaKogos) {
		this.czyDlaKogos = czyDlaKogos;
	}

	public List<Wspollokator> getWspollokatorzy() {
		return this.wspollokatorzy;
	}

	public void setWspollokatorzy(List<Wspollokator> wspollokatorzy) {
		this.wspollokatorzy = wspollokatorzy;
	}

	public String getSpecjalneZyczenia() {
		return this.specjalneZyczenia;
	}

	public void setSpecjalneZyczenia(String specjalneZyczenia) {
		this.specjalneZyczenia = specjalneZyczenia;
	}
}
