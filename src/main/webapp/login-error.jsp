<%-- 
    Document   : login-error
    Created on : Oct 6, 2022, 11:35:56 PM
    Author     : Group 4
    CE161130  Nguyen Le Quang Thinh (Leader)
    CE170036  Pham Nhat Quang
    CE160464  Nguyen The Lu
    CE161096  Nguyen Ngoc My Quyen
    CE161025  Tran Thi Ngoc Hieu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/login.css" />
        <link rel="icon" type="image/png" href="favicon.png"/>

        <title>Login</title>
    </head>
    <body>
        <c:if test="${sessionScope.userID != null}">
            <c:redirect url="home"></c:redirect>
        </c:if>
        <section style="background-image: url('image/login.jpg');">
            <div class="form-container">
                <h1>Login form</h1>
                <form action="login-control" method="post">
                    <div class="page-header align-items-start min-vh-100"  loading="lazy">
                        <span class="mask bg-gradient-dark opacity-6"></span>
                        <div class="container my-auto">
                            <div class="row">
                                <div class="col-lg-4 col-md-8 col-12 mx-auto">
                                    <div class="card z-index-0 fadeIn3 fadeInBottom">
                                        <div class="card-body">
                                            <!--USERNAME INPUT-->
                                            <div class="input-group">

                                                <div class="control">
                                                    <label class="form-label">Username</label>
                                                    <input type="text" required name="username" class="form-control" required>
                                                </div>
                                                <!--PASSWORD INPUT-->
                                                <div class="control">
                                                    <label class="form-label">Password</label>
                                                    <input type="password" required name="password" class="form-control"required>
                                                </div>
                                                <div class="remember">
                                                    <input type="checkbox" name="remember" class="form-control" value = "remember">
                                                    <label class="form-label">&nbsp;&nbsp;Remember me</label>
                                                </div>
                                                <!--SUBMIT BUTTON-->
                                                <div class="huhu">
                                                    <input type="submit" name="action" value="Login">
                                                </div>
                                                <!--SIGN UP LINK!-->
                                                <p class="sigup">
                                                    Not registered?
                                                    <a href="register" class="text-primary text-gradient font-weight-bold">Create an account</a>
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                </form>
            </div>
            <div id="txtError" style="color:red">
                Your username or password is not correct!!
            </div>
        </section>
    </body>
    <script>
        document.getElementById('txtError').style.display = 'block';
    </script>
</html>