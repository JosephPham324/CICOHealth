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
  if (!(et instanceof ExerciseType)){
    exerciseTypes.splice(exerciseTypes.indexOf(et),1)
  } else {
    let element = generateResultElement(et);
    appendResultElement(element);
  }
});

results = document.querySelectorAll(".search-results .result");

let createExercise = document.querySelector('.create-exercise')

results.forEach((result) => {

    result.addEventListener('click',()=>{
        createExercise.style.display ='flex'
    })
//   result.style.display = "none";
});

let overlay = document.querySelector('.overlay')

overlay.addEventListener('click',()=>{
    createExercise.style.display ='none'
})
