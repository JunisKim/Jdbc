package kr.re.kitri.northwind;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by danawacomputer on 2017-05-10.
 */
public class InsertDemo {

    public static final String DRIVER_POSTGRES = "org.postgresql.Driver";
    public static final String DB_URL = "jdbc:postgresql://localhost/northwind";
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "12345678";

    public static void main(String[] args) {

        // driver loading
        try {
            Class.forName(DRIVER_POSTGRES);
            System.out.println("driver loading ok...");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query = "INSERT INTO public.categories(\n" +
                "\tcategoryid, categoryname, description)\n" +
                "\tVALUES (?, ?, ?)";

        //get a connection
        try {
            Connection conn =
            DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("connection ok..");

            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,101);
            pstmt.setString(2,"데스크탑");
            pstmt.setString(3,"집에 놓고 쓰는 컴퓨터");
//            pstmt.(4,"");
            pstmt.executeUpdate(); //Insert 일때는 executeUpdate();
            System.out.println("insert ok...");

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
