<%@page import="Entity.DailyNutritionGoal"%>
<%@page import="Entity.UserHealthInfo"%>
<%@page import="Entity.User"%>
<%@page import="Entity.Login"%>
<%@page import="DAO.HealthDAO"%>
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
        <link rel="stylesheet" href="css/adminuserinfo.css">
        <title>Users Info</title>
        <style>
            .container {
                height: 1000px;
                position: relative;
                border: 3px solid green;
            }

            .center {
                margin: 0;
                position: absolute;
                top: 50%;
                left: 50%;
                -ms-transform: translate(-50%, -50%);
                transform: translate(-50%, -50%);
                
            }
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

    </head>
    <body>
        <%
            DAO.LoginDAO lDAO = new DAO.LoginDAO();
            DAO.UserDAO uDAO = new DAO.UserDAO();
            DAO.HealthDAO hDAO = new HealthDAO();
            DAO.GoalDAO gDAO = new DAO.GoalDAO();
            String id = request.getParameter("userid").toString();
            System.out.println(id);

            Login loginInfo = lDAO.getLoginInfo(id);
            User user = uDAO.getUserByID(id);
            String name = user.getFirstName() + " " + user.getLastName();
            UserHealthInfo healthInfo = hDAO.findUserHealthInfo(Integer.parseInt(id));
            DailyNutritionGoal goals = gDAO.getGoalByID(Integer.parseInt(id));


        %>
         <a href="/Nutrition/admin-control?action=USER+INFO" class="previous round">Back</a>
        <div class="container">
            <div class="center">
                <h1><%=name%>'s Health Information</h1>
                <div class="field">
                    <div class="label">Age:</div>
                    <span class="field-value" id="age-value"><%=healthInfo.getAge()%></span>
                    <button class="edit"><i class="fa-solid fa-pen-to-square edit-button"></i></button>
                </div>
                <div class="field">
                    <div class="label">Gender:</div>
                    <span class="field-value" id="gender-value"><%=healthInfo.getGender()%></span>
                    <button class="edit"><i class="fa-solid fa-pen-to-square edit-button"></i></button>
                </div>
                <div class="field">
                    <div class="label">Height:</div>
                    <span class="field-value"><%=healthInfo.getHeight()%></span>
                    <span>cm</span>
                    <button class="edit"><i class="fa-solid fa-pen-to-square edit-button"></i></button>
                </div>
                <div class="field">
                    <div class="label">Weight:</div>
                    <span class="field-value"><%=healthInfo.getWeight()%></span>
                    <span>kg</span>
                    <button class="edit"><i class="fa-solid fa-pen-to-square edit-button"></i></button>
                </div>
                <div class="field">
                    <div class="label">Activeness:</div>
                    <span class="field-value"><%=healthInfo.getActivenessString()%></span>
                    <button class="edit"><i class="fa-solid fa-pen-to-square edit-button"></i></button>
                </div>
            </div>
        </div>

    </body>
</html>