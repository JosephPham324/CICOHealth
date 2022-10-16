<%-- Document : FoodSearch Created on : Oct 13, 2022, 5:45:06 AM Author : Pham
Nhat Quang --%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/foodsearch.css" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
      integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />
    <link
      href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css"
      rel="stylesheet"
    />
    <title>Search Food</title>
  </head>
  <body>
    <section>
      <div class="create-meal">
        <div class="overlay"></div>
        <form id="nameForm" onsubmit="return enterName();">
          <h3>ENTER MEAL NAME</h3>
          <input type="text" name = "name" value="Breakfast">
          <input type="submit" value="SUBMIT" name="submit">
        </form>
        <form action="CreateMeal" id="mealForm" method="post">
          <fieldset>
            <legend>Selected Items</legend>
            <input type="submit" value="CREATE MEAL" name="submit" id="submit">
          </fieldset>
        </form>
      </div>
    </section>

    <header>
      <div class="belly">
        <div class="wrapper">
          <span>0</span>
          <img src="./image/stomach_!.png" alt="Stomach image" />
        </div>
      </div>
    </header>

    <div class="food-search">
      <div class="search-wrapper">
        <label for="search">Search Food</label>
        <form action="#" onsubmit="event.preventDefault();button.click()">
          <div class="input">
            <i class="fa-solid fa-magnifying-glass button"></i>
            <input
              type="text"
              id="search"
              placeholder="Type in some food, for example: brisket cheese"
            />
          </div>
        </form>
      </div>
      <div class="search-results"></div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/scripts/calculations.js"></script>
    <script src="${pageContext.request.contextPath}/scripts/foodsearch.js"></script>
  </body>
</html>
