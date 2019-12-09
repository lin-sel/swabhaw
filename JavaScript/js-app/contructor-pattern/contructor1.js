(function () {

    function Employee(id, name) {

        this.id = id;
        this.name = name;

        this.getDetails = function () {
            return "Name: " + this.name + "<br/>" + "Id: " + this.id;
        }

    }


    var e1 = new Employee(201, "Alex");
    console.log(e1.getDetails(), e1);

    var e2 = new Employee(202, "George");
    console.log(e2);

}());