$(document).ready(function () {
    var groupColumn = 0;
    var table = $('#stats-table').DataTable({
        scrollY: '600px',
        scrollCollapse: true,
        paging: false,
        columnDefs: [{ visible: false, targets: groupColumn }],
        order: [[groupColumn, 'asc']],
        displayLength: 25,
        drawCallback: function (settings) {
            var api = this.api();
            var rows = api.rows({ page: 'current' }).nodes();
            var last = null;
 
            api
                .column(groupColumn, { page: 'current' })
                .data()
                .each(function (group, i) {
                    if (last !== group) {
                        $(rows)
                            .eq(i)
                            .before('<tr class="group"><td colspan="10">' + group + '</td></tr>');
 
                        last = group;
                    }
                });
        },
    });
 
    // Order by the grouping
    $('#example tbody').on('click', 'tr.group', function () {
        var currentOrder = table.order()[0];
        if (currentOrder[0] === groupColumn && currentOrder[1] === 'asc') {
            table.order([groupColumn, 'desc']).draw();
        } else {
            table.order([groupColumn, 'asc']).draw();
        }
    });
});


let buttonTable = document.getElementById("buttonTable")
let buttonChart = document.getElementById("buttonChart")

buttonTable.addEventListener('click',()=>{
    buttonTable.classList.add('active')
    buttonChart.classList.remove('active')
    document.querySelector('.info-table').classList.add('active')
    document.querySelector('.info-chart').classList.remove('active')
})
buttonChart.addEventListener('click',()=>{
    buttonChart.classList.add('active')
    buttonTable.classList.remove('active')
    document.querySelector('.info-chart').classList.add('active')
    document.querySelector('.info-table').classList.remove('active')
})