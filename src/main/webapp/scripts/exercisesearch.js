function appendResultElement(element) {
  let results = document.querySelector(".exercise-search .search-results");
  results.appendChild(element);
}

function generateResultElement(exerciseType) {
  let html = `
    <header>
        <div class="icon"></div>
    </header>
    <div class="description">
        <div class="exercise-name">${exerciseType.exerciseName}</div>
        <div class="exercise-description">${exerciseType.description}</div>
        <div class="energy-expenditure">
        <strong><i class="fa-solid fa-bolt-lightning calories"></i></strong>
        ${exerciseType.calPerHour}kcal</div>
    </div>`;
  let res = document.createElement("div");
  res.innerHTML = html;
  res.classList.add("result");
  return res;
}
// console.log('hello')
exerciseTypes.forEach((et) => {
  if (!(et instanceof ExerciseType)) {
    exerciseTypes.splice(exerciseTypes.indexOf(et), 1);
  } else {
    let element = generateResultElement(et);
    appendResultElement(element);
  }
});

results = document.querySelectorAll(".search-results .result");
results = Array.prototype.slice.call(results);
let createExercise = document.querySelector(".create-exercise");
console.log(results);
let selected;

results.forEach((result) => {
  result.addEventListener("click", () => {
    createExercise.style.display = "flex";
    selected = results.indexOf(result);
    console.log(selected);
    console.log(exerciseTypes[selected]);
    addFormExercise(generateFormExercise(exerciseTypes[selected]))
  });
  //   result.style.display = "none";
});

function generateFormExercise(exerciseType) {
  let html = `
      <div class="exercise-name">${exerciseType.exerciseName}</div>
        <div class="energy-expenditure">
          <strong
                ><i class="fa-solid fa-bolt-lightning"
                  >&nbsp;${exerciseType.calPerHour}kcal/h</i>
          </strong>
        </div>
      <div class="duration">
        <label for="duration">Duration (minutes):</label>
        <input type="number" name="duration" value="60" />
      </div>
        <div class="energy-expenditure totalCal">
        <strong>
        <i class="fa-solid fa-bolt-lightning">&nbsp;684kcal/h</i>
        </strong>
      </div>
      <input type="hidden" name = "exerciseName" value = "${exerciseType.exerciseName}">
      <input type="hidden" name = "description" value = "${exerciseType.description}">
      <input type="hidden" name = "kcalph" value = "${exerciseType.calPerHour}">
      <input type="hidden" name="kcal" value = "${exerciseType.calPerHour}">
  `;
  let element = document.createElement("div");
  element.classList.add("description");
  element.innerHTML = html;

  return element;
}

/**
 * Remove all food items and meal element in the meal form
 */
function clearExerciseForm() {
  items = document.querySelectorAll(".create-exercise .description");
  items.forEach((item) => {
    item.parentNode.removeChild(item);
  });
}

function addFormExercise(element) {
  clearExerciseForm();

  let exerciseForm = document.querySelector("#exerciseForm fieldset");

  exerciseForm.insertBefore(
    element,
    document.querySelector("#exerciseForm #submit")
  );


  let duration = document.querySelector("#exerciseForm .duration input[name='duration']");
  let kcalph = document.querySelector(
    "#exerciseForm .description .energy-expenditure"
  );


  console.log(extractKcalPH(kcalph.innerHTML));

  let kcalphValElement = document.querySelector(".energy-expenditure.totalCal");

  duration.addEventListener("input", () => {
    kcalphValElement.innerHTML = `
  <strong><i class="fa-solid fa-bolt-lightning">&nbsp;${(
    minuteToHour(duration.value) * extractKcalPH(kcalph.innerHTML)
  ).toFixed(0)}kcal/h</i></strong>
  `;
  });
}

function extractKcalPH(text) {
  let regex = /\d+(\.\d+)?/;
  return regex.exec(text)[0];
}

let overlay = document.querySelector(".overlay");

overlay.addEventListener("click", () => {
  createExercise.style.display = "none";
});
