import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class UserManagerTest {

    @Test
    // tests the registerUser method of UserManager
    public void testRegisterUser() {
        UserManager userManager = new UserManager();
        boolean result = userManager.registerUser("username", "email", "password");

        assertTrue(result);
    }

    @Test
    // tests the duplicate user registration functionality
    public void testDuplicateUser() {
        UserManager userManager = new UserManager();

        userManager.registerUser("username", "email", "password");

        boolean result = userManager.registerUser("username", "email", "password");

        assertFalse(result);
    }

    @Test
    // tests the loginUser method of UserManager
    public void testLoginUser() {
        UserManager userManager = new UserManager();

        userManager.registerUser("username", "email", "password");

        User loggedInUser = userManager.loginUser("username", "password");

        assertNotNull(loggedInUser);
    }

    @Test
    // tests the invalid login functionality
    public void testInvalidLogin() {
        UserManager userManager = new UserManager();

        userManager.registerUser("username", "email", "password");

        User loggedInUser = userManager.loginUser("username", "wrongpassword");

        assertNull(loggedInUser);
    }

    @Test
    // tests the logoutUser method of UserManager
    public void testLogoutUser() {
        UserManager userManager = new UserManager();

        userManager.registerUser("username", "email", "password");
        userManager.loginUser("username", "password");

        userManager.logoutUser();

        assertNull(userManager.getCurrentUser());
}
    
}