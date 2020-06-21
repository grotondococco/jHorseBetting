package menu;

import java.io.FileNotFoundException;
import java.io.IOException;
import game.InputChecker;
import game.Saldo;
import game.ResultHandler;

/**
 * DP State: ConcreteState
 */
public class HistoryMenu implements MenuStatus {
	public void print() throws IOException, FileNotFoundException {
		System.out.println("Saldo:" + Saldo.getInstanceSaldo().getSaldo() + "€");
		System.out.println("w] ultime cinque vittorie");
		System.out.println("l] ultime cinque perdite");
		System.out.println("r] ultime cinque ricariche");
		System.out.println("o] ultime dieci operazioni");
		System.out.println("\nb] back");
	};

	public MenuStatus changeStatus() throws IOException {
		char selection;
		selection = InputChecker.checkInput();
		switch (selection) {
		case 'w':
			return viewHistory5win();
		case 'l':
			return viewHistory5lost();
		case 'r':
			return viewHistory5rec();
		case 'o':
			return viewHistory10mov();
		case 'b':
			return back();
		default: 
			System.out.println("Scelta non valida.");
		}
		return this;
	}

	public MenuStatus next() {
		return this;
	};

	public MenuStatus back() {
		return new MainMenu();
	};

	public MenuStatus viewHistory5win() throws FileNotFoundException, IOException {
		ResultHandler.getInstanceResults().get5win();
		return this;
	};

	public MenuStatus viewHistory5lost() throws FileNotFoundException, IOException {
		ResultHandler.getInstanceResults().get5Los();
		return this;
	};

	public MenuStatus viewHistory5rec() throws FileNotFoundException, IOException {
		ResultHandler.getInstanceResults().get5Rec();
		return this;
	};

	public MenuStatus viewHistory10mov() throws FileNotFoundException, IOException {
		ResultHandler.getInstanceResults().get10Mov();
		return this;
	};

}