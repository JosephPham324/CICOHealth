$(document).ready(function () {
    var groupColumn = 1;
    var table = $('#exercises').DataTable({
        scrollY: '500px',
        scrollCollapse: true,
        paging: false,
        columnDefs: [{visible: false, targets: groupColumn}],
        order: [[groupColumn, 'asc']],
        displayLength: 25,
        drawCallback: function (settings) {
            var api = this.api();
            var rows = api.rows({page: 'current'}).nodes();
            var last = null;

            api
                    .column(groupColumn, {page: 'current'})
                    .data()
                    .each(function (group, i) {
                        if (last !== group) {
                            $(rows)
                                    .eq(i)
                                    .before('<tr class="group"><td colspan="8">' + group + '</td></tr>');
                            last = group;
                        }
                    });
        },
    });
});

let formContainer = document.querySelector('.edit-form')

let overlay = document.querySelector('.edit-form .overlay')

overlay.addEventListener('click', () => {
    formContainer.style.display = 'none'
})

let edit = document.querySelectorAll('.edit-button')
edit.forEach(item => {
    item.addEventListener('click', () => {
        formContainer.style.display = 'flex'
    })
})

function fillEditForm(form) {
    let itemForm = form;
    let itemFormData = new FormData(itemForm)
    let editFormInput = document.querySelectorAll('#editForm input')
    let i = 0;
    for ([key, value] of itemFormData.entries()) {
        let j = i;
        editFormInput[j].value = value;
        if (editFormInput[j].name === 'calorie') {
            let calorie = editFormInput[j].value
            let duration = editFormInput[j - 1].value
            let base = (calorie / duration)
            editFormInput[j - 1].addEventListener('input', () => {
                // console.log(base)
                editFormInput[j].value = (editFormInput[j - 1].value * base).toFixed(1)
            })
        }
        i++
    }
    return false;
}

function askDelete(message) {
    return confirm(message);
}