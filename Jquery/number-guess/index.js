


$(document).ready(function () {
    var randomNumber = function () {
        console.log("inside random")
        return Math.floor(Math.random() * 10);
    }();

    var turn = 5;
    $("#check").click(function () {
        console.log(randomNumber);
        if (turn > 0) {
            turn--;
            let num = $("#inputnumber").val();
            console.log(typeof num);
            if ($("#inputnumber").val() != randomNumber) {
                if (num > randomNumber) {
                    setNotification("<h5> Chance left: " + turn + "</h5><h3>To High Number</h3>");
                    return;
                }
                setNotification("<h5> Chance left: " + turn + "</h5><h3>Low Number</h3>");
                return;
            }
            setNotification("<h3>You Win the Game</h3>");
            return;
        }
        setNotification("<h5> Chance left: " + turn + "</h5><h3>You Have Failed to Guess Number start Game Again</h3>");
        setTimeout(() => {
            location.reload()
        }, 3000);
    });

    function setNotification(msg) {
        $("#notification").html(msg);
    }
});