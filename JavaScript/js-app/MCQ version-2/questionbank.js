(function () {

    // Onload Variable initialize for html tag access. 
    var mainblog = document.getElementById("main-blog");
    var questionserialnumber = document.getElementById("question-serial-number");
    var questionblog = document.getElementById("question-blog");
    var optionblog = document.getElementById("option-blog");
    var next = document.getElementById("next");
    var previous = document.getElementById("previous");
    var final = document.getElementById("final");
    var successbar = document.getElementById("successbar");
    var unsuccessbar = document.getElementById("unsuccessbar");
    var resultbox = document.getElementById("result-main-box");

    // variable for program control.
    var counter = 0;
    var answer = {};
    var totalquestion;

    // Fetch Data from JSON File.
    function fetchQuestionFromJson() {
        let xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                totalquestion = JSON.parse(this.responseText);
                buttonAction();
                showNextQuestion();
            }
        }
        xhr.open("GET", "question.json", true);
        xhr.send();
    }

    const buttonAction = () => {
        previousButton();
        nextButton();
        finalButton();
    }

    const initfunction = () => {
        fetchQuestionFromJson();
    }

    initfunction();

    // Next button listner register.
    next.addEventListener("click", () => {
        if (getAnswer()) {
            counter++;
            if (counter < totalquestion.length) {
                showNextQuestion();
            }
            buttonAction();
            return;
        }
        alert("Please Select Answer.");
    });

    // Previous button listner register.
    previous.addEventListener("click", () => {
        if (counter > 0) {
            counter--;
            showNextQuestion();
        }
        buttonAction();

    });

    // Final button listner register.
    final.addEventListener("click", () => {
        getAnswer();
        counter++;
        previousButton();
        displayResult();
    });


    function showNextQuestion() {
        questionSerialNumber();
        getOptionforQuestion();
        questionblog.innerHTML = totalquestion[counter].text;
        answerPreservationOnClick();
    }


    function questionSerialNumber() {
        let questionserialnum = counter + 1;
        questionserialnumber.innerHTML = "Question Number:&nbsp&nbsp " + (counter + 1) + "/" + totalquestion.length;
    }

    function getOptionforQuestion() {
        optionblog.innerHTML = "";
        for (init = 0; init < totalquestion[counter].option.length; init++) {
            var div = document.createElement("div");
            var element = document.createElement("input");
            element.name = "option";
            element.type = "radio";
            element.value = totalquestion[counter].option[init];
            var lable = document.createElement("p");
            lable.append(document.createTextNode(totalquestion[counter].option[init]));
            div.append(element);
            div.append(lable);
            optionblog.append(div);

        }
    }

    function previousButton() {
        if (counter > 0) {
            previous.disabled = false;
            previous.style.backgroundColor = "green";
        }
        if (counter == 0 || counter == totalquestion.length) {
            previous.disabled = true;
            previous.style.backgroundColor = "gray";
        }
    }

    function nextButton() {
        if ((counter + 1) == totalquestion.length) {
            next.disabled = true;
            next.style.backgroundColor = "gray";
            return;
        }
        next.disabled = false;
        next.style.backgroundColor = "green";
    }

    function finalButton() {
        if ((counter + 1) == totalquestion.length) {
            final.disabled = false;
            final.style.backgroundColor = "green";
            return;
        }
        final.disabled = true;
        final.style.backgroundColor = "gray";
    }


    function displayResult() {
        mainblog.style.display = "none";
        resultbox.style.display = "block";
        let successpercentage = calculateResult();
        if (successpercentage == 100) {
            successbar.innerHTML = successpercentage + "%";
            successbar.style.width = successpercentage + "%";
            unsuccessbar.style.display = "none";
            return;
        }
        else if (successpercentage == 0) {
            successbar.style.display = "none";
            unsuccessbar.innerHTML = (100 - successpercentage) + "%";
            unsuccessbar.style.width = (100 - successpercentage) + "%";
            return;
        }
        successbar.innerHTML = successpercentage + "%";
        successbar.style.width = successpercentage + "%";
        unsuccessbar.innerHTML = (100 - successpercentage) + "%";
        unsuccessbar.style.width = (100 - successpercentage) + "%";
    }

    function getAnswer() {
        let input = document.getElementsByName("option");
        for (init = 0; init < input.length; init++) {
            if (input[init].checked) {
                answer[counter] = init;
                return true;
            }
        }
        return false;
    }

    function answerPreservationOnClick() {
        if (answer[counter] != undefined) {
            document.getElementsByName("option")[answer[counter]].checked = true;
        }
    }

    function calculateResult() {
        let score = 0;
        console.log(answer);
        for (init = 0; init < totalquestion.length; init++) {
            console.log("checked outside");
            if (answer[init] == totalquestion[init].answer) {
                console.log("checked", init);
                score++;
            }
        }
        score = (score / totalquestion.length) * 100;
        return score;
    }
}());