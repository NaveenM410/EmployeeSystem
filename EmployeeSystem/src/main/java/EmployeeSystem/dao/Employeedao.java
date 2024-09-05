package EmployeeSystem.dao;

import EmployeeSystem.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Employeedao
{
    private String url = "jdbc:mysql://localhost:3306/employees?useSSL=false";
    private String username = "root";
    private String password = "Naveen@410";

    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employee" +" (id,name,age,address,maritalstatus,active) VALUES "
            + " (?,?,?,?,?,?)";

    private static final String SELECT_EMPLOYEE_BY_ID = "select id,name,age,address,maritalstatus," +
            "active from employee where id=?";

    private static final String SELECT_ALL_EMPLOYEES = "select * from employee";

    private static final String DELETE_EMPLOYEES_SQL = "delete from employee where id=?";

    private static final String UPDATE_EMPLOYEES_SQL = "update employee set name=?,age=?,address=?,maritalstatus=?,active=?";


    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.print("vis");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertEmployee(Employee employee) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL))
        {
        	preparedStatement.setInt(1,employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setInt(3,employee.getAge());
            preparedStatement.setString(4, employee.getAddress());
            preparedStatement.setString(5, employee.getMaritalStatus());;
            preparedStatement.setString(6, employee.getActive());
             

            preparedStatement.executeUpdate();
            System.out.println("Data Inserted success");      
         }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEES_SQL)){
        	statement.setString(1, employee.getName());
            statement.setInt(2,employee.getAge());
            statement.setString(3, employee.getAddress());
            statement.setString(4, employee.getMaritalStatus());;
            statement.setString(5, employee.getActive());
            statement.setInt(6,employee.getId());


            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public Employee selectEmployee(int id) throws SQLException {
        Employee employee = null;
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);){
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) 
            {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                String maritalStatus = rs.getString("maritalStatus");
                String active = rs.getString("active");
                employee = new Employee(id, name, age, address, maritalStatus, active);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return employee;
    }

    public List<Employee>  selectAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);){

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                String maritalStatus = rs.getString("maritalStatus");
                String active = rs.getString("active");
                employees.add(new Employee(id,name,age,address,maritalStatus,active));
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return employees;
    }

    public boolean deleteEmployee(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEES_SQL)){
            statement.setInt(1,id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

}



















