package gestiondesnavettes.service;

import gestiondesnavettes.model.User;
import gestiondesnavettes.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.SQLException;

public class UserService {

    private UserRepository userRepository;

    public UserService(Connection connection) {
        this.userRepository = new UserRepository(connection);
    }

    // Method for registering a new user
    public void registerUser(String name, String email, String password) throws SQLException {
        if (userRepository.findByEmail(email) != null) {
            throw new IllegalArgumentException("User with this email already exists.");
        }

        // Hash the password
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        User user = new User(0, name, email, hashedPassword);
        userRepository.saveUser(user);
    }

    // Method for logging in a user
    public User loginUser(String email, String password) throws SQLException {
        User user = userRepository.findByEmail(email);
        if (user != null && BCrypt.checkpw(password, user.getPassword())) {
            return user;
        }
        return null; // Invalid login
    }
}
