
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"> 
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href = "./css/formstyle.css"/>
        <title>Your health info</title>
    </head>
    <body>
        <form method="post" action="healthinfocontrol">
            <div class="form-group row">
                <legend>Your health info</legend>
                <input type="hidden" id="userID" name="userID" value="${param.userID}">
                <label class="col-4 col-form-label">How active are you?</label> 
                <div class="col-8">
                    <div class="custom-controls-stacked">
                        <div class="custom-control custom-radio">
                            <input name="activity" id="activity_0" type="radio" required="required" class="custom-control-input" value="1"> 
                            <label for="activity_0" class="custom-control-label">Not very active</label>
                        </div>
                    </div>
                    <div class="custom-controls-stacked">
                        <div class="custom-control custom-radio">
                            <input name="activity" id="activity_1" type="radio" required="required" class="custom-control-input" value="2"> 
                            <label for="activity_1" class="custom-control-label">Lightly active</label>
                        </div>
                    </div>
                    <div class="custom-controls-stacked">
                        <div class="custom-control custom-radio">
                            <input name="activity" id="activity_2" type="radio" required="required" class="custom-control-input" value="3"> 
                            <label for="activity_2" class="custom-control-label">Active</label>
                        </div>
                    </div>
                    <div class="custom-controls-stacked">
                        <div class="custom-control custom-radio">
                            <input name="activity" id="activity_3" type="radio" required="required" class="custom-control-input" value="4"> 
                            <label for="activity_3" class="custom-control-label">Very active</label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-4">Gender</label> 
                <div class="col-8">
                    <div class="custom-control custom-radio custom-control-inline">
                        <input name="gender" id="gender_0" type="radio" class="custom-control-input" value="Male" required="required"> 
                        <label for="gender_0" class="custom-control-label">Male</label>
                    </div>
                    <div class="custom-control custom-radio custom-control-inline">
                        <input name="gender" id="gender_1" type="radio" class="custom-control-input" value="Female" required="required"> 
                        <label for="gender_1" class="custom-control-label">Female</label>
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <label for="a" class="col-4 col-form-label">Age</label> 
                <div class="col-8">
                    <input id="a" name="age" type="text" class="form-control">
                </div>
            </div>
            <div class="form-group row">
                <label for="height" class="col-4 col-form-label">Height (cm)</label> 
                <div class="col-8">
                    <input id="height" name="height" type="text" required="required" class="form-control">
                </div>
            </div>
            <div class="form-group row">
                <label for="weight" class="col-4 col-form-label">Weight (kg)</label> 
                <div class="col-8">
                    <input id="weight" name="weight" type="text" class="form-control" required="required">
                </div>
            </div> 
            <div class="form-group row">
                <div class="offset-4 col-8">
                    <button name="submit" type="submit" class="btn btn-primary">Submit</button>
                </div>
            </div>
        </form>
    </body>
</html>
