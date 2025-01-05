package ViewHotelu;

import ModelHotelu.*;
import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class RezerwacjaView implements IRezerwacjaView {

	HotelFasada hotel;

	public RezerwacjaView(HotelFasada hotel) {
		this.hotel = hotel;
	}

	public void wyswietlListeRezerwacji() {
		// TODO - implement RezerwacjaView.wyswietlListeRezerwacji
		throw new UnsupportedOperationException();
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

	public void zapisDanychRezerwacjiView(Rezerwacja selectedReservation, boolean isEditMode){
		// Tworzenie głównego okna
		JFrame frame = new JFrame(isEditMode ? "Edytuj Rezerwację" : "Dodaj Rezerwację");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(900, 750); // Zwiększono wysokość, aby uwzględnić większy panel
		frame.setLayout(null); // Użycie null layout dla pełnej kontroli nad rozmieszczeniem

		// Kolor tła
		Color tloKolor = new Color(255, 182, 156); // Odpowiada kolorowi na zdjęciu
		frame.getContentPane().setBackground(tloKolor); // Ustawienie koloru tła ramki

		// Panel "Dane Rezerwacji"
		JPanel daneRezerwacjiPanel = new JPanel();
		daneRezerwacjiPanel.setBounds(20, 20, 400, 350); // Zwiększono wysokość panelu
		daneRezerwacjiPanel.setBackground(tloKolor); // Ustawienie tła panelu
		daneRezerwacjiPanel.setBorder(BorderFactory.createTitledBorder("Dane Rezerwacji"));
		daneRezerwacjiPanel.setLayout(null);

		// Elementy "Dane Rezerwacji" z większym odstępem
		JLabel imieNazwiskoLabel = new JLabel("Imię i nazwisko:");
		imieNazwiskoLabel.setBounds(20, 30, 120, 25);
		JTextField imieNazwiskoField = new JTextField();
		imieNazwiskoField.setBounds(160, 30, 200, 25); // Większy odstęp w poziomie

		JLabel numerTelefonuLabel = new JLabel("Numer telefonu:");
		numerTelefonuLabel.setBounds(20, 70, 120, 25);
		JTextField numerTelefonuField = new JTextField();
		numerTelefonuField.setBounds(160, 70, 200, 25);

		JLabel adresEmailLabel = new JLabel("Adres Email:");
		adresEmailLabel.setBounds(20, 110, 120, 25);
		JTextField adresEmailField = new JTextField();
		adresEmailField.setBounds(160, 110, 200, 25);

		JLabel iloscDoroslychLabel = new JLabel("Ilość dorosłych:");
		iloscDoroslychLabel.setBounds(20, 150, 120, 25);
		JTextField iloscDoroslychField = new JTextField();
		iloscDoroslychField.setBounds(160, 150, 200, 25);

		JLabel iloscDzieciLabel = new JLabel("Ilość dzieci:");
		iloscDzieciLabel.setBounds(20, 190, 120, 25);
		JTextField iloscDzieciField = new JTextField();
		iloscDzieciField.setBounds(160, 190, 200, 25);

		JLabel godzinaPrzyjazduLabel = new JLabel("Godzina przyjazdu:");
		godzinaPrzyjazduLabel.setBounds(20, 230, 120, 25);
		JTextField godzinaPrzyjazduField = new JTextField();
		godzinaPrzyjazduField.setBounds(160, 230, 200, 25);

		JLabel specjalneZyczeniaLabel = new JLabel("Specjalne życzenia:");
		specjalneZyczeniaLabel.setBounds(20, 270, 130, 25);
		JTextField specjalneZyczeniaField = new JTextField();
		specjalneZyczeniaField.setBounds(160, 270, 200, 25);

		JCheckBox czyDlaInnejOsobyCheckBox = new JCheckBox("Czy to rezerwacja dla innej osoby?");
		czyDlaInnejOsobyCheckBox.setBounds(20, 310, 300, 25);
		czyDlaInnejOsobyCheckBox.setBackground(tloKolor); // Ustawienie tła checkboxa na kolor panelu

		// Dodanie elementów do panelu "Dane Rezerwacji"
		daneRezerwacjiPanel.add(imieNazwiskoLabel);
		daneRezerwacjiPanel.add(imieNazwiskoField);
		daneRezerwacjiPanel.add(numerTelefonuLabel);
		daneRezerwacjiPanel.add(numerTelefonuField);
		daneRezerwacjiPanel.add(adresEmailLabel);
		daneRezerwacjiPanel.add(adresEmailField);
		daneRezerwacjiPanel.add(iloscDoroslychLabel);
		daneRezerwacjiPanel.add(iloscDoroslychField);
		daneRezerwacjiPanel.add(iloscDzieciLabel);
		daneRezerwacjiPanel.add(iloscDzieciField);
		daneRezerwacjiPanel.add(godzinaPrzyjazduLabel);
		daneRezerwacjiPanel.add(godzinaPrzyjazduField);
		daneRezerwacjiPanel.add(specjalneZyczeniaLabel);
		daneRezerwacjiPanel.add(specjalneZyczeniaField);
		daneRezerwacjiPanel.add(czyDlaInnejOsobyCheckBox);

		// Panel "Rezerwacja służbowa"
		JPanel rezerwacjaSluzbowaPanel = new JPanel();
		rezerwacjaSluzbowaPanel.setBounds(450, 20, 400, 350);
		rezerwacjaSluzbowaPanel.setBackground(tloKolor);
		rezerwacjaSluzbowaPanel.setBorder(BorderFactory.createTitledBorder("Rezerwacja służbowa"));
		rezerwacjaSluzbowaPanel.setLayout(null);

		JLabel nazwaFirmyLabel = new JLabel("Nazwa firmy:");
		nazwaFirmyLabel.setBounds(20, 30, 120, 25);
		JTextField nazwaFirmyField = new JTextField();
		nazwaFirmyField.setBounds(160, 30, 200, 25);

		JLabel numerVATLabel = new JLabel("Numer VAT:");
		numerVATLabel.setBounds(20, 70, 120, 25);
		JTextField numerVATField = new JTextField();
		numerVATField.setBounds(160, 70, 200, 25);

		JLabel numerNIPLabel = new JLabel("Numer NIP:");
		numerNIPLabel.setBounds(20, 110, 120, 25);
		JTextField numerNIPField = new JTextField();
		numerNIPField.setBounds(160, 110, 200, 25);

		JButton wspollokatorzyButton = new JButton("Współlokatorzy");
		wspollokatorzyButton.setBounds(125, 170, 150, 30);

		JButton dodajPlatnoscButton = new JButton("Dodaj płatność");
		dodajPlatnoscButton.setBounds(125, 210, 150, 30);

		JButton zapiszButton = new JButton("Zapisz");
		zapiszButton.setBounds(125, 250, 150, 30);

		rezerwacjaSluzbowaPanel.add(nazwaFirmyLabel);
		rezerwacjaSluzbowaPanel.add(nazwaFirmyField);
		rezerwacjaSluzbowaPanel.add(numerVATLabel);
		rezerwacjaSluzbowaPanel.add(numerVATField);
		rezerwacjaSluzbowaPanel.add(numerNIPLabel);
		rezerwacjaSluzbowaPanel.add(numerNIPField);
		rezerwacjaSluzbowaPanel.add(wspollokatorzyButton);
		rezerwacjaSluzbowaPanel.add(dodajPlatnoscButton);
		rezerwacjaSluzbowaPanel.add(zapiszButton);

		// Panel "Adres zamieszkania"
		JPanel adresZamieszkaniaPanel = new JPanel();
		adresZamieszkaniaPanel.setBounds(20, 400, 830, 150);
		adresZamieszkaniaPanel.setBackground(tloKolor);
		adresZamieszkaniaPanel.setBorder(BorderFactory.createTitledBorder("Adres zamieszkania"));
		adresZamieszkaniaPanel.setLayout(null);

		JLabel ulicaLabel = new JLabel("Ulica:");
		ulicaLabel.setBounds(20, 30, 120, 25);
		JTextField ulicaField = new JTextField();
		ulicaField.setBounds(160, 30, 200, 25);

		JLabel numerDomuLabel = new JLabel("Numer domu:");
		numerDomuLabel.setBounds(20, 70, 120, 25);
		JTextField numerDomuField = new JTextField();
		numerDomuField.setBounds(160, 70, 200, 25);

		JLabel numerMieszkaniaLabel = new JLabel("Numer mieszkania:");
		numerMieszkaniaLabel.setBounds(400, 30, 150, 25);
		JTextField numerMieszkaniaField = new JTextField();
		numerMieszkaniaField.setBounds(550, 30, 200, 25);

		JLabel miejscowoscLabel = new JLabel("Miejscowość:");
		miejscowoscLabel.setBounds(400, 70, 120, 25);
		JTextField miejscowoscField = new JTextField();
		miejscowoscField.setBounds(550, 70, 200, 25);

		JLabel kodPocztowyLabel = new JLabel("Kod pocztowy:");
		kodPocztowyLabel.setBounds(20, 110, 120, 25);
		JTextField kodPocztowyField = new JTextField();
		kodPocztowyField.setBounds(160, 110, 200, 25);

		JLabel krajLabel = new JLabel("Kraj:");
		krajLabel.setBounds(400, 110, 120, 25);
		JTextField krajField = new JTextField();
		krajField.setBounds(550, 110, 200, 25);

		adresZamieszkaniaPanel.add(ulicaLabel);
		adresZamieszkaniaPanel.add(ulicaField);
		adresZamieszkaniaPanel.add(numerDomuLabel);
		adresZamieszkaniaPanel.add(numerDomuField);
		adresZamieszkaniaPanel.add(numerMieszkaniaLabel);
		adresZamieszkaniaPanel.add(numerMieszkaniaField);
		adresZamieszkaniaPanel.add(miejscowoscLabel);
		adresZamieszkaniaPanel.add(miejscowoscField);
		adresZamieszkaniaPanel.add(kodPocztowyLabel);
		adresZamieszkaniaPanel.add(kodPocztowyField);
		adresZamieszkaniaPanel.add(krajLabel);
		adresZamieszkaniaPanel.add(krajField);

		// Dodanie paneli do ramki
		frame.add(daneRezerwacjiPanel);
		frame.add(rezerwacjaSluzbowaPanel);
		frame.add(adresZamieszkaniaPanel);



		if (isEditMode && selectedReservation != null) {
			// Wypełnienie pól tekstowych danymi wybranej rezerwacji
			imieNazwiskoField.setText(selectedReservation.getGosc().getImieNazwisko());
			numerTelefonuField.setText(selectedReservation.getGosc().getNumerTelefonu());
			adresEmailField.setText(selectedReservation.getGosc().getAdresEmail());
			iloscDoroslychField.setText(String.valueOf(selectedReservation.getIloscDoroslych()));
			iloscDzieciField.setText(String.valueOf(selectedReservation.getIloscDzieci()));
			godzinaPrzyjazduField.setText(selectedReservation.getGodzinaPrzyjazdu());
			specjalneZyczeniaField.setText(selectedReservation.getGosc().getSpecjalneZyczenia());
			czyDlaInnejOsobyCheckBox.setSelected(selectedReservation.getGosc().isCzyDlaKogos());

			//nazwaFirmyField.setText(selectedReservation);
			//numerVATField.setText(selectedReservation.getNumerVAT());
			//numerNIPField.setText(selectedReservation.getNumerNIP()); - TODO gosc prywatny bo nie dziala

			ulicaField.setText(selectedReservation.getGosc().getAdresZamieszkania().getUlica());
			numerDomuField.setText(selectedReservation.getGosc().getAdresZamieszkania().getNumerDomu());
			numerMieszkaniaField.setText(String.valueOf(selectedReservation.getGosc().getAdresZamieszkania().getNumerMieszkania()));
			miejscowoscField.setText(selectedReservation.getGosc().getAdresZamieszkania().getMiejscowosc());
			kodPocztowyField.setText(selectedReservation.getGosc().getAdresZamieszkania().getKodPocztowy());
			krajField.setText(selectedReservation.getGosc().getAdresZamieszkania().getKraj());

			wspollokatorzyButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					wyswietlWspollokatorzyButton(selectedReservation, true);
				}
			});
		}

		wspollokatorzyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				wyswietlWspollokatorzyButton(selectedReservation, false);
			}
		});

		dodajPlatnoscButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				wyswietlDodajPlatnoscButton();
			}
		});

		zapiszButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				// Pobranie danych z pól tekstowych
				String imieNazwisko = imieNazwiskoField.getText();
				String numerTelefonu = numerTelefonuField.getText();
				String adresEmail = adresEmailField.getText();
				int iloscDoroslych = Integer.parseInt(iloscDoroslychField.getText());
				int iloscDzieci = Integer.parseInt(iloscDzieciField.getText());
				String godzinaPrzyjazdu = godzinaPrzyjazduField.getText();
				String specjalneZyczenia = specjalneZyczeniaField.getText();
				boolean czyDlaInnejOsoby = czyDlaInnejOsobyCheckBox.isSelected();

				String nazwaFirmy = nazwaFirmyField.getText();
				int numerVat = 0;
				int numerNip = 0;

				// Pobranie adresu zamieszkania
				String ulica = ulicaField.getText();
				String numerDomu = numerDomuField.getText();
				int numerMieszkania = Integer.parseInt(numerMieszkaniaField.getText());
				String miejscowosc = miejscowoscField.getText();
				String kodPocztowy = kodPocztowyField.getText();
				String kraj = krajField.getText();

				// Utworzenie obiektu AdresZamieszkania
				AdresZamieszkania adresZamieszkania = new AdresZamieszkania(miejscowosc, ulica, numerDomu, numerMieszkania,kodPocztowy, kraj);

				// Utworzenie obiektu Gosc
				Gosc gosc;
				if (nazwaFirmy != null) {
					gosc = new GoscSluzbowy(nazwaFirmy, numerVat, numerNip, imieNazwisko, numerTelefonu, adresEmail, czyDlaInnejOsoby, specjalneZyczenia, adresZamieszkania);
				} else {
					gosc = new GoscPrywatny(imieNazwisko, numerTelefonu, adresEmail, czyDlaInnejOsoby, specjalneZyczenia, adresZamieszkania);
				}

				// Utworzenie obiektu Termin
				String dataRozpoczecia = null;
				String dataZakonczenia = null;
				Termin nowyTermin = new Termin(dataRozpoczecia, dataZakonczenia);

				// Utworzenie obiektu Rezerwacja
				Rezerwacja nowaRezerwacja = new Rezerwacja(iloscDoroslych, iloscDzieci, null, godzinaPrzyjazdu, gosc, null, nowyTermin); //TODO na pierwszym null jest platnosc a na drugim jest pokoj

				// Zapisanie nowej rezerwacji do pliku/ bazy danych lub JSON
				zapiszDaneDoJson(nowaRezerwacja);
			}
		});



		// Wyświetlenie okna
		frame.setVisible(true);
	}

	private void zapiszDaneDoJson(Rezerwacja rezerwacja) {
		try {
			List<Rezerwacja> rezerwacjaList = hotel.getRezerwacje();
			rezerwacjaList.add(rezerwacja);
			hotel.setRezerwacje(rezerwacjaList);
			JOptionPane.showMessageDialog(null, "Rezerwacja zapisana pomyślnie.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void wyswietlDodajPlatnoscButton() {
		// Tworzenie głównego okna
		JFrame frame = new JFrame("Dodaj płatność");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(400, 250); // Rozmiar okna
		frame.setLayout(null);

		// Kolor tła
		Color tloKolor = new Color(255, 182, 156); // Kolor odpowiadający obrazkowi
		frame.getContentPane().setBackground(tloKolor);

		// Etykieta "Kwota do zapłacenia"
		JLabel kwotaLabel = new JLabel("Kwota do zapłacenia: [kwota opłacona / całość]");
		kwotaLabel.setBounds(20, 20, 350, 25); // Pozycjonowanie
		kwotaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		kwotaLabel.setFont(new Font("Arial", Font.BOLD, 14));
		frame.add(kwotaLabel);

		// Etykieta "Kwota wpłacona"
		JLabel kwotaWplaconaLabel = new JLabel("Kwota wpłacona:");
		kwotaWplaconaLabel.setBounds(50, 70, 120, 25);
		frame.add(kwotaWplaconaLabel);

		// Pole tekstowe do wpisania kwoty
		JTextField kwotaField = new JTextField();
		kwotaField.setBounds(50, 100, 120, 25);
		frame.add(kwotaField);

		// Etykieta "Forma"
		JLabel formaLabel = new JLabel("Forma:");
		formaLabel.setBounds(220, 70, 120, 25);
		frame.add(formaLabel);

		// Lista rozwijana dla formy płatności
		JComboBox<String> formaComboBox = new JComboBox<>();
		formaComboBox.setBounds(220, 100, 120, 25);
		frame.add(formaComboBox);

		// Dodawanie opcji z enumeracji FormaPlatnosci
		for (FormaPlatnosci forma : FormaPlatnosci.values()) {
			formaComboBox.addItem(forma.name());
		}

		// Przycisk "Zapisz"
		JButton zapiszButton = new JButton("Zapisz");
		zapiszButton.setBounds(150, 160, 100, 30);
		frame.add(zapiszButton);

		// Wyświetlenie okna
		frame.setVisible(true);
	}

	public void wyswietlWspollokatorzyButton(Rezerwacja selectedReservation, boolean isEditMode) {
		// Tworzenie głównego okna
		JFrame frame = new JFrame("Współlokatorzy");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(600, 400); // Rozszerzone okno
		frame.setLayout(null);

		// Kolor tła
		Color tloKolor = new Color(255, 182, 156); // Odpowiada kolorowi na zdjęciu
		frame.getContentPane().setBackground(tloKolor);

		// Etykieta tytułowa
		JLabel tytulLabel = new JLabel("Edytuj współlokatorów:");
		tytulLabel.setBounds(200, 10, 220, 25); // Pozycjonowanie
		tytulLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tytulLabel.setFont(new Font("Arial", Font.BOLD, 18));
		frame.add(tytulLabel);

		// Etykieta "Imię i nazwisko" nad polem tekstowym
		JLabel imieNazwiskoLabel = new JLabel("Imię i nazwisko:");
		imieNazwiskoLabel.setBounds(100, 50, 200, 25);
		frame.add(imieNazwiskoLabel);

		JTextField imieNazwiskoField = new JTextField();
		imieNazwiskoField.setBounds(50, 80, 200, 25);
		frame.add(imieNazwiskoField);

		// Etykieta "Adres Email" nad polem tekstowym
		JLabel adresEmailLabel = new JLabel("Adres Email:");
		adresEmailLabel.setBounds(350, 50, 200, 25);
		frame.add(adresEmailLabel);

		JTextField adresEmailField = new JTextField();
		adresEmailField.setBounds(300, 80, 200, 25);
		frame.add(adresEmailField);

		// Pole tekstowe do wyświetlania listy współlokatorów
		JTextArea listaWspollokatorow = new JTextArea();
		listaWspollokatorow.setBounds(50, 130, 480, 150); // Większe pole tekstowe
		listaWspollokatorow.setEditable(false);
		frame.add(listaWspollokatorow);

		// Przycisk "Dodaj"
		JButton dodajButton = new JButton("Dodaj");
		dodajButton.setBounds(150, 310, 120, 30);
		frame.add(dodajButton);

		// Przycisk "Usuń"
		JButton usunButton = new JButton("Usuń");
		usunButton.setBounds(320, 310, 120, 30);
		frame.add(usunButton);

		if (isEditMode) {
			if (selectedReservation.getGosc().getWspollokatorzy() != null && !selectedReservation.getGosc().getWspollokatorzy().isEmpty()) {
				StringBuilder szczegoly = new StringBuilder();
				for (Gosc wspollokator : selectedReservation.getGosc().getWspollokatorzy()) {
					szczegoly.append("Imię i nazwisko: ").append(wspollokator.getImieNazwisko()).append("\n");
					szczegoly.append("Adres e-mail: ").append(wspollokator.getAdresEmail()).append("\n");
				}
				listaWspollokatorow.setText(szczegoly.toString());
			} else {
				listaWspollokatorow.setText("Brak współlokatorów.");
			}
		}

		// Wyświetlenie okna
		frame.setVisible(true);
	}

}