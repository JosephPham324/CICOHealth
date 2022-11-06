document.addEventListener("DOMContentLoaded", () => {
    let calEaten = document.getElementById("cal-eaten");
    let allNumbers = document.querySelector(".all-numbers");
    let todayNumbers = document.querySelector(".today-numbers");
    let content;

    calEaten.addEventListener("click", () => {
        if (allNumbers.classList.contains("active")) {
            calEaten.textContent = content;
            allNumbers.classList.remove("active");
            todayNumbers.classList.remove("active");
        } else {
            content = calEaten.textContent;
            calEaten.textContent = 'Hide';
            allNumbers.classList.add("active");
            todayNumbers.classList.add("active");
        }
    });
});