package ModelHotelu;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.event.ListDataEvent;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HotelFasadaTest {
    HotelFasada hotel;
    @BeforeEach
    void getData() {
        hotel = new HotelFasada();
        File plikPokojeJSON = new File("/Users/maks_rz/Desktop/Studia/Semestr 5/Inżynieria oprogramowania/HotelProject/src/main/resources/pokoje.json");
        File rezerwacjePokojeJSON = new File("/Users/maks_rz/Desktop/Studia/Semestr 5/Inżynieria oprogramowania/HotelProject/src/main/resources/rezerwacje.json");
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            List<Pokoj> pokoje = objectMapper.readValue(plikPokojeJSON, new TypeReference<List<Pokoj>>(){});
            List<Rezerwacja> rezerwacje = objectMapper.readValue(rezerwacjePokojeJSON, new TypeReference<List<Rezerwacja>>() {});

            hotel.setPokoje(pokoje);
            hotel.setRezerwacje(rezerwacje);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @org.junit.jupiter.api.Test
    void makeReservation() {
        List<Pokoj> pokoje = hotel.getPokoje();
        List<Rezerwacja> rezerwacje = hotel.getRezerwacje();
        Termin termin = new Termin("2025-01-19", "2025-01-22");
        Rezerwacja nowaRezerwacja = new Rezerwacja(2, 0, null, "12:00", null, pokoje.get(1), termin);
        if(hotel.checkInput(nowaRezerwacja, pokoje.get(1)))	{
            rezerwacje.add(nowaRezerwacja);
            for (Pokoj pokojZListy : pokoje) {
                if (pokojZListy.equals(pokoje.get(1))) {
                    pokojZListy.addReservationDate(termin);
                    break;
                }
            }
        }
        assertTrue(rezerwacje.contains(nowaRezerwacja));
    }

    @Test
    void shouldDeleteReservation() {
        List<Rezerwacja> rezerwacje = hotel.getRezerwacje();
        String numer_rezerwacji = "1";
        for (Rezerwacja rezerwacja : rezerwacje) {
            if (rezerwacja.getNumerRezerwacji().equals(numer_rezerwacji)) {
                rezerwacje.remove(rezerwacja);
                break;
            }
        }
        for (Rezerwacja rezerwacja : rezerwacje) {
            assertFalse(rezerwacja.getNumerRezerwacji().equals(numer_rezerwacji));
        }

    }

    void shouldReturnAvailableRoomsForSpecificDate() {

    }

    void shouldReturnTrueIfTerminIsFree() {

    }
}