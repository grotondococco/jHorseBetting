package menu;

import java.io.FileNotFoundException;
import java.io.IOException;

import game.Cavalli;
import game.InputChecker;
import game.Saldo;

public class GameMenu implements MenuStatus {
	/**
	 * DP State: ConcreteState
	 */

	int numCavalli = 0;

	public void print() throws IOException, FileNotFoundException {
		System.out.println("Saldo:" + Saldo.getInstanceSaldo().getSaldo() + "€");
		int i = 1;
		for (String s : Cavalli.getCavalli()) {
			System.out.println(i + "] " + s);
			i++;
		}
		numCavalli = Cavalli.num;
		System.out.println("\n0] torna al menu' principale.");
	};

	public MenuStatus changeStatus() throws IOException {
		int selection;
		selection = InputChecker.numberInput();
		if (selection < 0 || selection > numCavalli) {
			System.out.println("Scelta non valida.");
			return this;
		}
		if (selection == 0)
			return back();
		else {
			return coreGame(selection);
		}
	}

	public MenuStatus next() {
		return this;
	};

	public MenuStatus back() {
		return new MainMenu();
	};

	public MenuStatus coreGame(int ncav) {
		return new GameTypeMenu(ncav);
	}

}