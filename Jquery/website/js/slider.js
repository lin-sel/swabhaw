(function () {

    const slider = document.getElementsByName("slider-1");
    var index = 0;

    const sliderMaker = function () {
        console.log(index);
        slider[index].style.display = "block";
        for (let iterate = 0; iterate < slider.length; iterate++) {
            if (iterate != index) {
                slider[iterate].style.display = "none";
            }
        }
        index++;
    }

    setInterval(() => {
        if (index == slider.length) {
            index = 0;
        }
        sliderMaker();
    }, 3000);

}());