let apiKey = "06Ve1mf2SCu8Ex1P/f6MVg==2N8rX79akXJaUwPS";
let query;
let button = document.querySelector(".search-wrapper .button");
let input = document.querySelector(".search-wrapper input");
let queryResult;
let meal = new Meal("Breakfast", 0, 0, 0, 0, []);
let foodItems;
let selectedFoodItems;
let addFoodButtons;

searchFood("brisket and cheese");

//SEARCH BUTTON ON SEARCH BAR
button.addEventListener("click", () => {
    query = input.value;
    searchFood(query);
});

/**
 * Do a query to api-ninjas nutrition API. Push the results in foodItems array
 * @param {String} query
 * @returns none
 */
function searchFood(query) {
    console.log("https://api.api-ninjas.com/v1/nutrition?query=" + query);
    $.ajax({
        method: "GET",
        url: "https://api.api-ninjas.com/v1/nutrition?query=" + query,
        headers: {"X-Api-Key": apiKey},
        contentType: "application/json",
        success: function (result) {
            clearResults();
            foodItems = [];
            selectedFoodItems = [];
            result.forEach((item) => {
                let element = null;
                if (item !== null) {
                    element = createResultElement(
                            item.name,
                            item.serving_size_g,
                            item.calories,
                            item.protein_g,
                            item.fat_total_g,
                            item.carbohydrates_total_g
                            );
                    foodItems.push(
                            new FoodItem(
                                    item.name,
                                    item.serving_size_g,
                                    item.calories,
                                    item.protein_g,
                                    item.fat_total_g,
                                    item.carbohydrates_total_g
                                    )
                            );
                    if (meal.findFoodItem(item.name) instanceof FoodItem) {
                        selectedFoodItems.push(true);
                    } else {
                        selectedFoodItems.push(false);
                    }
                    appendToResults(element);
                }
            });
            checkSelectedItems();
            addFoodButtonsEventListener();
        },
        error: function ajaxError(jqXHR) {
            console.error("Error: ", jqXHR.responseText);
        },
    });
}

function checkSelectedItems() {
    addFoodButtons = document.querySelectorAll(".add i.icon-food");
    for (let i in selectedFoodItems) {
        if (selectedFoodItems[i] === true) {
            addFoodButtons[i].classList.add("selected");
        }
    }
}

/**
 * Clear search results in the page's search-results container
 */
function clearResults() {
    let results = document.querySelector(".search-results");
    results.innerHTML = "";
}

/**
 * Append a a result element child to the page's search-results container
 * @param {Node} resultElement result element
 */
function appendToResults(resultElement) {
    let results = document.querySelector(".search-results");
    results.appendChild(resultElement);
}

/**
 * Create a result element to be appended to search-results container
 * @param {String} name Name of food item
 * @param {Number} servingAmount Serving size (gram)
 * @param {Number} calories Calories (kcal)
 * @param {Number} protein Protein weight (gram)
 * @param {Number} fat Fat weight (gram)
 * @param {Number} carbs Carbs weight (gram)
 * @returns A result element (of type Node)
 */
function createResultElement(
        name,
        servingAmount,
        calories,
        protein,
        fat,
        carbs
        ) {
    let text = `
              <div class = "food">
                <div class="header">${name}</div>
                <div class="serving">${name}, ${servingAmount}g</div>
                <div class="nutrition-facts">
                 <span class="calories">Calories ${calories}</span><br>
                 <span class="protein"><i class='fas fa-egg'></i>P ${protein}g</span>
                 <span class="fat"><i class='fas fa-cheese'></i>F ${fat}g</span>
                 <span class="carbs"><i class ='fas fa-bread-slice'></i>C ${carbs}g</span>
                </div>
              </div>
             <div class="add">
                <i class="icon-food"></i>
             </div>
              `;
    let element = document.createElement("div");
    element.classList.add("result");
    element.innerHTML = text;
    return element;
}

let selectedNumber = document.querySelector(".belly span");

/**
 * Update the number of food items selected and stored in meal object
 */
function updateSelectedNumber() {
    let text = meal.getNumberOfItems();
    selectedNumber.innerText = text;
}

/**
 *
 */
function addFoodButtonsEventListener() {
    addFoodButtons = document.querySelectorAll(".add i.icon-food");
    let resultElements = document.querySelectorAll(".result")
    for (let i in addFoodButtons) {
        if (addFoodButtons[i] instanceof Node)
            resultElements[i].addEventListener("click", (item) => {
                if (selectedFoodItems[i] == false) {
                    meal.addFoodItem(foodItems[i]);
                    addFoodButtons[i].classList.add("selected");
                    selectedFoodItems[i] = true;
                } else {
                    selectedFoodItems[i] = false;
                    addFoodButtons[i].classList.remove("selected");
                    meal.removeFoodItem(foodItems[i]["name"]);
                }

                updateSelectedNumber();
            });
    }
}

let mealForm = document.querySelector(".create-meal form fieldset");

/**
 * Create a food item element to display on Create Meal form
 * @param {FoodItem} item Food Item to be displayed on form
 * @param {Number} index Index in the foodItems array of the Meal object
 */
function createFormItem(item, index) {
    let html = `
  <mark>${item.get("name")}:</mark>
  <strong><i class="fa-solid fa-bolt-lightning calories"></i></strong>
  <span class="calories">${item.get("totalCal").toFixed(1)}</span>
  <strong><i class='fas fa-egg protein'></i></strong>
  <span class="protein">${item.get("proteinWeight").toFixed(1)}g</span> 
  <strong><i class='fas fa-cheese fat'></i></strong>
  <span class="fat">${item.get("fatWeight").toFixed(1)}g</span> 
  <strong><i class ='fas fa-bread-slice carbs'></i></strong>
  <span class="carbs">${item.get("carbWeight").toFixed(1)}g</span>
  <strong><i class="fa-solid fa-weight-scale"></i></strong>
  <span class="weight"><input type="number" value="${item.get("totalWeight")}" min = "1">g</span>
  <i class="fa-solid fa-x"></i>
  `;
    let element = document.createElement("div");
    element.classList.add("food");
    element.innerHTML = html;
    element.id = `${item.get("name").split(" ").join("")}_${index}`;

    mealForm.insertBefore(
            element,
            document.querySelector(".create-meal #submit")
            );
    let items = foodItems
    //Remove item from selected
    let cross = document.querySelector(`#${item.get("name")}_${index} .fa-x`);
    if (cross instanceof Node)
        cross.addEventListener("click", () => {
//            console.log(items)
            meal.removeFoodItem(`${item["name"]}`);
            createMealForm();
            updateSelectedNumber();
            let i = items.indexOf(items.find(food => food.name === item.get('name')));
            if (i >= 0) {
                selectedFoodItems[i] = false;
                addFoodButtons[i].classList.remove("selected");
            }
        });

    //Change item weight
    let cal = document.querySelector(`#${element.id} span.calories`);
    let protein = document.querySelector(`#${element.id} span.protein`);
    let fat = document.querySelector(`#${element.id} span.fat`);
    let carb = document.querySelector(`#${element.id} span.carbs`);
    let weight = document.querySelector(`#${element.id} .weight input`);
    weight.addEventListener("input", () => {
        item.changeWeight(weight.value);
        cal.innerHTML = `${item.get("totalCal").toFixed(1)}`;
        protein.innerHTML = `${item.get("proteinWeight").toFixed(1)}g`;
        fat.innerHTML = `${item.get("fatWeight").toFixed(1)}g`;
        carb.innerHTML = `${item.get("carbWeight").toFixed(1)}g`;
        meal = createMeal(meal.get("mealName"), meal.get("foodItems"));
        createFormMeal();
        console.log(meal);
    });
}

/**
 * Create a meal display element and add it to the meal form
 */
function createFormMeal() {
    let currentFormMeal = document.querySelector(".food.meal");
    console.log(currentFormMeal);
    if (currentFormMeal instanceof Node) {
        mealForm.removeChild(currentFormMeal);
    }
    let html = `
  <strong style ="color:red;margin:15px">${meal.get("mealName")}</strong>
  <strong><i class="fa-solid fa-bolt-lightning calories"></i></strong>
  <span class="calories">${meal.get("totalCal").toFixed(1)}</span>
  <strong><i class='fas fa-egg protein'></i></strong>
  <span class="protein">${meal.get("proteinWeight").toFixed(1)}g</span> 
  <strong><i class='fas fa-cheese fat'></i></strong>
  <span class="fat">${meal.get("fatWeight").toFixed(1)}g</span> 
  <strong><i class ='fas fa-bread-slice carbs'></i></strong>
  <span class="carbs">${meal.get("carbWeight").toFixed(1)}g</span>
  <input type="hidden" name = "meal" value='${JSON.stringify(meal)}'>
  `;
    let element = document.createElement("div");
    element.classList.add("food");
    element.classList.add("meal");
    element.innerHTML = html;
    element.style.textAlign = "center";
    mealForm.insertBefore(
            element,
            document.querySelector(".create-meal #submit")
            );
}

/**
 * Remove all food items and meal element in the meal form
 */
function clearMealForm() {
    items = document.querySelectorAll(".create-meal .food");
    items.forEach((item) => {
        item.parentNode.removeChild(item);
    });
}

/**
 * Create the meal form used to submit a meal
 */
function createMealForm() {
    clearMealForm();
    let items = meal.get("foodItems");
    let i = 0;
    items.forEach((item) => {
        if (item instanceof FoodItem) {
            console.log(item.toString());
            createFormItem(item, i);
        }
        i++;
    });
    createFormMeal();
}

let belly = document.querySelector(".belly"); //The button to display create meal form

//If user clicks on the belly button, display the create meal form
belly.addEventListener("click", () => {
    console.log(foodItems)
    document.querySelector(".create-meal").style.display = "flex";
    createMealForm();
});

let overlay = document.querySelector(".overlay"); //Element that has blur effect

//If user clicks on the overlay, hide the meal form
overlay.addEventListener("click", () => {
    document.querySelector(".create-meal").style.display = "none";
});

/**
 * Get the name input for the meal
 * @returns false to disable submitting form
 */
function enterName() {
    let name = document.querySelector('#nameForm input[type="text"]');
    document.querySelector("#mealForm").style.display = "flex";
    document.querySelector("#nameForm").style.display = "none";
    meal.set("mealName", name.value);
    createMealForm();
    return false;
}
