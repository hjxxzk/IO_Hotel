package ModelHotelu;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;

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
        Termin termin = new Termin("2025-01-11", "2025-01-13");
        Rezerwacja nowaRezerwacja = new Rezerwacja(2, 0, null, "12:00", null, pokoje.get(1), termin);
        System.out.println(pokoje.get(1).getTerminy());
        System.out.println(hotel.czyIloscMiejscSieZgadza(nowaRezerwacja, pokoje.get(1)));
        for (Termin t : pokoje.get(1).getTerminy()) {
            System.out.println(t);
        }
        System.out.println(hotel.czyTerminJestWolny(nowaRezerwacja.getTermin().getData_rozpoczecia_pobytu(), nowaRezerwacja.getTermin().getData_zakonczenia_pobytu(), pokoje.get(1)));
        //System.out.println(nowaRezerwacja.getTermin().getData_rozpoczecia_pobytu() + " " + nowaRezerwacja.getTermin().getData_zakonczenia_pobytu());
        if(hotel.checkInput(nowaRezerwacja, pokoje.get(1)))	{
            rezerwacje.add(nowaRezerwacja);
            for (Pokoj pokojZListy : pokoje) {
                if (pokojZListy.equals(pokoje.get(1))) {
                    pokojZListy.addReservationDate(termin);
                    break;
                }
            }
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate nowyStart = LocalDate.parse("2025-01-11", formatter);
        LocalDate nowyEnd = LocalDate.parse("2025-01-13", formatter);

        for (Termin t : pokoje.get(1).getTerminy()) {
            LocalDate start = LocalDate.parse(t.getData_rozpoczecia_pobytu(), formatter);
            LocalDate end = LocalDate.parse(t.getData_zakonczenia_pobytu(), formatter);

            if ((nowyStart.isBefore(end) && nowyEnd.isAfter(start)) ||
                    (nowyStart.isEqual(start) || nowyEnd.isEqual(end))) {
            }
        }
        assertTrue(rezerwacje.contains(nowaRezerwacja));
    }

    void shouldDeleteReservation() {

    }

    void shouldReturnAvailableRoomsForSpecificDate() {

    }

    void shouldReturnTrueIfTerminIsFree() {

    }
}