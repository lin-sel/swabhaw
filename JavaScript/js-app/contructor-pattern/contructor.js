(function () {

    function Employee() {
        var _name, _id;

        this.setEmpId = function (id) {
            if (id > 0) {
                _id = id;
            }
        }

        this.setEmpName = function (name) {
            if (name.length > 0) {
                _name = name;
            }
        }

        this.getDetails = function () {
            return "Name: " + _name + "<br/>" + "Id: " + _id;
        }

    }


    var e1 = new Employee();
    e1.setEmpId(201);
    e1.setEmpName("Alex")
    console.log(e1);

    var e2 = new Employee();
    e2.setEmpId(202);
    e2.setEmpName("George");
    console.log(e2);





}());