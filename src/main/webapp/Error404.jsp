<%-- 
    Document   : Error404
    Created on : Nov 3, 2022, 10:54:25 AM
    Author     : Pham Nhat Quang CE170036 (FPTU CANTHO)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Resource not found</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            body{
                width:100vw;
                height:100vh;
                margin: 0;
            }
            section{
                width:100%;
                height:100%;
                display:flex;
                flex-direction:column;
                align-items:center;
                justify-content:center;
                background-color: antiquewhite;
            }
            h1{
                font-size: 2rem;
            }
            a{
                width: 200px;
                height: 50px;
                display:flex;
                flex-direction:column;
                align-items:center;
                justify-content:center;
                background-color: red;
                color: white;
                text-decoration: none;
            }
        </style>
    </head>
    <body>
        <section>
            <h1><strong>Oops, the page you're looking for isn't available</strong></h1>
            <a href="${pageContext.request.contextPath}/home-control">RETURN TO HOMEPAGE</a>
        </section>
    </body>
</html>

