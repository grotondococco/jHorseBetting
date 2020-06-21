package game;

import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * DP Factory Method: Product
 */
public interface Esito {
	public void recordEsit() throws FileNotFoundException, IOException;

	public String toString();

	public String gTypeToString();
}
