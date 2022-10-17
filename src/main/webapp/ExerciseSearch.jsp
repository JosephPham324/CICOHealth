<%-- Document : ExerciseSearch Created on : Oct 17, 2022, 2:50:48 PM Author : M
S I --%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Exercise Lookup</title>
  </head>
  <body>
    <jsp:useBean
      id="etDAO"
      class="DAO.ExerciseTypeDAO"
      scope="request"
    ></jsp:useBean>

    <section>
      <header>
        <div class="add-exercise">
          <button></button>
        </div>
      </header>
    </section>

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
        <div class="search-results">
          <div class="result">
            <header>
              <div class="icon"></div>
            </header>
            <div class="description">
              <div class="exercise-name">RUNNING</div>
              <div class="exercise-description">Average effort, 55kg</div>
              <div class="energy-expenditure">684kcal/h</div>
            </div>
          </div>
          <div class="result">
            <header>
              <div class="icon"></div>
            </header>
            <div class="description">
              <div class="exercise-name">RUNNING</div>
              <div class="exercise-description">Average effort, 55kg</div>
              <div class="energy-expenditure">684kcal/h</div>
            </div>
          </div>
          <div class="result">
            <header>
              <div class="icon"></div>
            </header>
            <div class="description">
              <div class="exercise-name">RUNNING</div>
              <div class="exercise-description">Average effort, 55kg</div>
              <div class="energy-expenditure">684kcal/h</div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <script src="./scripts/calculations.js"></script>
    <script src="./scripts/exercisesearch.js"></script>
    <script>
        let exerciseTypes=[];
      <c:forEach items="${etDAO.getAllExerciseTypes()}" var="item">
        if (`${item}`!==null){
            exerciseTypes.push(new ExerciseType(`${item.getExerciseName()}`,`${item.getDescription()}`,${item.getCalPerHour()}));
        }
      </c:forEach>
    </script>
  </body>
</html>
