//
//
//class Piece {
//	Player player;
//	Position currentPosition;
//	
//	Piece(Player player) {
//		this.player = player;
//	}
//
//	/*This method does not have to check the validity of the position*/
//	public void setArbitraryPosition(Position currentPosition) {		
//		this.currentPosition = currentPosition;
//	}
//	
//	public void setArbitraryPosition(char col, Integer row) {		
//		this.setArbitraryPosition(new Position(col, row));
//	}
//
//	/*This method checks if the position is a valid position */
//	public boolean isValidPosition(Position newPosition) {
//		
//		if (newPosition.getCol() == 'a' || newPosition.getCol() == 'b' || 
//			newPosition.getCol() == 'c' || newPosition.getCol() == 'd' || 
//			newPosition.getCol() == 'e' || newPosition.getCol() == 'f' ||
//			newPosition.getCol() == 'g' || newPosition.getCol() == 'h') {
//			
//			if (newPosition.getRow() >= 1 && newPosition.getRow() <= 8)  {
//				return true;
//			} else {
//				return false;
//			}
//		} else {
//			return false;
//		}
//				
//	}
//	
//	/**
//	 * This method moves the piece
//	 * @return true if the piece has been moved correctly, false otherwise
//	 */
//	public boolean move(Position newPosition) {
//		if (this.isValidPosition(newPosition) == true) {
//			this.currentPosition = newPosition;
//			return true;
//		} else {
//			System.err.println("Not possible to move the piece to this position");
//			return false;
//		}
//	}
//}
//
//
//class Position{
//	char col;
//	Integer row;
//	
//	Position(char col, Integer row) {
//		this.col = col;
//		this.row = row;
//	}
//	
//	public char getCol() {
//		return this.col;
//	}
//	
//	public Integer getRow() {
//		return this.row;
//	}
//	
//	public Integer getRowDistance(Position otherPosition) {
//		return Math.abs(this.row - otherPosition.getRow());
//	}
//	
//	public Integer getColDistance(Position otherPosition) {
//		
//		return Math.abs(Character.getNumericValue(this.col) - Character.getNumericValue(otherPosition.getCol()));
//	}
//}
//
//class Player{
//	String name;
//	boolean isWhite;
//	Player(String name){
//		this.name = name;}
//	public void setColorWhite (boolean isWhite){
//		this.isWhite = isWhite;
//	}
//	public boolean isWhite() {
//		return this.isWhite;
//	}
//}
//
///*	p1
//	
//	p2
//	
//	p1.getRowDistance(p2)*/
//
//class King extends Piece {
//
//	King(Player player) {
//		super(player);
//	}
//	public boolean isValidPosition(Position newPosition) {
//		if (!super.isValidPosition(newPosition)) {
//			return false;
//		} else {
//	       if (currentPosition.getRowDistance(newPosition) == 1  || currentPosition.getColDistance(newPosition) == 1) {
//	    	   return true;
//	       }
//		} return false;
//	}
//}
//
//class Rook extends Piece {
//
//	Rook(Player player) {
//		super(player);
//	}
//	public boolean isValidPosition(Position newPosition) {
//		if (!super.isValidPosition(newPosition)) {
//			return false;
//		} else {
//			if((currentPosition.getCol() == newPosition.getCol() && currentPosition.getRow() != newPosition.getRow()) ||
//				(currentPosition.getCol() != newPosition.getCol() && currentPosition.getRow() == newPosition.getRow())) {
//				return true;
//			}
//		}
//		return false;
//	}
//}
//class Bishop extends Piece{
//
//	Bishop(Player player) {
//		super(player);
//	}
//	public boolean isValidPosition(Position newPosition) {
//		if (!super.isValidPosition(newPosition)) {
//			return false;
//		} else {
//			if(currentPosition.getColDistance(newPosition) == currentPosition.getRowDistance(newPosition)) {
//				return true;
//			}
//		}
//	return false;
//	}
//}
//
//class Knight extends Piece{
//
//	Knight(Player player) {
//		super(player);
//	} 
//	public boolean isValidPosition(Position newPosition) {
//		if (!super.isValidPosition(newPosition)) {
//			return false;
//		} else {
//				if((currentPosition.getColDistance(newPosition) == 2 && currentPosition.getRowDistance(newPosition) == 1)
//				|| (currentPosition.getColDistance(newPosition) == 1 && currentPosition.getRowDistance(newPosition) == 2)) {
//				return true;	
//			} return false;
//		}
//	}
//}
//
//class Pawn extends Piece {
//
//	Pawn(Player player) {
//		super(player);
//	}
//	
//	public boolean isValidPosition(Position newPosition) {
//		if (!super.isValidPosition(newPosition)) {
//			return false;
//		} else {
//			if (currentPosition.getCol() != newPosition.getCol()) {
//				return false;
//			}			
//			if  ((this.player.isWhite() && (newPosition.getRow() - currentPosition.getRow()) == 1)
//				     || (!this.player.isWhite() && (newPosition.getRow() - currentPosition.getRow()) == -1))   {		
//				return true;
//			}
//			if ((currentPosition.getRow() == 2 && this.player.isWhite() && newPosition.getRow() == 4) 
//				|| (currentPosition.getRow() == 7 && !this.player.isWhite() && newPosition.getRow() == 5) ) {
//				return true;
//			}
//		}
//		return false;
//	}	
//}
// 
//
//
//public class Chess {
//	
//	public static void main(String[] args) {
//		Player p1 = new Player("White player");
//		p1.setColorWhite(true);
//		Player p2 = new Player("Black player");
//		p2.setColorWhite(false);
//		
//		System.out.println("Testing kings:");
//		Piece whiteKing = new King(p1);
//		whiteKing.setArbitraryPosition(new Position('f', 5));
//		test(whiteKing, 'a', 1, false);
//		test(whiteKing, 'f', 4, true);
//		
//		System.out.println("Testing rooks:");
//		Rook blackRook = new Rook(p2);
//		blackRook.setArbitraryPosition('d', 5);
//		test(blackRook, 'h', 5, true);
//		test(blackRook, 'h', 1, false);
//		test(blackRook, 'd', 9, false);
//		
//		System.out.println("Testing bishops:");
//		Piece whiteBishop = new Bishop(p1);
//		whiteBishop.setArbitraryPosition(new Position('d', 5));
//		test(whiteBishop, 'b', 2, false);
//		test(whiteBishop, 'a', 8, true);
//		
//		System.out.println("Testing knigts:");
//		Knight blackKnight = new Knight(p2);
//		blackKnight.setArbitraryPosition('d', 4);
//		test(blackKnight, 'e', 6, true);
//		test(blackKnight, 'f', 6, false);
//		test(blackKnight, 'c', 2, true);
//		test(blackKnight, 'i', 8, false);
//		
//		System.out.println("Testing pawns:");
//		Pawn whitePawn = new Pawn(p1);
//		Pawn blackPawn = new Pawn(p2);
//		blackPawn.setArbitraryPosition('b', 4);
//		test(blackPawn, 'b', 3, true);
//		test(blackPawn, 'b', 5, false);
//		whitePawn.setArbitraryPosition('f', 2);
//		test(whitePawn, 'f', 3, true);
//		test(whitePawn, 'f', 4, true);
//		blackPawn.setArbitraryPosition('g', 5);
//		test(blackPawn, 'g', 4, true);
//		test(blackPawn, 'g', 3, false);
//		whitePawn.setArbitraryPosition('e', 7);
//		test(whitePawn, 'd', 8, false);
//		test(whitePawn, 'f', 8, false);
//	}
//	
//	public static void test(Piece p, char x, int y, boolean valid) {
//		if (p.isValidPosition(new Position(x, y)) == valid) {
//			System.out.println("  > Test passed!");
//		} else {
//			System.out.println("  X Test NOT passed!");
//		}
//	}
//}
