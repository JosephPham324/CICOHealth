<%-- 
    Document   : ADMIN
    Created on : Nov 1, 2022, 8:48:18 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADMIN PAGE</title>
        <style>
            .h2 {
                text-align: center;
            }
            .button {
                background-color: #4CAF50;
                width: 100%;
                border: none;
                color: white;
                padding: 10px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                cursor: pointer;
            }

            .button:hover {
                background-color: #3e8e41
            }

            .button:active {
                background-color: #3e8e41;
                box-shadow: 0 5px #666;
                transform: translateY(4px);
            }

            .container {
                padding: 100px;
                height: 200px;
                position: relative;
                border: 3px solid green;
            }

            .center {
               padding: 100px;
                position: absolute;
                top: 50%;
                left: 50%;
                -ms-transform: translate(-50%, -50%);
                transform: translate(-50%, -50%);
            }

        </style>
    </head>
    <body>
        <div class="container"> 
            <div class="center">
                <h2>ADMIN PAGE</h2>
                <form action="admin-control">
                    <input type="submit" class="button" value="ADMIN INFO" name="action"  /> <br>
                    <input type="submit" class="button" value="USER INFO" name="action" /> <br>
                    <input type="submit" class="button" value="EXERCISE MANAGEMENT" name="action" /> <br>
                    <input type="submit" class="button" value="LOG OUT" name="action" /> <br>
                </form>
            </div>

        </div>

    </body>
</html>
