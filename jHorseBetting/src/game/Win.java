package game;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * DP Factory Method: ConcreteProduct
 */
public class Win implements Esito {
	double puntata;
	String ncav;
	int gType;

	Win(double puntata, String ncav, int gType) {
		this.puntata = puntata;
		this.ncav = ncav;
		this.gType = gType;
	}

	public void recordEsit() throws FileNotFoundException, IOException {
		ResultHandler.getInstanceResults().addRecord(this);
	}

	public String toString() {
		return "Win" + "		" + puntata + "€		" + ncav + "		" + gTypeToString() + "\n";
	}

	public String gTypeToString() {
		if (gType == 1)
			return "1POS";
		else
			return "PODIO";
	}
}
