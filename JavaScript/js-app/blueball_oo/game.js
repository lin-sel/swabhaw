(function () {

    const DEFAULT_COLOR = '#808080';
    const LOW_NUMBER_COLOR = '#FF0000';
    const ABOVE_NUMBER_COLOR = '#008000';
    const BLUE_BALL_COLOR = '	#00008B';
    const TOTAL_BALL = 50;
    var steptoWin = 5;
    const maindiv = document.getElementById("mainbox");
    const display = document.getElementById("display");
    const startgamebutton = document.getElementById("startgame");
    const rulesec = document.getElementById("rulessection");
    const leftchance = document.getElementById('leftchance');

    startgamebutton.addEventListener("click", () => {
        display.style.display = 'block';
        maindiv.style.display = 'block';
        rulesec.style.display = 'none';
        leftchance.innerHTML = "Total Step left :" + steptoWin;

    });

    var Ball = function (id, color) {

        if (id == undefined || color == undefined) {
            return;
        }
        this._id = id;
        this._color = color;

        this.showColor = function () {
            document.getElementById(this._id).style.backgroundColor = this._color;
        }

        this.setColor = function (color) {
            this._color = color;
            this.showColor();
        }
    }

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

        gamecontrol.checkBall = function (ball) {
            console.log(gamecontrol.blueball);
            if (ball._id == gamecontrol.blueball) {
                ball.setColor(BLUE_BALL_COLOR);
                return {
                    status: true,
                    color: BLUE_BALL_COLOR
                };
            }
            if (ball._id > gamecontrol.blueball) {
                ball.setColor(LOW_NUMBER_COLOR);
                return {
                    status: false,
                    color: LOW_NUMBER_COLOR
                };
            }
            ball.setColor(ABOVE_NUMBER_COLOR);
            return {
                status: false,
                color: ABOVE_NUMBER_COLOR
            };
        }

        return gamecontrol;
    }

    var HTMLViewer = function () {
        var view = {};
        var obj = GameControl();
        console.log("Log");

        view.generateView = function () {
            obj.generateBalls();
            var len = obj.ballList.length;
            var balls = obj.ballList;
            for (let i = 0; i < len; i++) {
                let button = document.createElement("button");
                button.id = balls[i]._id;
                button.innerHTML = balls[i]._id;
                button.addEventListener("click", (e) => {
                    e.target.disabled = true;
                    steptoWin--;
                    leftchance.innerHTML = "Total Step left :" + steptoWin;
                    let statusobj = obj.checkBall(balls[i]);
                    if (statusobj.status == true) {
                        display.innerHTML = "You Win the Game";
                        return;
                    }
                    if (steptoWin <= 0) {
                        display.innerHTML = "Loose the Game Try Again";
                    }
                });
                maindiv.append(button);
            }
        }

        view.createViewBall = function(){
            
        }

        view.startGame = function () {
            view.generateView();
        }
        return view;
    }

    var e = HTMLViewer();
    e.startGame();

}());