let buttonPersonal = document.querySelector("button:first-child").addEventListener("click", function(){
    window.location.href = "personal.html"
})
let buttonCompany = document.querySelector("button:last-child").addEventListener("click", function() {
    window.location.href = "company.html"
})

let loginStrong = document.querySelector("body>span strong").addEventListener("click", function() {
    window.location.href = "../home_login/home.html"
})