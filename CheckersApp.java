import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

// This class represents the main application for the Checkers game. 
// It manages the different views (login, menu, and game) and handles user 
// interactions such as login, registration, starting a new game, and logging out.
public class CheckersApp extends Application {

    private Stage stage;
    private UserManager userManager = new UserManager();

    @Override
    public void start(Stage stage) {

        System.out.println("JavaFX start method is running");

        this.stage = stage;
        showLoginScreen();
        stage.show();
    }

    // This method displays the login screen by creating an instance of LoginView and
    // setting it as the scene of the stage. It also sets the title of the stage to indicate
    // that it is the login screen.
    private void showLoginScreen() {
        LoginView loginView = new LoginView(userManager, this::showMenuScreen);

        StackPane container = new StackPane(loginView.getRoot());

        stage.setScene(new Scene(container, 400, 450));
        stage.setTitle("Checkers Game - Login");
    }

    // This method displays the menu screen after a successful login. 
    // It retrieves the current user's username from the UserManager and creates a 
    // welcome message. It also provides buttons for starting a new game and logging out, 
    // and sets up the layout for the menu screen.
    private void showMenuScreen() {
        String username = userManager.getCurrentUser().getUsername();

        Label welcome = new Label("Welcome, " + username + "!");
        welcome.setFont(Font.font("System", FontWeight.BOLD, 20));

        Button newGameButton = new Button("Start New Game");
        newGameButton.setPrefWidth(160);
        newGameButton.setOnAction(e -> showGameScreen());

        Button logoutButton = new Button("Logout");
        logoutButton.setPrefWidth(160);
        logoutButton.setOnAction(e -> logout());

        VBox menu = new VBox(15, welcome, newGameButton, logoutButton);
        menu.setAlignment(Pos.CENTER);
        menu.setPadding(new Insets(30));

        stage.setScene(new Scene(menu, 400, 450));
        stage.setTitle("Checkers Game - Menu");
    }

    // This method displays the game screen where the user can play Checkers. 
    // It creates an instance of CheckersGame and CheckersView, sets up a top bar with the 
    // player's username, buttons for starting a new game and logging out, and arranges the 
    // layout using a BorderPane.
    private void showGameScreen() {
        CheckersGame game = new CheckersGame();
        CheckersView view = new CheckersView(game);

        Label playerLabel = new Label("Player: " + userManager.getCurrentUser().getUsername());

        Button newGameButton = new Button("New Game");
        newGameButton.setOnAction(e -> showGameScreen());

        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> logout());

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        HBox topBar = new HBox(10, playerLabel, spacer, newGameButton, logoutButton);
        topBar.setAlignment(Pos.CENTER_LEFT);
        topBar.setPadding(new Insets(8));

        BorderPane layout = new BorderPane();
        layout.setTop(topBar);
        layout.setCenter(view.getGrid());

        stage.setScene(new Scene(layout, 400, 450));
        stage.setTitle("Checkers Game");
    }

    //This method handles the logout process by calling the logoutUser method of the UserManager and then displaying the login screen again.
    private void logout() {
        userManager.logoutUser();
        showLoginScreen();
    }

    public static void main(String[] args) {
        launch(args);
    }
}