var speedCanvas = document.getElementById("myChart");

Chart.defaults.global.defaultFontFamily = "Lato";
Chart.defaults.global.defaultFontSize = 18;

var dataFirst = {
  label: "Your daily consumption",
  data: mealKcal,
  lineTension: 0,
  fill: false,
  borderColor: "red",
};

var dataSecond = {
  label: "Calorie Goal",
  data: goalKcal,
  lineTension: 0,
  fill: false,
  borderColor: "blue",
};

var nutritionData = {
  labels: chartLabel,
  datasets: [dataFirst, dataSecond],
};

var chartOptions = {
  legend: {
    display: true,
    position: "top",
    labels: {
      boxWidth: 80,
      fontColor: "black",
    },
  },
};

var lineChart = new Chart(speedCanvas, {
  type: "line",
  data: nutritionData,
  options: chartOptions,
});
