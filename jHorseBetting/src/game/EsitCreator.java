package game;
/**
 * DP Factory Method: Creator/ConcreteCreator
 */
public class EsitCreator {
	public static Esito getEsit(double puntata, String ncav, int gType, boolean gameEsit) {
		if (ncav == "Ricarica")
			return new Rec(puntata, ncav);
		else if (gameEsit == true)
			return new Win(puntata, ncav, gType);
		else
			return new Lost(puntata, ncav, gType);
	}

}
