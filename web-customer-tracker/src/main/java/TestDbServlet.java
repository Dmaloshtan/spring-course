import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = "springstudent";
        String password = "springstudent";
        String jdbcurl = "jdbc:mysql://localhost:3306/web_customer_tracker";
        String driver = "com.mysql.jdbc.Driver";

        try{
            PrintWriter out = resp.getWriter();
            out.println("Connecting to database: " + jdbcurl);
            Class.forName(driver);
            Connection con  = DriverManager.getConnection(jdbcurl,user,password);
            out.println("Connection Success");
            con.close();
        } catch (Exception ex){
            ex.printStackTrace();
            throw new ServletException(ex);
        }

    }
}
