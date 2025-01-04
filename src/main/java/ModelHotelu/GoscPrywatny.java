package ModelHotelu;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GoscPrywatny extends Gosc {

	private String imieNazwisko;
	private String numerTelefonu;
	private String adresEmail;
	private boolean czyDlaKogos;
	private List<Wspollokator> wspollokatorzy;
	private String specjalneZyczenia;

	@Override
	public AdresZamieszkania getAdresZamieszkania() {
		return adresZamieszkania;
	}

	private AdresZamieszkania adresZamieszkania;

	@JsonCreator
	public GoscPrywatny(
			@JsonProperty("imieNazwisko") String imieNazwisko,
			@JsonProperty("numerTelefonu") String numerTelefonu,
			@JsonProperty("adresEmail") String adresEmail,
			@JsonProperty("czyDlaKogos") boolean czyDlaKogos,
			@JsonProperty("specjalneZyczenia") String specjalneZyczenia,
			@JsonProperty("adresZamieszkania") AdresZamieszkania adresZamieszkania
	) {
		this.imieNazwisko = imieNazwisko;
		this.numerTelefonu = numerTelefonu;
		this.adresEmail = adresEmail;
		this.czyDlaKogos = czyDlaKogos;
		this.specjalneZyczenia = specjalneZyczenia;
		this.adresZamieszkania = adresZamieszkania;
	}

	public void setAdresZamieszkania(AdresZamieszkania adresZamieszkania) {
		this.adresZamieszkania = adresZamieszkania;
	}

	private void addRoommates(Wspollokator wspollokator) {
		wspollokatorzy.add(wspollokator);
	}

	private void editContactInfo(String newNumerTelefonu, String newAdresEmail) {
		this.numerTelefonu = newNumerTelefonu;
		this.adresEmail = newAdresEmail;
	}

	private void deleteRoommate(Wspollokator wspollokator) {
		this.wspollokatorzy.remove(wspollokator);
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
