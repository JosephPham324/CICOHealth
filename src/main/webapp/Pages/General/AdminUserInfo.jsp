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
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
            />
        <link
            rel="stylesheet"
            href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css"
            />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
            integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
            />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Assets/css/adminuserinfo.css">
        <style>
         
        </style>
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
                <div  class="widget_search" style=" margin-right: 10px;">
                    <form role="search" method="post" action="user-load-control">
                        <div style="text-align: right;">
                            <input style="margin-bottom: 5px;border-radius: 4px;" type="Search" name="txtSearch" placeholder="&nbsp First name or last name">
                            <input type="submit" id="searchsubmit" value="Search"/>
                        </div>
                    </form>
                </div>
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
            src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"
        ></script>
        <script
            src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"
        ></script>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"
        ></script>
        <script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
        <script src="${pageContext.request.contextPath}/Assets/scripts/adminuserinfo.js"></script>
    </body>
      <script>
            function askDelete(id){
                let option = confirm('Are you sure you want to delete ' + id);
                if (option === true){
                    window.location.href = "delete-user-control?userid="+id;
                }
            }
        </script>
</html>
