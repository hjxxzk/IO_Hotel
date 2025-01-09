package ModelHotelu;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RezerwacjaTest {
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

    @Test
    void shouldGenerateReservationNumberWithCurrentDate() {
        Rezerwacja rezerwacja = new Rezerwacja(2, 0, null, "12:40", null, null, null);
        String dataNumeruRezerwacji = rezerwacja.getNumerRezerwacji().substring(0, 10);
        String numerRezerwacji = rezerwacja.getNumerRezerwacji().substring(12, 16);
        assertEquals(rezerwacja.getCurrentDate(), dataNumeruRezerwacji);
        assertTrue(Integer.parseInt(numerRezerwacji) > 0);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "5, 2, null, 12:34, null, null, null",
            "3, 7, null, 10:11, null, null, null",
            "1, 0, null, 15:52, null, null, null"
    }, nullValues = {"null"})
    void shouldGenerateReservationNumberWithCurrentDateForDifferentReservations(int iloscDoroslych, int iloscDzieci, Platnosc platnosc, String godzinaPrzyjazdu, Gosc gosc, Pokoj pokoj, Termin termin) {
        Rezerwacja rezerwacja = new Rezerwacja(iloscDoroslych, iloscDzieci, platnosc, godzinaPrzyjazdu, gosc, pokoj, termin);
        String dataNumeruRezerwacji = rezerwacja.getNumerRezerwacji().substring(0, 10);
        String numerRezerwacji = rezerwacja.getNumerRezerwacji().substring(12, 16);
        assertEquals(rezerwacja.getCurrentDate(), dataNumeruRezerwacji);
        assertTrue(Integer.parseInt(numerRezerwacji) > 0);
    }

    @Test
    void checkIn() {

    }
}