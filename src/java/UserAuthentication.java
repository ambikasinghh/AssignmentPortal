import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserAuthentication extends HttpServlet {

    private PreparedStatement ps,ps1;
    private Connection con;
    
    public void init() {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ProjectData", "root", "root");
        String sql = "SELECT * FROM student WHERE userid=? AND password=?";
        ps = con.prepareStatement(sql);
        ps1= con.prepareStatement("SELECT * FROM faculty where userid=? AND password=?");
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
            
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        String usertype = request.getParameter("usertype");
        String save=request.getParameter("save");

        PrintWriter out = response.getWriter();

        if (usertype.equals("admin")) {
            ServletConfig config = getServletConfig();
            String validId = config.getInitParameter("admin-id");
            String validPw = config.getInitParameter("admin-password");
            if (userid.equals(validId) && password.equals(validPw)) {
                if(save != null){
                    Cookie c1 = new Cookie("id",validId);
                    c1.setMaxAge(60*60*24*7);
                    response.addCookie(c1);
                    
                    Cookie c2 = new Cookie("pw",validPw);
                    c2.setMaxAge(60*60*24*7);
                    response.addCookie(c2);              
                }
                response.sendRedirect("admindashboard.jsp");    //send this request to admindashboard
            }
            else{
                out.println("Invalid Admin Credentials");
            }
        }
        else if (usertype.equals("faculty")){
            try{
                ps1.setString(1, userid);
                ps1.setString(2, password);
                ResultSet rs=ps1.executeQuery();
                boolean found=rs.next();   
                if(found){
                    String status = rs.getString("status");
                    /*if(save != null){
                            Cookie c3 = new Cookie("fid",userid);
                            c3.setMaxAge(60*60*24*7);
                            response.addCookie(c3);
                    
                            Cookie c4 = new Cookie("fpw",password);
                            c4.setMaxAge(60*60*24*7);
                            response.addCookie(c4);
                    }*/
                    HttpSession session = request.getSession();
                    session.setAttribute("fid", userid);
                    
                    if(save != null){
                        HttpSession session2 = request.getSession();
                        session.setAttribute("fpw", password);
                    }
                    
                    if(status.equals("disabled")){
                        response.sendRedirect("FacultyAccountUpdate.jsp");
                    }
                    else{
                        response.sendRedirect("facultydashboard.jsp");
                    }
                }
                else{
                    out.println("Invalid Faculty Account");
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
            
        else if (usertype.equals("student")) {
            //match id and password from student database
            try{
                ps.setString(1, userid);
                ps.setString(2, password);
                ResultSet rs=ps.executeQuery();
                boolean found=rs.next();    ////true-rs-contains-1-row(credentials are correct)//////false-rs-empty-credentials are wrong
                if(found){
                    if(save != null){
                            Cookie c5;
                            c5 = new Cookie("sid",userid);
                            c5.setMaxAge(60*60*24*7);
                            response.addCookie(c5);
                    
                            Cookie c6 = new Cookie("spw",password);
                            c6.setMaxAge(60*60*24*7);
                            response.addCookie(c6);
                    
                        }
                    
                    //RequestDispatcher rd=request.getRequestDispatcher("studentdashboard.jsp");   ///dispatchs to studentdashboard
                    //rd.forward(request, response);
                    response.sendRedirect("studentdashboard.jsp");
                    //out.println("Welcome Student");
                }
                else{
                    out.println("Invalid Student Account");
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
}