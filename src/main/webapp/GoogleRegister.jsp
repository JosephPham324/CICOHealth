<%-- 
    Document   : GoogleRegister
    Created on : Dec 14, 2022, 3:04:27 PM
    Author     : Pham Nhat Quang CE170036 (FPTU CANTHO)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <header>
            <h1 style="text-align: center;">You have registered with Google</h1>
        </header>
        <main style="display: flex;flex-direction: column; align-items: center; justify-content: center;">
            <h2>You can now login with Google or use the following credentials:</h2>
            <p>Username: ${requestScope.username}</p>
            <p>Password: ${requestScope.password}</p>
            <form action="healthinfo" method="get">
                <input type="hidden" id = "userID" name="userID" value="${requestScope.userID}">
                <input type="submit" value="PROCEED TO NEXT STEPS">
            </form>
        </main>
    </body>
</html>
