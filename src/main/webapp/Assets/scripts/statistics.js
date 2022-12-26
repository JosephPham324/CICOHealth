/**
 * Script for statistics table and some other components like buttons
 * @Author Pham Nhat Quang
 *
 */

$(document).ready(function () {
  var groupColumn = 0;
  var table = $("#stats-table").DataTable({
    //Turn stats-table into datatable
    scrollY: "600px", //Body display height 600px
    scrollCollapse: true, //Collapse height to scrollY height
    paging: false, //No paging
    //Some columns settings
    columnDefs: [
      { visible: false, targets: groupColumn },
      { className: "dt-center", targets: "_all" },
    ],
    order: [[groupColumn, "asc"]], //Ascending order for group column
    displayLength: 25,
    drawCallback: function (settings) {
      //Callback function for grouping
      var api = this.api();
      var rows = api.rows({ page: "current" }).nodes(); //Get all rows of current page
      var last = null;

      api
        .column(groupColumn, { page: "current" }) //Get the grouping column of current page
        .data() //Turn to data objects
        .each(function (group, i) {
          //Iterate
          if (last !== group) {
            //If current group cell is different from current group
            //Add a grouping header at row before current ow
            $(rows)
              .eq(i)
              .before(
                '<tr class="group"><td colspan="10">' + group + "</td></tr>"
              );

            last = group; //Update current group
          }
        });
    },
  });

  // Order by the grouping
  $("#example tbody").on("click", "tr.group", function () {
    var currentOrder = table.order()[0];
    if (currentOrder[0] === groupColumn && currentOrder[1] === "asc") {
      table.order([groupColumn, "desc"]).draw();
    } else {
      table.order([groupColumn, "asc"]).draw();
    }
  });
});

let buttonTable = document.getElementById("buttonTable"); //Button to switch view to table
let buttonChart = document.getElementById("buttonChart"); //Button to switch biew to chart

//WHen table button is clicked, hide chart and dislay table
buttonTable.addEventListener("click", () => {
  buttonTable.classList.add("active");
  buttonChart.classList.remove("active");
  document.querySelector(".info-table").classList.add("active");
  document.querySelector(".info-chart").classList.remove("active");
});

//When chart button is clicked, hide talbe and display chart
buttonChart.addEventListener("click", () => {
  buttonChart.classList.add("active");
  buttonTable.classList.remove("active");
  document.querySelector(".info-chart").classList.add("active");
  document.querySelector(".info-table").classList.remove("active");
});
