let apiKey = "06Ve1mf2SCu8Ex1P/f6MVg==2N8rX79akXJaUwPS";
let query;
let button = document.querySelector(".search-wrapper .button");
let input = document.querySelector(".search-wrapper input");
let queryResult;
function searchFood(query) {
    console.log("https://api.api-ninjas.com/v1/nutrition?query=" + query);
    var data = null;
    $.ajax({
        method: "GET",
        url: "https://api.api-ninjas.com/v1/nutrition?query=" + query,
        headers: {"X-Api-Key": apiKey},
        contentType: "application/json",
        success: function (result) {
            clearResults();
            result.forEach((item) => {
                console.log(item);
                let element = null;
                if (item !== null) {
                    console.log(item);
                    element = createResultElement(
                            item.name,
                            item.serving_size_g,
                            item.calories,
                            item.protein_g,
                            item.fat_total_g,
                            item.carbohydrates_total_g
                            );
                    appendToResults(element);
                }
            });
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
              <div class="header">${name}</div>
              <div class="serving">${name}, ${servingAmount}g</div>
              <div class="nutrition-facts">
                <span class="calories">Calories ${calories}</span><br>
                <span class="protein"><i class='fas fa-egg'></i>P ${protein}g</span>
                <span class="fat"><i class='fas fa-cheese'></i>F ${fat}g</span>
                <span class="carbs"><i class ='fas fa-bread-slice'></i>C ${carbs}g</span>
              </div>
              `;
    let element = document.createElement("div");
    element.classList.add("food");
    element.innerHTML = text;
    return element;
}
