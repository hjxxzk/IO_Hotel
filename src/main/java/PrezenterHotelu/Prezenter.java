package PrezenterHotelu;

import ModelHotelu.Pokoj;
import ModelHotelu.Termin;
import ViewHotelu.IMenuView;
import ViewHotelu.RecepcjonistkaMenuView;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Prezenter {

	public static void main(String[] args) {
		setMenu();
		//IMenuView menuRecepcjonistki = new RecepcjonistkaMenuView();
		//menuRecepcjonistki.wyswietl();

	}


	public static void setMenu() {
		File plikJSON = new File("---sciezka-do-pliku---");

		// Inicjalizacja ObjectMapper (do parsowania JSON)
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			// Zmienia zawartość pliku JSON na List<Pokoj>
			List<Pokoj> pokoje = objectMapper.readValue(plikJSON, new TypeReference<List<Pokoj>>(){});

			// Iterowanie po pokoju i wyświetlanie danych
			for (Pokoj pokoj : pokoje) {
				System.out.println("Numer pokoju: " + pokoj.getNumer());
				System.out.println("Pietro: " + pokoj.getPietro());
				System.out.println("Liczba gosci: " + pokoj.getLiczbaGosci());
				System.out.println("Standard: " + pokoj.getStandard());
				System.out.println("Udogodnienia: " + pokoj.getUdogodnienia());
				System.out.println("Koszt: " + pokoj.getKoszt());
				System.out.println("Terminy:");
				for (Termin termin : pokoj.getTerminy()) {
					System.out.println("Od: " + termin.getData_rozpoczecia_pobytu() + " Do: " + termin.getData_zakonczenia_pobytu());
				}
				System.out.println("-----------------------");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}