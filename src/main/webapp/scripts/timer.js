function wait(ms) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve(ms);
    }, ms);
  });
}
async function countdown(clock, seconds) {
  let currentPercent = 0;
  clock.className = `c100 p${currentPercent} center`;
  clock.childNodes[1].innerText = `${clockTimeFromSeconds(seconds)}`;
  let oneSec = 100 / seconds;
  while (seconds != 0 && !stopClock) {
    await wait(1000);
    seconds--;
    currentPercent += oneSec;
    clock.className = `c100 green p${Math.floor(currentPercent)} center`;
    clock.childNodes[1].innerText = `${clockTimeFromSeconds(seconds)}`;
  }
}

function clockTimeFromSeconds(seconds) {
  let minutes = Math.floor(seconds / 60);
  let hours = Math.floor(minutes / 60);
  if (!(minutes > 0))
    return `00:${seconds >= 10 ? seconds : String(seconds).padStart(2, "0")}`;
  else if (!(hours > 0)) {
    return `${minutes > 10 ? minutes : String(minutes).padStart(2, "0")}:${
      seconds % 60 >= 10 ? seconds % 60 : String(seconds % 60).padStart(2, "0")
    }`;
  } else {
    return `${hours >= 10 ? hours : String(hours).padStart(2, "0")}:${
      minutes % 60 > 10 ? minutes % 60 : String(minutes % 60).padStart(2, "0")
    }:${
      seconds % 60 >= 10 ? seconds % 60 : String(seconds % 60).padStart(2, "0")
    }`;
  }
}

async function activateSetTimer() {
  let setNum = document.getElementById("setNum").value;
  let setTime = document.getElementById("setTime").value;
  let restTime = document.getElementById("restTime").value;
  clockForm.classList.add("hidden");
  clockContainer.classList.remove("hidden");
  console.log(clockContainer);
  clockContainer.style.transformOrigin = 'center';
  clockContainer.style.transform = `scale(${getScaleValue(
    clock,
    Math.min(screen.height / 3, screen.width / 3)
  )})`;

  for (let i = 0; i < setNum; i++) {
    clockLabel.innerHTML = `<span class = 'set-remaining'>Set: ${i+1} of ${setNum}</span><br>Set time left`;
    await countdown(clock, setTime);
    clockLabel.innerHTML = `<span class = 'set-remaining'>Set: ${i+1} of ${setNum}</span><br>Rest time left`;
    await countdown(clock, restTime);
    if (stopClock) {
        stopClock = false
        break;
    }
  }
  clockForm.classList.remove("hidden");
  clockContainer.classList.add("hidden");

  return false;
}
let clockForm = document.querySelector(".clock-form");
let clock = document.getElementById("clock");
let clockContainer = document.querySelector(".clock");
let clockLabel = document.getElementById("clock-label");
let stopClock = false;
function getScaleValue(element, desiredSquareSize) {
  let width = element.offsetWidth;
  console.log(width);
  console.log(desiredSquareSize);
  console.log((desiredSquareSize / width).toFixed(1));
  return Number((desiredSquareSize / width).toFixed(2));
}

function stopClockFunc() {
  stopClock = true;
  console.log('')
}
