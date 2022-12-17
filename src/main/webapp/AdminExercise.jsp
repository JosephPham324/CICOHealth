<%-- 
    Document   : AdminExercise
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" />
        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
            />
        <link
            rel="stylesheet"
            type="text/css"
            href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.css"
            />
        <link rel="stylesheet" href="css/adminuserinfo.css">

        <title>Exercise management</title>
    </head>
    <body>
        <div class="nav">
            <a href="admin" class="button" style="vertical-align:middle"><span>Back </span></a>
            <h1 class="navbar-brand mx-auto">EXERCISE MANAGEMENT</h1>
        </div>


        <!--        <a href="ADMIN.jsp" class="previous round">Back</a>-->
        <div class="info-container">

            <div class="info-table">
                <table id="info-table" class="table table-striped table-hover display">
                    <thead>
                        <tr>
                            <th scope="col">Exercise ID</th>
                            <th scope="col">Exercise name</th>
                            <th scope="col">Cal/hour</th>
                            <th scope="col">Description</th>
                            <th scope="col">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items= "${listExercise}" var="i">
                            <tr>
                                <td>${i.exerciseID}</td>
                                <td>${i.exerciseName}</td>
                                <td>${i.calPerHour}</td>
                                <td>${i.description}</td>
                                <td>
                                    <a class="fa-solid fa-pen-to-square edit-button" href="update-exercisetype-control?exerciseid=${i.exerciseID}" style="color: blue;">Update</a>
                                    |<a class="delete-usercontrol" href = "#" onclick = "askDelete(${i.exerciseID})" style="color: red"><i class="fa-solid fa-xmark">Delete</i></a>
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
        <script src="scripts/adminuserinfo.js"></script>
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    </body>
    <script>
                                        $(document).ready(function () {
                                            $("#info-table").DataTable();
                                        });
                                        function askDelete(id) {
//                                            let option = confirm('Are you sure you want to delete ' + id);
//                                            if (option === true) {
//                                                window.location.href = "delete-exercisetype-control?exerciseid=" + id;
//                                            }
                                            Swal.fire({
                                                title: 'Are you sure?',
                                                text: "You won't be able to revert this!",
                                                icon: 'warning',
                                                showCancelButton: true,
                                                confirmButtonColor: '#3085d6',
                                                cancelButtonColor: '#d33',
                                                confirmButtonText: 'Yes, delete it!'
                                            }).then((result) => {
                                                if (result.isConfirmed) {
                                                    Swal.fire(
                                                            'Deleted!',
                                                            'Your file has been deleted.',
                                                            'success'
                                                            ),
                                                    window.location.href = "delete-exercisetype-control?exerciseid=" + id;
                                                }
                                            })
                                        }
    </script>
</html>
