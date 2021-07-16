import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {

    private PreparedStatement ps;
    private Connection con;
    
    public void init() {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ProjectData", "root", "root");
        String sql = "INSERT INTO student VALUES(?,?,?,?,?,?)";
        ps = con.prepareStatement(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void destroy() {
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        //read-the-request
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        //process-the-request
        try {
            ps.setString(1, userid);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setString(4, address);
            ps.setString(5, email);
            ps.setString(6, mobile);
            ps.executeUpdate();
            //System.out.println("Query Executed.............");
        //provide the response
            out.println("<html>");
            out.println("<body>");
            out.println("<hr>");
            out.println("<h3>Registration Completed</h3>");
            out.println("<hr>");
            out.println("<h4><a href=index.jsp>Login-Now</a></h4>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            //e.printStackTrace();
            out.println(e);
        }
    }
}