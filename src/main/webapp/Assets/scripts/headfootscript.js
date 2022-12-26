// When the user scrolls the page, execute myFunction
//window.onscroll = function () {
//  myFunction();
//};
//
//// Get the header
//var header = document.getElementById("myHeader");
//
//// Get the offset position of the navbar
//var sticky = header.offsetTop;
//
//// Add the sticky class to the header when you reach its scroll position. Remove "sticky" when you leave the scroll position
//function myFunction() {
//  if (window.pageYOffset > sticky) {
//    header.classList.add("sticky");
//  } else {
//    header.classList.remove("sticky");
//  }
//}

/* When the user clicks on the button,
 toggle between hiding and showing the dropdown content */
function myDropdownF(id) {
    if (document.getElementById(id).classList.contains('show'))
        document.getElementById(id).classList.remove('show')
    else
        document.getElementById(id).classList.add("show");
}

// Close the dropdown menu if the user clicks outside of it
//window.onclick = function (event) {
//    if (!event.target.matches(".personal-logo")) {
//        var dropdowns = document.getElementsByClassName("dropdown-content");
//        var i;
//        for (i = 0; i < dropdowns.length; i++) {
//            var openDropdown = dropdowns[i];
//            if (openDropdown.classList.contains("show")) {
//                openDropdown.classList.remove("show");
//            }
//        }
//    }
//};

window.onload = function () {
    let dropdowns = document.querySelectorAll('.dropdown-toggle')
//    console.log(dropdowns)

    dropdowns.forEach(dropdown => {
        let events = ['click']
        events.forEach(evt => {
//            console.log(evt)
            dropdown.addEventListener(`${evt}`, () => {
                console.log(evt)
                myDropdownF(dropdown.dataset.id);
            })
        })
    })
    
    let navLinks = document.querySelectorAll('.nav-link')
    navLinks.forEach(link=>{
        link.classList.add('noselect')
    })
}
