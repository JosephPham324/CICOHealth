function wait(ms) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve(ms);
    }, ms);
  });
}

async function countdown(clock, millis) {
  let currentPercent = 0;
  clock.className = `c100 green p${currentPercent} center`;
  clock.childNodes[1].innerText = `${clockTimeFromMillis(millis)}`;
  console.log(clockTimeFromMillis(millis));
  let tenMillis = 100 / (millis / 10);
  while (millis != 0 && !stopClock) {
    await wait(10);
    millis -= 10;
    currentPercent += tenMillis;
    clock.className = `c100 green p${Math.floor(currentPercent)} center`;
    clock.childNodes[1].innerText = `${clockTimeFromMillis(millis)}`;
    if (stopClock)
     return false
  }
  return true
}

function clockTimeFromMillis(millis) {
  let seconds = Math.floor(millis / 1000);
  let minutes = Math.floor(seconds / 60);
  let hours = Math.floor(minutes / 60);
  if (!(seconds > 0))
    //Seconds not greater than 0
    //00:millis
    return `00:${
      millis % 1000 >= 100
        ? (millis % 1000) / 10
        : String((millis % 1000) / 10).padStart(2, "0")
    }`;
  else if (!(minutes > 0))
    //Minutes not greater than 0
    //seconds:millis
    return `${seconds >= 10 ? seconds : String(seconds).padStart(2, "0")}:${
      millis % 1000 >= 100
        ? (millis % 1000) / 10
        : String((millis % 1000) / 10).padStart(2, "0")
    }`;
  else if (!(hours > 0)) {
    //Hours not greater than 0
    //minutes:seconds:millis
    return `${minutes > 10 ? minutes : String(minutes).padStart(2, "0")}:${
      seconds % 60 >= 10 ? seconds % 60 : String(seconds % 60).padStart(2, "0")
    }:${
      millis % 1000 >= 100
        ? (millis % 1000) / 10
        : String((millis % 1000) / 10).padStart(2, "0")
    }`;
  } else {
    //hours:minutes:seconds:millis
    return `${hours >= 10 ? hours : String(hours).padStart(2, "0")}:${
      minutes % 60 > 10 ? minutes % 60 : String(minutes % 60).padStart(2, "0")
    }:${
      seconds % 60 >= 10 ? seconds % 60 : String(seconds % 60).padStart(2, "0")
    }:${
      millis % 1000 >= 100
        ? (millis % 1000) / 10
        : String((millis % 1000) / 10).padStart(2, "0")
    }`;
  }
}

async function activateSetTimer() {
  stopClock = false;
  let setNum = document.getElementById("setNum").value;
  let setTime = document.getElementById("setTime").value;
  let restTime = document.getElementById("restTime").value;
  clockForm.classList.add("hidden");
  clockContainer.classList.remove("hidden");
  clockContainer.style.transformOrigin = "center top";
  clockContainer.style.transform = `scale(${getScaleValue(
    clock,
    Math.min(screen.height / 3, screen.width / 3)
  )})`;

  for (let i = 0; i < setNum; i++) {
    clockLabel.innerHTML = `<span class = 'set-remaining'>Set: ${
      i + 1
    } of ${setNum}</span><br>Set time left`;
    if (! await countdown(clock, setTime * 1000)){
      stopClock = false;
      break;
    }
    clockLabel.innerHTML = `<span class = 'set-remaining'>Set: ${
      i + 1
    } of ${setNum}</span><br>Rest time left`;
    await countdown(clock, restTime * 1000);
    if (stopClock) {
      stopClock = false;
      break;
    }
  }
  // resetClock();
  // clockForm.classList.remove("hidden");
  // clockContainer.classList.add("hidden");

  return false;
}
let clockForm = document.querySelector(".clock-form");
let clock = document.getElementById("clock");
let clockContainer = document.querySelector(".clock");
let clockLabel = document.getElementById("clock-label");
let stopClock = false;

function getScaleValue(element, desiredSquareSize) {
  let width = element.offsetWidth;
  // console.log(width);
  // console.log(desiredSquareSize);
  // console.log((desiredSquareSize / width).toFixed(1));
  return Number((desiredSquareSize / width).toFixed(2));
}

function stopClockFunc() {
  stopClock = true;
  if (prev == nav_links[1]) changeButtonFunction(button, "timer");
}

let nav_links = document.querySelectorAll(".clock-container .nav-link");
// let views = document.querySelectorAll(".converter-panel");

function off_links() {
  nav_links.forEach((link) => {
    link.parentElement.classList.remove("active");
  });
}

function showClock() {
  clockForm.classList.add("hidden");
  clockContainer.classList.remove("hidden");
  clockContainer.style.transformOrigin = "center top";
  clockContainer.style.transform = `scale(${getScaleValue(
    clock,
    Math.min(screen.height / 3, screen.width / 3)
  )})`;
}

function hideClock() {
  clockForm.classList.remove("hidden");
  clockContainer.classList.add("hidden");
}

function stopwatchFunc() {
  stopClock = false;
  activateStopwatch();
  changeButtonFunction(button, "stop-clock");
}

function changeButtonFunction(button, func) {
  switch (func) {
    case "timer":
      button.innerText = "Start";
      button.removeEventListener("click", stopClockFunc);
      button.addEventListener("click", stopwatchFunc);
      break;
    case "set-countdown":
    default:
      button.innerText = "Stop";
      button.removeEventListener("click", stopwatchFunc);
      button.addEventListener("click", stopClockFunc);
  }
}

async function activateStopwatch() {
  stopClock = false;
  let timePassed = 0;
  clock.className = `c100 green p0 center`;
  clock.childNodes[1].innerText = `${clockTimeFromMillis(timePassed)}`;
  while (!stopClock) {
    await wait(10);
    timePassed += 10;
    clock.childNodes[1].innerText = `${clockTimeFromMillis(timePassed)}`;
  }
//  resetClock();
  stopClock = false;
}
function resetClock() {
  clockLabel.innerText = `Stopwatch`;
  clock.className = `c100 green p0 center`;
  clock.childNodes[1].innerText = `${clockTimeFromMillis(0)}`;
}

let prev = nav_links[0];
let prevButton = document.getElementById("prev-button");
let button = document.getElementById("clock-button");
nav_links.forEach((link) => {
  link.addEventListener("click", () => {
    prev = link;
    resetClock();
    off_links();
    stopClockFunc();
    link.parentElement.classList.add("active");
    // console.log(link.parentElement);
    let purpose = link.getAttribute("data-purpose");
    switch (purpose) {
      case "set-countdown":
        prevButton.classList.remove("hidden");
        hideClock();
        changeButtonFunction(button, purpose);
        break;
      case "timer":
        prevButton.classList.add("hidden");
        showClock();
        changeButtonFunction(button, purpose);
        break;
      default:
    }
  });
});

prevButton.addEventListener("click", prev.click());
