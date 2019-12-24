var n: string = "Swabhaw";
var rool: number = 50;

var isMale: boolean = true;

var displayFormat: string = `Name is  ${n}
                            rool is ${rool}
                            isMale is ${isMale}`;

console.log(displayFormat);

function f1() {
    console.log("inside f1");
}

f1();

var f2 = () => {
    console.log("inside f2");
}

f2();
setTimeout(() => {
    console.log("After 3 Sec");
}, 3000)