package gestiondesnavettes.repository;

import gestiondesnavettes.model.User;
import java.sql.*;

public class UserRepository {

    private Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    // Method to save a user to the database
    public void saveUser(User user) throws SQLException {
        String query = "INSERT INTO User (name, email, password) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.executeUpdate();
        }
    }

    // Method to find a user by email
    public User findByEmail(String email) throws SQLException {
        String query = "SELECT * FROM User WHERE email = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password")
                );
            }
        }
        return null;
    }
}
