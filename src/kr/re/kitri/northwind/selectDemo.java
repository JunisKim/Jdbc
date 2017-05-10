package kr.re.kitri.northwind;

import java.sql.*;

/**
 * Created by danawacomputer on 2017-05-10.
 */
public class selectDemo {
    public static final String DRIVER_POSTGRES = "org.postgresql.Driver";
    public static final String DB_URL = "jdbc:postgresql://localhost/northwind";
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "12345678";

    public static void main(String[] args) {
        try {
            Class.forName(DRIVER_POSTGRES);
            System.out.println("driver loading ok..");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query = "select customerid, " +
                        "      companyname, " +
                        "      address, " +
                        "      contactname, " +
                        "      city, " +
                        "      phone " +
                        "from  customers " +
                        "order by contactname"; //쿼리는 반드시 검증된 커리를 가져와야한다.

        try {
            Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);

            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery(); //2차원 배열 형태의 데이터 반환

            while (rs.next()){ //rs.next() -> bollean false 값 리턴
                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.print(rs.getString(3) + "\t");
                System.out.print(rs.getString(4) + "\t");
                System.out.print(rs.getString(5) + "\t");
                System.out.print(rs.getString(6) + "\t");
            }
            rs.next(); //nextLine 과 유사한 메서드, 첫번째 레코드로 커서 이동
//            rs.next(); //nextLine 과 유사한 메서드, 두번째 레코드로 커서 이동
//            rs.next(); //nextLine 과 유사한 메서드, 세번째 레코드로 커서 이동
//            rs.previous();


            conn.close();
            System.out.println("connection closed");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
