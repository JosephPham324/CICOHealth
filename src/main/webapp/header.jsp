<%-- 
    Document   : header
    Created on : Oct 20, 2022, 8:15:00 PM
    Author     : Pham Nhat Quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="menu-list">
    <ul class="navbar header" id="myHeader" >
        <li class="navbar__link"><a href="#"><img class="nutrition-logo" src="image/nutrition-logo.png"></a></li>
        <li class="navbar__link"><a href="home">Home</a></li>
        <li class="navbar__link"><a href="#footer">About</a></li>
        <li class="navbar__link"><a href="search-food" target="_blank">Food</a></li>
        <li class="navbar__link"><a href="search-exercise">Exercise</a></li>
        <li class="navbar__link"><a href="#footer">Contact</a></li>
        <c:choose>
            <c:when test = "${sessionScope.userID!=null}">
                <li class="navbar__link"><a href="user-meals" target="_blank"><img class="add-food-logo" src="image/addFood-logo.png"></a></li>
                <li class="navbar__link"><a href="user-exercises" target="_blank"><img class="add-exercise-logo" src="image/addExercise-logo.png"></a></li>
                <li class="navbar__link">
                    <div class="dropdown">
                        <img class="personal-logo" src="image/personal-logo.png" onclick="myDropdownF()">

                        <div id="myDropdown" class="dropdown-content">
                            <a href="user-info">Profile</a>
                            <a href="logout-control">Log out</a>
                        </div>
                    </div>
                </li>
            </c:when>
            <c:otherwise>
                <li class="navbar__link"><a href="login">Login</a></li>
                <li class="navbar__link"><a href="register">Register</a></li>
            </c:otherwise>
        </c:choose>

        <form id="demo-2">
            <input type="search" placeholder="Search">
        </form>
    </ul>
</div>
