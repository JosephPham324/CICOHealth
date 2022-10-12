<%-- Document : FoodSearch Created on : Oct 13, 2022, 5:45:06 AM Author : Pham
Nhat Quang --%> 
<%@page import="java.io.InputStream"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link
            rel="stylesheet"
            href="${pageContext.request.contextPath}/css/foodsearch.css"
            />
        <title>Search Food</title>
    </head>
    <body>
        <div class="food-search">
            <div class="search-wrapper">
                <label for="search">Search Food</label>
                <input type="text" id="search" />
            </div>
            <div class="search-results">
                <div class="food">
                    <div class="header">Food name</div>
                    <div class="serving">Food name, Serving amount</div>
                    <div class="nutrition-facts">
                        <span class="calories">Calories</span>
                        <span class="protein">Protein</span>
                        <span class="fat">Fat</span>
                        <span class="carbs">Carbs</span>
                    </div>
                </div>
                <div class="food">
                    <div class="header">Food name</div>
                    <div class="serving">Food name, Serving amount</div>
                    <div class="nutrition-facts">
                        <span class="calories">Calories</span>
                        <span class="protein">Protein</span>
                        <span class="fat">Fat</span>
                        <span class="carbs">Carbs</span>
                    </div>
                </div>
                <div class="food">
                    <div class="header">Food name</div>
                    <div class="serving">Food name, Serving amount</div>
                    <div class="nutrition-facts">
                        <span class="calories">Calories</span>
                        <span class="protein">Protein</span>
                        <span class="fat">Fat</span>
                        <span class="carbs">Carbs</span>
                    </div>
                </div>
                <div class="food">
                    <div class="header">Food name</div>
                    <div class="serving">Food name, Serving amount</div>
                    <div class="nutrition-facts">
                        <span class="calories">Calories</span>
                        <span class="protein">Protein</span>
                        <span class="fat">Fat</span>
                        <span class="carbs">Carbs</span>
                    </div>
                </div>
                <div class="food">
                    <div class="header">Food name</div>
                    <div class="serving">Food name, Serving amount</div>
                    <div class="nutrition-facts">
                        <span class="calories">Calories</span>
                        <span class="protein">Protein</span>
                        <span class="fat">Fat</span>
                        <span class="carbs">Carbs</span>
                    </div>
                </div>
                <div class="food">
                    <div class="header">Food name</div>
                    <div class="serving">Food name, Serving amount</div>
                    <div class="nutrition-facts">
                        <span class="calories">Calories</span>
                        <span class="protein">Protein</span>
                        <span class="fat">Fat</span>
                        <span class="carbs">Carbs</span>
                    </div>
                </div>
            </div>
        </div>
        <%
            URL url = new URL("https://api.api-ninjas.com/v1/nutrition?query=1lb brisket and fries");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            InputStream responseStream = connection.getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(responseStream);
            System.out.println(root.path("fact").asText());
        %>
        <script>

        </script>
    </body>
</html>
