package game;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Core {
	private static final Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	private static List<Integer> play = Arrays.asList(numbers);

	private static void newGame() {
		Collections.shuffle(play);
	};

	public static boolean getEsit1P(int ncav) {
		newGame();
		if (play.get(0) == ncav)
			return true;
		return false;
	}

	public static boolean getEsit3P(int ncav) {
		newGame();
		for (int i = 0; i < 3; i++) {
			if (play.get(i) == ncav)
				return true;
		}
		return false;
	}

	public static List<Integer> gameEsit() {
		return play;
	}

}