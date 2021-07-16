<%
    String fid = (String) session.getAttribute("fid");
    
%>
<html>
    <head>
        <title>Faculty Dashboard <%=fid%></title>
    </head>
    <body>
        <h1>Faculty Dashboard</h1>
        <h3>Welcome faculty <%=fid%></h3>
        <hr>
            <pre>
               <a href="Questionload.jsp">Upload Questions</a>

               <a href="EndSession">Logout</a>
            </pre>
        <hr>
    </body>
</html>
