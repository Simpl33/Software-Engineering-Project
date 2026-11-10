import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class CheckersView {

     // The current game of checkers that this view is displaying
    private CheckersGame game;

    // the checkers board that this view is displaying
    private CheckersBoard board;
    
    // the grid that displays the checkerboard
    private GridPane grid;

    // constructor that takes in a checkers board to display
    public CheckersView(CheckersGame game) {
        this.game = game;
        this.board = game.getBoard();
        this.grid = new GridPane();

        updateView();
    }

    // creates the visual checkerboard
    private void updateView() {

        for (int row = 0; row < 8; row++) {

            for (int col = 0; col < 8; col++) {

                // creates a stack pane to hold the square and any checker piece on top of it
                StackPane stack = new StackPane();

                Rectangle square = new Rectangle(50, 50);
                

                if ((row + col) % 2 == 0) {
                    square.setFill(Color.BEIGE);
                } else {
                    square.setFill(Color.BROWN);
                }

                // adds the square to the stack pane
                stack.getChildren().add(square);

                Piece piece = board.getPiece(row, col);

                if (piece != null) {

                    // creates a circle to represent the checker piece
                    Circle checker = new Circle(20);

                    if (piece.getColor().equals("black")) {
                        checker.setFill(Color.BLACK); 
                    } else {
                        checker.setFill(Color.RED);
                    }

                    // adds the checker on top of the square
                    stack.getChildren().add(checker);   
                }

                // Creates an interactable overlay on the board
                Tile tile = new Tile(row, col);

                tile.setOnMouseClicked(e -> {
                        game.handlePieceClicked(tile);
                        this.updateView();
                    });
                
                stack.getChildren().add(tile);

                // adds the entire stack pane to the checkerboard grid
                grid.add(stack, col, row);
            }
        }
    }

   
    // returns the grid that displays the checkerboard
    public GridPane getGrid() {
        return grid;
    }
}