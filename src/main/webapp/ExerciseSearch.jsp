<%-- Document : ExerciseSearch 
Created on : Oct 17, 2022, 2:50:48 PM 
Author : Pham Nhat Quang
--%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Exercise Lookup</title>
        <link rel="stylesheet" href="./css/exercisesearch.css" />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
            integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <%@include file="headfootlink.jsp" %>
    </head>
    <body>
        <jsp:useBean
            id="etDAO"
            class="DAO.ExerciseTypeDAO"
            scope="request"
            ></jsp:useBean>

            <div class="create-exercise">
                <div class="overlay"></div>
                <form action="add-exercise-control" id="exerciseForm" method="post" onsubmit="return ${sessionScope.userID!=null}">
                <fieldset>
                    <legend>Selected Exercise</legend>
                    <p>Note that you have to be logged in to add an exercise</p>
                    <div class="description">
                        <div class="exercise-name">RUNNING</div>
                        <div class="energy-expenditure">
                            <strong
                                ><i class="fa-solid fa-bolt-lightning"
                                >&nbsp;684kcal/h</i
                                ></strong
                            >
                        </div>
                        <div class="duration">
                            <label for="duration">Duration (minutes):</label>
                            <input type="number" name="duration" value="60" />
                        </div>
                        <div class="energy-expenditure totalCal">
                            <strong
                                ><i class="fa-solid fa-bolt-lightning"
                                >&nbsp;684kcal/h</i
                                ></strong
                            >
                        </div>
                        <input type="hidden" name = "exerciseName" value = "">
                        <input type="hidden" name = "description" value = "">
                        <input type="hidden" name = "kcalph" value = "">
                        <input type="hidden" name="kcal">
                    </div>

                    <input type="submit" value="ADD EXERCISE" name="submit" id="submit" />
                    <input type="hidden" value="ADD EXERCISE" name="action">
                </fieldset>
            </form>
        </div>
        <%@include file = "header.jsp" %>
        <section>
            <div class="exercise-search">
                <div class="search-wrapper">
                    <label for="search">Find an exercise</label>
                    <form action="#" onsubmit="event.preventDefault();button.click()">
                        <div class="input">
                            <i class="fa-solid fa-magnifying-glass button"></i>
                            <input
                                type="text"
                                id="search"
                                placeholder="Type in an exercise name, for example: running"
                                />
                        </div>
                    </form>
                </div>
                <div class="search-results"></div>
            </div>
        </section>
        <script src="./scripts/calculations.js"></script>
        <script>
                    let exerciseTypes = [];
            <c:forEach items="${etDAO.getAllExerciseTypes()}" var="item">
                    if (`${item}` !== null) {
                        exerciseTypes.push(new ExerciseType(`${item.getExerciseName()}`, `${item.getDescription()}`,${item.getCalPerHour()}));
                    }
            </c:forEach>
                    console.log(exerciseTypes)
        </script>
        <script src="./scripts/exercisesearch.js"></script>
        <script src = "./scripts/headfootscript.js"></script>
    </body>
</html>
