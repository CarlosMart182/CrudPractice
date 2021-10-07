package test;

import conection.Conection;
import employeeDAO.EmployeeDAO;
import employeeDTO.Employee;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static EmployeeDAO dao = new EmployeeDAO();
    public static void main(String[] args) {
        //conex();
        //readAll();
        //create();
        //update();
        read();
        //delete();
    }

    private static void delete() {
        System.out.println(dao.delete(3));
    }

    private static void read() {
        //Employee DTO = new Employee();
        System.out.println(dao.read(1));
    }

    private static void update() {
        Employee DTO = new Employee(2,"Daniel","Escobar",new Date(1992/06/15),"M",1300);
        System.out.println(dao.update(DTO));
    }

    private static void create() {
        Employee DTO = new Employee("Melisa","Alas", new Date(1991/06/20),"F",3500);
        System.out.println(dao.create(DTO));
    }

    private static void readAll() {
        List<Employee> lista = new ArrayList<>();
        lista = dao.readAll();
        for (int i=0; i< lista.size();i++){
            System.out.println(lista.get(i).getEmp_id()+ " " +lista.get(i).getFirst_name()+" "+lista.get(i).getLast_name()+" "+
                    lista.get(i).getBirthday()+" "+lista.get(i).getSex()+" "+lista.get(i).getSalary());
        }
    }

    public static void conex(){
        if (Conection.getConection()!=null){
            System.out.println("Si");
        } else {
            System.out.println("No");
        }
    }
}
