import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


// This class is the main entry point for the Checkers game application. It extends the JavaFX Application class and overrides the start method to set up the game board and view.
public class CheckersApp extends Application {

    @Override
    // starts the JavaFX application
    public void start(Stage stage) {

        System.out.println("JavaFX start method is running");

        CheckersBoard board = new CheckersBoard();
        CheckersView view = new CheckersView(board);

        // creates a scene with the checkerboard view and sets it on the stage
        Scene scene = new Scene(view.getGrid(), 400, 400);

        stage.setScene(scene);
        stage.setTitle("Checkers Game");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}