package menu;

import java.io.FileNotFoundException;
import java.io.IOException;
import game.InputChecker;
import game.Saldo;

/**
 * DP State: ConcreteState / stato iniziale
 */
public class MainMenu implements MenuStatus {
	public void print() throws IOException, FileNotFoundException {
		System.out.println("Saldo: " + Saldo.getInstanceSaldo().getSaldo() + "€");
		System.out.println("g] gioca");
		System.out.println("r] ricarica");
		System.out.println("s] storico");
		System.out.println("e] exit");
	};

	public MenuStatus changeStatus() throws IOException {
		char selection;
		selection = InputChecker.checkInput();
		switch (selection) {
		case 'g':
			return next();
		case 'r':
			return recharge();
		case 's':
			return viewHistory();
		case 'e':
			return back();
		default: 
			System.out.println("Scelta non valida.");
		}
		return this;
	}

	public MenuStatus next() {
		return new GameMenu();
	};

	public MenuStatus back() {
		return new ExitMenu();
	};

	public MenuStatus recharge() {
		return new RechargeMenu();
	};

	public MenuStatus viewHistory() {
		return new HistoryMenu();
	};

}