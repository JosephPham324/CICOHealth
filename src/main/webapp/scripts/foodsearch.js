let apiKey = "06Ve1mf2SCu8Ex1P/f6MVg==2N8rX79akXJaUwPS";
let query;
let button = document.querySelector(".search-wrapper .button");
let input = document.querySelector(".search-wrapper input");
let queryResult;
const meal = new Meal('None',0,0,0,0,[])
let foodItems
let selectedFoodItems
let addFoodButtons

searchFood('brisket and cheese')

function searchFood(query) {
  console.log("https://api.api-ninjas.com/v1/nutrition?query=" + query);
  var data = null;
  $.ajax({
    method: "GET",
    url: "https://api.api-ninjas.com/v1/nutrition?query=" + query,
    headers: { "X-Api-Key": apiKey },
    contentType: "application/json",
    success: function (result) {
      clearResults();
      foodItems = [];
      selectedFoodItems =[]
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
          foodItems.push(new FoodItem(item.name,item.serving_size_g,item.calories,item.protein_g,item.fat_total_g,item.carbohydrates_total_g))
          selectedFoodItems.push(false)
          appendToResults(element);
        }
      });
      console.log(foodItems)
      addFoodButtonsEventListener();
    },
    error: function ajaxError(jqXHR) {
      console.error("Error: ", jqXHR.responseText);
    },
  });
  return data;
}
button.addEventListener("click", () => {
  query = input.value;
  searchFood(query);
});

function clearResults() {
  let results = document.querySelector(".search-results");
  results.innerHTML = "";
}
function appendToResults(resultElement) {
  let results = document.querySelector(".search-results");
  results.appendChild(resultElement);
}
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



function addFoodButtonsEventListener(){
    addFoodButtons = document.querySelectorAll('.add i.icon-food')
    console.log(addFoodButtons)
    for (let i in addFoodButtons){
        if (addFoodButtons[i] instanceof Node)
        addFoodButtons[i].addEventListener('click',(item)=>{
            if (selectedFoodItems[i]==false){
                meal.addFoodItem(foodItems[i])
                addFoodButtons[i].classList.add('selected')
                selectedFoodItems[i]=true
            } else {
                selectedFoodItems[i]=false
                addFoodButtons[i].classList.remove('selected')
                meal.removeFoodItem(foodItems[i]['name'])
            }
            console.log(foodItems[i])
            console.log(meal)
        })
    }
}