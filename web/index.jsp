<%
    //reading cookies
    //step-1    (fetch all cookies coming with request)
    Cookie ck[]=request.getCookies();
    //step-2    (search for desired one)
    //searching for 2 cookies (id,pw)
    String v1="",v2="";
    
        for(Cookie c:ck){
            String name=c.getName();
            if(name.equals("id")){
                v1=c.getValue();
            }else if(name.equals("pw") ){
                v2=c.getValue();
            }
        }
    
%>

<html>
    <head>
        <!--<title>Assignment Portal Login</title>-->
        <!--<link rel="stylesheet" type="text/css" href="style_login_page.css">-->
        <link rel="stylesheet" type="text/css" href="fontawesome/css/all.min.css">
	<link rel="stylesheet" type="text/css" href="style2.css">
        <link rel = "icon" href = "title_iconn.ico" type = "image/x-icon">
        <title>Assignment Portal</title>
    </head>
    <!--<body>
        <%@include file="header.jsp"%>

        <hr>
        <section>
            <div class="container">
                <form action="UserAuthentication" method="post">
                    <table border="0">
                        <tr>
                            <td>Userid</td><td><input type="text" name="userid" value="<%=v1%>"/></td>
                        </tr>
                        <tr>
                            <td>Password</td><td><input type="password" name="password" value="<%=v2%>"/></td>
                        </tr>
                        <tr>
                            <td>Usertype</td><td><select name="usertype"><option>admin</option><option>faculty</option><option>student</option></select></td>
                         </tr>
                         <tr>
                            <td>Save Password</td><td><input type="checkbox" name="save" value="yes"/></td>
                         </tr>
                         <tr>
                            <td><input type="submit" value="Login"/><td>input type="checkbox" name="save" value="yes"/></</td>
                         </tr>
                    </table>
                </form>
            </div>
        </section>
        <a href="registration.jsp">New-Student-Registration</a>
    </body>-->
        <body>
    <h2 style="text-align: center; color:white; font-size: 45px;">XYZ College Assignment Portal</h2>
 <div class="container">
 	<div class="header">
 		<h1>Login Form</h1>
 	</div>
 	<div class="main">
            <form action="UserAuthentication" method="post">
 			<span>
 				<i class="fa fa-user"></i>
 				<input type="text" placeholder="userid" name="userid">
 			</span><br>
 			<span>
 				<i class="fa fa-lock"></i>
 				<input type="password" placeholder="password" name="password">
 			</span><br>
                        <span>
 				<!--<i class="fa fa-lock"></i>-->
                                <label for="usertype" style="color:green;"><b>Usertype</b></label>
                                <select name="usertype" id="usertype" style="width: 225px; height: 40px;">
                                    <option value="" disabled selected>Usertype</option>
                                    <option>admin</option>
                                    <option>faculty</option>
                                    <option>student</option>
                               </select>
 			</span><br>
                        <span>
 				<!--<i class="fa fa-lock"></i>-->
 				<input type="checkbox" name="save" id="save" value="yes" style="width: 20px; height: 20px;"/>
                                <label for="save" style="color:green;"><b>Remember Me</b></label><br>
 			</span><br>
                                <th><button type="submit" value="login">Submit</button>
                                <th><button type="reset"  value="Reset">Reset</button>
 		</form>
 	</div>
     <a href="registration.jsp" style="color:green; align-content: center;">
         <button class="container main">New-Student-Registration</button>
     </a>
 </div>
</body>
</html>