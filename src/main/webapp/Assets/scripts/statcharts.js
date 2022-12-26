/**
 * Configuration for statistics chart
 * @Author Pham Nhat Quang
 */

var canvas = document.getElementById("myChart");//Canvas to draw

//Font settings
Chart.defaults.global.defaultFontFamily = "Lato";
Chart.defaults.global.defaultFontSize = 18;

var dataFirst = {//Data for first line graph
  label: "Total daily calorie",
  data: mealKcal,
  lineTension: 0,
  fill: false,
  borderColor: "red",
};

var dataSecond = {//Data for second line graph
  label: "Calorie Goal",
  data: goalKcal,
  lineTension: 0,
  fill: false,
  borderColor: "blue",
};

var nutritionData = {//To draw
  labels: chartLabel,
  datasets: [dataFirst, dataSecond],
};

var chartOptions = {//Options
  legend: {//Legend display
    display: true,
    position: "top",
    labels: {
      boxWidth: 80,
      fontColor: "black",
    },
  },
  scales: {//Naming axes
    yAxes: [{
      scaleLabel: {
        display: true,
        labelString: 'kcal'
      }
    }],
    xAxes: [{
      scaleLabel: {
        display: true,
        labelString: 'date'
      }
    }]
  }  
};
//Display the chart
var lineChart = new Chart(canvas, {
  type: "line",
  data: nutritionData,
  options: chartOptions,
});
