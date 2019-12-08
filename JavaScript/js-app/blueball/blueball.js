(function () {

    const buttonsec = document.getElementById("buttonsec");
    const displaynotification = document.getElementById("display");
    var detail = document.getElementById("details");
    const maxbutton = 50;
    var selectedbutton;
    var attempt = 5;

    document.getElementById("startgame").addEventListener("click", () => {
        document.getElementById("rulessection").style.display = "none";
        document.getElementById("main").style.display = "block";
        console.log(selectedbutton);
    });


    window.onload = function () {
        for (var init = 1; init <= maxbutton; init++) {
            var button = document.createElement("button");
            button.innerHTML = init.toString();
            button.addEventListener("click", checkbutton);
            buttonsec.append(button);
        }
        randomButtonSelect();
        checkAttempt();
    }


    function randomButtonSelect() {
        selectedbutton = Math.floor(Math.random() * 100) % maxbutton;
        if (selectedbutton == 0) {
            randomButtonSelect();
        }
    }

    function checkbutton(e) {
        attempt -= 1;
        checkAttempt();
        if (e.target.innerHTML == selectedbutton) {
            e.target.style.backgroundColor = "blue";
            alert("You Have Win the Game.");
            reload();
            return;
        }
        else if (Number(e.target.innerHTML) > selectedbutton) {
            e.target.style.backgroundColor = "red";
            return;
        }
        e.target.style.backgroundColor = "green";
    }

    function checkAttempt() {
        if (attempt > 0) {
            detail.innerHTML = "Total Attempt left: " + attempt;
            return;
        }
        detail.innerHTML = "Total Attempt left: " + attempt + "<br/> Lose the Game.";
        reload();
    }

    function reload() {
        setTimeout(() => {
            location.reload();
        }, 5000);
    }
}());