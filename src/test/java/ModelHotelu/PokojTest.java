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
class PokojTest {
    HotelFasada hotel;
    @BeforeEach
    void getData()  {
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
    void shouldReturn750ForRoom101_whenGuestStaysFor3Days() {
        List<Pokoj> pokoje = hotel.getPokoje();
        String dataRozpoczecia = "2025-01-07";
        String dataZakonczenia = "2025-01-10";
        String wybranyPokoj = "101";
        int expectedPrice = 750;
        for (Pokoj pokoj : pokoje) {
            if (pokoj.getNumer().equals(wybranyPokoj)) {
                float endPrice = pokoj.calculateCost(dataRozpoczecia, dataZakonczenia);
                assertEquals(expectedPrice, endPrice);
            }
        }
    }

    @ParameterizedTest
    @CsvSource({
            "101, 2025-01-07, 2025-01-10, 750",
            "102, 2025-02-01, 2025-02-05, 600",
            "103, 2025-03-10, 2025-03-15, 1250"
    })
    void shouldReturnExpectedPriceForRoom_whenGuestStaysForSpecificDays(String wybranyPokoj, String dataRozpoczecia, String dataZakonczenia, int expectedPrice) {
        List<Pokoj> pokoje = hotel.getPokoje();
        for (Pokoj pokoj : pokoje) {
            if (pokoj.getNumer().equals(wybranyPokoj)) {
                float endPrice = pokoj.calculateCost(dataRozpoczecia, dataZakonczenia);
                assertEquals(expectedPrice, endPrice);
            }
        }
    }

    @Test
    void shouldAddGivenReservationDate() {
        String wybranyPokoj = "101";
        String dataRozpoczecia = "2025-01-14";
        String dataZakonczenia = "2025-01-15";
        Termin termin = new Termin(dataRozpoczecia, dataZakonczenia);
        List<Pokoj> pokoje = hotel.getPokoje();
        for (Pokoj pokoj : pokoje) {
            if (pokoj.getNumer().equals(wybranyPokoj)) {
                pokoj.addReservationDate(termin);
                List<Termin> listaTerminowDlaPokoju = pokoj.getTerminy();
                assertTrue(listaTerminowDlaPokoju.contains(termin));
            }
        }
    }


}