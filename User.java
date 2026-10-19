public class User {
    private String username;
    private String email;
    private String password;


    // constructor that initializes the user with a username, email, and password
    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
        } 
        
        // getters and setters for the username, email, and password fields
        public String getUsername() {
            return username;

        }

        // returns the email of the user
        public String getEmail() {
            return email;
        }

        // returns the password of the user
        public String getPassword() {
            return password;
        }

        // sets the username of the user
        public void setUsername(String username) {
            this.username = username;
        }


        // sets the email of the user
        public void setEmail(String email) {
            this.email = email;
        }


        // sets the password of the user
        public void setPassword(String password) {
            this.password = password;
        }

        
}

