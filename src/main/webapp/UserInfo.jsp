<%-- 
    Document   : UserInfo
    Created on : Oct 9, 2022, 7:35:44 PM
    Author     : ASUS
--%>

<%@page import="Entity.User"%>
<%@page import="Entity.Login"%>
<%@page import="Security.RegLoginLogic"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
            integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
            crossorigin="anonymous"
            />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
            integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <%@include file = "headfootlink.jsp" %>
        <link rel="stylesheet" href="css/userinfo.css" />
        <title>User Profile</title>
    </head>
    <body>
        <c:if test="${sessionScope.userID == null}">
            <c:redirect url="home"></c:redirect>
        </c:if>
        <%
            DAO.LoginDAO lDAO = new DAO.LoginDAO();
            DAO.UserDAO uDAO = new DAO.UserDAO();
            Login loginInfo = lDAO.getLoginInfo(request.getSession().getAttribute("userID").toString());
            User user = uDAO.getUserByID(request.getSession().getAttribute("userID").toString());
            
            String enteredPassword = request.getParameter("password");
            
            boolean correctPassword = false;
            if (request.getParameter("password")!=null)
            correctPassword = Security.RegLoginLogic.verifyPassword(
                    request.getParameter("password").toString(),
                    loginInfo.getPasswordSalt(),
                    loginInfo.getPasswordHash());
            Object panel = request.getSession().getAttribute("panel");
            int panelSwitch = 0;
            if (panel!=null){
                switch (panel.toString()){
                    case "userInfo":
                        panelSwitch = 1;
                        break;
                    case "healthInfo":
                        panelSwitch = 2;
                        break;
                    default:
                        panelSwitch = 0;
                        break;
                }
            }
        %>


        <div class="form">
            <div class="overlay"></div>
            <form method="post">
                <div class="form-group row">
                    <label for="username" class="col-4 col-form-label">Username</label>
                    <div class="col-8">
                        <input
                            id="username"
                            name="username"
                            placeholder="Your username"
                            type="text"
                            class="form-control"
                            aria-describedby="usernameHelpBlock"
                            />
                        <span id="usernameHelpBlock" class="form-text text-muted"
                              >Help text</span
                        >
                    </div>
                </div>
                <div class="form-group row">
                    <div class="offset-4 col-8">
                        <button name="submit" type="submit" class="btn btn-primary">
                            Submit
                        </button>
                    </div>
                </div>
            </form>
        </div>

        <!--<div class="header row col-sm-12 g-0">Header</div>-->
        <%@include file = "header.jsp" %>
        <div class="info-container row g-0">
            <div class="col-sm-2">
                <ul class="nav flex-column nav-pills nav-fill">
                    <li class="nav-item">
                        <a class="nav-link <%=panelSwitch==0?"active":""%>" href="#" data-destination="#login-info"
                           >Login Info</a
                        >
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <%=panelSwitch==1?"active":""%>" href="#" data-destination="#user-info"
                           >User Info</a
                        >
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <%=panelSwitch==2?"active":""%>" href="#" data-destination="#health-info"
                           >Health Info</a
                        >
                    </li>
                </ul>
            </div>
            <div class="col-sm-10 row g-0 info tab-content" id="pills-tabContent">
                <div class="login-info <%=panelSwitch==0?"active":""%>" id="login-info">
                    <h1>Your Login Information</h1>
                    <div class="field">
                        <div class="label">Username:</div>
                        <span class="field-value" id="username-value"><%=loginInfo.getUsername()%></span>
                        <button class="edit"><i class="fa-solid fa-pen-to-square edit-button"></i></button>
                    </div>
                    <div class="field">
                        <div class="label">Password:</div>
                        <span class="field-value hidden" id="password-value"><%if (correctPassword){
                                    out.print(enteredPassword);
                                } else {out.print("***********");}%></span>
                        <span id="toggle-password-visibility"><i class="fa fa-eye-slash" aria-hidden="true"></i></span>
                        <button class="edit"><i class="fa-solid fa-pen-to-square edit-button"></i></button>
                    </div>
                </div>
                <div class="user-info <%=panelSwitch==1?"active":""%>" id="user-info">
                    <h1>Your Personal Information</h1>
                    <div class="field">
                        <div class="label">First name:</div>
                        <span class="field-value" id="first-name-value"><%=user.getFirstName()%></span>
                        <button class="edit"><i class="fa-solid fa-pen-to-square edit-button"></i></button>
                    </div>
                    <div class="field">
                        <div class="label">Last name:</div>
                        <span class="field-value" id="last-name-value"><%=user.getLastName()%></span>
                        <button class="edit"><i class="fa-solid fa-pen-to-square edit-button"></i></button>
                    </div>
                    <div class="field">
                        <div class="label">Email:</div>
                        <span class="field-value"><%=user.getEmail()%></span>
                        <button class="edit"><i class="fa-solid fa-pen-to-square edit-button"></i></button>
                    </div>
                    <div class="field">
                        <div class="label">Phone number:</div>
                        <span class="field-value" id="phone-value"><%=user.getPhone()%></span>
                        <button class="edit"><i class="fa-solid fa-pen-to-square edit-button"></i></button>
                    </div>
                </div>
                <div class="health-info <%=panelSwitch==2?"active":""%>" id="health-info">
                    <h1>Quang's Health Information</h1>
                    <div class="field">
                        <div class="label">Age:</div>
                        <span class="field-value" id="age-value">19</span>
                        <button class="edit"><i class="fa-solid fa-pen-to-square edit-button"></i></button>
                    </div>
                    <div class="field">
                        <div class="label">Gender:</div>
                        <span class="field-value" id="gender-value">Male</span>
                        <button class="edit"><i class="fa-solid fa-pen-to-square edit-button"></i></button>
                    </div>
                    <div class="field">
                        <div class="label">Height:</div>
                        <span class="field-value">170cm</span>
                        <button class="edit"><i class="fa-solid fa-pen-to-square edit-button"></i></button>
                    </div>
                    <div class="field">
                        <div class="label">Activeness:</div>
                        <span class="field-value">Moderately active</span>
                        <button class="edit"><i class="fa-solid fa-pen-to-square edit-button"></i></button>
                    </div>
                    <div class="field">
                        <h3>Nutrition goals</h3>
                        <div class="label">Daily calorie:</div>
                        <span class="field-value">2400kcal</span><br />
                        <div class="label">Daily protein:</div>
                        <span class="field-value">200g</span><br />
                        <div class="label">Daily fat:</div>
                        <span class="field-value">60g</span><br />
                        <div class="label">Daily carbs:</div>
                        <span class="field-value">260g</span><br />
                    </div>
                </div>
            </div>
        </div>
        <script>
            let correctPassword = <%=correctPassword%>;
            if (!correctPassword) {
                let showPassword = document.getElementById('toggle-password-visibility');
                showPassword.addEventListener('click', checkPassword);
            }
            function checkPassword(){
                {
                    let form = document.querySelector('.form form')
                    form.action = '#';
                    let html = `
            <div class="form-group row">
                <label for="password" class="col-4 col-form-label">Verify Password:</label>
                <div class="col-8">
                    <input
                        id="password"
                        name="password"
                        placeholder="Your password"
                        type="password"
                        class="form-control"
                        aria-describedby="passwordHelpBlock"
                        value = ""
                        />
                    <span id="passwordHelpBlock" class="form-text text-muted">Help text</span>
                </div>
            </div>
            <div class="form-group row">
                <div class="offset-4 col-8">
                    <button name="submit" type="submit" class="btn btn-primary">Submit</button>
                </div>
            </div>
            `;
                    form.innerHTML = html;
                    document.querySelector('.form').classList.add('active');
                }
            }
        </script>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js"
            integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk"
            crossorigin="anonymous"
        ></script>
        <script src="scripts/headfootscript.js"></script>
        <script src="scripts/userinfo.js"></script>
    </body>
</html>

