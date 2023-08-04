package qlns;

import java.sql.*;

public class Filecanbang {
    private Connection connection;
    private String currentSender;
    private String currentReceiver;

    public Filecanbang() {
        connectToDatabase();
    }

    private void connectToDatabase() {
        try {
            // Replace with your database credentials
            String url = "jdbc:mysql://localhost:3306/nguoidung";
            String username = "tendangnhap";
            String password = "matkhau";

            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setCurrentSender(String sender) {
        this.currentSender = sender;
    }

    public void setCurrentReceiver(String receiver) {
        this.currentReceiver = receiver;
    }

    public void sendMessage(String message) {
        try {
            String query = "INSERT INTO messages (sender, receiver, message) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, currentSender);
            statement.setString(2, currentReceiver);
            statement.setString(3, message);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getAllMessages() {
        StringBuilder messages = new StringBuilder();
        try {
            String query = "SELECT * FROM messages WHERE (sender = ? AND receiver = ?) OR (sender = ? AND receiver = ?) ORDER BY timestamp";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, currentSender);
            statement.setString(2, currentReceiver);
            statement.setString(3, currentReceiver);
            statement.setString(4, currentSender);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String sender = resultSet.getString("sender");
                String message = resultSet.getString("message");
                messages.append(sender).append(": ").append(message).append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages.toString();
    }
}
