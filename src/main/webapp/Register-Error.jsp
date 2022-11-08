<%-- 
    Document   : login-error
    Created on : Oct 6, 2022, 11:35:56 PM
    Author     : Group 4
    CE161130  Nguyen Le Quang Thinh (Leader)
    CE170036  Pham Nhat Quang
    CE160464  Nguyen The Lu
    CE161096  Nguyen Ngoc My Quyen
    CE161025  Tran Thi Ngoc Hieu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <%@ include file="RegisterAccount.jsp" %>  
    </body>
    <script>
        document.getElementById("ErrorDuplicate").style.display = 'block';
    </script>
</html>