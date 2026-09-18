// class that represents one checker piece
public class Piece {

    // stores whether the piece is red or black
    private String color;

    // stores whether the piece is a king
    private boolean king;

    // constructor that creates a piece with a color
    // every piece starts as a regular piece, not a king
    Piece(String color) {
        this.color = color;
        this.king = false;
    }

    // returns the color of this piece
    public String getColor() {
        return color;
    }

    // returns true if this piece is a king and false if it is not
    public boolean isKing() {
        return king;
    }

    // changes whether this piece is a king
    public void setKing(boolean king) {
        this.king = king;
    }
}