import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni";
        String user = "hbstudent";
        String pass = "hbstudent";

        try{
            System.out.println("Connecting to Database: " + jdbcUrl);
            Connection con = DriverManager.getConnection(jdbcUrl,user,pass);
            System.out.println("Connecting successful");
        } catch (SQLException ex){
            ex.printStackTrace();
        }

        System.out.println(Byte.MAX_VALUE);

    }
}
