package menu;

import java.io.IOException;

import game.InputChecker;
import game.Saldo;

public class FinalSelectionMenu implements MenuStatus {

	/**
	 * DP State: ConcreteState
	 */
	int ncav;
	int gType;

	FinalSelectionMenu(int ncav, int gType) {
		this.ncav = ncav;
		this.gType = gType;
	}

	public void print() throws IOException {
		System.out.println("Saldo:" + Saldo.getInstanceSaldo().getSaldo() + "€");
		System.out.println("Inserisci quanti soldi puntare:");
		System.out.print("\n");
		System.out.println("0] annulla giocata");
	}

	public MenuStatus changeStatus() throws IOException {
		double euroSelection = InputChecker.doubleInput();
		if (euroSelection < 0 || euroSelection > Saldo.getInstanceSaldo().getSaldo()) {
			System.out.println("Scelta non valida.");
			return this;
		}
		if (euroSelection == 0)
			return back();
		else
			return coreGame(ncav, gType, euroSelection);
	}

	public MenuStatus next() {
		return this;
	};

	public MenuStatus back() {
		return new MainMenu();
	};

	public MenuStatus coreGame(int ncav, int gtype, double euroS) throws IOException {
		return new CoreGame(ncav, gtype, euroS);
	}
}
