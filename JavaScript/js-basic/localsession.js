(function(){
    localStorage.setItem("test", 1);
    var textarea = document.getElementById("textarea");
    textarea.onchange = function(){
        var message = document.getElementById("textarea").value;
        console.log(message);
        localStorage.setItem("textarea", message);
    }

    window.onload = () =>{
        document.getElementById("textarea").innerHTML = localStorage.getItem("textarea");
    }
}());