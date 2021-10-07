package employeeDTO;

import java.sql.Date;
import java.time.LocalDate;

public class Employee {
    private int emp_id;
    private String first_name;
    private String last_name;
    private Date birth_day;
    private String sex;
    private int salary;

    public Employee(String first_name, String last_name, Date birth_day, String sex, int salary) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_day = birth_day;
        this.sex = sex;
        this.salary = salary;
    }

    public Employee() {

    }

    public Employee(int emp_id, String first_name, String last_name, Date birth_day, String sex, int salary) {
        this.emp_id = emp_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_day = birth_day;
        this.sex = sex;
        this.salary = salary;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getBirthday() {
        return birth_day;
    }

    public void setBirthday(Date birthday) {
        this.birth_day = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
