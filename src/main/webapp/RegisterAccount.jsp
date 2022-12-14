<%-- 
    Document : RegisterAccount 
    Created on : Oct 4, 2022, 4:34:32 PM
    Author : Group 4
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
            />
        <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
            />
        <link rel="icon" type="image/png" href="favicon.png"/>
        <link rel="stylesheet" href = "./css/registeracount.css"/>
        <title>Register Account | ${initParam['webappName']}</title>
        <style>
            .error {
                color: red;
            }
        </style>
        <script src="./scripts/validateRegister.js">
        </script>
    </head>
    <body>
        <script src="https://accounts.google.com/gsi/client" async defer></script>
        <c:if test="${sessionScope.userID != null}">
            <c:redirect url="home"></c:redirect>
        </c:if>
        <section style="background-image: url('image/login.jpg');">
            <div class="form-container"> 
                <div class="login-form">
                    <form method="post" action="register-control" onsubmit="return checkAllData()">
                        <fieldset>
                            <legend>Register</legend>
                            <div class="form-group row">
                                <label for="username" class="col-4 col-form-label"
                                       >Username</label
                                >
                                <div class="col-8">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fa fa-address-card"></i>
                                            </div>
                                        </div>
                                        <input
                                            id="username"
                                            name="username"
                                            placeholder="Enter your username"
                                            type="text"
                                            class="form-control"
                                            onblur="checkUsername()"
                                            />
                                        <div class ="error" id="txtUsernameMessage"></div>
                                        <div class ="error" id="ErrorDuplicate">Username exist!!</div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="password" class="col-4 col-form-label"
                                       >Password</label
                                >
                                <div class="col-8">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fa fa-lock"></i>
                                            </div>
                                        </div>
                                        <input
                                            id="password"
                                            name="password"
                                            placeholder="Enter your password"
                                            type="password"
                                            class="form-control"
                                            onblur="checkPassword1()"
                                            />
                                        <div class ="error" id="txtPassword1Message"></div>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="password" class="col-4 col-form-label"
                                       >Confirm password</label>
                                <div class="col-8">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fa fa-lock"></i>
                                            </div>
                                        </div>
                                        <input
                                            id="confirmpassword"
                                            name="confirmpassword"
                                            placeholder="Enter your confirm password"
                                            type="password"
                                            class="form-control"
                                            onblur="checkPassword2()" 
                                            />
                                    </div>
                                    <div class ="error" id="txtPassword2Message"></div>
                                </div>
                            </div>


                            <div class="form-group row">
                                <label for="firstName" class="col-4 col-form-label"
                                       >First Name</label
                                >
                                <div class="col-8">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fa fa-adn"></i>
                                            </div>
                                        </div>
                                        <input
                                            id="firstName"
                                            name="firstName"
                                            placeholder="Enter your first name"
                                            type="text"
                                            class="form-control"
                                            onblur="checkFirstname()"
                                            />
                                    </div>
                                    <div class ="error" id="txtFirstNameMessage"></div>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="lastName" class="col-4 col-form-label"
                                       >Last Name</label
                                >
                                <div class="col-8">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fa fa-adn"></i>
                                            </div>
                                        </div>
                                        <input
                                            id="lastName"
                                            name="lastName"
                                            placeholder="Enter your last name"
                                            type="text"
                                            class="form-control"
                                            onblur="checkLastname()"
                                            />
                                    </div>
                                    <div class ="error" id="txtLastNameMessage"></div>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="email" class="col-4 col-form-label">Email</label>
                                <div class="col-8">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fa fa-address-book"></i>
                                            </div>
                                        </div>
                                        <input
                                            id="email"
                                            name="email"
                                            placeholder="Enter your email"
                                            type="text"
                                            class="form-control"
                                            onblur="checkEmail()"
                                            />
                                    </div>
                                    <div class ="error" id="txtEmailMessage"></div>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="phone" class="col-4 col-form-label">Phone</label>
                                <div class="col-8">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text">
                                                <i class="fa fa-phone"></i>
                                            </div>
                                        </div>
                                        <input
                                            id="phone"
                                            name="phone"
                                            placeholder="Enter your phone"
                                            type="text"
                                            class="form-control"
                                            onblur="checkPhone()"
                                            />
                                    </div>
                                    <div class ="error" id="txtPhoneMessage"></div>
                                </div>
                            </div>

                            <div class="offset-4 col-8">
                                <div class="form-check">
                                    <input type="checkbox" id="invalidCheck" name="remember" class="form-check-input" value = "remember" required>
                                    <label class="form-check-label" for="invalidCheck">
                                        <a href="terms" class="text-success text-gradient font-weight-bold">&nbsp;Terms&nbsp;&&nbsp;Conditions&nbsp;</a>
                                        and 
                                        <a href="terms" class="text-success text-gradient font-weight-bold">&nbsp;Privacy&nbsp;Policy</a>
                                    </label>
                                    <div class="invalid-feedback">
                                        You must agree before submitting.
                                    </div>
                                </div>
                            </div>

                            <div id="google-sign-up" style ="display:flex; align-items:center; justify-content: center;">
                                OR&nbsp;&nbsp;&nbsp;
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
                                     data-text="signin_with"
                                     data-size="medium"
                                     data-logo_alignment="left">
                                </div>
                            </div>

                            <div class="submit">
                                <div class="form-group row">
                                    <div class="col-md-12 text-center">
                                        <button name="submit" type="submit" class="btn btn-success">
                                            Submit
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>

        </section>
    </body>
    <script>
        /**
         * sends a request to the specified url from a form. this will change the window location.
         * @param {string} path the path to send the post request to
         * @param {object} params the parameters to add to the url
         * @param {string} [method=post] the method to use on the form
         */
        function post(path, params, method = 'post') {

            // The rest of this code assumes you are not using a library.
            // It can be made less verbose if you use one.
            const form = document.createElement('form');
            form.method = method;
            form.action = path;

            for (const key in params) {
                if (params.hasOwnProperty(key)) {
                    const hiddenField = document.createElement('input');
                    hiddenField.type = 'hidden';
                    hiddenField.name = key;
                    hiddenField.value = params[key];

                    form.appendChild(hiddenField);
                }
            }

            document.body.appendChild(form);
            form.submit();
        }

        function parseJwt(token) {
            var base64Url = token.split('.')[1];
            var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
            var jsonPayload = decodeURIComponent(window.atob(base64).split('').map(function (c) {
                return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
            }).join(''));

            return JSON.parse(jsonPayload);
        }
        
        function chainString(str){
            return str.split(' ').join('');
        }
        function handleCredentialResponse(response) {
            // decodeJwtResponse() is a custom function defined by you
            // to decode the credential response.
            const responsePayload = parseJwt(response.credential);
            const formParams = {
                username : chainString(responsePayload.email + '_' + responsePayload.family_name),
                password : chainString(responsePayload.email + '_' + responsePayload.name),
                firstName : responsePayload.given_name,
                lastName : responsePayload.family_name,
                email : responsePayload.email,
                phone : '0123456789'
            };
//            console.log(formParams)
            post('register-control', formParams);
//            console.log(formParams);
//            console.log("ID: " + responsePayload.sub);
//            console.log('Full Name: ' + responsePayload.name);
//            console.log('Given Name: ' + responsePayload.given_name);
//            console.log('Family Name: ' + responsePayload.family_name);
//            console.log("Image URL: " + responsePayload.picture);
//            console.log("Email: " + responsePayload.email);
        }
        document.getElementById("ErrorDuplicate").style.display = 'none';
    </script>
</html>