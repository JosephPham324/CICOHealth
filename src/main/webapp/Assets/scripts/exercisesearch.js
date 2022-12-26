/**
* @Author: Pham Nhat Quang
*/

/**
 * Append a result element to results
 * @param {Node} element Result element to be appended
 */
function appendResultElement(element) {
    let results = document.querySelector(".exercise-search .search-results");
    results.appendChild(element);
}

/**
 * Generate a result element to to display
 * @param {ExerciseType} exerciseType Info of the exercise type 
 * @returns {Node} result element
 */
function generateResultElement(exerciseType) {
    let html = `
    <header>
        <div class="icon">
            <i class="fa-solid fa-person-running"></i>
        </div>
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
let selected;

results.forEach((result) => {
    result.addEventListener("click", () => {
        createExercise.style.display = "flex";
        selected = results.indexOf(result);
        addFormExercise(generateFormExercise(exerciseTypes[selected]))
    });
});

//hideResults();

/**
 * Hide all results
 */
function hideResults() {
    results.forEach(result => result.style.display = 'none')
}

/**
 * Generate element representing an exercise in the form
 * @param {type} exerciseType Info of the exercise
 * @returns {Node} Element representing exercise in the form
 */
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
        <input type="number" name="duration" value="60" min = "1" required/>
      </div>
        <div class="energy-expenditure totalCal">
        <strong>
        <i class="fa-solid fa-bolt-lightning">&nbsp;${exerciseType.calPerHour}kcal</i>
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

/**
 * Add an exercise in the form
 * @param {Node} element Represents the exercise
 */
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

    let totalCalElement = document.querySelector(".energy-expenditure.totalCal");
    let totalCalInput = document.querySelector("#exerciseForm input[name='kcal']")

    duration.addEventListener("input", () => {
        totalCalElement.innerHTML = `
  <strong><i class="fa-solid fa-bolt-lightning">&nbsp;${(
                minuteToHour(duration.value) * extractKcalPH(kcalph.innerHTML)
                ).toFixed(0)}kcal</i></strong>
  `;
        totalCalInput.value = (minuteToHour(duration.value) * extractKcalPH(kcalph.innerHTML)).toFixed(1)
    });
}

/**
 * Extract number value in a text representing calories
 * @param {string} text Text to get value
 * @returns Number extracted
 */
function extractKcalPH(text) {
    let regex = /\d+(\.\d+)?/;
    return regex.exec(text)[0];
}

let overlay = document.querySelector(".overlay");

overlay.addEventListener("click", () => {
    createExercise.style.display = "none";
});


let searchBar = document.querySelector("#search")

searchBar.addEventListener('input', () => {
    hideResults()
    showResultElements(searchBar.value)
})

/**
 * Show results elements with a desired content
 * @param {type} content Desired content
 */
function showResultElements(content) {
    if (content !== '') {
        let show = results.filter(o => checkExerciseName(o, content))

        show.forEach(element => element.style.display = 'flex')
    }
}

/**
 * Check if text content of an element contains desired content
 * @param {type} element Result element to check
 * @param {type} content Desired content
 * @returns {Node} The element if content is found
 */
function checkExerciseName(element, content) {
    let regex = new RegExp(`${content.toLowerCase()}`)

    if (regex.test((element.textContent).toLowerCase())) {
        return element
    }
}
