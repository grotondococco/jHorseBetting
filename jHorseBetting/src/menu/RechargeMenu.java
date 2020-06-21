package menu;

import java.io.FileNotFoundException;
import java.io.IOException;
import game.InputChecker;
import game.Saldo;
import game.ResultHandler;
import game.EsitCreator;

/**
 * DP State: ConcreteState
 */
public class RechargeMenu implements MenuStatus {
	public void print() throws FileNotFoundException, IOException {
		System.out.println("Saldo: " + Saldo.getInstanceSaldo().getSaldo() + "€");
		System.out.println("0] Torna al menu' principale.");
	};

	public MenuStatus changeStatus() throws IOException {
		double selection;
		selection = InputChecker.doubleInput();
		if (selection < 0) {
			System.out.println("Scelta non valida.");
			return this;
		}
		if (selection == 0)
			return back();
		else {
			recharge(selection);
		}
		return this;
	}

	public MenuStatus next() {
		return this;
	};

	public MenuStatus back() {
		return new MainMenu();
	};

	public MenuStatus recharge(double selection) throws IOException {
		Saldo.getInstanceSaldo().addSaldo(selection);
		ResultHandler.getInstanceResults().addRecord(EsitCreator.getEsit(selection, "Ricarica", 1, true));
		return this;
	};

}