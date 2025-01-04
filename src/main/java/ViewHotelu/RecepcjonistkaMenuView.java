package ViewHotelu;

import ModelHotelu.HotelFasada;
import ModelHotelu.Rezerwacja;
import PrezenterHotelu.Logowanie;
import PrezenterHotelu.RecepcjonistkaSingleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

public class RecepcjonistkaMenuView implements IMenuView {

	Logowanie logowanie = new Logowanie();
	HotelFasada hotel;

	public RecepcjonistkaMenuView(HotelFasada hotel) {
		this.hotel = hotel;
	}

	public void wyswietlCodziennychGosci() {
		// TODO - implement RecepcjonistkaMenuView.wyswietlCodziennychGosci
	}

	public void wyswietl() {
		JFrame frame = new JFrame("DEOnly Wonderland Hotel");
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Panel główny
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 182, 156)); // Pomarańczowe tło

		// Dodanie tytułu
		JLabel titleLabel = new JLabel("Miło cię widzieć!");
		titleLabel.setFont(new Font("Cursive", Font.BOLD, 20));
		titleLabel.setBounds(120, 20, 200, 30);
		panel.add(titleLabel);

		// Dodanie opisu
		JLabel loginLabel = new JLabel("Zaloguj się do systemu");
		loginLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		loginLabel.setBounds(130, 60, 150, 20);
		panel.add(loginLabel);

		// Pole do wpisania loginu
		JLabel userLabel = new JLabel("Login:");
		userLabel.setBounds(80, 100, 80, 25);
		panel.add(userLabel);

		JTextField userText = new JTextField();
		userText.setBounds(160, 100, 150, 25);
		panel.add(userText);

		// Pole do wpisania hasła
		JLabel passwordLabel = new JLabel("Hasło:");
		passwordLabel.setBounds(80, 140, 80, 25);
		panel.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField();
		passwordText.setBounds(160, 140, 150, 25);
		panel.add(passwordText);

		// Przycisk logowania
		JButton loginButton = new JButton("Zaloguj");
		loginButton.setBounds(150, 190, 100, 30);
		panel.add(loginButton);

		// Dodanie akcji dla przycisku
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = userText.getText();
				String password = new String(passwordText.getPassword());

				// Prosta weryfikacja
				if (logowanie.checkCredentials(username, password)) {
					JOptionPane.showMessageDialog(frame, "Logowanie udane!");
					frame.dispose();
					wyswietlMenuPoZalogowaniu();
				} else {
					JOptionPane.showMessageDialog(frame, "Błędny login lub hasło.", "Błąd", JOptionPane.ERROR_MESSAGE);
				}
            }
		});
		frame.add(panel);
		frame.setVisible(true);


	}

	@Override
	public void RecepcjonistkaMenuView() {

	}

	public void wyswietlMenuPoZalogowaniu() {
		// Główne okno
		JFrame frame = new JFrame(logowanie.getObecnieZalogowanaRecepcjonistka().getId() + " " +logowanie.getObecnieZalogowanaRecepcjonistka().getImie() + " " + logowanie.getObecnieZalogowanaRecepcjonistka().getNazwisko());
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Główny panel
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 182, 156)); // Pomarańczowe tło

		// Nagłówek
		JLabel greetingLabel = new JLabel("Miłego dnia " + logowanie.getObecnieZalogowanaRecepcjonistka().getImie() + "!");
		greetingLabel.setFont(new Font("Arial", Font.BOLD, 16));
		greetingLabel.setBounds(20, 10, 300, 30);
		panel.add(greetingLabel);

		// Przycisk "Wyloguj"
		JButton logoutButton = new JButton("Wyloguj");
		logoutButton.setBounds(700, 10, 80, 30);
		panel.add(logoutButton);

		// Sekcja "Lista rezerwacji"
		JLabel reservationLabel = new JLabel("Lista rezerwacji:");
		reservationLabel.setFont(new Font("Arial", Font.BOLD, 14));
		reservationLabel.setBounds(20, 60, 200, 20);
		panel.add(reservationLabel);


		List<Rezerwacja> rezerwacje = hotel.getRezerwacje();
		List<String> rezerwacjeAsString = rezerwacje.stream()
				.map(Object::toString) // Zastąp .toString() odpowiednią metodą
				.toList();

		JList<String> reservationList = new JList<>(rezerwacjeAsString.toArray(new String[0])); // TODO Pusta lista
		JScrollPane reservationScrollPane = new JScrollPane(reservationList);
		reservationScrollPane.setBounds(20, 90, 495, 300);
		panel.add(reservationScrollPane);

		// Sekcja "Nasi dzisiejsi goście"
		JLabel guestsLabel = new JLabel("Nasi dzisiejsi goście:");
		guestsLabel.setFont(new Font("Arial", Font.BOLD, 14));
		guestsLabel.setBounds(550, 60, 200, 20);
		panel.add(guestsLabel);

		JList<String> guestList = new JList<>(new String[]{}); // TODO Pusta lista
		JScrollPane guestScrollPane = new JScrollPane(guestList);
		guestScrollPane.setBounds(555, 90, 200, 300);
		panel.add(guestScrollPane);

		// Przyciski
		JButton addButton = new JButton("Dodaj");
		addButton.setBounds(15, 400, 100, 30);
		panel.add(addButton);

		JButton editButton = new JButton("Edytuj");
		editButton.setBounds(150, 400, 100, 30);
		panel.add(editButton);

		JButton deleteButton = new JButton("Usuń");
		deleteButton.setBounds(285, 400, 100, 30);
		panel.add(deleteButton);

		JButton expandButton = new JButton("Rozwiń");
		expandButton.setBounds(420, 400, 100, 30);
		panel.add(expandButton);

		JButton checkInButton = new JButton("Zamelduj");
		checkInButton.setBounds(545, 400, 100, 30);
		panel.add(checkInButton);

		JButton checkOutButton = new JButton("Wymelduj");
		checkOutButton.setBounds(660, 400, 100, 30);
		panel.add(checkOutButton);

		// Akcja przycisku "Wyloguj"
		logoutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pokazOkienkoWylogowania(logowanie.getObecnieZalogowanaRecepcjonistka().getImie());
				//JOptionPane.showMessageDialog(frame, "Wylogowano!");
				frame.dispose();
			}
		});

		// Dodanie panelu do ramki i wyświetlenie
		frame.add(panel);
		frame.setVisible(true);
	}

	public void pokazOkienkoWylogowania(String imieRecepcjonistki) {
		// Tworzenie nowego okna
		JFrame logoutFrame = new JFrame("Do widzenia!");
		logoutFrame.setSize(400, 200);
		logoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Panel
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 182, 156)); // Pomarańczowe tło

		// Wiadomość wylogowania
		JLabel messageLabel1 = new JLabel("Poprawnie wylogowano [" + imieRecepcjonistki + "]");
		messageLabel1.setFont(new Font("Arial", Font.BOLD, 14));
		messageLabel1.setBounds(80, 50, 300, 30);
		panel.add(messageLabel1);

		JLabel messageLabel2 = new JLabel("Dziękujemy za Twoją pracę!");
		messageLabel2.setFont(new Font("Arial", Font.PLAIN, 14));
		messageLabel2.setBounds(100, 90, 200, 30);
		panel.add(messageLabel2);

		// Dodanie panelu do ramki i wyświetlenie
		logoutFrame.add(panel);
		logoutFrame.setVisible(true);
	}


}