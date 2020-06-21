package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputChecker {

	/**
	 * This method is used to check the input from the user.
	 * 
	 * @return the first character the user input on the terminal.
	 * @throws IOException
	 */
	public static char checkInput() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader((System.in)));
		char selection = 'x';
		try {
			System.out.println("Input utente: ");
			selection = (char) input.readLine().charAt(0);
		} catch (IOException e) {
			System.out.println("Input non valido.");
		}
		return selection;
	}

	/**
	 * This method is used to check the input from the user.
	 * 
	 * @return a double number user input on the terminal
	 * @throws IOException
	 */
	public static double doubleInput() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader((System.in)));
		double euros = 0.0;
		try {
			System.out.println("Inserire euro: ");
			euros = Double.parseDouble(input.readLine().trim());
		} catch (IOException e) {
			System.out.println("Input non valido.");
			euros = 0;
		} catch (NumberFormatException nfe) {
			System.out.println("Inserire un numero valido, comprensivo di virgola.");
			euros = 0;
		}
		return euros;
	}

	/**
	 * This method is used to check the input from the user.
	 * 
	 * @return a integer number user input on the terminal
	 * @throws IOException
	 */
	public static int numberInput() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader((System.in)));
		int selection;
		try {
			System.out.println("Input utente: ");
			selection = Integer.parseInt(input.readLine().trim());
		} catch (IOException e) {
			System.out.println("Input non valido.");
			selection = 0;
		} catch (NumberFormatException nfe) {
			System.out.println("Inserire un numero valido, comprensivo di virgola.");
			selection = 0;
		}
		return selection;
	}
}