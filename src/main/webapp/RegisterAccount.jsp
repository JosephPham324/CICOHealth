<%-- Document : RegisterAccount Created on : Oct 4, 2022, 4:34:32 PM Author : M
S I --%> 
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
        <!--        <link rel="stylesheet" href = "./css/formstyle.css"/>-->
        <link rel="stylesheet" href = "./css/registeracount.css"/>
        <title>Register Account</title>
    </head>
    <body>
        <section style="background-image: url('${pageContext.request.contextPath}/image/login.jpg');">
            <div class="form-container">
                <div  >
                    <div>
                        <div class="login-form">
                            <form method="post" action="register" 
                                  oninput='password2.setCustomValidity(password2.value != password1.value ? "Passwords do not match." : "")'>
                                <fieldset>
                                    <legend>Register</legend>
                                    <div class="form-group row">
                                        <label for="username" class="col-5 col-form-label"
                                               >Username</label>
                                        <div class="col-7">
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
                                                    />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="password1" class="col-5 col-form-label"
                                               >Password</label>
                                        <div class="col-7">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fa fa-lock"></i>
                                                    </div>
                                                </div>
                                                <input
                                                    id="password1"

                                                    name="password1"
                                                    placeholder="Enter your password"
                                                    type="password"
                                                    class="form-control"
                                                    />
                                            </div>
                                        </div>
                                    </div>


                                    <div class="form-group row">
                                        <label for="password2" class="col-5 col-form-label"
                                               >Confirm password</label>
                                        <div class="col-7">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fa fa-lock"></i>
                                                    </div>
                                                </div>
                                                <input
                                                    id="password2"
                                                    name="password2"
                                                    placeholder="Enter your password"
                                                    type="password"
                                                    class="form-control"
                                                    />
                                            </div>
                                        </div>
                                    </div>


                                    <div class="form-group row">
                                        <label for="firstName" class="col-5 col-form-label"
                                               >First Name</label
                                        >
                                        <div class="col-7">
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
                                                    />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="lastName" class="col-5 col-form-label"
                                               >Last Name</label
                                        >
                                        <div class="col-7">
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
                                                    />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="email" class="col-5 col-form-label">Email</label>
                                        <div class="col-7">
                                            <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fa fa-envelope"></i>
                                                    </div>
                                                </div>
                                                <input
                                                    id="email"
                                                    name="email"
                                                    placeholder="Enter your email"
                                                    type="text"
                                                    class="form-control"
                                                    />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="phone" class="col-5 col-form-label">Phone</label>
                                        <div class="col-7">
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
                                                    />
                                            </div>
                                        </div>
                                    </div

                                    <div class="row g-3 needs-validation" novalidate>
                                        <div class="offset-5 col-7">
                                            <div class="form-check">
                                                <input type="checkbox" id="invalidCheck" name="remember" class="form-check-input" value = "remember" required>
                                                <label class="form-check-label" for="invalidCheck"><p class="term">
                                                        <a href="TermConditions.jsp" class="text-success text-gradient font-weight-bold">&nbsp;Terms&nbsp;&&nbsp;Conditions&nbsp;</a>
                                                        and 
                                                        <a href="TermConditions.jsp" class="text-success text-gradient font-weight-bold">&nbsp;Privacy&nbsp;Policy</a>
                                                    </p></label>
                                                <div class="invalid-feedback">
                                                    You must agree before submitting.
                                                </div>
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

                </div>
            </div>
        </section>
    </body>
</html>
