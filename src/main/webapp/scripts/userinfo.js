
let nav_links = document.querySelectorAll('.nav-link')
let contents = document.querySelectorAll('.info>div')
let form = document.querySelector('.form')
let overlay = document.querySelector('.form .overlay')
nav_links.forEach(item=>{
    item.addEventListener('click',()=>{
        let destination = document.querySelector(`${item.getAttribute('data-destination')}`)
        contents.forEach(item=>item.classList.remove('active'))
        nav_links.forEach(item=>item.classList.remove('active'))
        destination.classList.add('active')
        item.classList.add('active')
    })
})

let editButtons = document.querySelectorAll('.edit')

editButtons.forEach(button=>{
    button.addEventListener('click',()=>{
        form.classList.add('active')
    })
})

overlay.addEventListener('click',()=>{
    form.classList.remove('active')
})