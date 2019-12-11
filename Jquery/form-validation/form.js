(function () {

    $(document).ready(function () {
        const usernamefield = $("#username");
        const passwordfield = $("#password");
        const emailfield = $("#email");
        const usernamest = $(".usernamest");
        const passwordst = $(".passwordst");
        const captchinput = $("#captchainput");
        const submit = $("#submit");

        var captch = "";
        captchaDesign();

        usernamefield.change(() => {
            usernameCheck(usernamefield.val());
        });
        passwordfield.change(() => {
            passwordCheck(passwordfield.val());
        });
        emailfield.change(() => {
            emailCheck(emailfield.val());
        });
        submit.click(() => {
            login();
        });

        function login() {
            if (!isEmpty(usernamefield.val(), "username")) {
                if (!usernameCheck(usernamefield.val())) {
                    usernamefield.css("border", "1px solid red");
                    alert("Please follow the rule for username");
                    return;
                }
            }
            if (isEmpty(passwordfield.val(), "password")) {
                if (!passwordCheck(passwordfield.val())) {
                    passwordfield.css("border", "1px solid red");
                    alert("Please follow the rule for password");
                    return;
                }
            }
            if (!emailCheck(emailfield.val())) {
                alert("Invalid Email Address");
                return;
            }
            if (!captchValidate()) {
                alert("Invalid Captcha");
                return;
            }

            alert("Login Successful.");
            location.reload();

        }

        function isEmpty(string, field) {
            if (string == "") {
                alert("Please Enter " + field);
                return true;
            }
            return false;
        }

        function captchValidate() {
            if (captchinput.val() != captch) {
                return false;
            }
            return true;
        }
        function usernameCheck(string) {
            let capital = false;
            if (isCapitalLetter(string)) {
                usernamestatementColorChange(0, "green");
                capital = true;
            }
            let small = false;
            if (isSmallLetter(string)) {
                usernamestatementColorChange(1, "green");
                small = true;
            }
            let whitespace = false;
            if (isWhiteSpacePresent(string)) {
                usernamestatementColorChange(2, "green");
                whitespace = true;
            }
            let number = false;
            if (isNumberPresent(string)) {
                usernamestatementColorChange(3, "green");
                number = true;
            }
            let special = false;
            if (!isSpecialCharacter(string)) {
                usernamestatementColorChange(4, "green");
                special = true;
            }

            return capital && small && whitespace && number && special;
        }

        function isCapitalLetter(string) {
            return string.match('[A-Z]');
        }

        function isSmallLetter(string) {
            return string.match('[a-z]');
        }

        function isNumberPresent(string) {
            return string.match('[0-9]');
        }

        function isWhiteSpacePresent(string) {
            return string.match('[^ ]');
        }

        function isSpecialCharacter(string) {
            return string.match('[!@#$%&*]');
        }

        function usernamestatementColorChange(index, color) {
            usernamest[index].style.color = color;
        }

        function passwordstatementColorChange(index, color) {
            passwordst[index].style.color = color;
        }

        function passwordCheck(string) {
            let capital = false;
            if (isCapitalLetter(string)) {
                passwordstatementColorChange(0, "green");
                capital = true;
            }
            let small = false;
            if (isSmallLetter(string)) {
                passwordstatementColorChange(1, "green");
                small = true;
            }
            let number = false;
            if (string.match('[0-9]')) {
                passwordstatementColorChange(3, "green");
                number = true;
            }
            let whitespace = false;
            if (isWhiteSpacePresent(string)) {
                passwordstatementColorChange(2, "green");
                whitespace = true;
            }
            let special = false;
            if (isSpecialCharacter(string)) {
                passwordstatementColorChange(4, "green");
                special = true;
            }

            return capital && number && special && whitespace && small;
        }

        function emailCheck(email) {
            if (!email.match("[a-zA-Z0-9]+@[A-Za-z0-9]+\.[A-Za-z]{2,4}")) {
                emailfield.css("border", "1px solid red");
                return false;
            }
            emailfield.css("border", "2px solid green");
            return true;
        }

        function captchaDesign() {
            var cox = 0;
            var c = document.getElementById("captch");
            var ctx = c.getContext("2d");
            console.log("Captch");
            ctx.moveTo(0, 50);
            ctx.lineTo(300, 50);
            ctx.stroke();
            for (i = 0; i < 5; i++) {
                cox = cox + 50;
                ctx.font = "30px Verdana";
                ctx.translate(cox, 50);
                angle = Math.random() * 100 * Math.PI / 180;
                ctx.rotate(angle);
                let text = createText();
                captch = captch + text;
                ctx.fillText(text, 00, 00);
                ctx.rotate(-angle);
                ctx.translate(-cox, -50);
            }
        }

        function createText() {
            let string = "ABCDEF1GHI2JKLM3NOPQ4RS@$&5TUV6WXYZ7abcd8efghi9jklmn0opqrstuvwxyz";
            let number = Math.floor(Math.random() * 100) % 64;
            return string[number];
        }
    });
}())


