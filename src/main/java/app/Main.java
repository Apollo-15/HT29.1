package app;

public class Main {
    public static void main(String[] args) {
        try {
            EmployeeDAO employeeDAO = new EmployeeDAO(DatabaseConnector.getConnection());
            employeeDAO.add(new Employee("John Denver", 38, "Guitarist", 55000));
            employeeDAO.add(new Employee("Johny Cash", 49, "Guitarist", 50000));
            employeeDAO.add(new Employee("David Gilmour", 79, "Guitarist", 80321));
            employeeDAO.add(new Employee("Richard Wright", 65, "Guitarist", 80123));
            employeeDAO.add(new Employee("Roger Waters", 80, "Guitarist", 80231));
            employeeDAO.add(new Employee("Nick Mason", 78, "Guitarist", 80132));
            employeeDAO.getAll();
            employeeDAO.remove(new Employee(5, "Roger Waters", 80, "Guitarist", 80132));
            employeeDAO.updateEmployee(new Employee(3, "David Gilmour", 79, "Guitarist", 123456));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}