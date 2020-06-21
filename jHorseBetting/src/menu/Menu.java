package menu;

import java.io.IOException;

/**
 * DP State: Context
 */
public class Menu {
	public String header = "\n--jHorseBetting--";
	public String footer = "----   ----  ----";
	public MenuStatus ms;

	public Menu() {
		ms = new MainMenu();
	}

	public void init() throws IOException {
		do {
			printHeader();
			ms.print();
			printFooter();
			ms = ms.changeStatus();
		} while (true);
	}

	public void printHeader() {
		System.out.println(header);
	}

	public void printFooter() {
		System.out.println(footer);
	}
}