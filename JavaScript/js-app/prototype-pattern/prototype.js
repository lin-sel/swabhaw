(function () {

    function Employee(id, name) {
        this.id = id;
        this.name = name;
    }

    Employee.prototype.getDetails = function () {
        return "Id: " + this.id + " Name: " + this.name;
    }

    var e1 = new Employee(201, "Alex");
    var e2 = new Employee(202, "George");

    console.log(e1);
    console.log(e2);

    console.log(Employee.prototype == e1.__proto__);
    console.log(e1.__proto__ == e2.__proto__);
    console.log(Employee.__proto__ == Object.__proto__);

    var obj = {};
    console.log(obj)
}());   