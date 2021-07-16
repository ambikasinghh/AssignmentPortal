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
import javax.servlet.http.HttpSession;

public class FacultyProfileUpdate extends HttpServlet {

    private PreparedStatement ps;
    private Connection con;
    
    public void init() {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ProjectData", "root", "root");
        String sql = "update faculty set password=?, address=?, email=?,mobile=?, status='enable' where userid=?";
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
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        HttpSession session = request.getSession();
        String userid = (String) session.getAttribute("fid");
        //process-the-request
        try {
            ps.setString(1, password);
            ps.setString(2, address);
            ps.setString(3, email);
            ps.setString(4, mobile);
            ps.setString(5, userid);
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