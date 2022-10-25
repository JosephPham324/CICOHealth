<%-- 
    Document   : UserFoods
    Created on : Oct 24, 2022, 6:12:28 AM
    Author     : Pham Nhat Quang
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <link rel="stylesheet" href="./css/meals.css" />
        <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
            />
        <title>Your Meals</title>
    </head>
    <body>
        <c:if test="${sessionScope.userID == null}">
            <c:redirect url="search-exercise"></c:redirect>
        </c:if>
        <jsp:useBean
            id="mDAO"
            class="DAO.MealDAO"
            scope="request"
            ></jsp:useBean>
            <div class="edit-form">
                <div class="overlay"></div>

                <div class="create-meal">
                <form action="edit-meal-control" id="mealForm" method="post" onsubmit="return ${sessionScope.userID!=null}">
                    <fieldset>
                        <legend>EDIT MEAL</legend>
                        <input type="submit" value="SUBMIT" name="submit" id="submit">
                    </fieldset>
                </form>
                </div>
            </div>
            <div>
                <div class="info-container">
                    <h1 style="text-align: center">List of your meals</h1>
                    <table
                        class="table table-striped table-hover display"
                        id="meals"
                        title="Meals List"
                        >
                        <thead>
                            <tr>
                                <th scope="col">No.</th>
                                <th scope="col">Date</th>
                                <th scope="col">Time</th>
                                <th scope="col">Name</th>
                                <th scope="col">Protein</th>
                                <th scope="col">Fat</th>
                                <th scope="col">Carbs</th>
                                <th scope="col">Calories</th>
                                <th scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:set var="sumCal" value="${0}"></c:set>
                        <c:set var="sumPro" value="${0}"></c:set>
                        <c:set var="sumFat" value="${0}"></c:set>
                        <c:set var="sumCarb" value="${0}"></c:set>
                        
                        <c:set var="previousDate" value=""></c:set>
                        <c:set var="currentDate" value=""></c:set>
                        <c:set var="index" value ="1"></c:set>
                        <c:set var="meals" value = "${mDAO.getMealsByUserID(sessionScope.userID+'')}"></c:set>
                        <c:forEach items="${meals}" var="item" varStatus="loop">
                            
                            <c:set var="currentDate" value="${item.getDate()}"></c:set>
                            <c:choose>
                                <c:when test="${currentDate!= previousDate && previousDate!=''}">
                                    <c:set var="index" value ="1"></c:set>
                                    <tr class = "dayStat group">
                                        <td></td>
                                        <th scope="row">${previousDate}</th>
                                        <td></td>
                                        <td>Total of day</td>
                                        <td><fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${sumPro}"/></td>
                                        <td><fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${sumFat}"/></td>
                                        <td><fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${sumCarb}"/></td>
                                        <td>
                                            <fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${sumCal}"/>
                                        </td>
                                        <td></td>
                                    </tr>
                                </c:when>
                            </c:choose>
                            <c:set var="sumCal" value="${sumCal+item.getTotalCal()}"></c:set>
                            <c:set var="sumPro" value="${sumPro+item.getProteinWeight()}"></c:set>
                            <c:set var="sumFat" value="${sumFat+item.getFatWeight()}"></c:set>
                            <c:set var="sumCarb" value="${sumCarb+item.getCarbWeight()}"></c:set>
                            <tr>
                                    <td>${index}</td>
                                    <th scope="row">${item.getDate()}</th>
                                    <td>${item.getTime()}</td>
                                    <td>${item.getMealName()}</td>
                                    <td>${item.getProteinWeight()}</td>
                                    <td>${item.getFatWeight()}</td>
                                    <td>${item.getCarbWeight()}</td>
                                    <td>${item.getTotalCal()}</td>
                                    <c:set var="previousDate" value="${currentDate}"></c:set>
                                    <td>
                                        <form action="#" class="item-form" onsubmit="return fillEditForm(${item})">
                                            <button type="submit"><i class="fa-solid fa-pen-to-square edit-button"></i></button>
                                        </form>
                                        |
                                        <form action="delete-meal-control" method="post" class="delete-item-form">
                                            <input type="hidden" name="date" value="${item.getDate()}">
                                            <input type="hidden" name="time" value="${item.getTime()}">
                                            <input type="hidden" name="name" value="${item.getName()}">
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
                                        <td><fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${sumPro}"/></td>
                                        <td><fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${sumFat}"/></td>
                                        <td><fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${sumCarb}"/></td>
                                        <td>
                                            <fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${sumCal}"/>
                                        </td>
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
                                <th scope="col">Protein</th>
                                <th scope="col">Fat</th>
                                <th scope="col">Carbs</th>
                                <th scope="col">Calories</th>
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
        <script src="./scripts/calculations.js"></script>
        <script src="./scripts/meals.js"></script>
    </body>
</html>

