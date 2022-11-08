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
        <title>Register Account</title>
        <style>
            .error {
                color: red;
            }
        </style>
        <script src="./scripts/validateRegister.js">
        </script>
    </head>
    <body>
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
                                    <a href="TermConditions.jsp" class="text-success text-gradient font-weight-bold">&nbsp;Terms&nbsp;&&nbsp;Conditions&nbsp;</a>
                                    and 
                                    <a href="TermConditions.jsp" class="text-success text-gradient font-weight-bold">&nbsp;Privacy&nbsp;Policy</a>
                                </label>
                                <div class="invalid-feedback">
                                    You must agree before submitting.
                                </div>
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
    document.getElementById("ErrorDuplicate").style.display = 'none';
</script>
</html>