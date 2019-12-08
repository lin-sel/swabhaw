(function () {

    var questions;
    var counter = 0;
    var ans = 0;
    const mainsection = document.getElementById("mainsection");
    const questioncounter = document.getElementById("quesnumber");
    const questionhtml = document.getElementById("question");
    const questionoption = document.getElementById("option");
    const submitbutton = document.getElementById("submitbutton");
    // const previousbutton = document.getElementById("previousbutton");
    const resultDisplay = document.getElementById("resultdisplay");
    const passresult = document.getElementById("rightdiv");
    const failresult = document.getElementById("wrongdiv");

    // previousbutton.addEventListener("click", () => {
    //     if (counter > 0) {
    //         console.log(counter);
    //         counter = counter - 1;
    //         console.log(counter);
    //         showQuestion();
    //         return;
    //     }
    //     alert("you can't go back.");

    // });
    submitbutton.addEventListener("click", () => {
        if (!getAnswer()) {
            alert("Please Select Answer");
            return;
        }
        if (counter < 5) {
            showQuestion();
            return;
        }
        setProgessBar();

    });


    window.onload = () => {
        questionload();
    }

    function questionload() {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                questions = JSON.parse(this.responseText);
                console.log(questions);
                showQuestion();
            }
        };
        xmlhttp.open("GET", "question.json", true);
        xmlhttp.send();
    }


    function showQuestion() {
        if (counter < questions.length) {
            showQuestionNumber();
            questionhtml.innerHTML = "ID:" + questions[counter].id + "<br/> Question: " + questions[counter].text;
            questionoption.innerHTML = "";
            createOptionNode();
            counter++;
            if (counter == questions.length) {
                buttonstate();
            }
            return;
        }

    }

    function createOptionNode() {
        var form = document.createElement("form");
        for (var opt = 0; opt < questions[counter].option.length; opt++) {
            var options = document.createElement("input");
            options.type = "radio";
            options.name = "optionans";
            options.value = questions[counter].option[opt];

            form.append(options);
            form.append(createoptionlable(questions[counter].option[opt]));
        }
        questionoption.append(form);
    }

    function createoptionlable(value) {
        var label = document.createElement("p");
        label.append(document.createTextNode(value));
        return label;
    }

    function showQuestionNumber() {
        questioncounter.innerHTML = Number(counter) + 1 + "/" + questions.length;
    }

    function buttonstate() {
        submitbutton.innerHTML = "Finish";
    }

    function getAnswer() {
        var tag = document.getElementsByName("optionans");
        var flag = 0;
        for (var init = 0; init < tag.length; init++) {
            if (tag[init].checked) {
                if (tag[init].value === questions[counter - 1].answer) {
                    flag++;
                    ans++;
                }
                return true;
            }
        }
        return false;
    }

    function setProgessBar() {
        setLayoutforProgressBar();
        let percentage = (ans / questions.length) * 100;
        passresult.style.width = percentage + "%";
        passresult.innerHTML = percentage;
        failresult.style.width = 100 - percentage + "%";
        failresult.innerHTML = 100 - percentage;
    }

    function setLayoutforProgressBar() {
        mainsection.style.display = "none";
        resultDisplay.style.display = "block";
    }


}());