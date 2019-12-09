(function () {

    var swabhav = function () {
        var math = {};
        console.log("Inside swabhav");
        math.cubeEvenNum = function (number) {
            if (number % 2 == 0) {
                return number * number * number;
            }
            throw "Odd Number Not Valid";
        }

        math.isPrime = function (number) {
            for (init = 2; init < number; init++) {
                if (number % init == 0) {
                    return false;
                }
            }
            return true;
        }
        return math;
    }();


    console.log(swabhav);

    console.log(swabhav.isPrime(20));


    console.log(swabhav.cubeEvenNum(20));





}());