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
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>${initParam['webappName']}</title>

        <style>
            .header {
                display: flex;
                justify-content: space-between;
                align-items: center;
                margin: 0 20px;
            }

            .navbar {
                list-style: none;
                display: flex;
                justify-content: center;
                padding: 10px 0;
                margin-bottom: 0;
            }

            .navbar__link {
                margin: 0 34px;
            }

            .banner img {
                width: 100%;
            }

        </style>

    </head>



    <body>
        <c:if test="${cookie.userID!=null}">
            <c:set var="userID" value="${cookie.userID.value}" scope="session"></c:set>
            <c:set var="username" value="${cookie.username.value}" scope="session"></c:set>
        </c:if>
        <c:redirect url="home"/>
        <div class="header">


            <div>
                <a href="test.html"><img src="${pageContext.request.contextPath}/image/logo1.jpg"></a>
            </div>

            <div>
                <ul class="navbar">
                    <li class="navbar__link"><a href="#">Home</a></li>
                    <li class="navbar__link"><a href="#">About</a></li>
                    <li class="navbar__link"><a href="#">Food</a></li>
                    <li class="navbar__link"><a href="#">Exercise</a></li>
                    <li class="navbar__link"><a href="#">Contact</a></li>
                </ul>
            </div>

            <div>
                <form>
                    <input type="text" placeholder="Search in website">
                    <button type="submit">Search</button>
                </form>
            </div>

        </div>

        <div class="banner">

            <img src="${pageContext.request.contextPath}/image/Food.jpg" alt="Chanel" />

        </div>

        <div>
            <div>
                <a href="Login.jsp">Login</a><br>
                <a href="RegisterAccount.jsp">Register</a><br>
            </div>
        </div>
        <script>

        </script>
    </body>
</html>
