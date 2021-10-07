<%
    String fid = (String) session.getAttribute("fid");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Question upload</title>
    </head>
    <body>
        <h1 style="align-content: center">Question Upload</h1>
        <h1 style="align-content: center">Question is uploaded by Faculty <%=fid%></h1>
        <form action="SaveQuestionServlet">
        <pre>

            Subject     <select name="subject">
                            <option>java</option>
                            <option>python</option>
                            <option>oracle</option>
                            <option>dotnet</option>
                            <option>cpp</option>
                            <option>algorithum</option>
                        </select>
            
            Class       <input type="text" name="class"/>

            Number of   <input type="text" name="noques"/>
            questions

            Question    <textarea name="question" rows="4" cols="50"></textarea>

                        <input type="submit" value="Submit"/>
        </pre>
        </form>
    </body>
</html>
