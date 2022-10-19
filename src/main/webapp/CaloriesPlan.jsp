<%-- 
    Document   : CaloriesPlan
    Created on : Oct 18, 2022, 2:38:19 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.HealthDAO"%>
<%@page import="Entity.UserHealthInfo"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>BMI Calculator</title>
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300&display=swap');

            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            html {
                font-size: 62.5%;
            }

            .first-container {
                display: flex;
                flex-direction: column;
                align-items: center;
            }

            .second-container {
                display: flex;
                justify-content: center;
            }

            .application,
            .results-container {
                display: flex;
                flex-direction: column;
                align-items: center;
                background-color: rgb(199, 193, 193);
                margin-top: 3rem;
                border: 1px solid rgb(41, 40, 40);
                border-radius: 0.6rem;
                padding: 3rem;
            }

            .radio-buttons{
                margin-bottom: 1.5rem;
            }

            .title {
                font-family: 'Poppins', sans-serif;
                font-size: 3rem;
                margin-bottom: 1.5rem;
                letter-spacing: 2px;
                ;
            }

            .intro {
                font-size: 1.5rem;
                font-family: 'Poppins', sans-serif;
            }

            .intro:last-of-type{
                padding-bottom: 2rem;
            }

            .label {
                padding: .5rem;
                font-family: Arial, Helvetica, sans-serif;
            }


            .age-field {
                padding: .5rem;
                border-radius: 3px;
                width: 12rem;
            }

            .field {
                padding: .5rem;
                border-radius: 3px;
                width: 7rem;
                margin-bottom: 3rem;
            }

            #feet,
            #stone {
                margin-right: 1.5rem;
            }

            .submit {
                padding: .5rem 2rem;
                border-radius: .5rem;
                transition: all .2s;
            }

            .submit:active {
                transform: translateY(.2rem);
            }

            .gender-label {
                font-size: 1rem;
                font-family: Arial, Helvetica, sans-serif;
            }

            .results {
                display: flex;
                flex-direction: column;
                align-items: center;
            }

            .finalNumberStyling {
                font-family: Arial, Helvetica, sans-serif;
                font-size: 4rem;
            }
        </style>
    </head>
    <body>
        <div class="first-container">
            <div class="second-container">
                <div class="application">
                    <h1 class="title">DIET PLANNER</h1>
                    <p class="intro">Fill out the below fields to discover your BMR.</p><br>
                    <p class="intro">Your BMR is the number of calories you burn off in 24 hours</p>

                    <form>
                        <div class="radio-buttons">
                            <p class="label"><strong>Select your gender</strong></p>
                            <input type="radio" checked="checked" id="male" name="gender" value="Male"><label for="male" class="gender-label">Male</label>
                            <input type="radio" id="female" name="gender" value="Female"><label for="female" class="gender-label">Female</label>
                        </div>

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



                        <p class="label"><strong>Age</strong></p>
                        <input type="number" id="age" class="age-field" min="0" max="130" placeholder="Enter your age">

                        <p class="label"><strong>Height</strong></p>
                        <input type="number" name="height" id="height" class="field" min="0" max="300" placeholder="cm">

                        <p class="label"><strong>Weight</strong></p>
                        <input type="number" id="weight" name="weight" class="field" min="0" max="300" placeholder="kg">

                        <div>
                            <input type="submit" id="submit" class="submit">
                        </div>

                    </form>
                </div>

            </div>
            <div id="results"> <!--This is where the results will appear.  This is hidden when the program loads and appears when the user clicks 'submit'-->
                <div class="results-container">
                    <h1 class="title">Your daily BMI is:</h1>
                    <p id="bmi-result">Placeholder text</p>
                </div>
            </div>
            
            <div id="results_2">  
                <div class="results-container">
                    <h1 class="title">Which plan will you choose?:</h1>
                    <p id="plan-result">Placeholder text</p>
                </div>
            </div>

            <script src="./scripts/calculateTDEE.js"></script>
    </body>
</html>
