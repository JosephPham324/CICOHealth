<%-- 
    Document   : Info
    Created on : Oct 6, 2022, 7:25:14 PM
    Author     : Thinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>
         <h1>Login form</h1>
        <form action="healthinfocontrol" method="post">
            <table>
                <tr>
                          <td> UserID: </td>
                        <td>
                            <input type="number"  name="userid" min="0" max="300">
                        </td>              
                </tr>
            
                 <tr>
                    <td align="right">How active are you? </td>
                    <td>
                        <input name="activity" type="radio" value="1" checked> Not very active
                        <input type="radio" name="activity" value="2"> Lightly active
                        <input type="radio" name="activity" value="3"> Active
                        <input type="radio" name="activity" value="4"> Very active
                    </td>
                </tr>
                
                
                
                <tr>
                    <td>Gender</td>
                    <td>
                        <input name="gender" type="radio" value="Male" checked>Male
                        <input type="radio" name="gender" value="Female"> Female
                    </td>
                </tr>

                
                <tr>
                          <td>Height(cm): </td>
                        <td>
                            <input type="number"  name="height" min="0" max="300">
                        </td>              
                </tr>
                
                <tr>
                          <td>Weight(kg): </td>
                        <td>
                            <input type="number"  name="weight" min="0" max="200">
                        </td>      
                </tr>
                
                                
                 <tr><td>Age</td>
                    <td><input type="number" name="age" min="0" max="100"/></td> 
                </tr>
                      
          
            </table>
            <input type="submit" value="submit"/>
        </form>
    </body>
</html>
