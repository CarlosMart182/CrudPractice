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
        create();
    }

    private static void create() {
        Employee DTO = new Employee(110,"Maria","Rodriguez", new Date(1992/01/21),"M",2500);
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
