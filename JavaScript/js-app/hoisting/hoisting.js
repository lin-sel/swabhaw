(function(){

    function hoisting(){
        console.log("inside main");
        for(var i = 1; i <= 10; i++){
            console.log("count is",i);
        }
        console.log("end of the loop", i);
    }


    console.log("end of the loop", i);
    hoisting();

    // Statement function.
    f2();
    function f2(){
        console.log("inside f2");
    }
    f2();

    // Expression function.
    // f3();
    var f3 = function(){
        console.log("inside f3");
    }
    f3();

    // Function Return. 
    var f4 = function(){
        console.log("inside f4");
    }();

    f4();


}());