package ViewHotelu;

import PrezenterHotelu.Logowanie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecepcjonistkaMenuView implements IMenuView {

	Logowanie logowanie = new Logowanie();

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
					RecepcjonistkaMenuView();
				} else {
					JOptionPane.showMessageDialog(frame, "Błędny login lub hasło.", "Błąd", JOptionPane.ERROR_MESSAGE);
				}
            }
		});
		frame.add(panel);
		frame.setVisible(true);


	}

	public void RecepcjonistkaMenuView() {
		// TODO - implement RecepcjonistkaMenuView.RecepcjonistkaMenuView
	}

}