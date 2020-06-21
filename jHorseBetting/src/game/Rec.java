package game;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * DP Factory Method: ConcreteProduct
 */
public class Rec implements Esito {
	double importo;
	String causale;

	Rec(double importo, String causale) {
		this.importo = importo;
		this.causale = causale;
	}

	public void recordEsit() throws FileNotFoundException, IOException {
		ResultHandler.getInstanceResults().addRecord(this);
	}

	public String toString() {
		return causale + "	" + importo + "€		" + "--" + "		" + gTypeToString() + "\n";
	}

	public String gTypeToString() {
		return "--";
	}

}
