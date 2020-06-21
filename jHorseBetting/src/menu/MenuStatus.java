package menu;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * DP State: State
 */
public interface MenuStatus {
	public void print() throws IOException, FileNotFoundException;

	public MenuStatus changeStatus() throws IOException;

	public MenuStatus back();

	public MenuStatus next();
}