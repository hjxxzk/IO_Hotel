package PrezenterHotelu;

import java.util.HashMap;

public class Logowanie {

    private final HashMap<String, String> recepcjonistki;
    private final HashMap<String, RecepcjonistkaSingleton> recepcjonistkiDane;
    private RecepcjonistkaSingleton obecnieZalogowanaRecepjonistka;

    public Logowanie() {
        recepcjonistki = new HashMap<>();
        recepcjonistkiDane = new HashMap<>();

        recepcjonistki.put("Malgosia", "hasloMalgosia");
        recepcjonistki.put("Kuba", "hasloKuba");
        recepcjonistki.put("Aneta", "hasloAneta");
        recepcjonistki.put("Sylwia", "hasloSylwia");
        recepcjonistki.put("Kasia", "hasloKasia");

        recepcjonistkiDane.put("Malgosia", new RecepcjonistkaSingleton("Malgosia", "Kowalska", 1));
        recepcjonistkiDane.put("Kuba", new RecepcjonistkaSingleton("Kuba", "Nowak", 2));
        recepcjonistkiDane.put("Aneta", new RecepcjonistkaSingleton("Aneta", "Wiśniewska", 3));
        recepcjonistkiDane.put("Sylwia", new RecepcjonistkaSingleton("Sylwia", "Wójcik", 4));
        recepcjonistkiDane.put("Kasia", new RecepcjonistkaSingleton("Kasia", "Zielińska", 5));
    }

    public boolean checkCredentials(String username, String password) {
        if (recepcjonistki.containsKey(username)) {
            String storedPassword = recepcjonistki.get(username);
            if (storedPassword.equals(password)) {
                obecnieZalogowanaRecepjonistka = recepcjonistkiDane.get(username);
                return true;
            }
        }
        return false;
    }

    public RecepcjonistkaSingleton getObecnieZalogowanaRecepcjonistka() {
        return obecnieZalogowanaRecepjonistka;
    }
}