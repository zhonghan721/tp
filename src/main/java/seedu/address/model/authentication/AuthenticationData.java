package seedu.address.model.authentication;

/**
 * Represents the authentication data stored in the authentication.json file.
 */
public class AuthenticationData {
    private String username;
    private String password;

    /**
     * Creates an AuthenticationData object with the given username and password.
     * @param username
     * @param password
     */
    public AuthenticationData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Creates an empty AuthenticationData object.
     */
    public AuthenticationData() {}

    /**
     * Returns the username of the AuthenticationData object.
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Returns the password of the AuthenticationData object.
     * @return password
     */
    public String getPassword() {
        return password;
    }
}
