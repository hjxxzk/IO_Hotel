package PrezenterHotelu;

import InterfejsHotelu.IHotel;
import ModelHotelu.HotelFasada;
import ModelHotelu.Pokoj;
import ModelHotelu.Rezerwacja;
import ModelHotelu.Termin;
import ViewHotelu.IMenuView;
import ViewHotelu.RecepcjonistkaMenuView;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Prezenter {

	static HotelFasada hotel;

	public static void main(String[] args) {
		hotel = new HotelFasada();
		setMenu();
		IMenuView menuRecepcjonistki = new RecepcjonistkaMenuView(hotel);
		menuRecepcjonistki.wyswietl();
	}
	public static void setMenu() {
		File plikPokojeJSON = new File("/Users/maks_rz/Desktop/Studia/Semestr 5/Inżynieria oprogramowania/HotelProject/src/main/resources/pokoje.json");
		File rezerwacjePokojeJSON = new File("/Users/maks_rz/Desktop/Studia/Semestr 5/Inżynieria oprogramowania/HotelProject/src/main/resources/rezerwacje.json");
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			List<Pokoj> pokoje = objectMapper.readValue(plikPokojeJSON, new TypeReference<List<Pokoj>>(){});
			List<Rezerwacja> rezerwacje = objectMapper.readValue(rezerwacjePokojeJSON, new TypeReference<List<Rezerwacja>>() {});

			hotel.setPokoje(pokoje);
			hotel.setRezerwacja(rezerwacje);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}