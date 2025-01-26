package ModelHotelu;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(CustomExceptionHandler.class)
class HotelFasadaTest {
    HotelFasada hotel;
    @BeforeEach
    void getData() {
        hotel = new HotelFasada();
       // File plikPokojeJSON = new File("/Users/maks_rz/Desktop/Studia/Semestr 5/Inżynieria oprogramowania/HotelProject/src/main/resources/pokoje.json");
      //  File rezerwacjePokojeJSON = new File("/Users/maks_rz/Desktop/Studia/Semestr 5/Inżynieria oprogramowania/HotelProject/src/main/resources/rezerwacje.json");

        File plikPokojeJSON = new File("C:\\Users\\agnie\\Documents\\Moje_pliki\\Studia\\V_SEM\\Inżynieria_oprogramowania\\IOI_kod\\src\\main\\resources\\pokoje.json");
        File rezerwacjePokojeJSON = new File("C:\\Users\\agnie\\Documents\\Moje_pliki\\Studia\\V_SEM\\Inżynieria_oprogramowania\\IOI_kod\\src\\main\\resources\\rezerwacje.json");

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
    @Order(1)
    @Tag("reservation")
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

    @org.junit.jupiter.api.Test
    @Order(5)
    @Tag("reservation")
    void shouldNotMakeReservation_whenGivenDateIsIncorrect() {
        List<Pokoj> pokoje = hotel.getPokoje();
        List<Rezerwacja> rezerwacje = hotel.getRezerwacje();
        assertThrows(IllegalArgumentException.class, () -> {
            Termin termin = new Termin("2025-01-23", "2025-01-22");
        });
    }

    @Test
    @Order(2)
    @Tag("reservation")
    void shouldDeleteReservation() {
        try {
            List<Rezerwacja> rezerwacje = hotel.getRezerwacje();
            String numer_rezerwacji = "1";

            for (Rezerwacja rezerwacja : rezerwacje) {
                if (rezerwacja.getNumerRezerwacji().equals(numer_rezerwacji)) {
                    rezerwacje.remove(rezerwacja);
                    break;
                }
            }
            for (Rezerwacja rezerwacja : rezerwacje) {
                assertNotEquals(rezerwacja.getNumerRezerwacji(), numer_rezerwacji, "Rezerwacja o numerze " + numer_rezerwacji + " powinna zostać usunięta.");
            }
        } catch (Exception e) {
            System.err.println("Wystąpił wyjątek w teście: " + e.getMessage());
            e.printStackTrace();
            fail("Test zakończył się niepowodzeniem z powodu wyjątku: " + e.getMessage());
        }
    }

    @ParameterizedTest
    @CsvSource({
            "1",
            "2",
            "3"
    })
    @Order(3)
    @Tag("reservation")
    void shouldDeleteReservation(String numerRezerwacji) {
        List<Rezerwacja> rezerwacje = hotel.getRezerwacje();
        rezerwacje.removeIf(rezerwacja -> rezerwacja.getNumerRezerwacji().equals(numerRezerwacji));
        for (Rezerwacja rezerwacja : rezerwacje) {
            assertNotEquals(rezerwacja.getNumerRezerwacji(), numerRezerwacji);
        }
    }

    @ParameterizedTest
    @MethodSource("provideReservationNumbers")
    @Order(4)
    @Tag("reservation")
    void shouldCheckInGuests(String numerRezerwacji) {
        hotel.checkInGuests(numerRezerwacji);
        for (Rezerwacja rezerwacja : hotel.getRezerwacje()) {
            if (rezerwacja.getNumerRezerwacji().equals(numerRezerwacji)) {
                assertTrue(rezerwacja.isZameldowanie(), "Rezerwacja powinna być zameldowana.");
            }
        }
    }

    static Stream<String> provideReservationNumbers() {
        return Stream.of("1", "2", "3");
    }
}