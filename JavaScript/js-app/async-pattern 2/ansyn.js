(function () {

    function dataServer(id, name) {
        this.id = id;
        this.sname = name;

        this.printDetails = function () {
            setTimeout(function () {
                console.log("Id: " + this.id + " Name: " + this.sname);
            }, 3000);
        }
    }

    var result = new dataServer(201, "Name1");
    result.printDetails();

    console.log("End of the Line");
}());