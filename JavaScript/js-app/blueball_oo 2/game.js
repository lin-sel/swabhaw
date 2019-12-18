(function () {

    // Constant Variable.
    const DEFAULT_COLOR = '#808080';
    const LOW_NUMBER_COLOR = '#FF0000';
    const ABOVE_NUMBER_COLOR = '#008000';
    const BLUE_BALL_COLOR = '#00008B';
    const TOTAL_BALL = 50;
    var steptoWin = 5;
    const maindiv = document.getElementById("mainbox");
    const display = document.getElementById("display");
    const startgamebutton = document.getElementById("startgame");
    const rulesec = document.getElementById("rulessection");
    const leftchance = document.getElementById('leftchance');

    // On Start Button Click Event.
    startgamebutton.addEventListener("click", () => {
        display.style.display = 'block';
        maindiv.style.display = 'block';
        rulesec.style.display = 'none';
        leftchance.innerHTML = "Total Step left :" + steptoWin;

    });

    // Ball Model.
    var Ball = function (id, color) {
        if (id == undefined || color == undefined) {
            return;
        }
        this._id = id;
        this._color = color;
    }


    // Game Controller
    var GameControl = function () {
        var gamecontrol = {};
        gamecontrol.ballList = Array();
        gamecontrol.blueball;

        gamecontrol.getBlueBall = function () {
            let num = (Math.floor(Math.random() * 100)) % TOTAL_BALL;
            if (num == 0) {
                gamecontrol.getBlueBall();
            }
            gamecontrol.blueball = num;
        }

        gamecontrol.generateBalls = function () {
            gamecontrol.getBlueBall();
            for (let i = 1; i <= TOTAL_BALL; i++) {
                let ball = new Ball(i, DEFAULT_COLOR);
                gamecontrol.ballList.push(ball);
            }
        }

        gamecontrol.changeBackground = function (eball, id) {
            eventStatus = gamecontrol.checkBall(id);
            if (eventStatus.status == true) {
                eball.style.backgroundColor = eventStatus.color;
                display.innerHTML = "You Win the Game";
                return true;
            }
            eball.style.backgroundColor = eventStatus.color;
            e.disabled = true;
            return false;
        }

        gamecontrol.checkBall = function (id) {
            console.log(gamecontrol.blueball, id);
            if (id == gamecontrol.blueball) {
                return {
                    status: true,
                    color: BLUE_BALL_COLOR
                };
            }
            if (id > gamecontrol.blueball) {
                return {
                    status: false,
                    color: LOW_NUMBER_COLOR
                };
            }
            return {
                status: false,
                color: ABOVE_NUMBER_COLOR
            };
        }

        return gamecontrol;
    }


    // Create Game view.
    var HTMLViewer = function () {
        var view = {};
        var gamecontroller = GameControl();

        view.generateView = function () {
            gamecontroller.generateBalls();
            var len = gamecontroller.ballList.length;
            var balls = gamecontroller.ballList;
            for (let i = 0; i < len; i++) {
                let button = view.createViewBall(balls[i]);
                button.addEventListener("click", (e) => {
                    view.status(e, balls[i]._id);
                });
                maindiv.append(button);
            }
        }

        view.status = function (e, id) {
            let st = gamecontroller.changeBackground(e.target, id);
            if (st == true) {
                view.reloadView();
                return;
            }
            steptoWin--;
            leftchance.innerHTML = "Total Step left :" + steptoWin;
            if (steptoWin <= 0) {
                display.innerHTML = "Loose the Game Try Again" + "<br/>Page will Reload After 5 Sec.";
                view.reloadView();
            }
        }

        view.reloadView = function () {
            setTimeout(() => {
                location.reload();
            }, 5000);
        }


        view.createViewBall = function (ball) {
            let button = document.createElement("button");
            button.id = ball._id;
            button.innerHTML = ball._id;
            return button;
        }

        view.startGame = function () {
            view.generateView();
        }
        return view;
    }


    // Start Game.
    var e = HTMLViewer();
    e.startGame();

}());