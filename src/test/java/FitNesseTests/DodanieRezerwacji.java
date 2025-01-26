package FitNesseTests;

import ModelHotelu.HotelFasada;
import ModelHotelu.Pokoj;
import ModelHotelu.Termin;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fit.ColumnFixture;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class DodanieRezerwacji extends ColumnFixture {

    public static HotelFasada hotel;
    public String dane[];

    public boolean dodajRezerwacje() {
        hotel = new HotelFasada();
        File plikPokojeJSON = new File("C:\\Users\\agnie\\Documents\\Moje_pliki\\Studia\\V_SEM\\Inżynieria_oprogramowania\\IOI_kod\\src\\main\\resources\\pokoje.json");
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            List<Pokoj> pokoje = objectMapper.readValue(plikPokojeJSON, new TypeReference<List<Pokoj>>() {});
            hotel.setPokoje(pokoje);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Termin termin = new Termin(dane[2], dane[3]);

        Pokoj pokoj = hotel.getPokoje().stream()
                .filter(p -> Objects.equals(p.getNumer(), dane[4]))
                .findFirst()
                .orElse(null);


        int s1 = liczbaRezerwacji();
        hotel.makeReservation(Integer.parseInt(dane[0]), Integer.parseInt(dane[1]), null, null, null, pokoj, termin);

        int s2 = liczbaRezerwacji();
        return s2 > s1;
    }

    public int liczbaRezerwacji() {
        return hotel.getRezerwacje().size();
    }

}
