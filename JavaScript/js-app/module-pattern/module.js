(function () {

    function makeEmployee() {
        var _id, _name = "no name";
        var emp = {};
        console.log("inside makeEmployee");
        emp.setEmpId = function (id) {
            if (id > 0) {
                _id = id;
            }
        }

        emp.getDetails = function () {
            return "Id: " + _id + "<br/>" + "Name: " + _name;
        }

        return emp;
    }

    var e1 = makeEmployee();
    e1.setEmpId(201);
    console.log(e1.getDetails, e1);

    var e1 = makeEmployee();
    e1.setEmpId(202);
    console.log(e1.getDetails, e1);





}());