package ViewHotelu;

import ModelHotelu.HotelFasada;
import ModelHotelu.Pokoj;
import ModelHotelu.Rezerwacja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Pattern;


public class PokojView implements IPokojeView {

	List<Pokoj> dostepnePokoje;

	public void pokojView(HotelFasada hotel, RezerwacjaView rezerwacjaView) {
		JFrame frame = new JFrame("Wybierz termin");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(700, 400);
		frame.setLocationRelativeTo(null);
		// Panel główny
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 182, 156));

		// Etykiety i pola wyboru
		JLabel arrivalLabel = new JLabel("Data przyjazdu:");
		arrivalLabel.setBounds(50, 30, 120, 25);
		panel.add(arrivalLabel);

		JTextField arrivalDate = new JTextField();
		arrivalDate.setBounds(160, 30, 120, 25);
		panel.add(arrivalDate);

		JLabel departureLabel = new JLabel("Data wyjazdu:");
		departureLabel.setBounds(300, 30, 120, 25);
		panel.add(departureLabel);

		JTextField departureDate = new JTextField();
		departureDate.setBounds(410, 30, 120, 25);
		panel.add(departureDate);

		JLabel adultsLabel = new JLabel("Ilość dorosłych:");
		adultsLabel.setBounds(50, 70, 120, 25);
		panel.add(adultsLabel);

		JTextField adultsField = new JTextField();
		adultsField.setBounds(160, 70, 120, 25);
		panel.add(adultsField);

		JLabel childrenLabel = new JLabel("Ilość dzieci:");
		childrenLabel.setBounds(300, 70, 120, 25);
		panel.add(childrenLabel);

		JTextField childrenField = new JTextField();
		childrenField.setBounds(410, 70, 120, 25);
		panel.add(childrenField);

		// Przycisk szukania
		JButton searchButton = new JButton("Szukaj pokoi");
		searchButton.setBounds(270, 110, 150, 30);
		panel.add(searchButton);

		// Etykieta listy pokoi
		JLabel roomsLabel = new JLabel("Lista dostępnych pokoi:");
		roomsLabel.setBounds(50, 160, 200, 25);
		roomsLabel.setFont(new Font("Arial", Font.BOLD, 16));
		panel.add(roomsLabel);

		// Lista pokoi
		JList<String> roomList = new JList<>(new String[]{});
		JScrollPane roomScrollPane = new JScrollPane(roomList);
		roomScrollPane.setBounds(50, 200, 600, 100);
		panel.add(roomScrollPane);

		// Przycisk wyboru
		JButton chooseButton = new JButton("Wybierz");
		chooseButton.setBounds(300, 320, 100, 30);
		panel.add(chooseButton);
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				String adults = adultsField.getText().trim();
				String children = childrenField.getText().trim();
				String arrival = arrivalDate.getText().trim();
				String departure = departureDate.getText().trim();

				String datePattern = "^(\\d{4})-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$";

				if (adults.isEmpty() || children.isEmpty() || arrival.isEmpty() || departure.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Proszę uzupełnić wszystkie pola!", "Błąd", JOptionPane.WARNING_MESSAGE);
				} else if (!Pattern.matches(datePattern, arrival) || !Pattern.matches(datePattern, departure)) {
					JOptionPane.showMessageDialog(frame, "Proszę podać datę w formacie YYYY-MM-DD!", "Błąd", JOptionPane.WARNING_MESSAGE);
				}	else {
					dostepnePokoje = hotel.listaDostepnychPokoi(arrival, departure, Integer.parseInt(children), Integer.parseInt(adults));
					// Aktualizuj JList
					roomList.setListData(dostepnePokoje.stream()
							.map(PokojView.this::showRoomsToString)
							.toArray(String[]::new));
				}
            }
		});

		chooseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				int selectedIndex = roomList.getSelectedIndex();
				if (selectedIndex != -1) {
					hotel.setPokojDoZarezerwowania(dostepnePokoje.get(selectedIndex));
					frame.dispose();
					rezerwacjaView.zapisDanychRezerwacjiView(null, false);
				} else {
					JOptionPane.showMessageDialog(frame, "Proszę wybrać pokój z listy.", "Błąd", JOptionPane.ERROR_MESSAGE);
				}
            }
		});

		// Dodanie panelu do ramki
		frame.add(panel);
		frame.setVisible(true);
	}

	public String showRoomsToString(Pokoj pokoj)	{
		return "Pokoj nr " + pokoj.getNumer() +
				" | Piętro: " + pokoj.getPietro() +
				" | Standard: " + pokoj.getStandard() +
				" | Udogodnienia: " + pokoj.getUdogodnienia() +
				" | Koszt: " + pokoj.getKoszt() +
				" | Liczba Gości: " + pokoj.getLiczbaGosci();
	}

}