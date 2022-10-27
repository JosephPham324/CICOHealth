<%-- 
    Document   : Login
    Created on : Oct 4, 2022, 10:11:09 PM
    Author     : Thinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/login.css" />
        <title>Login</title>
    </head>

    <body>
        <section style="background-image: url('${pageContext.request.contextPath}/image/login.jpg');">
            <div class="form-container">
                <h1>Login form</h1>
                <form action="login-control" method="post">
                    <div class="page-header align-items-start min-vh-100"  loading="lazy">
                        <span class="mask bg-gradient-dark opacity-6"></span>
                        <div class="container my-auto">
                            <div class="row">
                                <div class="col-lg-4 col-md-8 col-12 mx-auto">
                                    <div class="card z-index-0 fadeIn3 fadeInBottom">
                                        <!--                                        <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                                                                                    <div class="bg-gradient-primary shadow-primary border-radius-lg py-3 pe-1">
                                                                                        <h4 class="text-black font-weight-bolder text-center mt-2 mb-0">Welcome to food-tracker</h4>
                                                                                    </div>
                                                                                </div>-->
                                        <div class="card-body">
                                            <!--<form action="login-control" method="POST" class="text-start">-->
                                            <!--USERNAME INPUT-->
                                            <!-- <div class="input-group input-group-outline my-3"> -->
                                            <div class="input-group">

                                                <div class="control">
                                                    <label class="form-label">Username</label>
                                                    <input type="text" required name="username" class="form-control" required>
                                                </div>
                                                <!--PASSWORD INPUT-->
                                                <!--  <div class="input-group input-group-outline mb-3"> -->
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
                                                    <a href="RegisterAccount.jsp" class="text-primary text-gradient font-weight-bold">Create an account</a>
                                                </p>
                                                <!--</form>-->
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
        document.getElementById('txtError').style.display = 'none';
        </script>
</html>