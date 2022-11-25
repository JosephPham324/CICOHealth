<%-- 
    Document   : MainMenu
    Created on : Oct 8, 2022, 7:57:33 PM
    Author     : Group 4
    CE161130  Nguyen Le Quang Thinh (Leader)
    CE170036  Pham Nhat Quang
    CE160464  Nguyen The Lu
    CE161096  Nguyen Ngoc My Quyen
    CE161025  Tran Thi Ngoc Hieu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="DAO.HealthDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <%@ include file = "headfootlink.jsp"%>
        <title>${initParam['webappName']}</title>
    </head>

    <body>
        <%@ include file="header.jsp" %>
        <div class="banner">

            <img src="image/Body-first.jpg" alt="Chanel" />

        </div>
        <div class="banner">

            <img src="image/Body-second.jpg" alt="Chanel" />

        </div>
        <jsp:include page="footer.jsp"></jsp:include>
        <!--<script src="scripts/headfootscript.js"></script>-->
    </body>
</html>
