function auth(email, password) {
    var xhr = new XMLHttpRequest();
    var url = "localhost:8080/login";
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    /*xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var json = JSON.parse(xhr.responseText);
            console.log(json.email + ", " + json.password);
        }
    };
    */
    var data = {"email" : email,
        "password" : password };
    xhr.send(data);


}