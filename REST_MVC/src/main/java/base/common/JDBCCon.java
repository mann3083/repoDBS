package base.common;

import java.sql.*;

public class JDBCCon {
    //Make the connection class static
    private static JDBCCon jdbcConnection = new JDBCCon();


    private static final String DB_DRIVER="org.postgresql.Driver";
    private static final String DB_URL="jdbc:postgresql://127.0.0.1:5432/companydb";
    private static final String DB_USER="postgres";
    private static final String DB_PASSWORD="1234";
    private static Statement stm=null;
    private static ResultSet rs = null;

    private JDBCCon(){
        try {
            Class.forName(DB_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            stm = conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static JDBCCon getJDBCCon(){
        return jdbcConnection;
    }

    public void execute(String queryToRun){
        //SELECT * FROM EMPLOYEE
        try {
            rs = stm.executeQuery(queryToRun);
        while(rs.next()){
            System.out.printf("%10s\t%s\t%s\t%s\n",rs.getString(1),
                    rs.getString(2),rs.getString(3),rs.getString(4));
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public static void main(String[] args) {
       JDBCCon j1 = new JDBCCon();
       j1.execute("SELECT * FROM EMPLOYEE");
    }

}
