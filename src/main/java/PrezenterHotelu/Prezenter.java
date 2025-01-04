package PrezenterHotelu;

import ViewHotelu.IMenuView;
import ViewHotelu.RecepcjonistkaMenuView;

public class Prezenter {

	public static void main(String[] args) {
		IMenuView menuRecepcjonistki = new RecepcjonistkaMenuView();
		menuRecepcjonistki.wyswietl();

	}


	public void setMenu() {
		// TODO - implement Prezenter.setMenu
		throw new UnsupportedOperationException();
	}

}