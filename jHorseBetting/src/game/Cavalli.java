package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Cavalli {
	private static List<String> listaCavalli = new ArrayList<>();
	public static int num = listaCavalli.size();

	public static List<String> getCavalli() throws IOException {
		if (listaCavalli.isEmpty() == true)
			loadCavalli();
		updateNumCavalli();
		return listaCavalli;
	}

	private static void loadCavalli() throws IOException, FileNotFoundException {
		final File elencoCavalliTxt = new File(System.getProperty("user.dir") + "/src/game/data/elencocavalli.txt");
		BufferedReader br = new BufferedReader(new FileReader(elencoCavalliTxt));
		while (br.ready()) {
			listaCavalli.add(br.readLine());
		}
		br.close();
	}

	private static void updateNumCavalli() {
		num = listaCavalli.size();
	}
}
