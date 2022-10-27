var patt_email = /^[a-zA-Z]+[\w-_\.]*\@([\w]+\.)+[\w]+[\w]$/;
var patt_phone = /^0[1-9]\d{8,10}$/;


 


function checkUsername() {
    tk = document.getElementById("username").value;
    document.getElementById("txtUsernameMessage").innerHTML =
            tk.trim() == "" ? "Username can't be empty!" : "";
    return tk != "" ? true : false;
}

function checkFirstname() {
    fn = document.getElementById("firstName").value;
    document.getElementById("txtFirstNameMessage").innerHTML =
            fn.trim() == "" ? "First name can't be empty!" : "";
    return fn != "" ? true : false;
}

function checkLastname() {
    ln = document.getElementById("lastName").value;
    document.getElementById("txtLastNameMessage").innerHTML =
            ln.trim() == "" ? "Last name can't be empty!" : "";
    return ln != "" ? true : false;
}

function checkPassword1() {
    mk1 = document.getElementById("password").value;
    document.getElementById("txtPassword1Message").innerHTML =
            (mk1.length < 6 || mk1.length > 20) ?
            "Password length must be from 6 to 20 characters!" : "";
    return mk1.length >= 6 && mk1.length <= 20;
}

function checkPassword2() {
    mk1 = document.getElementById("password").value;
    mk2 = document.getElementById("confirmpassword").value;
    document.getElementById("txtPassword2Message").innerHTML =
            (mk1 != mk2) ? "Password doesn't match!" : "";
    return mk1 == mk2;
}

function checkEmail() {
    email = document.getElementById("email").value;
    document.getElementById("txtEmailMessage").innerHTML =
            patt_email.test(email) == false ? "Email is invalid!" : "";
    return  patt_email.test(email);
}

function checkPhone() {
    phone = document.getElementById("phone").value;
    document.getElementById("txtPhoneMessage").innerHTML =
            patt_phone.test(phone) == false ? "Phone is invalid!" : "";
    return patt_phone.test(phone);
}

function checkAllData() {
 
    isValidUserName = checkUsername();
    isValidPassword1 = checkPassword1();
    isValidPassword2 = checkPassword2();
    isValidFirstname = checkFirstname();
    isValidLastname = checkLastname();
    isValidEmail = checkEmail();
    isValidPhone = checkPhone();

    isValid = isValidUserName &&
            isValidPassword1 &&
            isValidPassword2 &&
            isValidFirstname &&
            isValidLastname &&
            isValidEmail &&
            isValidPhone;

    if (isValid == true) {
        return true;
    } else {
            return false;
    }
    //return isValid;
}