import java.util.LinkedList;
import java.util.Scanner;

class Item {
	int row;
	int col;
	int dir;
}

class Offsets {
	int vert;
	int horiz;
}

public class MazeCode {

	Offsets[] move = getMoveArray();
	int[][] maze = {};
	int[][] history = {};

	public static void main(String[] args) {

	}

	String go(LinkedList<Item> stack, int dir) {
		// stack init
		while (stack.size() != 0) {

			Item item = stack.remove();

			while (true) {

				int row = item.row + move[dir].vert;
				int col = item.col + move[dir].horiz;

				if (row == -1 && col == -1) {
					return "Success";
				}
				//
				if (maze(row, col) == 0 && mark(row, col) == 0) {
					history[row][col] = 1;
					
					stack.add(item);
					
					item.row = row;
					item.col = col;
				}
			}
		}

		return null;
	}

	int maze(int row, int col) {
		return maze[row][col];
	}

	int mark(int row, int col) {
		return history[row][col];
	}

	//
	void initEntranceCoordinates(LinkedList<Item> stack) {
		Item item = new Item();
		item.row = 0;
		item.col = 0;
		stack.add(item);
	}

	//
	final Offsets[] getMoveArray() {

		Offsets n = new Offsets();
		n.vert = -1;
		n.horiz = 0;

		Offsets ne = new Offsets();
		ne.vert = -1;
		ne.horiz = 1;

		Offsets e = new Offsets();
		e.vert = 0;
		e.horiz = 1;

		Offsets se = new Offsets();
		se.vert = 1;
		se.horiz = 1;

		Offsets s = new Offsets();
		s.vert = 1;
		s.horiz = 0;

		Offsets sw = new Offsets();
		sw.vert = 1;
		sw.horiz = -1;

		Offsets w = new Offsets();
		w.vert = 0;
		w.horiz = -1;

		Offsets nw = new Offsets();
		nw.vert = -1;
		nw.horiz = -1;

		return new Offsets[] { n, ne, e, se, s, sw, w, nw };
	}

}
