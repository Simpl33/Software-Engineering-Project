import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

// This class represents the login view for the Checkers game application. 
// It provides a user interface for users to log in or register, and it interacts 
// with the UserManager to handle authentication and registration.
public class LoginView {

    private UserManager userManager;
    private Runnable onLoginSuccess;
    private VBox root;
    private TextField usernameField;
    private TextField emailField;
    private PasswordField passwordField;
    private Label messageLabel;

    // Constructor for the LoginView class. It initializes the user manager and the 
    // callback for successful login, and builds the view.
    public LoginView(UserManager userManager, Runnable onLoginSuccess) {
        this.userManager = userManager;
        this.onLoginSuccess = onLoginSuccess;
        buildView();
    }

    // This method builds the user interface for the login view, including labels, 
    // text fields, buttons, and message labels. It sets up the layout and styling for the
    //  components.
    private void buildView() {

        Label title = new Label("The Big Triple T Checkers");
        title.setFont(Font.font("System", FontWeight.BOLD, 20));

        Label subtitle = new Label("Log in or register to play");

        usernameField = new TextField();
        usernameField.setPromptText("Username");

        emailField = new TextField();
        emailField.setPromptText("Email (only needed to register)");

        passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginButton = new Button("Login");
        loginButton.setPrefWidth(100);
        loginButton.setDefaultButton(true);
        loginButton.setOnAction(e -> handleLogin());

        Button registerButton = new Button("Register");
        registerButton.setPrefWidth(100);
        registerButton.setOnAction(e -> handleRegister());

        HBox buttons = new HBox(10, loginButton, registerButton);
        buttons.setAlignment(Pos.CENTER);

        messageLabel = new Label("");
        messageLabel.setWrapText(true);

        root = new VBox(12, title, subtitle, usernameField, emailField, passwordField, buttons, messageLabel);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        root.setMaxWidth(320);
    }

    // This method handles the login process when the login button is clicked. 
    // It retrieves the username and password from the text fields, checks if they are empty,
    //  and then attempts to log in the user using the UserManager. If successful, 
    // it clears the fields and runs the onLoginSuccess callback; otherwise, 
    // it shows an error message.
    private void handleLogin() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showError("Please enter a username and password.");
            return;
        }

        User user = userManager.loginUser(username, password);

        if (user == null) {
            showError("Invalid username or password.");
        } else {
            clearFields();
            onLoginSuccess.run();
        }
    }

    // This method handles the registration process when the register button is clicked.
    //  It retrieves the username, email, and password from the text fields, checks if they
    //  are empty, and then attempts to register the user using the UserManager. 
    // If successful, it shows a success message and clears the email and password fields; 
    // otherwise, it shows an error message.
    private void handleRegister() {
        String username = usernameField.getText().trim();
        String email = emailField.getText().trim();
        String password = passwordField.getText();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            showError("Please fill in username, email, and password to register.");
            return;
        }

        boolean registered = userManager.registerUser(username, email, password);

        if (registered) {
            showSuccess("Registration successful! You can now log in.");
            emailField.clear();
            passwordField.clear();
        } else {
            showError("That username or email is already registered.");
        }
    }

    // This method displays an error message in red text on the message label.
    private void showError(String message) {
        messageLabel.setTextFill(Color.RED);
        messageLabel.setText(message);
    }

    // This method displays a success message in green text on the message label.
    private void showSuccess(String message) {
        messageLabel.setTextFill(Color.GREEN);
        messageLabel.setText(message);
    }

    // This method clears the text fields and resets the message label to an empty state.
    private void clearFields() {
        usernameField.clear();
        emailField.clear();
        passwordField.clear();
        messageLabel.setText("");
    }

    // This method returns the root VBox of the login view, which can be added to a scene or another layout in the JavaFX application.
    public VBox getRoot() {
        return root;
    }
}