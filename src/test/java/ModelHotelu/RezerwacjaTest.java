package ModelHotelu;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import mockit.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RezerwacjaTest {
    HotelFasada hotel;
    @BeforeEach
    void getData() {
        hotel = new HotelFasada();
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

    @Tested
    private Rezerwacja rezerwacja;

    @Injectable
    private Platnosc platnosc;

    @Injectable
    private Gosc gosc;

    @Injectable
    private Pokoj pokoj;

    @Injectable
    private Termin termin;


    @Test
    @Order(1)
    @Tag("reservation")
    void shouldGenerateReservationNumberWithCurrentDate() {
        Rezerwacja rezerwacja = new Rezerwacja(2, 0, null, "12:40", null, null, null);
        String dataNumeruRezerwacji = rezerwacja.getNumerRezerwacji().substring(0, 15);
        String numerRezerwacji = rezerwacja.getNumerRezerwacji().substring(16, 21);
        assertEquals(rezerwacja.getCurrentDate(), dataNumeruRezerwacji);
        assertTrue(Integer.parseInt(numerRezerwacji) > 0);
    }

    static Stream<Arguments> dataForCreatingReservations() {
        return Stream.of(
                Arguments.of(5, 2, null, "12:34", null, null, null),
                Arguments.of(3, 7, null, "10:11", null, null, null),
                Arguments.of(1, 0, null, "15:52", null, null, null)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForCreatingReservations")
    @Order(3)
    @Tag("reservation")
    void shouldGenerateReservationNumberWithCurrentDateForDifferentReservations(int iloscDoroslych, int iloscDzieci, Platnosc platnosc, String godzinaPrzyjazdu, Gosc gosc, Pokoj pokoj, Termin termin) {
        Rezerwacja rezerwacja = new Rezerwacja(iloscDoroslych, iloscDzieci, platnosc, godzinaPrzyjazdu, gosc, pokoj, termin);
        String dataNumeruRezerwacji = rezerwacja.getNumerRezerwacji().substring(0, 15);
        String numerRezerwacji = rezerwacja.getNumerRezerwacji().substring(16, 21);
        assertEquals(rezerwacja.getCurrentDate(), dataNumeruRezerwacji);
        assertTrue(Integer.parseInt(numerRezerwacji) > 0);
    }

    @Test
    @Order(2)
    @Tag("reservation")
    void shouldCheckInGReservation() {
        List<Rezerwacja> rezerwacje = hotel.getRezerwacje();
        for (Rezerwacja rezerwacja : rezerwacje) {
            rezerwacja.checkIn();
            assertTrue(rezerwacja.isZameldowanie());
        }
    }

    @Test
    @Order(4)
    public void testEditTermin() {
        Termin termin = new Termin("2023-01-01", "2023-01-10");
        Rezerwacja rezerwacja = new Rezerwacja(2, 1, null, "15:00", null, null, termin);

        rezerwacja.editTermin("2023-05-01", "2023-05-10");

        assertEquals("2023-05-01", termin.getData_rozpoczecia_pobytu());
        assertEquals("2023-05-10", termin.getData_zakonczenia_pobytu());
    }

    @Test
    @Order(5)
    public void shouldGenerateDifferentReservationNumbers() {
        Termin termin = new Termin("2023-01-01", "2023-01-10");
        Rezerwacja rezerwacja = new Rezerwacja(2, 1, null, "15:00", null, null, termin);

        Termin terminDrugiejRezerwacji = new Termin("2023-01-01", "2023-01-10");
        Rezerwacja drugaRezerwacja = new Rezerwacja(2, 1, null, "15:00", null, null, termin);

        assertNotEquals(rezerwacja.getNumerRezerwacji(), drugaRezerwacja.getNumerRezerwacji());

        try {
            Thread.sleep(5000);

            Termin terminTrzeciejRezerwacji = new Termin("2023-01-01", "2023-01-10");
            Rezerwacja trzeciaRezerwacja = new Rezerwacja(2, 1, null, "15:00", null, null, termin);

            assertNotEquals(rezerwacja.getNumerRezerwacji(), trzeciaRezerwacja.getNumerRezerwacji());
            assertNotEquals(drugaRezerwacja.getNumerRezerwacji(), trzeciaRezerwacja.getNumerRezerwacji());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}