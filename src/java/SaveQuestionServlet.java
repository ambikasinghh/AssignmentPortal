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

public class SaveQuestionServlet extends HttpServlet {

    private PreparedStatement ps;
    private Connection con;
    
    public void init() {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ProjectData", "root", "root");
        String sql = "insert into quesbank(question,sdate,fid,subject) values(?,?,?,?)";
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

        HttpSession session = request.getSession();
        String userid = (String) session.getAttribute("fid");
        PrintWriter out = response.getWriter();
        //read-the-request
        String question = request.getParameter("question");
        String subject = request.getParameter("subject");
        
        //date
        java.util.Date dt=new java.util.Date();
        long val = dt.getTime();
        java.sql.Date sqlDate=new java.sql.Date(val);
        //out.println(sqlDate);
        //process-the-request
        
        try {
            ps.setString(1, question);
            ps.setDate(2, sqlDate);
            ps.setString(3, userid);
            ps.setString(4, subject);
            ps.executeUpdate();
            //System.out.println("Query Executed.............");
        //provide the response
            out.println("<html>");
            out.println("<body>");
            out.println("<hr>");
            out.println("<h3>Question Uploaded Successfully</h3>");
            out.println("<hr>");
            out.println("<h4><a href=facultydashboard.jsp>Back to Dashboard</a></h4>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            //e.printStackTrace();
            out.println(e);
        }
    }
}