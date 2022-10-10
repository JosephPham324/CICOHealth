<%-- 
    Document   : Create
    Created on : Oct 5, 2022, 10:09:50 AM
    Author     : Thinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Sign up form</h1>
        <form action="createcontrol" method="post">
            loginid : <input type="number" name="loginid"/><br>
            userid:   <input type="number" name="userid"/><br>
            username: <input type="text" name="username"/><br>
            password: <input type="password" name="password"/><br>
            <input type="submit" value="Sign up"/>
        </form>
    </body>
</html>
