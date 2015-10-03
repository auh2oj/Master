public class TicTacToe {
	static int who = 0;
	static double[] coords = new double[] {0.17, 0.5, 0.83};

	public static void draw() {
		StdDraw.line(0.33, 1.0, 0.33, 0.0);
		StdDraw.line(0.67, 1.0, 0.67, 0.0);
		StdDraw.line(0.0, 0.33, 1.0, 0.33);
		StdDraw.line(0.0, 0.67, 1.0, 0.67);
	}



	public static int nextPlayer() {
		return 1 - who;
	}

	public static String chooseToken() {
		if (who == 0) {
			who = nextPlayer();
			return "X";
		}
		else {
			who = nextPlayer();
			return "O";
		}
	}

	public static double chooseCoordX(char elem) {
		if (elem == '0' || elem == '3' || elem == '6') {
			return coords[0];
		}
		else if (elem == '1' || elem == '4' || elem == '7') {
			return coords[1];
		}
		else if (elem == '2' || elem == '5' || elem == '8') {
			return coords[2];
		}
		else
			System.err.println("You must enter a number from 0 to 8");
			return 0.0;
	}

	public static double chooseCoordY(char elem) {
		if (elem == '0' || elem == '1' || elem == '2') {
			return coords[2];
		}
		else if (elem == '3' || elem == '4' || elem == '5') {
			return coords[1];
		}
		else if (elem == '6' || elem == '7' || elem == '8') {
			return coords[0];
		}
		else
			System.err.println("You must enter a number from 0 to 8");
			return 0.0;
	}


	public static void placeToken() {
		while (true) {
			if (StdDraw.hasNextKeyTyped()) {
				char elem = StdDraw.nextKeyTyped();
				double x_coord = chooseCoordX(elem);
				double y_coord = chooseCoordY(elem);

				if (x_coord != 0.0 && y_coord != 0.0) {
					StdDraw.text(x_coord, y_coord, chooseToken());
				}
			}
		}
	}

	public static void main(String[] args) {

		draw();
		placeToken();
	}
}