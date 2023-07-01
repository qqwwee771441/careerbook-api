function setCookie(cookie_name, value, minutes) {
    const exdate = new Date();
    exdate.setMinutes(exdate.getMinutes() + minutes);

    const cookie_value = encodeURIComponent(value) + ((minutes == null) ? '' : ';' +
        'expires=' + exdate.toUTCString());
    document.cookie = cookie_name + '=' + cookie_value;
}

function getCookie(cookie_name) {
    let cookies = document.cookie.split(';');

    for(let i=0; i<cookies.length; i++) {
        let name = cookies[i].substring(0, cookies[i].indexOf('='));
        let value = cookies[i].substring(cookies[i].indexOf('=') + 1);
        name = name.replace("/^\s+|\s+$/g", '');

        if (name == cookie_name) {
            return decodeURIComponent(value);
        }
    }
    return null;
}
