<%-- 
    Document   : ADMIN
    Created on : Nov 1, 2022, 8:48:18 PM
    Author     : ASUS
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file = "headfootlink.jsp"%>
        <link rel="stylesheet" href="css/admin.css" />

        <title>JSP Page</title>
        <style>


        </style>
    </head>
    <body>
        <%-- <%@ include file="header.jsp" %> --%>
        <div class="wrapper">
            <div class="container"> 
                <!--                <div class="center">-->
                <h2 style="font-weight: 600;">ADMIN PAGE</h2>
                <form class="form" action="admin-control">
                    <input type="submit" class="button" value="ADMIN INFO" name="action"  /> <br>
                    <input type="submit" class="button" value="USER INFO" name="action" /> <br>
                    <input type="submit" class="button" value="EXERCISE MANAGEMENT" name="action" /> <br>
                    <input type="submit" class="button" value="LOG OUT" name="action" /> <br>
                </form>
                <!--                </div>-->

            </div>
            <ul class="bg-bubbles">
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
            </ul>
        </div>
    </body>
</html>
