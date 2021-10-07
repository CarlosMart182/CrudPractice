package employeeDAO;

import conection.Conection;
import employeeDTO.Employee;
import interfaces.Operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements Operations <Employee> {
    private ResultSet rs;
    private PreparedStatement ps;
    private Connection connection;
    private static final String SQL_READALL = "SELECT * FROM employee";
    private static final String SQL_CREATE = "INSERT INTO employee (first_name, last_name, birth_day, sex, salary) VALUES(?,?,?,?,?)";
    private static final String SQL_READ = "SELECT * FROM employee WHERE emp_id= ?";
    private static final String SQL_UPDATE = "UPDATE employee SET first_name = ?, last_name = ?, birth_day = ?, sex = ?, salary = ? WHERE emp_id = ?";
    private static final String SQL_DELETE = "DELETE FROM employee WHERE emp_id = ?";
    @Override
    public int create(Employee employee) {
        int x=0;
        try {
            connection = Conection.getConection();
            ps = connection.prepareStatement(SQL_CREATE);
            //ps.setInt(1,employee.getEmp_id());
            ps.setString(1, employee.getFirst_name());
            ps.setString(2, employee.getLast_name());
            ps.setDate(3,employee.getBirthday());
            ps.setString(4, employee.getSex());
            ps.setInt(5,employee.getSalary());
            x = ps.executeUpdate();
        }catch (Exception e){
            System.out.println("Error"+e);
        } return x;
    }

    @Override
    public int update(Employee employee) {
        int x=0;
        try {
            //System.out.println(employee.getEmp_id());
            connection = Conection.getConection();
            ps = connection.prepareStatement(SQL_UPDATE);
            //ps.setInt(1,employee.getEmp_id());
            ps.setString(1, employee.getFirst_name());
            ps.setString(2, employee.getLast_name());
            ps.setDate(3,employee.getBirthday());
            ps.setString(4, employee.getSex());
            ps.setInt(5,employee.getSalary());
            ps.setInt(6,employee.getEmp_id());
            x = ps.executeUpdate();
        }catch (Exception e){
            System.out.println("Error"+e);
        } return x;
    }

    @Override
    public int delete(int key) {
        int x=0;
        try {
            connection = Conection.getConection();
            ps = connection.prepareStatement(SQL_DELETE);
            ps.setInt(1, key);
            x = ps.executeUpdate();
        }catch (Exception e){
            System.out.println("Error"+e);
        } return x;
    }

    @Override
    public Employee read(int key) {
        Employee dTO = new Employee();
        try {
            connection = Conection.getConection();
            ps = connection.prepareStatement(SQL_READ);
            ps.setInt(1,key);
            rs = ps.executeQuery();
            while (rs.next()){
                dTO.setEmp_id(rs.getInt(1));
                dTO.setFirst_name(rs.getString(2));
                dTO.setLast_name(rs.getString(3));
                dTO.setBirthday(rs.getDate(4));
                dTO.setSex(rs.getString(5));
                dTO.setSalary(rs.getInt(6));
            }
        } catch (SQLException e){
            System.out.println("Error"+e);
        } return dTO;
    }

    @Override
    public List<Employee> readAll() {
        List<Employee> list = new ArrayList<>();
        try {
            connection = Conection.getConection();
            ps = connection.prepareStatement(SQL_READALL);
            rs = ps.executeQuery();
            while (rs.next()){
                Employee dTO = new Employee();
                dTO.setEmp_id(rs.getInt(1));
                dTO.setFirst_name(rs.getString(2));
                dTO.setLast_name(rs.getString(3));
                dTO.setBirthday(rs.getDate(4));
                dTO.setSex(rs.getString(5));
                dTO.setSalary(rs.getInt(6));
                list.add(dTO);
            }
        } catch (SQLException e){
            System.out.println("Error"+e);
        } return list;
    }
}
