<%-- 
    Document   : Statistics.jsp
    Created on : Oct 30, 2022, 7:07:09 AM
    Author     : Pham Nhat Quang CE170036 (FPTU CANTHO)
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
        <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
            />
        <title>Statistics</title>
    </head>
    <body>
        <c:if test="${sessionScope.userID == null}">
            <c:redirect url="home"></c:redirect>
        </c:if>
        <jsp:useBean class="DAO.GoalDAO" id="goalsDAO" scope="page"></jsp:useBean>
        <jsp:useBean class="DAO.MealDAO" id="mealDAO" scope="page"></jsp:useBean>
        <c:set var="goals" value="${goalsDAO.getGoalByID(sessionScope.userID)}"></c:set>
        <c:set var="proteinGoal" value="${goals.getProtein()}"></c:set>
        <c:set var="fatGoal" value="${goals.getFat()}"></c:set>
        <c:set var="carbGoal" value="${goals.getCarb()}"></c:set>
        <c:set var="calorieGoal" value="${goals.getCalories()}"></c:set>
        <c:set var="meals" value="${mealDAO.getMealsGroupedByDate(sessionScope.userID)}" scope="request"></c:set>
        

            <div class="info-container">
                <h1 style="text-align:center">Your statistics</h1>
                
                <table id="stats-table" class="table table-striped table-hover display">
                    <thead>
                        <tr>
                            <th>Month</th>
                            <th>Date</th>
                            <th>Protein (g)</th>
                            <th>Fat (g)</th>
                            <th>Carbs (g)</th>
                            <th>Protein (kcal)</th>
                            <th>Fat (kcal)</th>
                            <th>Carbs (kcal)</th>
                            <th>Calorie (kcal)</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="meal" items="${meals}">
                        <tr>
                            <td>${meal.getMonthYear()}</td>
                            <td>${meal.getMonthDay()}</td>
                            <td><fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${meal.getProteinWeight()}"/></td>
                            <td><fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${meal.getFatWeight()}"/></td>
                            <td><fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${meal.getCarbWeight()}"/></td>
                            <td><fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${meal.getProteinWeight()*4}"/></td>
                            <td><fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${meal.getFatWeight()*9}"/></td>
                            <td><fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${meal.getCarbWeight()*4}"/></td>
                            <td><fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${meal.getTotalCal()}"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
                <tfoot>
                    <tr>
                        <th colspan="2">Goals:</th>
                        <th><fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${proteinGoal}"/></th>
                        <th><fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${fatGoal}"/></th>
                        <th><fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${carbGoal}"/></th>
                        <th><fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${proteinGoal*4}"/></th>
                        <th><fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${fatGoal*9}"/></th>
                        <th><fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${carbGoal*4}"/></th>
                        <th><fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${calorieGoal}"/></th>
                    </tr>
                </tfoot>
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
        <script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>

        <script src="scripts/statistics.js"></script>
    </body>
</html>
