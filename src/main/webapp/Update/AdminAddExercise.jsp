<%-- 
    Document   : demoSlot11
    Created on : Sep 28, 2022, 20:56:41 AM
    Author     : Nguyen Le Quang Thinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <title>Add exercise</title>
        
    </head>
    <body>
         <a href="/Nutrition/admin-control?action=EXERCISE+MANAGEMENT" class="previous round">Back</a>
        <form action = "adminadd-exercise" method = "post">
            <fieldset>
            <legend>Add a new exercise</legend>
            
            <label>Enter exercise id</label>
            <input type ="text" name="exid" placeholder="Please enter exercise ID"/><br>
            
            <label>Enter exercise name</label>
            <input type ="text" name="exercisename" placeholder="Please enter exercise name"/><br>
            
            <label>Cal/hour</label>
            <input type ="text" name="calperhour" placeholder="Please enter calories per hour"/><br>
            
            <label>Description</label>
            <input type ="text" name="description" placeholder="Please enter description"/><br>
            
            <button type ="submit">Submit</button>
            </fieldset>
        </form>
    </body>
</html>
