package conection;

import java.sql.*;

import static java.lang.Class.forName;

public class Conection {
    private static final String URL = "jdbc:mysql://localhost:3306/Giraffe";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "cmartinez";
    private static final String PASSWORD = "martinez@92";
    private static Connection cx =null;
    public static Connection getConection(){
        try {
            if(cx == null){
                Class.forName(DRIVER);
                cx = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } return cx;
    }

}
