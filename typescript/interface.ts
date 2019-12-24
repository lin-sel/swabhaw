interface IStudent {
    id: number,
    name: string,
    cgpa: number
}

function printInfo(student: IStudent[]) {
    let s: IStudent;
    for (let s of student) {
        console.log(s);
    }
}

printInfo([
    { id: 101, name: "Alex", cgpa: 8 },
    { id: 102, name: "George", cgpa: 7.9 },
    { id: 103, name: "Cassandra", cgpa: 7.3 },
]);