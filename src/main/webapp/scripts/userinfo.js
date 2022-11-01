let nav_links = document.querySelectorAll(".nav-link");
let contents = document.querySelectorAll(".info>div");
let form_container = document.querySelector(".form");
let form = document.querySelector(".form form");
let overlay = document.querySelector(".form .overlay");
let password_value = document.querySelector("#password-value").textContent;
let password_span = document.querySelector("#password-value");
let toggle_password = document.querySelector("#toggle-password-visibility");
let eye_open = '<i class="fa fa-eye" aria-hidden="true"></i>';
let eye_close = '<i class="fa fa-eye-slash" aria-hidden="true"></i>';

hideTextContent(password_span, "*");

//Toggle password visibility
toggle_password.addEventListener("click", () => {
  if (password_span.classList.contains("hidden")) {
    password_span.classList.remove("hidden");
    password_span.classList.add("visible");
    toggle_password.innerHTML = eye_open;
    showTextContent(password_span, password_value);
  } else {
    password_span.classList.remove("visible");
    password_span.classList.add("hidden");
    toggle_password.innerHTML = eye_close;
    hideTextContent(password_span, "*");
  }
});

//Change content when clicking on nav links
nav_links.forEach((item) => {
  item.addEventListener("click", () => {
    let destination = document.querySelector(
      `${item.getAttribute("data-destination")}`
    );
    contents.forEach((item) => item.classList.remove("active"));
    nav_links.forEach((item) => item.classList.remove("active"));
    destination.classList.add("active");
    item.classList.add("active");
  });
});

let edit_buttons = document.querySelectorAll(".edit");

//Show form when clicking on an edit button
edit_buttons.forEach((button) => {
  button.addEventListener("click", () => {
    form_container.classList.add("active");
  });
});

//Hide form when clicking on the background
overlay.addEventListener("click", () => {
  form_container.classList.remove("active");
});

/**
 * Hide the text content of an element
 *
 * @param {Node} element Element to replace text content
 * @param {String} replaceCharacter Character or string to replace with
 */
function hideTextContent(element, replaceCharacter) {
  element.textContent = element.textContent.replace(/./g, replaceCharacter);
}

/**
 * Show a text content in an element
 *
 * @param {Node} element Element to show text content
 * @param {String} content Text content to show
 */
function showTextContent(element, content) {
  element.textContent = content;
}

let loginEditButtons = document.querySelectorAll(".login-info .edit");
let userEditButtons = document.querySelectorAll(".user-info .edit");
let healthEditButtons = Array.from(
  document.querySelectorAll(".health-info .edit")
);
let goalEditButtons = healthEditButtons.splice(5, 4);

loginEditButtons.forEach((button) => {
  button.addEventListener("click", () => {
    if (button == loginEditButtons[1] && !correctPassword) {
      checkPassword();
      return;
    }
    let field = button.parentElement.childNodes[3];
    let loginFields = document.querySelectorAll(".login-info .field-value");
    let formContent = `
    <div class="form-group row" style = "display:${
      loginFields[0] === field ? "flex" : "none"
    }">
      <label for="username" class="col-4 col-form-label">Username</label>
      <div class="col-8">
        <input
          id="username"
          name="username"
          placeholder="Your username"
          type="text"
          class="form-control"
          aria-describedby="usernameHelpBlock"
          value = "${loginFields[0].textContent}"
        />
        <span id="usernameHelpBlock" class="form-text text-muted"
          >Help text</span
        >
      </div>
    </div>
    <div class="form-group row" style = "display:${
      loginFields[1] === field ? "flex" : "none"
    }">
      <label for="password" class="col-4 col-form-label">New Password</label>
      <div class="col-8">
        <input
          id="password"
          name="password"
          placeholder="Your password"
          type="password"
          class="form-control"
          aria-describedby="passwordHelpBlock"
          value = "${password_value}"
        />
        <span id="passwordHelpBlock" class="form-text text-muted"
          >Help text</span
        >
      </div>
    </div>
    <div class="form-group row" style = "display:${
      loginFields[1] === field ? "flex" : "none"
    }">
        <label for="confirmPassword" class="col-4 col-form-label">Confirm Password</label>
        <div class="col-8">
          <input
            id="confirmPassword"
            name="confirmPassword"
            placeholder="Confirm Password"
            type="password"
            class="form-control"
            aria-describedby="confirmPasswordHelpBlock"
          />
          <span id="confirmPasswordHelpBlock" class="form-text text-muted"
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
    </div>`;
    form.innerHTML = formContent;
    form.action = "login-edit-control";
    if (button == loginEditButtons[1]) {
      form.onsubmit = function () {
        return (
          document.getElementById("password").value ===
            document.getElementById("confirmPassword").value && correctPassword
        );
      };
    }
  });
});

userEditButtons.forEach((button) => {
  button.addEventListener("click", () => {
    let field = button.parentElement.childNodes[3];
    let userFields = document.querySelectorAll(".user-info .field-value");
    let formContent = `
        <div class="form-group row" style = "display:${
          userFields[0] === field ? "flex" : "none"
        }">
          <label for="firstName" class="col-4 col-form-label">First name:</label>
          <div class="col-8">
            <input
              id="firstName"
              name="firstName"
              placeholder="Your first name"
              type="text"
              class="form-control"
              aria-describedby="firstNameHelpBlock"
              value = "${userFields[0].textContent}"
            />
            <span id="firstNameHelpBlock" class="form-text text-muted"
              >Help text</span
            >
          </div>
        </div>
        <div class="form-group row" style = "display:${
          userFields[1] === field ? "flex" : "none"
        }">
          <label for="lastName" class="col-4 col-form-label">Last name:</label>
          <div class="col-8">
            <input
              id="lastName"
              name="lastName"
              placeholder="Your last name"
              type="text"
              class="form-control"
              aria-describedby="lastNameHelpBlock"
              value = "${userFields[1].textContent}"
            />
            <span id="lastNameHelpBlock" class="form-text text-muted"
              >Help text</span
            >
          </div>
        </div>
        <div class="form-group row" style = "display:${
          userFields[2] === field ? "flex" : "none"
        }">
            <label for="email" class="col-4 col-form-label">Email:</label>
            <div class="col-8">
              <input
                id="email"
                name="email"
                placeholder="Your email"
                type="text"
                class="form-control"
                aria-describedby="emailHelpBlock"
                value = "${userFields[2].textContent}"
              />
              <span id="emailHelpBlock" class="form-text text-muted"
                >Help text</span
              >
            </div>
        </div>
        <div class="form-group row" style = "display:${
          userFields[3] === field ? "flex" : "none"
        }">
            <label for="phone" class="col-4 col-form-label">Phone:</label>
            <div class="col-8">
              <input
                id="phone"
                name="phone"
                placeholder="Your phone"
                type="text"
                class="form-control"
                aria-describedby="phoneHelpBlock"
                value = "${userFields[3].textContent}"
              />
              <span id="phonedHelpBlock" class="form-text text-muted"
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
        </div>`;
    form.innerHTML = formContent;
    form.action = "edit-user-info-control";
  });
});

healthEditButtons.forEach((button) => {
  button.addEventListener("click", () => {
    let field = button.parentElement.childNodes[3];
    let healthFields = document.querySelectorAll(".health-info .field-value");
    let formContent = `
        <div class="form-group row" style = "display:${
          healthFields[0] === field ? "flex" : "none"
        }">
          <label for="age" class="col-4 col-form-label">Age:</label>
          <div class="col-8">
            <input
              id="age"
              name="age"
              placeholder="Your age"
              type="text"
              class="form-control"
              aria-describedby="ageHelpBlock"
              value = "${healthFields[0].textContent}"
            />
            <span id="ageBlock" class="form-text text-muted"
              >Changing this will also change your nutrition goal to maintenance</span
            >
          </div>
        </div>
        <div class="form-group row" style = "display:${
          healthFields[1] === field ? "flex" : "none"
        }">
          <label for="gender" class="col-4 col-form-label">Gender:</label>
          <div class="col-8">
            <input
              id="gender"
              name="gender"
              placeholder="Your gender"
              type="text"
              class="form-control"
              aria-describedby="genderHelpBlock"
              value = "${healthFields[1].textContent}"
            />
            <span id="genderHelpBlock" class="form-text text-muted"
              >Changing this will also change your nutrition goal to maintenance</span
            >
          </div>
        </div>
        <div class="form-group row" style = "display:${
          healthFields[2] === field ? "flex" : "none"
        }">
            <label for="height" class="col-4 col-form-label">Height:</label>
            <div class="col-8">
              <input
                id="height"
                name="height"
                placeholder="Your height"
                type="number"
                class="form-control"
                aria-describedby="heightHelpBlock"
                value = "${healthFields[2].textContent}"
              />
              <span id="heightHelpBlock" class="form-text text-muted"
                >Changing this will also change your nutrition goal to maintenance</span
              >
            </div>
        </div>
        <div class="form-group row" style = "display:${
          healthFields[3] === field ? "flex" : "none"
        }">
            <label for="weight" class="col-4 col-form-label">Weight:</label>
            <div class="col-8">
              <input
                id="weight"
                name="weight"
                placeholder="Your weight"
                type="number"
                step="0.1"
                class="form-control"
                aria-describedby="weightHelpBlock"
                value = "${healthFields[3].textContent}"
              />
              <span id="weightHelpBlock" class="form-text text-muted"
                >Changing this will also change your nutrition goal to maintenance</span
              >
            </div>
        </div>
        <div class="form-group row"  style = "display:${
          healthFields[4] === field ? "flex" : "none"
        }">
          <label class="col-4 col-form-label">Activeness</label> 
          <div class="col-8">
            <div class="custom-controls-stacked">
             <div class="custom-control custom-checkbox">
          <input name="activeness" id="activeness_0" type="radio" class="custom-control-input" value="0" required="required" aria-describedby="activenessHelpBlock"> 
          <label for="activeness_0" class="custom-control-label">Not very active</label>
            </div>
          </div>
          <div class="custom-controls-stacked">
            <div class="custom-control custom-checkbox">
              <input name="activeness" id="activeness_1" type="radio" class="custom-control-input" value="1" required="required" aria-describedby="activenessHelpBlock"> 
              <label for="activeness_1" class="custom-control-label">Lightly active</label>
            </div>
          </div>
          <div class="custom-controls-stacked">
            <div class="custom-control custom-checkbox">
              <input name="activeness" id="activeness_2" type="radio" class="custom-control-input" value="2" required="required" aria-describedby="activenessHelpBlock"> 
              <label for="activeness_2" class="custom-control-label">Active</label>
            </div>
          </div>
          <div class="custom-controls-stacked">
            <div class="custom-control custom-checkbox">
              <input name="activeness" id="activeness_3" type="radio" required="required" class="custom-control-input" value="3" aria-describedby="activenessHelpBlock"> 
              <label for="activeness_3" class="custom-control-label">Very active</label>
            </div>
          </div> 
          <span id="activenessHelpBlock" class="form-text text-muted">Changing this will also change your nutrition goal to maintenance</span>
        </div>
      </div> 
      <input type = "hidden" name ="destination" value = "user-info">
        <div class="form-group row">
          <div class="offset-4 col-8">
            <button name="submit" type="submit" class="btn btn-primary">
              Submit
            </button>
          </div>
        </div>`;
    form.innerHTML = formContent;

    document.getElementById(`activeness_${activeness}`).checked = true;
    form.action = "edit-health-info-control";
  });
});

goalEditButtons[0].addEventListener("click", () => {
  let formContent = `
  <div class="form-group row">
    <label for="dailyCalorie" class="col-4 col-form-label">Daily calorie</label> 
    <div class="col-8">
      <div class="input-group">
        <input id="dailyCalorie" name="dailyCalorie" placeholder="Enter your daily calorie" type="number" class="form-control" required="required"
        value = "${cal}" min = "0" step="0.1">
        <div class="input-group-append">
          <div class="input-group-text">kcal</div>
        </div>
        </div>
    </div>
  </div>
  <div class="form-group row">
    <label for="proteinPercentage" class="col-4 col-form-label">Protein</label> 
    <div class="col-8">
      <div class="input-group">
        <input id="proteinPercentage" name="proteinPercentage" placeholder="Enter protein percentage" type="number" class="form-control" required="required"
        value = "${
          ((protein * 4) / cal).toFixed(2) * 100
        }" min = "0" max = "100" aria-describedby="carbHelpBlock" step="0.1"> 
        <div class="input-group-append">
          <div class="input-group-text">%</div>
        </div>
      </div>
      <span id="proteinPercentageHelpBlock" class="form-text text-muted"></span>
    </div>
  </div>
  <div class="form-group row">
    <label for="fatPercentage" class="col-4 col-form-label">Fat</label> 
    <div class="col-8">
      <div class="input-group">
        <input id="fatPercentage" name="fatPercentage" placeholder="Enter fat percentage" type="number" class="form-control" required="required"
        value ="${
          ((fat * 9) / cal).toFixed(2) * 100
        }" min = "0" max = "100" aria-describedby="carbHelpBlock" step="0.1"> 
        <div class="input-group-append">
          <div class="input-group-text">%</div>
        </div>
      </div>
      <span id="fatPercentageHelpBlock" class="form-text text-muted"></span>
    </div>
  </div>
  <div class="form-group row">
    <label for="carbPercentage" class="col-4 col-form-label">Carb</label> 
    <div class="col-8">
      <div class="input-group">
        <input id="carbPercentage" name="carbPercentage" placeholder="Enter carb percentage" type="number" class="form-control"
        value = "${
          ((carb * 4) / cal).toFixed(2) * 100
        }" min = "0" max = "100" aria-describedby="carbHelpBlock" step="0.1"> 
        <div class="input-group-append">
          <div class="input-group-text">%</div>
        </div>
      </div>
      <span id="carbPercentageHelpBlock" class="form-text text-muted"></span>
    </div>
  </div> 
  <input type="hidden" name ="purpose" value="edit-cal" id ="purpose">
  <div class="form-group row">
    <div class="offset-4 col-8">
      <button name="submit" type="submit" class="btn btn-primary">Submit</button>
    </div>
  </div>
  `;
  form.innerHTML = formContent;
  form.action = "edit-goal-control";
  let proteinPercentage = document.getElementById("proteinPercentage");
  let fatPercentage = document.getElementById("fatPercentage");
  let carbPercentage = document.getElementById("carbPercentage");
  let percentages = [proteinPercentage, fatPercentage, carbPercentage];
  console.log(percentages);
  let totalPercentage;

  percentages.forEach((percentage) => {
    percentage.addEventListener("input", () => {
      let totalPercentage =
        Number(proteinPercentage.value) +
        Number(carbPercentage.value) +
        Number(fatPercentage.value);
      let helpBlock = document.getElementById(percentage.id + "HelpBlock");
      if (totalPercentage > 100 || totalPercentage < 0) {
        helpBlock.innerText = "Total percentage of 3 macro must be 100!";
      } else {
        percentages.forEach((item) => {
          document.getElementById(item.id + "HelpBlock").innerText = "";
        });
      }
    });
  });
});

goalEditButtons.slice(1).forEach((button) => {
  button.addEventListener("click", () => {
    let field = button.parentElement.childNodes[4];
    let goalFields = document.querySelectorAll(".nutrition-goal .field-value");
    console.log(field);
    console.log(goalFields);
    let formContent = `
    <div class="form-group row">
    <label for="proteinPercentage" class="col-4 col-form-label">Protein</label> 
    <div class="col-8">
      <div class="input-group">
        <input id="proteinPercentage" name="proteinPercentage" placeholder="Enter protein weight" type="number" class="form-control" required="required" aria-describedby="proteinPercentageHelpBlock"
        value="${protein}" min ="0" step = "0.1"> 
        <div class="input-group-append">
          <div class="input-group-text">g</div>
        </div>
      </div> 
      <span id="proteinPercentageHelpBlock" class="form-text text-muted">${(
        ((protein * 4) / cal) *
        100
      ).toFixed(1)}% saved daily calorie</span>
    </div>
  </div>
  <div class="form-group row">
    <label for="fatPercentage" class="col-4 col-form-label">Fat</label> 
    <div class="col-8">
      <div class="input-group">
        <input id="fatPercentage" name="fatPercentage" placeholder="Enter fat weight" type="number" class="form-control" required="required" aria-describedby="fatPercentageHelpBlock"
        value = "${fat}" min = "0" step="0.1"> 
        <div class="input-group-append">
          <div class="input-group-text">g</div>
        </div>
      </div> 
      <span id="fatPercentageHelpBlock" class="form-text text-muted">${(
        ((fat * 9) / cal) *
        100
      ).toFixed(1)}% saved daily calorie</span>
    </div>
  </div>
  <div class="form-group row">
    <label for="carbPercentage" class="col-4 col-form-label">Carb</label> 
    <div class="col-8">
      <div class="input-group">
        <input id="carbPercentage" name="carbPercentage" placeholder="Enter carb weight" type="number" class="form-control" aria-describedby="carbPercentageHelpBlock"
        value = "${carb}" min ="0" step = "0.1"> 
        <div class="input-group-append">
          <div class="input-group-text">g</div>
        </div>
      </div> 
      <span id="carbPercentageHelpBlock" class="form-text text-muted">${(
        ((carb * 4) / cal) *
        100
      ).toFixed(1)}% saved daily calories</span>
    </div>
  </div> 
  <div class ="form-group row">
      <div class ="col-form-label col-4">Total macro calorie</div>
      <div class ="col-8" id ="totalCalorie">${cal}</div>
  </div>
  <input type="hidden" name="purpose" value ="edit-macro">
  <div class="form-group row">
    <div class="offset-4 col-8">
      <button name="submit" type="submit" class="btn btn-primary">Submit</button>
    </div>
  </div>
    `;
    form.innerHTML = formContent;
    form.action="edit-goal-control"
    let proteinWeight = document.getElementById("proteinPercentage");
    let fatWeight = document.getElementById("fatPercentage");
    let carbWeight = document.getElementById("carbPercentage");
    let weights = [proteinWeight, fatWeight, carbWeight];
    let macroMap = [4, 9, 4];

    weights.forEach((weight) => {
      weight.addEventListener("input", () => {
        let calPerGram = macroMap[weights.indexOf(weight)];
        let percentage = ((Number(weight.value) * calPerGram) / cal) * 100;
        let helpBlock = document.getElementById(weight.id + "HelpBlock");
        helpBlock.innerText = `${percentage.toFixed(1)}% saved daily calorie`;
        let totalCal =0;
        weights.forEach(item=>{
          totalCal+=Number(item.value)*macroMap[weights.indexOf(item)]
        })
        document.getElementById("totalCalorie").innerText=`${totalCal.toFixed(1)}kcal`
      });
    });
  });
});
