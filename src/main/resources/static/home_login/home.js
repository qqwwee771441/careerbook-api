let signup = document.querySelector(".signup span").addEventListener("click", function() {
    window.location.href = "../signup/signup.html"
})

const username = document.querySelector('#username');
const password = document.querySelector('#password');
const submitButton = document.querySelector('button[type="submit"]');

function checkInput() {
    if (username.value && password.value.length >= 8) {
        submitButton.removeAttribute('disabled');
    } else {
        submitButton.setAttribute('disabled', true);
    }
}

username.addEventListener('input', checkInput);
password.addEventListener('input', checkInput);

//**************************************************
//                  Back End
//**************************************************

let naverLogin = document.getElementsByClassName("naver")[0].addEventListener("click", function() {
    window.location.href = "/oauth2/authorization/naver";
});

let kakaoLogin = document.getElementsByClassName("kakao")[0].addEventListener("click", function() {
    window.location.href = "/oauth2/authorization/kakao";
});

let googleLogin = document.getElementsByClassName("google")[0].addEventListener("click", function() {
    window.location.href = "/oauth2/authorization/google";
});

let companySignIn = document.querySelector("body > section > form > button").addEventListener("click", function () {
    fetch('/api/sign-in', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            "username" : username.value,
            "password" : password.value
        })
    })
        .then(response => response.json())
        .then(data => {
            window.location.href = "/";
        });
});

//**************************************************
