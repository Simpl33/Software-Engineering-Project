
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class CheckersView {

    private CheckersGame game;
    private CheckersBoard board;
    private GridPane grid;

    public CheckersView(CheckersGame game) {
        this.game = game;
        this.board = game.getBoard();
        this.grid = new GridPane();

        updateView();
    }

    // Creates and updates the checkerboard
    private void updateView() {

        // Clear the old board before updating
        grid.getChildren().clear();

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {

                StackPane stack = new StackPane();

                Rectangle square = new Rectangle(50, 50);

                if ((row + col) % 2 == 0) {
                    square.setFill(Color.BEIGE);
                } else {
                    square.setFill(Color.BROWN);
                }

                stack.getChildren().add(square);

                Piece piece = board.getPiece(row, col);

                if (piece != null) {
                    Circle checker = new Circle(20);

                    if (piece.getColor().equals("black")) {
                        checker.setFill(Color.BLACK);
                    } else {
                        checker.setFill(Color.RED);
                    }

                    stack.getChildren().add(checker);
                }

                // Clickable tile
                Tile tile = new Tile(row, col);

                // Make the entire square clickable
                tile.setPrefSize(50, 50);
                tile.setPickOnBounds(true);

                tile.setOnMouseClicked(e -> {
                    game.handlePieceClicked(tile);
                    updateView();
                });

                stack.getChildren().add(tile);

                grid.add(stack, col, row);
            }
        }
    }

    public GridPane getGrid() {
        return grid;
    }
}
