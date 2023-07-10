let strong = document.querySelector("body>span strong").addEventListener("click", function() {
    window.location.href = "personal.html"
})

const businessRegistrationNumber = document.querySelector('#businessRegistrationNumber')
const username = document.querySelector('#username')
const password = document.querySelector('#password')
const submitButton = document.querySelector('button[type="submit"]')

function validateBusinessRegistrationNumber(input) {
  input.disabled = true;
  return fetch('https://api.odcloud.kr/api/nts-businessman/v1/status?serviceKey=Nacw8DWX7ijD0FFh%2FOyLS4Enc4eInNaVyp%2FMYTSnDR5%2BDjpFm8kVcu8iVDMwx1yal9oZyEWXpZvzkvEohl6ytQ%3D%3D', {
      method: 'POST',
      headers: {
          'Content-Type': 'application/json'
      },
      body: JSON.stringify({
          b_no: [input.value]
      })
  })
  .then(response => response.json())
  .then(data => {
      input.disabled = false;
      return data.data[0].b_stt_cd === '01';
  });
}

function validateUsername(input) {
  return /^[a-z0-9]{5,}$/.test(input.value);
}

function validatePassword(input) {
  return /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/.test(input.value);
}

businessRegistrationNumber.addEventListener('input', () => {
  if (businessRegistrationNumber.value.length === 10) {
      updateInputStatus(businessRegistrationNumber, validateBusinessRegistrationNumber, "유효하지 않은 사업자등록번호 입니다.");
      validateBusinessRegistrationNumber(businessRegistrationNumber).then(isValid => {
          submitButton.disabled = !validateUsername(username) || !validatePassword(password) || !isValid;
      });
  } else {
      businessRegistrationNumber.style.border = '';
      businessRegistrationNumber.nextElementSibling.textContent = '';
      submitButton.disabled = true;
  }
});

username.addEventListener('input', () => {
  if (username.value.length > 0) {
    updateInputStatus(username, validateUsername, "5자리 이상 영문소문자, 숫자만 사용 가능합니다.");
    submitButton.disabled = !validateUsername(username) || !validatePassword(password);
  } else {
    username.style.border = '';
    username.nextElementSibling.textContent = '';
    submitButton.disabled = true;
  }
});

password.addEventListener('input', () => {
  if (password.value.length > 0) {
    updateInputStatus(password, validatePassword, "8자리 이상 영문대소문자, 숫자, 특수문자를 포함해야합니다.");
    submitButton.disabled = !validateUsername(username) || !validatePassword(password);
  } else {
    password.style.border = '';
    password.nextElementSibling.textContent = '';
    submitButton.disabled = true;
  }  
});

function updateInputStatus(input, validateFunction, invalidMessage) {
  Promise.resolve(validateFunction(input)).then(isValid => {
      if (isValid) {
          input.style.border = '2px solid green';
          input.nextElementSibling.textContent = '';
      } else {
          input.style.border = '2px solid red';
          input.nextElementSibling.textContent = invalidMessage;
      }
  });
}

window.addEventListener('beforeunload', () => {
  document.querySelector('form').reset();
});

//**************************************************
//                  Back End
//**************************************************

let signUp = document.querySelector("body > section > form > button").addEventListener("click", function() {
    fetch('/api/sign-up', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            "username" : username.value,
            "password" : password.value,
            "businessRegistrationNumber" : businessRegistrationNumber.value
        })
    })
        .then(response => response.json())
        .then(data => {
            window.location.href = "/";
        });
});

//**************************************************
