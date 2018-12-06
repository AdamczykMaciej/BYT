// BAD SMELL: "Long Method". I used Extract Method.
public class TicTacToe {
	public StringBuffer board;

	public TicTacToe(String s) {
		board = new StringBuffer(s);
	}

	public TicTacToe(String s, int position, char player) {
		board = new StringBuffer(s);
		board.setCharAt(position, player);
	}

	public int suggestMove(char player) {
		for (int i = 0; i < 9; i++) {
			if (board.charAt(i) == '-') {
				TicTacToe game = makeMove(i, player);
				if (game.winner() == player)
					return i;
			}
		}

		for (int i = 0; i < 9; i++) {
			if (board.charAt(i) == '-')
				return i;
		}

		return -1;
	}

	public TicTacToe makeMove(int i, char player) {
		return new TicTacToe(board.toString(), i, player);
	}

	public char winner() {
		char winner = '-';
		
		if((winner = getHorizontalWinner()) != '-')
			return winner;
		if((winner = getVerticalWinner()) != '-')
			return winner;	
		if((winner = getDiagonalWinner()) != '-')
			return winner;	

		return winner;
	}

	private char getDiagonalWinner() {
		if (board.charAt(0) != '-' && board.charAt(4) == board.charAt(0)
				&& board.charAt(8) == board.charAt(0))
			return board.charAt(0);
		if (board.charAt(2) != '-' && board.charAt(4) == board.charAt(2)
				&& board.charAt(6) == board.charAt(2))
			return board.charAt(2);
		return '-';
	}

	private char getVerticalWinner() {
		for (int i = 0; i < 3; ++i) {
			if (board.charAt(i) != '-'
					&& board.charAt(i + 3) == board.charAt(i)
					&& board.charAt(i + 6) == board.charAt(i))
				return board.charAt(i);
		}
		return '-';
	}

	private char getHorizontalWinner() {
		for (int i = 0; i < 9; i += 3) {
			if (board.charAt(i) != '-'
					&& board.charAt(i + 1) == board.charAt(i)
					&& board.charAt(i + 2) == board.charAt(i))
				return board.charAt(i);
		}
		return '-';
	}
}
