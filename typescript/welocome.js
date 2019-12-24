var n = "Swabhaw";
var rool = 50;
var isMale = true;
var displayFormat = "Name is  " + n + "\n                            rool is " + rool + "\n                            isMale is " + isMale;
console.log(displayFormat);
function f1() {
    console.log("inside f1");
}
f1();
var f2 = function () {
    console.log("inside f2");
};
f2();
setTimeout(function () {
    console.log("After 3 Sec");
}, 3000);
