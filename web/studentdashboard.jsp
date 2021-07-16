
<!--
%@taglib uri="/web-inf/tlds/lib1.tld" prefix="mytag" %>-->
<html>
    <head>
        <title>Student Dashboard</title>
        <link rel = "icon" href = "title_iconn.ico" type = "image/x-icon">
        <style>
            div {
                background-image: url('img_girl.jpg');
            }
        </style>
    </head>
    <body>
        <h1 style="text-align: center; padding-top: 50px;">Student Dashboard</h1>
        <hr>
            <p style="text-align: center">
               <a href="SubjectListServlet">View Questions Subject Wise</a>
               <br>
               <a href="#">View Questions Date Wise</a>
               <br>
               <a href="assignmentupload.jsp">Upload Solution</a>
               <br>
               <a href="EndSession">Logout</a>
            </p>
        <hr>
        <h3 style="text-align: center">question</h3>
        <hr>
        <!--mytag:Questions/>-->
    </body>
</html>
