package app;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private Connection connection;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    public int add(Employee employee) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employees " +
                "(name, age, position, salary) VALUES (?, ?, ?, ?)")) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setInt(2, employee.getAge());
            preparedStatement.setString(3, employee.getPosition());
            preparedStatement.setFloat(4, employee.getSalary());
            return preparedStatement.executeUpdate();
        }
    }

    public int remove(Employee employee) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employees WHERE id = ?")) {
            preparedStatement.setInt(1, employee.getId());
            return preparedStatement.executeUpdate();
        }
    }

    public List<Employee> getAll() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM employees")) {
                while (resultSet.next()) {
                    employees.add(new Employee(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("age"),
                            resultSet.getString("position"),
                            resultSet.getFloat("salary")));
                }
                return employees;
            }
        }
    }

    public int updateEmployee(Employee employee) throws SQLException {
        String upd_qry = "UPDATE employees SET name = ?, age = ?, position = ?, salary = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(upd_qry)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setInt(2, employee.getAge());
            preparedStatement.setString(3, employee.getPosition());
            preparedStatement.setFloat(4, employee.getSalary());
            preparedStatement.setInt(5, employee.getId());
            return preparedStatement.executeUpdate();
        }
    }
}