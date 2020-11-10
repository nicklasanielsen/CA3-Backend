package errorhandling;

/**
 *
 * @author Nicklas Nielsen
 */
public class UserNotFound extends Exception {

    public UserNotFound(String username) {
        super("Couldn't find user with username: " + username);
    }

}
