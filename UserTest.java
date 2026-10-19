import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

// tests the User class and its methods
public class UserTest {

@Test

// tests the getters and setters of the User class
public void testUserGettersAndSetters() {
    User user = new User("username", "email", "password");

    assertEquals("email", user.getEmail());

    user.setUsername("newUsername");
    user.setEmail("newEmail");
    user.setPassword("newPassword");

    assertEquals("newUsername", user.getUsername());
    assertEquals("newEmail", user.getEmail());
    assertEquals("newPassword", user.getPassword());
}
    
}
