<%-- 
    Document   : assignmentupload
    Created on : 3 Jun, 2021, 12:21:08 AM
    Author     : Ambika Singh
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload Assignment</title>
        <link rel = "icon" href = "title_iconn.ico" type = "image/x-icon">
       
    </head>
    <body>
        <h1>Upload Assignment</h1>
        <hr>
        <form action="AssignmentUpload" method="post" enctype="multipart/from-data">
        <pre
            sid         <input type="text" name="sid"/>
            
            Class       <input type="text" name="class"/>
            
            Ques Code   <input type="text" name="qcode"/> 
            
            Upload->    <input type="file" name="file"/> 
            
                        <input type="submit" value="Submit"/>
        </pre>
        </form>
        <hr>
    </body>
</html>
