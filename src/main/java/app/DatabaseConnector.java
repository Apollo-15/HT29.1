package app;

import java.sql.*;

public class DatabaseConnector {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try (Connection connection = getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM employees")) {
                    while (resultSet.next()) {
                        System.out.println(resultSet.getInt("id"));
                        System.out.println(resultSet.getString("name"));
                        System.out.println(resultSet.getInt("age"));
                        System.out.println(resultSet.getString("position"));
                        System.out.println(resultSet.getFloat("salary"));
                    }
                }
            }
        }
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/company";
        String username = "root";
        String password = "QaZWsXEdCRfV";
        return DriverManager.getConnection(url, username, password);
    }
}
