<%-- 
    Document   : UserInfo
    Created on : Oct 9, 2022, 7:35:44 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User info</title>
    </head>
        <body>
         <h1>User info</h1>
        <form action="userinfocontrol" method="post">
            <table>
                <tr>
                          <td> UserID: </td>
                        <td>
                            <input type="number"  name="userid" min="0" max="300">
                        </td>              
                </tr>
            
                 <tr>
                          <td> Login ID: </td>
                        <td>
                            <input type="number"  name="loginid" min="0" max="300">
                        </td>              
                </tr>
                
                 <tr>
                          <td> User  role ID: </td>
                        <td>
                            <input type="number"  name="roleid" min="0" max="300">
                        </td>              
                </tr>
                
                
                <tr>
                    <td> First name: </td>
                    <td>
                        <input type="text" name="fname"/>           
                    </td>
                </tr>
                
                <tr>
                    <td> Last name: </td>
                    <td>
                        <input type="text" name="lname"/>           
                    </td>
                </tr>
                
                <tr>
                    <td> Email: </td>
                    <td>
                        <input type="text" name="email"/>           
                    </td>
                </tr>
                
                <tr>
                    <td> Phone number:  </td>
                    <td>
                        <input type="text" name="phone"/>           
                    </td>
                </tr>
          
            </table>
            <input type="submit" value="Submit"/>
        </form>
    </body>
</html>
