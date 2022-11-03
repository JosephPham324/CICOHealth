<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Exercise</title>
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
    </head>
    <body>
         <a href="admin-exercisetype" class="previous round">Back</a>
        <form action="update-exercisetype" method="post">
            <table>
                <tr>
                    <td>Exercise ID</td>
                    <td>
                        <input value="${ex.exerciseID}" type="text" name="exid" readonly>
                    </td>
                </tr>
                <tr>
                    <td>Exercise name</td>
                    <td>
                        <input value="${ex.exerciseName}" type="text" name="exercisename">
                    </td>
                </tr>

                <tr>
                    <td>Cal/hour</td>
                    <td><input value="${ex.calPerHour}" type="text" name="calperhour"></td>
                </tr>
                
                <tr>
                    <td>Description</td>
                    <td><input value="${ex.description}" type="text" name="description"></td>
                </tr>
                
                <tr>
                    <td></td>
                    <td><button type="submit">Update</button></td>
                </tr>
            </table>
        </form>
    </body>
</html>

