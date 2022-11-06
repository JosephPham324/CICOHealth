<%-- 
    Document : Exercises.jsp 
    Created on : Oct 19, 2022, 11:33:30 AM 
    Author : Pham Nhat Quang 
--%> 
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
        <title>Your Exercises</title>
    </head>
    <body>
        <c:if test="${sessionScope.userID == null}">
            <c:redirect url="search-exercise"></c:redirect>
        </c:if>
        <jsp:useBean
            id="eDAO"
            class="DAO.ExerciseDAO"
            scope="request"
            ></jsp:useBean>
            <div class="edit-form">
                <div class="overlay"></div>

                <form action="home-control" method = "post" id = "editForm">
                    <fieldset class="form-group">
                        <legend>EDIT EXERCISE</legend>
                        <div class="form-group row">
                            <label for="date" class="col-4 col-form-label">Date</label>
                            <div class="col-8">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                    </div>
                                    <input
                                        id="date"
                                        name="date"
                                        placeholder="Enter the new date"
                                        type="date"
                                        readonly
                                        class="form-control"
                                        />
                                </div>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="time" class="col-4 col-form-label">Time</label>
                            <div class="col-8">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text">
                                            <i class="fa fa-clock-o"></i>
                                        </div>
                                    </div>
                                    <input
                                        id="time"
                                        name="time"
                                        placeholder="Enter the new time"
                                        type="time"
                                        readonly
                                        class="form-control"
                                        />
                                </div>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="exerciseName" class="col-4 col-form-label">Name</label>
                            <div class="col-8">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text">
                                            <i class="fa fa-y-combinator"></i>
                                        </div>
                                    </div>
                                    <input
                                        id="exerciseName"
                                        name="exerciseName"
                                        type="text"
                                        class="form-control"
                                        readonly
                                        />
                                </div>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="duration" class="col-4 col-form-label">Duration</label>
                            <div class="col-8">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text">
                                            <i class="fa fa-clock-o"></i>
                                        </div>
                                    </div>
                                    <input
                                        id="duration"
                                        name="duration"
                                        placeholder="Enter the new duration"
                                        type="number"
                                        value ="0.0"
                                        step ="0.1"
                                        class="form-control"
                                        />
                                </div>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="calorie" class="col-4 col-form-label">Calories</label>
                            <div class="col-8">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text">
                                            <i class="fa fa-bolt"></i>
                                        </div>
                                    </div>
                                    <input
                                        id="calorie"
                                        name="calorie"
                                        type="number"
                                        value ="0.0"
                                        step ="0.1"
                                        class="form-control"
                                        readonly
                                        />
                                </div>
                            </div>
                        </div>
                        <input type="hidden" name="exerciseID" value = "">
                        <input type ="hidden" name="action" value="EDIT EXERCISE">
                        <div class="form-group row">
                            <div class="offset-4 col-8">
                                <button name="submit" type="submit" class="btn btn-primary">
                                    Submit
                                </button>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
            <div>
                <div class="info-container">
                    <h1 style="text-align: center">List of your exercises</h1>
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
                            items="${eDAO.getExerciseByUserID(sessionScope.userID)}"
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
                                    <form action="home-control" method="post" class="delete-item-form"
                                          onsubmit = "return askDelete('Are you sure you want to delete this exercise?')">
                                        <input type="hidden" name="date" value="${item.getDate()}">
                                        <input type="hidden" name="time" value="${item.getTime()}">
                                        <input type="hidden" name="action" value="DELETE EXERCISE">
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