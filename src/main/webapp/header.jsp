<%-- 
    Document   : header
    Created on : Oct 20, 2022, 8:15:00 PM
    Author     : Pham Nhat Quang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="menu-list">
    <ul class="navbar-fixed-top header navbar" id="myHeader" >
        <li class="nav-link"><a class="txt" href="home"><img class="nutrition-logo" src="image/nutrition-logo.png"></a></li>
        <li class="nav-link"><a class="txt" href="#footer">About</a></li>
        <li class="nav-link"><a class="txt" href="search-food">Food</a></li>
        <li class="nav-link"><a class="txt" href="search-exercise">Exercise</a></li>
            <c:choose>
                <c:when test = "${sessionScope.userID!=null}">
                <li class="nav-link"><a href="admin"><i class="fa-solid fa-user-gear" style="color:red;"></i></a></li>
                <li class="nav-link"><a href="user-meals"><img class="add-food-logo" src="image/addFood-logo.png"></a></li>
                <li class="nav-link"><a href="user-exercises"><img class="add-exercise-logo" src="image/addExercise-logo.png"></a></li>
                <li class="nav-link">
                    <div class="dropdown">
                        <img class="personal-logo" src="image/personal-logo.png" onclick="myDropdownF()">

                        <div id="myDropdown" class="dropdown-content">
                            <a href="user-info">Profile</a>
                            <a href="user-statistics">Nutrition Statistics</a>
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
<%
//    if (request.getSession().getAttribute("userID")!=null){
//    out.println("<jsp:include page=\"TodayNumbers.jsp\"></jsp:include>");
//    }
%>