<%-- 
Document : RegisterAccount Created on : Oct 4, 2022, 4:34:32 PM
Author : Pham Nhat Quang
--%> 
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
        <link rel="stylesheet" href = "./css/registeracount.css"/>
        <title>Register Account</title>
    </head>
    <body>
        <section style="background-image: url('${pageContext.request.contextPath}/image/login.jpg');">
            <div class="container" style="background-image: url('image/login.jpg');">
                <div class="row col-md-8 offset-4">
                    <div class="login-form">
                        <form method="post" action="register">
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
                                                />
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
                                                />
                                        </div>
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
                                                />
                                        </div>
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
                                                />
                                        </div>
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
                                                />
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="phone" class="col-4 col-form-label">Phone</label>
                                    <div class="col-8">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fa fa-address-book"></i>
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
                                </div>
                                <div class="form-group row">
                                    <div class="offset-4 col-8">
                                        <button name="submit" type="submit" class="btn btn-success">
                                            Submit
                                        </button>
                                    </div>
                                </div>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
    </body>
</section>

</html>
