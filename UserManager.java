import java.util.ArrayList;

public class UserManager {

    // stores all registered users
    private ArrayList<User> users;

    // stores the user that is currently logged in
    private User currentUser;

    // constructor that creates an empty list of users
    public UserManager() {
        users = new ArrayList<>();
        currentUser = null;
    }

    // checks the username and password and returns the user if they match
    public User loginUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {

                currentUser = user;
                return user;
            }
        }

        return null;
    }

    // registers a new user if the username and email are not already being used
    public boolean registerUser(String username, String email, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) || user.getEmail().equals(email)) {
                return false;
            }
        }

        User newUser = new User(username, email, password);
        users.add(newUser);

        return true;
    }

    // logs out the current user
    public void logoutUser() {
        currentUser = null;
    }

    // returns the user that is currently logged in
    public User getCurrentUser() {
        return currentUser;
    }
}