package menu;

import java.io.IOException;
import game.InputChecker;
import game.Saldo;

public class GameTypeMenu implements MenuStatus {

	/**
	 * DP State: ConcreteState
	 */
	public int ncav;

	GameTypeMenu(int selection) {
		ncav = selection;
	}

	public void print() throws IOException {
		System.out.println("Saldo:" + Saldo.getInstanceSaldo().getSaldo() + "€");
		System.out.println("Seleziona il tipo di giocata:");
		System.out.println("1] puntata sulla prima posizione (vincita: puntataX3)");
		System.out.println("2] puntata sul podio dei primi tre (vincita: puntataX2)");
		System.out.print("\n");
		System.out.println("0] annulla giocata");
	}

	public MenuStatus changeStatus() throws IOException {
		int selection;
		selection = InputChecker.numberInput();
		if (selection < 0 || selection > 2) {
			System.out.println("Scelta non valida.");
			return this;
		}
		if (selection == 0)
			return back();
		else
			return coreGame(ncav, selection);
	}

	public MenuStatus next() {
		return this;
	};

	public MenuStatus back() {
		return new MainMenu();
	};

	public MenuStatus coreGame(int ncav, int gtype) {
		return new FinalSelectionMenu(ncav, gtype);
	}

}