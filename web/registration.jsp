<!--<html>
    <body>
        <h3 style="text-align: center; color: green; font-size: 40px">Student-Registration-Form</h3>
         <hr>
        <form action="RegistrationServlet" method="get">
            <table border="0">
                <tr>
                    <td>Userid</td><td><input type="text" name="userid"/></td>
                </tr>
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
        <a href="index.jsp" >Home</a>
    </body>
</html>-->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel = "icon" href = "title_iconn.ico" type = "image/x-icon">
    <title>Student Registration</title>
    <link href="registration.css" rel="stylesheet">
</head>
<body>
    <div class="warpper fl">
        <div class="main">
            <div class="head">
                <p>Student Registration Form</p>
            </div>
            <div class="form fl">
                <form action="RegistrationServlet" method="get">
                    <p class="name">User ID :</p>
                    <p><input type="text" name="userid" placeholder="User Id" class="name-inp"></p>
                    
                    <p class="name">Name * :</p>
                    <p><input type="text" name="name" placeholder="Name" class="name-inp"></p>
                    
                    <p class="name">Password * :</p>
                    <p><input type="password" name="password" placeholder="Password" class="pass">
                       <!--<input type="password" name="pass" placeholder="Conform Password" class="pass">-->
                    </p>
                    
                    <p class="name">Address * :</p>
                    <p><input type="text" name="address" placeholder="Address" class="name-inp"></P>
                    
                    <p class="name">Email * :</p>
                    <p><input type="email" name="email" placeholder="Email" class="name-inp"></p>
                    
                    <p class="name">Phone * :</P>
                    <p><input type="text" name="phone" placeholder="Phone" class="name-inp"></p>
                    
                    <!--<p class="gender"><span class="gen">Gender</span>
                        <input type="checkbox" name="ge" class="genm">Male
                        <input type="checkbox" name="ge" class="genm">Female
                    </p>-->

                    <p><input type="submit" name="sb" value="SUBMIT" class="sub"></p>
                </form>
            </div>
        </div>
    </div>
</body>
</html>