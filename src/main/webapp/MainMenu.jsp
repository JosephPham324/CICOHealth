<%-- 
    Document   : MainMenu
    Created on : Oct 8, 2022, 7:57:33 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <%@ include file="header.jsp" %>
        <div class="banner">

            <img src="image/Body-first.jpg" alt="Chanel" />

        </div>
        <div class="banner">

            <img src="image/Body-second.jpg" alt="Chanel" />

        </div>
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
