(function () {
    document.getElementById("submit").addEventListener("click", getData);
    var message = document.getElementById("message");
    var input = document.getElementById("input");
    const xhr = new XMLHttpRequest();


    function getData() {
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && this.status == 200) {
                getTimeStamp();
                addNode(xhr.responseText);
            }
        }
        var url = "http://numbersapi.com/";
        url = url + input.value;
        xhr.open("GET", url, true);
        xhr.send();
    }

    function addNode(msg) {
        var node = document.createElement("li");
        node.append(document.createTextNode(msg));
        message.appendChild(node);
    }

    function getTimeStamp() {
        var d = Date();
        console.log(d.valueOf());
    }



}());