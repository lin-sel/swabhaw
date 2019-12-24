function printInfo(student) {
    var s;
    for (var _i = 0, student_1 = student; _i < student_1.length; _i++) {
        var s_1 = student_1[_i];
        console.log(s_1);
    }
}
printInfo([
    { id: 101, name: "Alex", cgpa: 8 },
    { id: 102, name: "George", cgpa: 7.9 },
    { id: 103, name: "Cassandra", cgpa: 7.3 },
]);
