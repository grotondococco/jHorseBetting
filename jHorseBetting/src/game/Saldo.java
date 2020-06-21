package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
//DP: Singleton
public class Saldo {
	private static Saldo mySaldo = new Saldo();
	private static File saldoTxt;
	private static double saldoLetto;

	private Saldo() {
		saldoTxt = new File(System.getProperty("user.dir") + "/src/game/data/saldo.txt");
		saldoLetto = 0;
	}

	public static Saldo getInstanceSaldo() throws FileNotFoundException, IOException {
		LineNumberReader lnr = new LineNumberReader(new FileReader(saldoTxt));
		saldoLetto = Double.parseDouble(lnr.readLine());
		lnr.close();
		return mySaldo;
	}

	public void addSaldo(double a) throws FileNotFoundException, IOException {
		saldoLetto += a;
		updateSaldo();
	}

	public void subSaldo(double s) throws FileNotFoundException, IOException {
		saldoLetto -= s;
		updateSaldo();
	}

	private static void updateSaldo() throws FileNotFoundException, IOException {
		FileWriter writer = new FileWriter(saldoTxt);
		Double tmp = saldoLetto;
		String parsedDouble = tmp.toString();
		writer.write(parsedDouble);
		writer.close();
	}

	public double getSaldo() {
		return saldoLetto;
	}

}