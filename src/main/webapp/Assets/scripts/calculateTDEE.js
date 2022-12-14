/**
 * @Author: Nguyen Le Quang Thinh
 */
document.getElementById("results").style.display = "none";
document.getElementById("results_2").style.display = "none";
smit.addEventListener("click", function (e) {
  // Runs getValues when form's submit button is clicked.
  e.preventDefault();
  getValues();
});

getValues = () => {
  // Converts values from form fields into integers, then assigns these integers to variables.
  const age = parseInt(document.getElementById("age").value);
  const gender = document.getElementsByName("gender"); // This produces a node-list with 2 items, male and female.  Male is checked by default.
  var checkedgender;
  // Loops through the node-list and checks which item is checked.  
  // Then assigns the value of the checked item to the variable checkedgender.
  gender.forEach((e) => {
    if (e.checked) {
      checkedgender = e.value;
    }
  });
  const height = parseInt(document.getElementById("height").value);
  const weight = parseInt(document.getElementById("weight").value);

  var element = document.querySelector('input[name="activity"]:checked');
  let activenessMap = [1.2, 1.375, 1.55, 1.725];
  var checkedButton;
  checkedButton = activenessMap[element.value];
  const activeness = parseFloat(checkedButton);
  finalResult(age, checkedgender, height, weight, activeness);
  createCaloriePlans(weight, height, age, checkedgender, activeness);
};

// Reveals the 'results' box which was originally hidden (see line 1)
finalResult = (age, gender, height, weight) => {
  let finalResult = 0;
  if (gender === "Male") {
    finalResult = 13.397 * weight + 4.799 * height - 5.677 * age + 88.362;
  } else {
    finalResult = 9.247 * weight + 3.098 * height - 4.33 * age + 447.593;
  }

  console.log(finalResult);
  revealResult(finalResult); // Calls below function & passes finalResult as an argument.
  return finalResult;
};

/**
 * Create calorie plans from health info
 * @param {Number} weight Person's weight
 * @param {Number} height Person's height
 * @param {Number} age Person's age
 * @param {Boolean} gender Person's gender
 * @param {Number} activeness Person's activenness
 * @returns 7 calorie plan for weight maintenance, weight loss and weight gain
 */
createCaloriePlans = (weight, height, age, gender, activeness) => {
  let TDEE = 0;
  if (gender === "Male") {
    TDEE =
      (13.397 * weight + 4.799 * height - 5.677 * age + 88.362) * activeness;
  } else {
    TDEE =
      (9.247 * weight + 3.098 * height - 4.33 * age + 447.593) * activeness;
  }
  console.log(TDEE);
  TDEE = Math.floor(TDEE);
  var plans = [];
  plans.push("Maintenance", TDEE, TDEE, 0);
  plans.push("Light Weight Loss", TDEE, TDEE - 300, -300 * 7);
  plans.push("Moderate Weight Loss", TDEE, TDEE - 500, -500 * 7);
  plans.push("Extreme Weight Loss", TDEE, TDEE - 700, -700 * 7);
  plans.push("Light Weight Gain", TDEE, TDEE + 300, 300 * 7);
  plans.push("Moderate Weight Gain", TDEE, TDEE + 500, 500 * 7);
  plans.push("Extreme Weight Gain", TDEE, TDEE + 700, 700 * 7);
  console.log(plans);

  document.getElementById("results_3").style.display = "none";
  document.getElementById("results_2").style.display = "block"; // Reveals the 'results' box which was originally hidden (see line 1)

  var strMsg = `
  <style>
  td {text-align: center; color: white; padding-right: 8px;}
  </style>
  <table>
  <tr>
  <td><b>Name<br/>&ensp;</b></td>
  <td><b>Maintenance <br/>Calories </b></td>
  <td><b>Calorie <br/>plan </b></td>
  <td><b>Energy Balance <br/>Per Week </b></td>
  </tr>
  `;
  for (const index in plans) {
    console.log(index);
    if ([0, 4, 8, 12, 16, 20, 24].includes(index)) {
      strMsg += "<tr>";
    //   console.log("open" + index);
    }

    strMsg += "<td>" + plans[index] + "</td>";

    if ([3, 7, 11, 15, 19, 23, 27].includes(index)) {
      strMsg += "</tr>";
    //   console.log("close" + index);
    }
  }
  strMsg += "</table>";
  const plan = document.getElementById("plan-result"); // Grabs 'p' element.4
  plan.innerHTML = strMsg;
  plan.classList.add("finalNumberStyling"); // Applies simple styling to 'p' element.
  return plans;
};

// Reveals the 'results' box which was originally hidden (see line 1)
revealResult = (finalResult) => {
  finalResult = Math.floor(finalResult);
  let finalBmi = finalResult.toString();

  document.getElementById("results").style.display = "block"; // Reveals the 'results' box which was originally hidden (see line 1)
  const calories = document.getElementById("bmi-result"); // Grabs 'p' element.
  calories.classList.add("finalNumberStyling"); // Applies simple styling to 'p' element.
  calories.innerText = finalBmi + " calories per day"; // Inserts finalBmi string into 'p' element.
};
