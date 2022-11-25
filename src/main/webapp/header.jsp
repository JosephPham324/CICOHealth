<%-- 
    Document   : header
    Created on : Oct 20, 2022, 8:15:00 PM
    Author     : Group 4
    CE170036  Pham Nhat Quang (today numbers, admin icon)
    CE161025  Tran Thi Ngoc Hieu
--%>

<%@page import="DAO.UserDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="menu-list">
    <ul class="navbar-fixed-top header navbar" id="myHeader" >
        <li class="nav-link"><a class="txt" href="home"><img class="nutrition-logo" src="image/nutrition-logo.png"></a></li>
        <li class="nav-link"><a class="txt" href="#footer">About</a></li>
        <li class="nav-link"><a class="txt" href="search-food">Food</a></li>
        <li class="nav-link"><a class="txt" href="search-exercise">Exercise</a></li>
        <li class="nav-link">
            <div class="dropdown dropdown-toggle" data-id="utilities">
                <span>Utilities</span>
                <div id="utilities" class="dropdown-content">
                    <a href="convert-unit">Utilities</a>
                </div>
            </div>
        </li>
        <c:choose>
            <c:when test = "${sessionScope.userID!=null}">
                <%
                    //String userID = ;
                    int userRole = new UserDAO().getRoleIDByUserID(Integer.parseInt(request.getSession().getAttribute("userID") + ""));
                    if (userRole == 1) {
                        out.println("<li class=\"nav-link\"><a href=\"admin\"><i class=\"fa-solid fa-user-gear\" style=\"color:red;\"></i></a></li>");
                    }
                %>
                <li class="nav-link dropdown-toggle" data-id="user" >
                    <div class="dropdown">
                        <img class="personal-logo"src="image/personal-logo.png" >

                        <div id="user" class="dropdown-content">
                            <a href="user-info">Profile</a>
                            <a href="user-statistics">Nutrition Statistics</a>
                            <a href="user-meals">Added Meals</a>
                            <a href="user-exercises">Added Exercises</a>
                            <a href="logout-control">Log out</a>
                        </div>
                    </div>
                </li>
            </c:when>
            <c:otherwise>
                <li class="nav-link"><a class="txt" href="login">Login</a></li>
                <li class="nav-link"><a class="txt" href="register">Register</a></li>
                </c:otherwise>
            </c:choose>

        <form id="demo-2">
            <input type="search" placeholder="Search">
        </form>
    </ul>
</div>
<c:if test="${sessionScope.userID!=null}">
    <jsp:include page="TodayNumbers.jsp" />
</c:if>