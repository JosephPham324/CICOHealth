function appendResultElement(element){
    let results = document.querySelector('.exercise-search .search-results')
    results.appendChild(element)
}

function generateResultElement(exerciseType) {
  if (!(exerciseType instanceof ExerciseType)) return null;
  let html = `
    <header>
        <div class="icon"></div>
    </header>
    <div class="description">
        <div class="exercise-name">${exerciseType.exerciseName}</div>
        <div class="exercise-description">${exerciseType.description}</div>
        <div class="energy-expenditure">${exerciseType.calPerHour}</div>
    </div>`;
    let res = document.createElement('div')
    res.innerHTML=html
    res.classList.add('result')
    return res
}
// console.log('hello')
exerciseTypes.forEach(et=>{
    // console.log('hello?')
    let element = generateResultElement(et)
    appendResultElement(element)
})

// results = document.querySelectorAll(".search-results .result");

// results.forEach((result) => {
//   result.style.display = "none";
// });
