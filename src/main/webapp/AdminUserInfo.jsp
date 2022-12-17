<%-- 
    Document   : AdminUserInfo
    Created on : Nov 1, 2022, 8:48:18 PM
    Author     : Group 4
    CE161130  Nguyen Le Quang Thinh (Leader)
    CE170036  Pham Nhat Quang
    CE160464  Nguyen The Lu
    CE161096  Nguyen Ngoc My Quyen
    CE161025  Tran Thi Ngoc Hieu
--%>
<%@page import="DAO.UserDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
            />

        <link
            rel="stylesheet"
            type="text/css"
            href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.css"
            />
        <link rel="stylesheet" href="css/adminuserinfo.css">
        <title>Users Info</title>
    </head>
    <body>
        <div class="nav">
            <a href="admin" class="button" style="vertical-align:middle"><span>Back </span></a>
            <h1 class="navbar-brand mx-auto">USER INFO</h1>
        </div>

        <!--         <a href="ADMIN.jsp" class="previous round">Back</a>-->
        <div class="info-container">
            <div class="info-table">
                <table id="info-table" class="table table-striped table-hover display">
                    <thead>
                        <tr>
                            <th scope="col">UserID</th>
                            <th scope="col">First name</th>
                            <th scope="col">Last name</th>
                            <th scope="col">Email</th>
                            <th scope="col">Phone number</th>
                            <th scope="col">Health Info</th>
                            <th scope="col">Exercise Info</th>
                            <th scope="col">Goal Info</th>
                            <th scope="col">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items= "${listUser}" var="i">
                            <tr>
                                <td>${i.userID}</td>
                                <td>${i.firstName}</td>
                                <td>${i.lastName}</td>
                                <td>${i.email}</td>
                                <td>${i.phone}</td>
                                <td>
                                    <a class="#" href = "user-healthinfo?userid=${i.userID}">View</a>
                                </td>
                                <td>
                                    <a class="#" href = "getuser-exerciseid-control?userid=${i.userID}">View</a>
                                </td>
                                <td>
                                    <a class="#" href = "user-goal?userid=${i.userID}">View</a>
                                </td>
                                <td>
                                    <a class="fa-solid fa-pen-to-square edit-button" href="update-control?id=${i.userID}" style="color: blue;"></a>
                                    |
                                    <a class="delete-usercontrol" href = "#" onclick = "askDelete(${i.userID})" style="color: red"
                                       ><i class="fa-solid fa-xmark"></i
                                        ></a>
                                </td>
                            </tr>

                        </c:forEach>

                    </tbody>

                </table>
            </div>
        </div>
        <script
            src="https://code.jquery.com/jquery-3.6.2.js"
            integrity="sha256-pkn2CUZmheSeyssYw3vMp1+xyub4m+e+QK4sQskvuo4="
            crossorigin="anonymous"
        ></script>
        <script
            type="text/javascript"
            charset="utf8"
            src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.js"
        ></script>
        <script>
                                        $(document).ready(function () {
                                            $("#info-table").DataTable();
                                        });
        </script>

</html>
