import java.util.List;
import java.util.ArrayList;

class Piece {
	Position currentPosition;
	boolean isWhite;

	public Piece(Position position, boolean isWhite) {
		this.currentPosition = position;
		this.isWhite = isWhite;
	}

	/*This method does not have to check the validity of the position*/
	public void setArbitraryPosition(Position currentPosition) {		
		this.currentPosition = currentPosition;
	}
	
	public void setArbitraryPosition(Integer col, Integer row) {		
		this.setArbitraryPosition(new Position(col, row));
	}
	
	public boolean isWhite() {
		return isWhite;
	}
}


class Position{
	Integer col;
	Integer row;
	
	Position(Integer col, Integer row) {
		this.col = col;
		this.row = row;
	}
	
	public Integer getCol() {
		return this.col;
	}
	
	public Integer getRow() {
		return this.row;
	}
	
	public Integer getRowDistance(Position otherPosition) {
		return Math.abs(this.row - otherPosition.getRow());
	}
	
	public Integer getColDistance(Position otherPosition) {
		return Math.abs(this.col - otherPosition.getCol());
	}
}

class Board{
	List<Piece> pieces = new ArrayList<Piece>(); 
		
	public void print() {		
		String mi = "  +----------------+";
		System.out.println("   0 1 2 3 4 5 6 7 <- X axis");
		System.out.println(mi);
		for (int row = 0; row < 8; row++) {
			System.out.print(String.valueOf(row) + " |");
			for (int col = 0; col < 8; col++) {
				Piece piece = pieceAt(new Position(row, col));
				if (piece == null) {
					System.out.print("  ");
				} else {
					System.out.print(String.valueOf(piece.isWhite() ? 1 : 2) + " ");
				}
			}
			System.out.print("|\n");
		}
		System.out.println(mi);
		System.out.println("   0 1 2 3 4 5 6 7");
	}
	
	public Piece pieceAt(Position position) {
		for (Piece piece: pieces) {
			if (piece.currentPosition.getCol() == position.getCol() && piece.currentPosition.getRow() == position.getRow()) {
				return piece;
			}
		}
		return null;
	}

	public void addPiece(Piece piece) {
		pieces.add(piece);
	}
	
	public boolean isValidMove(Piece piece, Position start, Position end) {
		if (end.getCol() >= 0 && end.getCol() <= 7 && end.getRow() >= 0 && end.getRow() <= 7) {
			if (pieceAt(end) == null) {
				if (piece.isWhite() && start.getColDistance(end) == 1 && (end.getRow() - start.getRow()) == -1) { 
					return true;
				} else if (!piece.isWhite() && start.getColDistance(end) == 1 && (end.getRow() - start.getRow()) == 1) {
					return true;
				} else {
					System.err.println("Move not valid");
					System.out.println(start.getColDistance(end));
					System.out.println(end.getRow() - start.getRow());
				}
			} else {
				System.err.println("Position already taken");
			}
		} else {
			System.err.println("Move outside board");
		}
		return false;		
	}
	
	/**
	 * This method moves the piece
	 * @return true if the piece has been moved correctly, false otherwise
	 */
	public boolean move(Integer turn, Position start, Position end) {
		Piece piece = pieceAt(start);
		if (piece != null && ((piece.isWhite() && turn % 2 == 1) || (!piece.isWhite() && turn % 2 == 0))  && this.isValidMove(piece, start, end) == true) {
			piece.setArbitraryPosition(end);
			return true;
		} else {
			System.err.println("Not possible to move the piece to this position");
			return false;
		}
	}
}

public class Checker_obj {

	public static void main(String[] args) {
		Board board = new Board();

		// Matrix used only to init pieces
		int[][] init = { { 0, 1, 0, 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0, 1, 0, 1 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 2, 0, 2, 0, 2, 0, 2, 0 },
				{ 0, 2, 0, 2, 0, 2, 0, 2 }, { 2, 0, 2, 0, 2, 0, 2, 0 }, };
		
		// Init pieces according the values of the matrix
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				System.out.println(col);
				System.out.println(row);
				Position position = new Position(row, col);
				if (init[row][col] == 1) {				
					board.addPiece(new Piece(position, true));
				} else if (init[row][col] == 2) {
					board.addPiece(new Piece(position, false));
				}
			}
		}
		
		board.print();
		
		// Play
		
		board.move(1, new Position(2, 1), new Position(3, 0));
		board.print();
		
		board.move(2, new Position(5, 6), new Position(4, 7));
		board.print();
		
		// ...
	}

}
