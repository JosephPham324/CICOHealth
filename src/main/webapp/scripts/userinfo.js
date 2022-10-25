
let nav_links = document.querySelectorAll('.nav-link')
let contents = document.querySelectorAll('.info>div')

nav_links.forEach(item=>{
    item.addEventListener('click',()=>{
        let destination = document.querySelector(`${item.getAttribute('data-destination')}`)
        contents.forEach(item=>item.classList.remove('active'))
        nav_links.forEach(item=>item.classList.remove('active'))
        destination.classList.add('active')
        item.classList.add('active')
    })
})