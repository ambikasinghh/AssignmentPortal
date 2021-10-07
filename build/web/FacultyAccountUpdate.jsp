<%
    String fid = (String) session.getAttribute("fid");
%>
<html>
    <body>
        <h3>Update Your Account</h3>
        <h3>Welcome faculty <%=fid%></h3>
         <hr>
        <form action="FacultyProfileUpdate" method="get">
            <table border="0">
                <tr>
                    <td>Password</td><td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td>Name</td><td><input type="text" name="name"/></td>
                </tr>
                <tr>
                    <td>Address</td><td><input type="text" name="address"/></td>
                </tr>
                <tr>
                    <td>Email</td><td><input type="text" name="email"/></td>
                </tr>
                <tr>
                    <td>Mobile</td><td><input type="text" name="mobile"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Register"/><td><input type="reset" value="Reset"/></td>
                </tr>
            </table>
        </form>
        <hr>
        <a href="index.jsp">Home</a>
    </body>
</html>