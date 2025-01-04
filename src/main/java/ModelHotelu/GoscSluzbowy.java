package ModelHotelu;

import java.util.ArrayList;
import java.util.List;

public class GoscSluzbowy extends Gosc {

	private String nazwaFirmy;
	private int numerVat;
	private int numerNip;
	private String imieNazwisko;
	private String numerTelefonu;
	private String adresEmail;
	private boolean czyDlaKogos;
	private List<Wspollokator> wspollokatorzy;
	private String specjalneZyczenia;

	// Konstruktor
	public GoscSluzbowy(String nazwaFirmy, int numerVat, int numerNip, String imieNazwisko, String numerTelefonu, String adresEmail, boolean czyDlaKogos, String specjalneZyczenia) {
		this.nazwaFirmy = nazwaFirmy;
		this.numerVat = numerVat;
		this.numerNip = numerNip;
		this.imieNazwisko = imieNazwisko;
		this.numerTelefonu = numerTelefonu;
		this.adresEmail = adresEmail;
		this.wspollokatorzy = new ArrayList<>();
		this.czyDlaKogos = czyDlaKogos;
		this.specjalneZyczenia = specjalneZyczenia;
	}

	// Gettery i Settery
	public String getNazwaFirmy() {
		return nazwaFirmy;
	}

	public void setNazwaFirmy(String nazwaFirmy) {
		this.nazwaFirmy = nazwaFirmy;
	}

	public int getNumerVat() {
		return numerVat;
	}

	public void setNumerVat(int numerVat) {
		this.numerVat = numerVat;
	}

	public int getNumerNip() {
		return numerNip;
	}

	public void setNumerNip(int numerNip) {
		this.numerNip = numerNip;
	}

	public String getImieNazwisko() {
		return imieNazwisko;
	}

	public void setImieNazwisko(String imieNazwisko) {
		this.imieNazwisko = imieNazwisko;
	}

	public String getNumerTelefonu() {
		return numerTelefonu;
	}

	public void setNumerTelefonu(String numerTelefonu) {
		this.numerTelefonu = numerTelefonu;
	}

	public String getAdresEmail() {
		return adresEmail;
	}

	public void setAdresEmail(String adresEmail) {
		this.adresEmail = adresEmail;
	}

	public boolean isCzyDlaKogos() {
		return czyDlaKogos;
	}

	public void setCzyDlaKogos(boolean czyDlaKogos) {
		this.czyDlaKogos = czyDlaKogos;
	}

	public List<Wspollokator> getWspollokatorzy() {
		return wspollokatorzy;
	}

	public void setWspollokatorzy(List<Wspollokator> wspollokatorzy) {
		this.wspollokatorzy = wspollokatorzy;
	}

	public String getSpecjalneZyczenia() {
		return specjalneZyczenia;
	}

	public void setSpecjalneZyczenia(String specjalneZyczenia) {
		this.specjalneZyczenia = specjalneZyczenia;
	}

	// Operacje na wspollokatorach
	public void addRoommates(Wspollokator wspollokator) {
		wspollokatorzy.add(wspollokator);
		System.out.println("Dodano współlokatora: " + wspollokator.getImieNazwisko());
	}

	public void editContactInfo(String nowyNumer, String nowyEmail) {
		this.numerTelefonu = nowyNumer;
		this.adresEmail = nowyEmail;
		System.out.println("Zaktualizowano dane kontaktowe dla: " + imieNazwisko);
	}

	public void deleteRoommate(Wspollokator wspollokator) {
		if (wspollokatorzy.remove(wspollokator)) {
			System.out.println("Usunięto współlokatora: " + wspollokator.getImieNazwisko());
		} else {
			System.out.println("Nie znaleziono współlokatora.");
		}
	}
}
