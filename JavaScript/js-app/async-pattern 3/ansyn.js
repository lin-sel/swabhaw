(function () {

    function dataServer(id, name) {
        this.id = id;
        this.sname = name;

        this.printDetails = function () {
            var that = this;
            console.log(this);
            setTimeout(function () {
                console.log("Id: " + that.id + " Name: " + that.sname);
            }, 3000);
        }
    }

    var result = new dataServer(201, "Name1");
    result.printDetails();

    console.log("End of the Line");
}());