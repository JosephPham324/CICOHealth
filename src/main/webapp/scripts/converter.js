let nav_links = document.querySelectorAll('.nav-link');
let views = document.querySelectorAll('.converter-panel')
function off_links(){
    nav_links.forEach(link =>{
        link.parentElement.classList.remove('active')
    })
}
function off_views(){
    views.forEach(view=>{
        console.log(view)
        view.classList.remove('active')
    })
}
nav_links.forEach(link => {
    link.addEventListener('click',()=>{
        off_links();
        link.parentElement.classList.add('active')
        let destination = document.querySelector(//Get the desired view element
        `${link.getAttribute("data-destination")}`
        );
        off_views()
        destination.classList.add('active')
    })
})