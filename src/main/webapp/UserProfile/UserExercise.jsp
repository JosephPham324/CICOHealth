<%-- 
Document : Exercises.jsp 
Created on : Oct 19, 2022, 11:33:30 AM 
Author : Pham Nhat Quang 
--%> 
<%@page import="Entity.User"%>
<%@page import="Entity.Login"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="DAO.ExerciseDAO"%>
<%@page import="Entity.Exercise"%> <%@page import="java.util.List"%>
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
        <link
            rel="stylesheet"
            href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css"
            />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
            integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <link rel="stylesheet" href="./css/exercises.css" />
        <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
            />
         <style>
            a {
                text-decoration: none;
                display: inline-block;
                padding: 8px 16px;
            }

            a:hover {
                background-color: #ddd;
                color: black;
            }
            .previous {
                background-color: #04AA6D;
                color: white;
            }
            .round {
                border-radius: 50%;
            }
        </style>
        <title>Your Exercises</title>
    </head>
    <body>
         <%
            DAO.LoginDAO lDAO = new DAO.LoginDAO();
            DAO.UserDAO uDAO = new DAO.UserDAO();
            
            String id = (String) session.getAttribute("adminuserID");
            System.out.println(id);

            Login loginInfo = lDAO.getLoginInfo(id);
            User user = uDAO.getUserByID(id);
            String name = user.getFirstName() + " " + user.getLastName();
        %>
        <c:if test="${sessionScope.userID == null}">
            <c:redirect url="search-exercise"></c:redirect>
        </c:if>
        <jsp:useBean
            id="eDAO"
            class="DAO.ExerciseDAO"
            scope="request"
            ></jsp:useBean>
                <a href="/Nutrition/admin-control?action=USER+INFO" class="previous round">Back</a>
                <div class="overlay"></div>
            <div>
                <div class="info-container">
                    <h1 style="text-align: center">List of <%=name%> exercises</h1>
                    <table
                        class="table table-striped table-hover display"
                        id="exercises"
                        title="Exercises List"
                        >
                        <thead>
                            <tr>
                                <th scope="col">No.</th>
                                <th scope="col">Date</th>
                                <th scope="col">Time</th>
                                <th scope="col">Name</th>
                                <th scope="col">Duration</th>
                                <th scope="col">Kcal</th>
                                <th scope="col">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:set var="sumCal" value="${0}"></c:set>
                        <c:set var="sumTime" value="${0}"></c:set>
                        <c:set var="previousDate" value=""></c:set>
                        <c:set var="currentDate" value=""></c:set>
                        <c:set var="index" value ="1"></c:set>
                        <c:forEach
                            items="${eDAO.getExerciseByUserID(sessionScope.adminuserID)}"
                            var="item"
                            varStatus="loop"
                            >
                            <c:set var="currentDate" value="${item.getDate()}"></c:set>
                            <c:choose>
                                <c:when test="${currentDate!= previousDate && previousDate!=''}">
                                    <c:set var="index" value ="1"></c:set>
                                    <tr class = "dayStat group">
                                        <td></td>
                                        <th scope="row">${previousDate}</th>
                                        <td></td>
                                        <td>Total of day</td>
                                        <td>${sumTime}</td>
                                        <td>${sumCal}</td>
                                        <td></td>
                                    </tr>
                                    <c:set var="sumCal" value="${0}"></c:set>
                                </c:when>
                            </c:choose>
                           <c:set var="sumCal" value="${sumCal+item.getCalorie()}"></c:set>
                           <c:set var="sumTime" value="${sumTime+item.getDuration()}"></c:set>
                           <c:set var="previousDate" value="${currentDate}"></c:set>
                                <tr>
                                    <td>${index}</td>
                                    <th scope="row">${item.getDate()}</th>
                                    <td>${item.getTime()}</td>
                                    <td>${item.getName()}</td>
                                    <td>${item.getDuration()}</td>
                                    <td>${item.getCalorie()}</td>
                                    <td>
                                        <form action="#" class="item-form" onsubmit="return fillEditForm(this)">
                                            <input type="hidden" name="date" value="${item.getDate()}">
                                            <input type="hidden" name="time" value="${item.getTime()}">
                                            <input type="hidden" name="name" value="${item.getName()}">
                                            <input type="hidden" name="duration" value="${item.getDuration()}">
                                            <input type="hidden" name="calories" value="${item.getCalorie()}">
                                            <input type="hidden" name="exerciseID" value="${item.getExerciseID()}">
                                            <button type="submit"><i class="fa-solid fa-pen-to-square edit-button"></i></button>
                                        </form>
                                        |
                                        <form action="delete-exercise-control" method="post" class="delete-item-form"
                                              onsubmit = "return askDelete('Are you sure you want to delete this exercise?')">
                                            <input type="hidden" name="date" value="${item.getDate()}">
                                            <input type="hidden" name="time" value="${item.getTime()}">
                                            <button type="submit"><i class="fa-solid fa-xmark"></i></i></button>
                                        </form>
                                    </td>
                                </tr>
                                <c:if test="${loop.last}">
                                    <tr class = "dayStat group">
                                        <td></td>
                                        <th scope="row">${previousDate}</th>
                                        <td></td>
                                        <td>Total of day</td>
                                        <td>${sumTime}</td>
                                        <td>${sumCal}</td>
                                        <td></td>
                                    </tr>
                                    <c:set var="sumCal" value="${0}"></c:set>
                                </c:if>
                                <c:set var="index" value ="${index+1}"></c:set>
                        </c:forEach>
                    </tbody>
                    <tfoot>
                        <tr>
                                <th scope="col">No.</th>
                                <th scope="col">Date</th>
                                <th scope="col">Time</th>
                                <th scope="col">Name</th>
                                <th scope="col">Duration</th>
                                <th scope="col">Kcal</th>
                                <th scope="col">Actions</th>
                        </tr>
                    </tfoot>
                </table>
            </div>
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
        <script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
        <script src="./scripts/exercises.js"></script>
    </body>
</html>