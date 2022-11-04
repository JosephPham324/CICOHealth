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
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
      integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />
    <link
      href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css"
      rel="stylesheet"
    />
    <style>
      body {
        width: 100vw;
        height: 100vh;
        margin: 0;
      }
      section {
        width: 100%;
        height: 100%;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        background-color: rgb(39, 121, 14);
      }
      h1 {
        font-size: 2rem;
        color: white;
      }
      a {
        width: 200px;
        height: 50px;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        background-color: red;
        color: white;
        text-decoration: none;
      }
      .exclamation {
        top: 20%;
        color: red;
        font-size: 72px;
        position: absolute;
      }
      .exclamation.left{
        left: 20%;
      }
      .exclamation.right {
        right: 20%;
      }
      .alert{
        color: red;
        font-size: 72px;
        position: absolute;
        top: 20%;
        pointer-events: none;
      }
    </style>
  </head>
  <body>
    <section>
      <span class="alert">ERROR 404</span>
      <div class="exclamation left">
        <i class="fa-solid fa-exclamation left"></i>
        <i class="fa-solid fa-exclamation left"></i>
        <i class="fa-solid fa-exclamation left"></i>
      </div>
      <div class="exclamation right">
        <i class="fa-solid fa-exclamation "></i>
        <i class="fa-solid fa-exclamation left"></i>
        <i class="fa-solid fa-exclamation left"></i>
      </div>
      

      <h1>
        <strong>Oops, the page you're looking for isn't available</strong>
      </h1>
      <a href="${pageContext.request.contextPath}/home-control"
        >RETURN TO HOMEPAGE</a
      >
    </section>
  </body>
</html>


