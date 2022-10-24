$(document).ready( function () {
    var groupColumn = 1;
    var table = $('#meals').DataTable({
        scrollY: '500px',
        scrollCollapse: true,
        paging: false,
        columnDefs: [{ visible: false, targets: groupColumn }],
        order: [[groupColumn, 'asc']],
        displayLength: 25,
        drawCallback: function (settings) {
            var api = this.api();
            var rows = api.rows({ page: 'current' }).nodes();
            var last = null;
 
            api
                .column(groupColumn, { page: 'current' })
                .data()
                .each(function (group, i) {
                    if (last !== group) {
                        $(rows)
                            .eq(i)
                            .before('<tr class="group"><td colspan="8">' + group + '</td></tr>');
 
                        last = group;
                    }
                });
        },
    });
} );
let meal = new Meal();
let formContainer = document.querySelector('.edit-form');

let overlay = document.querySelector('.edit-form .overlay');

overlay.addEventListener('click',()=>{
    formContainer.style.display = 'none';
});
//
let edit = document.querySelectorAll('.edit-button')
edit.forEach(item=>{
    item.addEventListener('click',()=>{
        formContainer.style.display='flex'
    })
})
let mealForm = document.querySelector(".create-meal form fieldset");

/**
 * Create a food item element to display on Create Meal form
 * @param {FoodItem} item Food Item to be displayed on form
 * @param {Number} index Index in the foodItems array of the Meal object
 */
function createFormItem(item, index) {
  let html = `
  <mark>${item["name"]}:</mark>
  <strong><i class="fa-solid fa-bolt-lightning calories"></i></strong>
  <span class="calories">${item["totalCal"].toFixed(1)}</span>
  <strong><i class='fas fa-egg protein'></i></strong>
  <span class="protein">${item["proteinWeight"].toFixed(1)}g</span> 
  <strong><i class='fas fa-cheese fat'></i></strong>
  <span class="fat">${item["fatWeight"].toFixed(1)}g</span> 
  <strong><i class ='fas fa-bread-slice carbs'></i></strong>
  <span class="carbs">${item["carbWeight"].toFixed(1)}g</span>
  <strong><i class="fa-solid fa-weight-scale"></i></strong>
  <span class="weight"><input type="number" value="${item["totalWeight"]}">g</span>
  <i class="fa-solid fa-x"></i>
  `;
  let element = document.createElement("div");
  element.classList.add("food");
  element.innerHTML = html;
  element.id = `${item["name"].split(" ").join("")}_${index}`;
  
  mealForm.insertBefore(
    element,
    document.querySelector(".create-meal #submit")
  );

  //Remove item from selected
  let cross = document.querySelector(`#${item["name"]}_${index} .fa-x`);
  if (cross instanceof Node)
    cross.addEventListener("click", () => {
      let i = foodItems.indexOf(foodItems.find(food=>food.name = item.get('name')));
      selectedFoodItems[i] = false;
      addFoodButtons[i].classList.remove("selected");
      meal.removeFoodItem(`${item.get("name")}`);
      createMealForm();
    });

  //Change item weight
  let cal = document.querySelector(`#${element.id} span.calories`);
  let protein = document.querySelector(`#${element.id} span.protein`);
  let fat = document.querySelector(`#${element.id} span.fat`);
  let carb = document.querySelector(`#${element.id} span.carbs`);
  let weight = document.querySelector(`#${element.id} .weight input`);
  weight.addEventListener("input", () => {
    changeWeight(item,weight.value,item['totalWeight']);
    cal.innerHTML = `${item["totalCal"].toFixed(1)}`;
    protein.innerHTML = `${item["proteinWeight"].toFixed(1)}g`;
    fat.innerHTML = `${item["fatWeight"].toFixed(1)}g`;
    carb.innerHTML = `${item["carbWeight"].toFixed(1)}g`;
    meal = createMeal(meal["mealName"], meal["foodItems"]);
    console.log(meal);
    createFormMeal();
  });
}

/**
 * Create a meal display element and add it to the meal form
 */
function createFormMeal() {
  let currentFormMeal = document.querySelector(".food.meal");
  if (currentFormMeal instanceof Node) {
    mealForm.removeChild(currentFormMeal);
  }
  let html = `
  <strong style ="color:red;margin:15px">${meal["mealName"]}</strong>
  <strong><i class="fa-solid fa-bolt-lightning calories"></i></strong>
  <span class="calories">${meal["totalCal"].toFixed(1)}</span>
  <strong><i class='fas fa-egg protein'></i></strong>
  <span class="protein">${meal["proteinWeight"].toFixed(1)}g</span> 
  <strong><i class='fas fa-cheese fat'></i></strong>
  <span class="fat">${meal["fatWeight"].toFixed(1)}g</span> 
  <strong><i class ='fas fa-bread-slice carbs'></i></strong>
  <span class="carbs">${meal["carbWeight"].toFixed(1)}g</span>
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
function createMealForm(meal) {
  clearMealForm();
  let items = meal["foodItems"];
  let i = 0;
  items.forEach((item) => {
      createFormItem(item, i);
      i++;
  });
  createFormMeal();
}

  function changeWeight(item,newWeight,originalWeight){
    console.log(originalWeight)

    let ratio = newWeight / originalWeight
    console.log(ratio)
    item.totalWeight=newWeight;
    item.totalCal=item.totalCal *ratio;
    item.proteinWeight=item.proteinWeight*ratio;
    item.fatWeight=item.fatWeight*ratio;
    item.carbWeight=item.carbWeight*ratio;
  }



function fillEditForm(mealToEdit){
//    console.log(meal)
      meal = mealToEdit;
      createMealForm(meal);
    return false;
}
