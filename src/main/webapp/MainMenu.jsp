<%-- 
    Document   : MainMenu
    Created on : Oct 8, 2022, 7:57:33 PM
    Author     : ASUS
--%>

<%@page import="DAO.HealthDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="./css/boostrap.css">
        <link rel="stylesheet" href="./css/mainMenu.css" />
        <link rel="stylesheet" href="./css/footer.css">
<!--        <link rel="stylesheet" href="./font/fontawesome-free-6.1.1-web/css/all.min.css"/>-->
        <script src="https://kit.fontawesome.com/1287d4f6f9.js" crossorigin="anonymous"></script>
        <title>Nutrition</title>
    </head>

    <body> 
        <div class="container">   
        </div>
        <div class="menu-list">
            <ul class="navbar header" id="myHeader" >
                <li class="navbar__link"><a href="test.html"><img class="nutrition-logo" src="image/nutrition-logo.png"></a></li>
                <li class="navbar__link"><a href="#">Home</a></li>
                <li class="navbar__link"><a href="#">About</a></li>
                <li class="navbar__link"><a href="#">Food</a></li>
                <li class="navbar__link"><a href="#">Exercise</a></li>
                <li class="navbar__link"><a href="#">Contact</a></li>
                <li class="navbar__link"><a href="#"><img class="add-food-logo" src="image/addFood-logo.png"></a></li>
                <li class="navbar__link"><a href="#"><img class="add-exercise-logo" src="image/addExercise-logo.png"></a></li>
                <li class="navbar__link">
                    <div class="dropdown">
                        <img class="personal-logo" src="image/personal-logo.png" onclick="myDropdownF()">
                        
                        <div id="myDropdown" class="dropdown-content">
                            <a href="HealthInfo.jsp">Edit Health Info</a>
                            <a href="#">Edit User Info</a>
                            <a href="logout">Log out</a>
                        </div>
                    </div></li>
                <form id="demo-2">
                    <input type="search" placeholder="Search">
                </form>
            </ul>
        </div>
    </div> 
    <div class="banner">

        <img src="image/Body-first.jpg" alt="Chanel" />

    </div>
    <div class="banner">

        <img src="image/Body-second.jpg" alt="Chanel" />

    </div>

<!--    <div>
        <div class="float-left">
            <h1>Hello ${username}</h1>

            <p>Remaining = Goal - Food + Exercise</p>
        </div>

    </div>-->
    <jsp:include page="footer.jsp"></jsp:include>
    <script>
        // When the user scrolls the page, execute myFunction
        window.onscroll = function () {
            myFunction();
        };

// Get the header
        var header = document.getElementById("myHeader");

// Get the offset position of the navbar
        var sticky = header.offsetTop;

// Add the sticky class to the header when you reach its scroll position. Remove "sticky" when you leave the scroll position
        function myFunction() {
            if (window.pageYOffset > sticky) {
                header.classList.add("sticky");
            } else {
                header.classList.remove("sticky");
            }
        }

        /* When the user clicks on the button,
         toggle between hiding and showing the dropdown content */
        function myDropdownF() {
            document.getElementById("myDropdown").classList.toggle("show");
        }

// Close the dropdown menu if the user clicks outside of it
        window.onclick = function (event) {
            if (!event.target.matches('.personal-logo')) {
                var dropdowns = document.getElementsByClassName("dropdown-content");
                var i;
                for (i = 0; i < dropdowns.length; i++) {
                    var openDropdown = dropdowns[i];
                    if (openDropdown.classList.contains('show')) {
                        openDropdown.classList.remove('show');
                    }
                }
            }
        }
    </script>

</body>
</html>
