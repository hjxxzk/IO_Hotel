package ViewHotelu;

import ModelHotelu.Gosc;
import ModelHotelu.Rezerwacja;
import ModelHotelu.Termin;

import javax.swing.*;
import java.awt.*;

public class RezerwacjaView implements IRezerwacjaView {

	public void wyswietlListeRezerwacji() {
		// TODO - implement RezerwacjaView.wyswietlListeRezerwacji
		//throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numer_rezerwacji
	 */
	public void wyswietlDaneRezerwacji(int numer_rezerwacji) {
		// TODO - implement RezerwacjaView.wyswietlDaneRezerwacji
		throw new UnsupportedOperationException();
	}

	public RezerwacjaView() {
		// TODO - implement RezerwacjaView.RezerwacjaView
		//throw new UnsupportedOperationException();
	}

	public void pokazSzczegolyRezerwacji(Rezerwacja rezerwacja) {
		// Tworzenie nowego okna
		JFrame detailsFrame = new JFrame("Rezerwacja");
		detailsFrame.setSize(400, 400);
		detailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Panel
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 182, 156)); // Pomarańczowe tło

		// Nagłówek
		JLabel reservationLabel = new JLabel("Rezerwacja numer: " + rezerwacja.getNumerRezerwacji());
		reservationLabel.setFont(new Font("Arial", Font.BOLD, 14));
		reservationLabel.setBounds(20, 20, 360, 30);
		panel.add(reservationLabel);

		// TextArea do wyświetlenia szczegółów
		JTextArea detailsArea = new JTextArea();
		detailsArea.setEditable(false);
		detailsArea.setText(formatujSzczegoly(rezerwacja)); // Ustaw szczegóły rezerwacji
		JScrollPane scrollPane = new JScrollPane(detailsArea);
		scrollPane.setBounds(20, 60, 350, 280);
		panel.add(scrollPane);

		// Dodanie panelu do ramki i wyświetlenie
		detailsFrame.add(panel);
		detailsFrame.setVisible(true);
	}

	//TODO rezerwacja
	public String formatujSzczegoly(Rezerwacja rezerwacja) {
		StringBuilder szczegoly = new StringBuilder();
		// Dane ogólne
		szczegoly.append("Numer rezerwacji: ").append(rezerwacja.getNumerRezerwacji()).append("\n");
		szczegoly.append("Data rezerwacji: ").append(rezerwacja.getDataRezerwacji()).append("\n");
		szczegoly.append("Godzina przyjazdu: ").append(rezerwacja.getGodzinaPrzyjazdu()).append("\n");
		szczegoly.append("Zameldowanie: ").append(rezerwacja.isZameldowanie() ? "Tak" : "Nie").append("\n");
		szczegoly.append("Wymeldowanie: ").append(rezerwacja.isWymeldowanie() ? "Tak" : "Nie").append("\n");

		// Gość
		szczegoly.append("\n--- Informacje o gościu ---\n");
		szczegoly.append("Imię i nazwisko: ").append(rezerwacja.getGosc().getImieNazwisko()).append("\n");
		szczegoly.append("Numer telefonu: ").append(rezerwacja.getGosc().getNumerTelefonu()).append("\n");
		szczegoly.append("Adres e-mail: ").append(rezerwacja.getGosc().getAdresEmail()).append("\n");
		szczegoly.append("Typ gościa: ").append(wyswietlTypGosc(rezerwacja)).append("\n");
		szczegoly.append("Specjalne życzenia: ").append(rezerwacja.getGosc().getSpecjalneZyczenia()).append("\n");
		szczegoly.append("Czy dla kogoś innego: ").append(rezerwacja.getGosc().isCzyDlaKogos() ? "Tak" : "Nie").append("\n");

		// Adres zamieszkania gościa
		szczegoly.append("\n--- Adres zamieszkania ---\n");
		szczegoly.append("Miejscowość: ").append(rezerwacja.getGosc().getAdresZamieszkania().getMiejscowosc()).append("\n");
		szczegoly.append("Ulica: ").append(rezerwacja.getGosc().getAdresZamieszkania().getUlica()).append("\n");
		szczegoly.append("Numer domu: ").append(rezerwacja.getGosc().getAdresZamieszkania().getNumerDomu()).append("\n");
		szczegoly.append("Numer mieszkania: ").append(
				rezerwacja.getGosc().getAdresZamieszkania().getNumerMieszkania() != 0 ?
						rezerwacja.getGosc().getAdresZamieszkania().getNumerMieszkania() : "Brak").append("\n");
		szczegoly.append("Kod pocztowy: ").append(rezerwacja.getGosc().getAdresZamieszkania().getKodPocztowy()).append("\n");
		szczegoly.append("Kraj: ").append(rezerwacja.getGosc().getAdresZamieszkania().getKraj()).append("\n");

		// Współlokatorzy
		if (rezerwacja.getGosc().getWspollokatorzy() != null && !rezerwacja.getGosc().getWspollokatorzy().isEmpty()) {
			szczegoly.append("\n--- Współlokatorzy ---\n");
			for (Gosc wspollokator : rezerwacja.getGosc().getWspollokatorzy()) {
				szczegoly.append("Imię i nazwisko: ").append(wspollokator.getImieNazwisko()).append("\n");
				szczegoly.append("Adres e-mail: ").append(wspollokator.getAdresEmail()).append("\n");
			}
		}

		// Pokój
		szczegoly.append("\n--- Informacje o pokoju ---\n");
		szczegoly.append("Numer pokoju: ").append(rezerwacja.getPokoj().getNumer()).append("\n");
		szczegoly.append("Piętro: ").append(rezerwacja.getPokoj().getPietro()).append("\n");
		szczegoly.append("Liczba gości: ").append(rezerwacja.getPokoj().getLiczbaGosci()).append("\n");
		szczegoly.append("Standard: ").append(rezerwacja.getPokoj().getStandard()).append("\n");
		szczegoly.append("Udogodnienia: ").append(rezerwacja.getPokoj().getUdogodnienia()).append("\n");
		szczegoly.append("Koszt: ").append(rezerwacja.getPokoj().getKoszt()).append(" zł\n");

		// Terminy pokoju
		if (rezerwacja.getPokoj().getTerminy() != null && !rezerwacja.getPokoj().getTerminy().isEmpty()) {
			szczegoly.append("\n--- Terminy pokoju ---\n");
			for (Termin termin : rezerwacja.getPokoj().getTerminy()) {
				szczegoly.append("Od: ").append(termin.getData_rozpoczecia_pobytu()).append(", Do: ").append(termin.getData_zakonczenia_pobytu()).append("\n");
			}
		}

		// Termin rezerwacji
		szczegoly.append("\n--- Termin pobytu ---\n");
		szczegoly.append("Data rozpoczęcia: ").append(rezerwacja.getTermin().getData_rozpoczecia_pobytu()).append("\n");
		szczegoly.append("Data zakończenia: ").append(rezerwacja.getTermin().getData_zakonczenia_pobytu()).append("\n");

		// Płatność
		szczegoly.append("\n--- Informacje o płatności ---\n");
		if (rezerwacja.getPlatnosc() != null) {
			szczegoly.append("Przedpłata: ").append(rezerwacja.getPlatnosc().getPrzedplata()).append(" zł\n");
			szczegoly.append("Koszt całkowity: ").append(rezerwacja.getPlatnosc().getKoszt()).append(" zł\n");
			szczegoly.append("Forma płatności: ").append(rezerwacja.getPlatnosc().getFormaPlatnosci()).append("\n");
			szczegoly.append("Data płatności: ").append(rezerwacja.getPlatnosc().getDataPlatnosci()).append("\n");
			szczegoly.append("Data przedpłaty: ").append(rezerwacja.getPlatnosc().getDataPrzedplaty()).append("\n");
		} else {
			szczegoly.append("Brak informacji o płatności.\n");
		}

		return szczegoly.toString();
	}

	public String wyswietlTypGosc(Rezerwacja rezerwacja) {
		if (rezerwacja.getGosc() != null) {
			return rezerwacja.getGosc().getClass().getSimpleName();
		}
		return null;
	}

}