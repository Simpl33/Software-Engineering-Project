import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class UserManagerTest {

    // tests the registerUser method of UserManager
    @Test    
    public void testRegisterUser() {
        UserManager userManager = new UserManager();
        boolean result = userManager.registerUser("username", "email", "password");

        assertTrue(result);
    }

    // tests the duplicate user registration functionality
    @Test    
    public void testDuplicateUser() {
        UserManager userManager = new UserManager();

        userManager.registerUser("username", "email", "password");

        boolean result = userManager.registerUser("username", "email", "password");

        assertFalse(result);
    }

    // tests the loginUser method of UserManager
    @Test    
    public void testLoginUser() {
        UserManager userManager = new UserManager();

        userManager.registerUser("username", "email", "password");

        User loggedInUser = userManager.loginUser("username", "password");

        assertNotNull(loggedInUser);
    }

    // tests the invalid login functionality
    @Test    
    public void testInvalidLogin() {
        UserManager userManager = new UserManager();

        userManager.registerUser("username", "email", "password");

        User loggedInUser = userManager.loginUser("username", "wrongpassword");

        assertNull(loggedInUser);
    }

    // tests the getCurrentUser method of UserManager
    @Test    
    public void testLogoutUser() {
        UserManager userManager = new UserManager();

        userManager.registerUser("username", "email", "password");
        userManager.loginUser("username", "password");

        userManager.logoutUser();

        assertNull(userManager.getCurrentUser());
}
    
}