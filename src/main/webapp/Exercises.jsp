<%-- 
    Document   : Exercises.jsp
    Created on : Oct 19, 2022, 11:33:30 AM
    Author     : Pham Nhat Quang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="DAO.ExerciseDAO"%>
<%@page import="Entity.Exercise"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
            />
        <title>Your Exercises</title>
    </head>
    <body>
        <jsp:useBean
            id = "eDAO"
            class = "DAO.ExerciseDAO"
            scope="request"
            ></jsp:useBean>
            <div class="header">Your exercises</div>
            <div class="info-container">
                <table class="table table-striped table-hover">
                    <caption>List of exercises</caption>
                    <thead>
                        <tr>
                            <th scope="col">Date</th>
                            <th scope="col">Time</th>
                            <th scope="col">Name</th>
                            <th scope="col">Duration</th>
                            <th scope="col">Kcal</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${eDAO.getExerciseByUserID(sessionScope.userID)}" var="item">
                        <tr>
                            <th scope="row">${item.getDate()}</th>
                            <td>${item.getTime()}</td>
                            <td>${item.getName()}</td>
                            <td>${item.getDuration()}</td>
                            <td>${item.getCalorie()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <script
            src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"
        ></script>
        <script
            src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"
        ></script>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"
        ></script>
    </body>
</html>

