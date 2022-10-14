<%-- Document : FoodSearch Created on : Oct 13, 2022, 5:45:06 AM Author : Pham
Nhat Quang --%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="./css/foodsearch.css" />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
            integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <title>Search Food</title>
    </head>
    <body>
        <div class="food-search">
            <div class="search-wrapper">
                <label for="search">Search Food</label>
                <form action = "#"onsubmit="event.preventDefault();button.click()">
                <div class="input">
                    <i class="fa-solid fa-magnifying-glass button"></i>
                    <input type="text" id="search" placeholder="Type in some food, for example: brisket cheese"/>
                </div>
                </form>
            </div>
            <div class="search-results">

                <div class="result">
                    <div class="food">
                        <div class="header">brisket</div>
                        <div class="serving">brisket, 100g</div>
                        <div class="nutrition-facts">
                            <span class="calories">Calories 289.3</span><br />
                            <span class="protein"><i class="fas fa-egg"></i>P 29.1g</span>
                            <span class="fat"><i class="fas fa-cheese"></i>F 18.3g</span>
                            <span class="carbs"
                                  ><i class="fas fa-bread-slice"></i>C 0g</span
                            >
                        </div>
                    </div>
                </div>
                <div class="result">
                    <div class="food">
                        <div class="header">cheese</div>
                        <div class="serving">cheese, 100g</div>
                        <div class="nutrition-facts">
                            <span class="calories">Calories 393.9</span><br />
                            <span class="protein"><i class="fas fa-egg"></i>P 22.7g</span>
                            <span class="fat"><i class="fas fa-cheese"></i>F 33g</span>
                            <span class="carbs"
                                  ><i class="fas fa-bread-slice"></i>C 3.2g</span
                            >
                        </div>
                    </div>
                </div>       
                
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="./scripts/foodsearch.js"></script>
    </body>
</html>
