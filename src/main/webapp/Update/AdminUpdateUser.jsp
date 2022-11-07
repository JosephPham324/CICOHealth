<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update user</title>
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
        <%
            if (session.getAttribute("AdminRole") == null) {
                response.sendRedirect("error-page");
            }
        %>
         <a href="user-load-control" class="previous round">Back</a>
        <form action="update-control" method="post">
            <table>
                <tr>
                    <td>User ID</td>
                    <td>
                        <input value="${id.userID}" type="text" name="userid" readonly>
                    </td>
                </tr>
                <tr>
                    <td>First name</td>
                    <td>
                        <input value="${id.firstName}" type="text" name="firstName">
                    </td>
                </tr>

                <tr>
                    <td>Last name</td>
                    <td><input value="${id.lastName}" type="text" name="lastName"></td>
                </tr>
                
                <tr>
                    <td>Email</td>
                    <td><input value="${id.email}" type="text" name="email"></td>
                </tr>
                
                 <tr>
                    <td>Phone number</td>
                    <td><input value="${id.phone}" type="text" name="phone"></td>
                </tr>
                
                <tr>
                    <td></td>
                    <td><button type="submit">Update</button></td>
                </tr>
            </table>
        </form>
    </body>
</html>

