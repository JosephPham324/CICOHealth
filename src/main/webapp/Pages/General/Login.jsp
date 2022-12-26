<%-- 
    Document   : Login
    Created on : Oct 4, 2022, 10:11:09 PM
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
        <link rel="icon" type="image/png" href="favicon.png"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Assets/scss/main/General/login.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Assets/scss/main/CommonStyles/buttons.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <title>Login | ${initParam['webappName']}</title>
    </head>
    <body>
        <script src="https://accounts.google.com/gsi/client" async defer></script>
        <c:if test="${sessionScope.userID != null}">
            <c:redirect url="home"></c:redirect>
        </c:if>
        <main>
            <section style="background-image: url('${pageContext.request.contextPath}/Assets/image/login.jpg');">
                <div class="back-button">
                    <button onclick="history.back()"><i class="fa-solid fa-chevron-left">&nbsp;BACK</i></button>
                </div>
                <div class="form-container">
                    <h1>Login</h1>
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
                                        <div style="text-align:center; font-weight:bold; margin-top:10px;">
                                            OR
                                        </div>
                                        <div id="google-sign-up" style ="display:flex; align-items:center; justify-content: center; margin:10px;">
                                            <div id="g_id_onload"
                                                 data-client_id="641593933823-qlfnb62fuif3fcsu01b0hf9vijetfepj.apps.googleusercontent.com"
                                                 data-context="signup"
                                                 data-ux_mode="popup"
                                                 data-login_uri="http://localhost:8080/Nutrition/register-account"
                                                 data-auto_prompt="false"
                                                 data-callback="handleCredentialResponse"
                                                 >
                                            </div>

                                            <div class="g_id_signin"
                                                 data-type="standard"
                                                 data-shape="pill"
                                                 data-theme="filled_blue"
                                                 data-text="login_with"
                                                 data-size="large"
                                                 data-logo_alignment="left">
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
            <script src="${pageContext.request.contextPath}/Assets/scripts/formhandling.js"></script>
            <script>
                        function handleCredentialResponse(response) {
                            const responsePayload = parseJwt(response.credential);
                            const formParams = {
                                username: chainString(responsePayload.email + '_' + responsePayload.family_name, ' ', ''),
                                password: chainString(responsePayload.email + '_' + responsePayload.name, ' ', ''),
                                email: responsePayload.email,
                                'google-login': true,
                                remember: document.querySelector('input[name="remember"]').checked
                            };
                            console.log(formParams)
                            post('login-control', formParams);
                        }
                        ;
                        document.getElementById('txtError').style.display = 'none';
            </script>
    </body>
</html>