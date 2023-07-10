let strong = document.querySelector("body>span strong").addEventListener("click", function() {
    window.location.href = "company.html"
})

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

//**************************************************
