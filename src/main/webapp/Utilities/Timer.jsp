<%-- 
    Document   : Timer
    Created on : Nov 25, 2022, 4:16:16 PM
    Author     : Pham Nhat Quang CE170036 (FPTU CANTHO)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/circle.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/timer.css" />
        <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
            />
        <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
            />
        <%@include file = "../headfootlink.jsp" %>
        <title>Exercise Timer | ${initParam['webappName']}</title>
    </head>
    <body>
        <%@ include file="../header.jsp" %>

        <div class="clock-container">
            <div class="clock-form">
                <form onsubmit="event.preventDefault();return activateSetTimer();">
                    <div class="form-group row">
                        <label for="setNum" class="col-4 col-form-label"
                               >Number of sets</label
                        >
                        <div class="col-8">
                            <input
                                id="setNum"
                                name="setNum"
                                placeholder="Enter number of sets"
                                type="number"
                                min="1"
                                value="1"
                                class="form-control"
                                aria-describedby="setNumHelpBlock"
                                required="required"
                                />
                            <span id="setNumHelpBlock" class="form-text text-muted"
                                  >The number of sets to perform</span
                            >
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="setTime" class="col-4 col-form-label">Set time</label>
                        <div class="col-8">
                            <input
                                id="setTime"
                                name="setTime"
                                placeholder="Enter time of each set in seconds"
                                type="number"
                                min="1"
                                value="45"
                                class="form-control"
                                aria-describedby="setTimeHelpBlock"
                                required="required"
                                />
                            <span id="setTimeHelpBlock" class="form-text text-muted"
                                  >How long you perform each set</span
                            >
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="restTime" class="col-4 col-form-label">Rest time</label>
                        <div class="col-8">
                            <input
                                id="restTime"
                                name="restTime"
                                placeholder="Enter rest time of each set in seconds"
                                type="number"
                                value="90"
                                min="1"
                                class="form-control"
                                aria-describedby="restTimeHelpBlock"
                                required="required"
                                />
                            <span id="restTimeHelpBlock" class="form-text text-muted"
                                  >How long you rest between sets</span
                            >
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="offset-4 col-8">
                            <button name="submit" type="submit" class="btn btn-primary">
                                Begin Timer
                            </button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="clock hidden">
                <p id="clock-label">Timer Description</p>
                <div class="c100 p0 center" id="clock">
                    <span>00:00</span>
                    <div class="slice">
                        <div class="bar"></div>
                        <div class="fill"></div>
                    </div>
                </div>
                <div class="stop-clock">
                    <button onclick="stopClockFunc()">Stop Clock</button>
                </div>
            </div>
        </div>
        <script src="${pageContext.request.contextPath}/scripts/timer.js"></script>
    </body>
</html>

