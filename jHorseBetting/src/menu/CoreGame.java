package menu;

import java.io.FileNotFoundException;
import java.io.IOException;
import game.*;

public class CoreGame implements MenuStatus {

	/**
	 * DP State: ConcreteState
	 */
	int ncav;
	int gType;
	double euros;
	boolean gameEsit;
	int nPos;
	Esito esitToRecord;

	CoreGame(int ncav, int gType, double euros) throws IOException {
		this.ncav = ncav;
		this.gType = gType;
		this.euros = euros;
		if (gType == 1)
			gameEsit = Core.getEsit1P(ncav);
		if (gType == 2)
			gameEsit = Core.getEsit3P(ncav);
		for (int i = 0; i < Core.gameEsit().size(); i++) {
			if (ncav == Core.gameEsit().get(i))
				nPos = i;
		}
		nPos++;
		esitToRecord = EsitCreator.getEsit(euros, getNomeCav(ncav), gType, gameEsit);
		esitToRecord.recordEsit();
	}

	public void print() throws IOException {
		System.out.println("Esito:");
		for (int i = 0; i < Cavalli.getCavalli().size(); i++) {
			System.out.println((i + 1) + ") " + Cavalli.getCavalli().get(Core.gameEsit().get(i) - 1));
		}
		if (gameEsit == true)
			win();
		else
			lost();
		System.out.print("\n");
		System.out.println("b] back");
	}

	public MenuStatus changeStatus() throws IOException {
		char selection;
		selection = InputChecker.checkInput();
		if (selection == 'b')
			return next();
		else {
			System.out.println("Input non valido.");
			return back();
		}

	}

	public MenuStatus next() {
		return new MainMenu();
	}

	public MenuStatus back() {
		return this;
	}

	private void updateSaldo() throws FileNotFoundException, IOException {
		Saldo.getInstanceSaldo().subSaldo(euros);
		if (gameEsit == false)
			return;
		else {
			double euroWin = 0;
			if (gType == 1)
				euroWin = euros * 3;
			if (gType == 2)
				euroWin = euros * 2;
			Saldo.getInstanceSaldo().addSaldo(euroWin);
		}
	}

	private void win() throws FileNotFoundException, IOException {
		System.out.println(
				"\nComplimenti, hai vinto! " + getNomeCav(ncav) + " si piazza alla posizione numero " + nPos + ".");
		updateSaldo();
		System.out.print("Sono stati aggiunti sul tuo saldo  ");
		if (gType == 1)
			System.out.print(euros * 3);
		if (gType == 2)
			System.out.print(euros * 2);
		System.out.print("€.\n");
	}

	private void lost() throws FileNotFoundException, IOException {
		System.out.println(
				"\nChe sfortuna, hai perso! " + getNomeCav(ncav) + " si piazza alla posizione numero " + nPos + ".");
		updateSaldo();
		System.out.println(euros + "€ sono stati detratti dal suo saldo.");
	}

	private String getNomeCav(int ncav) throws IOException {
		return Cavalli.getCavalli().get(ncav - 1);
	}
}