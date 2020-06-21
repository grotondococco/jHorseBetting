package menu;

import java.io.FileNotFoundException;
import java.io.IOException;
import game.InputChecker;
import game.Saldo;

/**
 * DP State: ConcreteState
 */
public class ExitMenu implements MenuStatus {

	public void print() throws FileNotFoundException, IOException {
		System.out.println("Saldo:" + Saldo.getInstanceSaldo().getSaldo() + "€");
		System.out.println("Desideri uscire dall'applicazione?");
		System.out.println("y] yes, please.");
		System.out.println("n] no, return back!");
	};

	public MenuStatus changeStatus() throws IOException {
		char selection;
		selection = InputChecker.checkInput();
		switch (selection) {
		case 'y':
			return next();
		case 'n':
			return back();
		default:
			System.out.println("Scelta non valida.");
		}
		return back();
	}

	public MenuStatus next() {
		System.exit(0);
		return this;
	};

	public MenuStatus back() {
		return new MainMenu();
	};
}