<%-- 
    Document   : Login
    Created on : Oct 12, 2022, 10:11:09 PM
    Author     : Group 4
    CE161130  Nguyen Le Quang Thinh (Leader)
    CE170036  Pham Nhat Quang
    CE160464  Nguyen The Lu
    CE161096  Nguyen Ngoc My Quyen
    CE161025  Tran Thi Ngoc Hieu
--%>
<%@page import="DAO.HealthDAO"%>
<%@page import="Entity.UserHealthInfo"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"> 
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href = "./css/healthinfo.css"/>
        <link rel="stylesheet" href="./scss/main/CommonStyles/buttons.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="icon" type="image/png" href="favicon.png"/>
        <title>${sessionScope.username != null ? sessionScope.username + "'s" : 'Your'} Health Info | ${initParam['webappName']}</title>
    </head>
    <body>
        <section style="background-image: url('image/healthinfo.jpg');">
            <div class="back-button">
                <button onclick="history.back()"><i class="fa-solid fa-chevron-left">&nbsp;BACK</i></button>
            </div>
            <div class="form-container">
                <%
                    Object sessionUserID = session.getAttribute("userID");//Get session's userID
                    String userID = "";//Stores userID
                    if (sessionUserID != null) {
                        userID = sessionUserID.toString();
                    }
                    Entity.UserHealthInfo healthInfo = null;//Stores userID's UserHeatlhInfo entry
                    if (!userID.equals("")) {
                        //Find entry if ID isn't empty
                        healthInfo = new HealthDAO().findUserHealthInfo(Integer.parseInt(userID));
                    }
                    //Stores UserHealthInfo attributes values
                    //Initiated with a preset value
                    String activeness = "0";
                    String gender = "0";
                    String age = "20";
                    String height = "180";
                    String weight = "75";

                    if (healthInfo != null) {//If an entry is found
                        //Assign values to variables
                        activeness = healthInfo.getActiveness() + "";//Activeness is stored as numbers
                        gender = healthInfo.getGender() + "";
                        switch (gender) {//Map gender value into number
                            case "Female"://Female: 1
                                gender = "1";
                                break;
                            default://Male and others: 0
                                gender = "0";
                        }
                        age = healthInfo.getAge() + "";
                        height = healthInfo.getHeight() + "";
                        weight = healthInfo.getWeight() + "";
                    }
                %>
                <form method="post" action="healthinfo-control">
                    <div id="results_3">
                        <div class="form-group row">
                            <legend>
                                <%if (session.getAttribute("username") != null)//If session stores a user name
                                    {
                                        out.print(session.getAttribute("username") + "'s");//Print username
                                    } else {
                                        out.print("Your");//Else print Your
                                    }%>
                                health info</legend>
                                    <input type="hidden" id="userID" name="userID" value = ${requestScope.userID}>

                            <!--FORM GROUP FOR ACTIVENESS-->
                            <label class="col-4 col-form-label">How active are you?</label> 
                            <div class="col-8">
                                <div class="custom-controls-stacked">
                                    <div class="custom-control custom-radio">
                                        <input name="activity" id="activity_0" type="radio" required="required" checked class="custom-control-input" value="0"> 
                                        <label for="activity_0" class="custom-control-label">Not very active</label>
                                    </div>
                                </div>

                                <div class="custom-controls-stacked">
                                    <div class="custom-control custom-radio">
                                        <input name="activity" id="activity_1" type="radio" required="required" class="custom-control-input" value="1"> 
                                        <label for="activity_1" class="custom-control-label">Lightly active</label>
                                    </div>
                                </div>

                                <div class="custom-controls-stacked">
                                    <div class="custom-control custom-radio">
                                        <input name="activity" id="activity_2" type="radio" required="required" class="custom-control-input" value="2"> 
                                        <label for="activity_2" class="custom-control-label">Active</label>
                                    </div>
                                </div>

                                <div class="custom-controls-stacked">
                                    <div class="custom-control custom-radio">
                                        <input name="activity" id="activity_3" type="radio" required="required" class="custom-control-input" value="3"> 
                                        <label for="activity_3" class="custom-control-label">Very active</label>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!--FORM GROUP FOR GENDER-->
                        <div class="form-group row">
                            <label class="col-4">Gender</label> 
                            <div class="col-8">
                                <div class="custom-control custom-radio custom-control-inline">
                                    <input name="gender" id="gender_0" type="radio" class="custom-control-input" checked value="Male" required="required"> 
                                    <label for="gender_0" class="custom-control-label">Male</label>
                                </div>
                                <div class="custom-control custom-radio custom-control-inline">
                                    <input name="gender" id="gender_1" type="radio" class="custom-control-input" value="Female" required="required"> 
                                    <label for="gender_1" class="custom-control-label">Female</label>
                                </div>
                            </div>
                        </div>

                        <!--AGE INPUT-->
                        <div class="form-group row">
                            <label for="a" class="col-4 col-form-label">Age</label> 
                            <div class="col-8">
                                <input id="age" name="age" type="number" class="form-control" min = "10">
                            </div>
                        </div>

                        <!--HEIGHT INPUT-->
                        <div class="form-group row">
                            <label for="height" class="col-4 col-form-label">Height (cm)</label> 
                            <div class="col-8">
                                <input id="height" name="height" type="text" required="required" class="form-control" min = "1">
                            </div>
                        </div>

                        <!--WEIGHT INPUT-->
                        <div class="form-group row">
                            <label for="weight" class="col-4 col-form-label">Weight (kg)</label> 
                            <div class="col-8">
                                <input id="weight" name="weight" type="text" class="form-control" required="required" min = "0.5">
                            </div>
                        </div> 

                        <!--BUTTON-->
                        <div class="submit">
                            <div class="form-group row">
                                <div class="col-md-12 text-center">
                                    <button name="submit"  id="smit" class="btn btn-primary">Submit</button>
                                </div>
                            </div>
                        </div>
                    </div>


                    <!--BMR result-->
                    <div class="BMR">
                        <div class="form-group row" id="results"  style="width: 600px;">
                            <div> <!--This is where the results will appear.  This is hidden when the program loads and appears when the user clicks 'submit'-->
                                <div class="results-container">
                                    <h1  class="title">Your daily BMI is:</h1>
                                    <p id="bmi-result">Placeholder text</p>
                                </div>
                            </div>

                            <!--Plan result-->
                            <div>  
                                <div class="results-container">
                                    <h3 class="title">Which plan will you choose?:</h3>
                                    <p id="plan-result">Placeholder text</p>
                                </div>
                            </div>
                            <h3  class="title">Your choice:</h3> 
                            <div class="col-8">
                                <div class="custom-controls-stacked">
                                    <div class="custom-control custom-radio">
                                        <input name="planChoice" id="planChoice_0" type="radio" class="custom-control-input" value="Maintenance"> 
                                        <label for="planChoice_0" class="custom-control-label">Maintenance</label>
                                    </div>
                                </div>
                                <div class="custom-controls-stacked">
                                    <div class="custom-control custom-radio">
                                        <input name="planChoice" id="planChoice_1" type="radio" class="custom-control-input" value="Light Weight Loss"> 
                                        <label for="planChoice_1" class="custom-control-label">Light Weight Loss</label>
                                    </div>
                                </div>
                                <div class="custom-controls-stacked">
                                    <div class="custom-control custom-radio">
                                        <input name="planChoice" id="planChoice_2" type="radio" class="custom-control-input" value="Moderate Weight Loss"> 
                                        <label for="planChoice_2" class="custom-control-label">Moderate Weight Loss</label>
                                    </div>
                                </div>
                                <div class="custom-controls-stacked">
                                    <div class="custom-control custom-radio">
                                        <input name="planChoice" id="planChoice_3" type="radio" class="custom-control-input" value="Extreme Weight Loss"> 
                                        <label for="planChoice_3" class="custom-control-label">Extreme Weight Loss</label>
                                    </div>
                                </div>
                                <div class="custom-controls-stacked">
                                    <div class="custom-control custom-radio">
                                        <input name="planChoice" id="planChoice_4" type="radio" class="custom-control-input" value="Light Weight Gain"> 
                                        <label for="planChoice_4" class="custom-control-label">Light Weight Gain</label>
                                    </div>
                                </div>
                                <div class="custom-controls-stacked">
                                    <div class="custom-control custom-radio">
                                        <input name="planChoice" id="planChoice_5" type="radio" class="custom-control-input" value="Moderate Weight Gain"> 
                                        <label for="planChoice_5" class="custom-control-label">Moderate Weight Gain</label>
                                    </div>
                                </div>
                                <div class="custom-controls-stacked">
                                    <div class="custom-control custom-radio">
                                        <input name="planChoice" id="planChoice_6" type="radio" class="custom-control-input" value="Extreme Weight Gain"> 
                                        <label for="planChoice_6" class="custom-control-label">Extreme Weight Gain</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div> 

                    <!--Submit-->
                    <div class="submit">
                        <div class="form-group row" id="results_2">
                            <div class="col-md-12 text-center" id="results_2">
                                <button name="submit" type="submit" class="btn btn-primary">Submit</button>
                            </div>
                        </div>
                    </div>

                </form>

                <script src="./scripts/calculateTDEE.js"></script>
                <script>
                        //GET INPUT FIELDS
                        let activeness = document.querySelectorAll('input[name="activity"]');
                        let gender = document.querySelectorAll('input[name="gender"]');
                        let age = document.querySelector('input[name="age"]');
                        let height = document.querySelector('input[name="height"]');
                        let weight = document.querySelector('input[name="weight"]');
                        let userID = document.querySelector('input[name="userID"]');

<<<<<<< Updated upstream
                        let requestUserID = ${userID} + "";//Get userID from request
=======
                    let requestUserID = ${requestScope.userID} + "";//Get userID from request
>>>>>>> Stashed changes

                        if (<%=userID != null%> && <%= !userID.equals("")%>) {
                            userID.value = <%=userID%> + "";//If there is userID from session, use this
                        } else {
                            userID.value = requestUserID;//If not, use from request
                        }
                        //Assign initial values for form inputs
                        activeness[<%=activeness%>].checked = "true";
                        gender[<%=gender%>].checked = "true";
                        age.value = "<%=age%>";
                        height.value = "<%=height%>";
                        weight.value = "<%=weight%>";
                </script>
            </div>
        </section>
    </body>
</html>
