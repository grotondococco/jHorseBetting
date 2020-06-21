package game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//DP: Singleton
public class ResultHandler {
	private static ResultHandler results = new ResultHandler();
	private static File resultsTxt;
	private static List<String> resultsList;

	private ResultHandler() {
		resultsTxt = new File(System.getProperty("user.dir") + "/src/game/data/results.txt");
		resultsList = new ArrayList<>();
	}

	public static ResultHandler getInstanceResults() throws FileNotFoundException, IOException {
		return results;
	}

	public void addRecord(Esito e) throws FileNotFoundException, IOException {
		BufferedWriter br = new BufferedWriter(new FileWriter(resultsTxt, true));
		br.write(e.toString());
		br.close();
	}

	private void loadList() throws FileNotFoundException, IOException {
		resultsList.clear();
		BufferedReader br = new BufferedReader(new FileReader(resultsTxt));
		while (br.ready())
			resultsList.add(br.readLine());
		br.close();
	}

	public void get5win() throws FileNotFoundException, IOException {
		loadList();
		Collections.reverse(resultsList);
		System.out.println("Elenco ultime cinque puntate vincenti:");
		System.out.println("Esito		Puntata		Cavallo		TipoDiPuntata");
		resultsList.stream().filter(s -> s.startsWith("Win")).limit(5).forEach(System.out::println);
	}

	public void get5Los() throws FileNotFoundException, IOException {
		loadList();
		Collections.reverse(resultsList);
		System.out.println("Elenco ultime cinque puntate perdenti:");
		System.out.println("Esito		Puntata		Cavallo		TipoDiPuntata");
		resultsList.stream().filter(s -> s.startsWith("Lost")).limit(5).forEach(System.out::println);
	}

	public void get5Rec() throws FileNotFoundException, IOException {
		loadList();
		Collections.reverse(resultsList);
		System.out.println("Elenco ultime cinque ricariche:");
		System.out.println("Causale		Denaro");
		resultsList.stream().filter(s -> s.startsWith("Ric")).limit(5).forEach(System.out::println);
	}

	public void get10Mov() throws FileNotFoundException, IOException {
		loadList();
		Collections.reverse(resultsList);
		System.out.println("Elenco ultimi dieci movimenti:");
		System.out.println("Causale		Denaro		Cavallo		TipoDiPuntata");
		resultsList.stream().limit(10).forEach(System.out::println);
	}

}