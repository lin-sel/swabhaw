(function () {

    var dataServer = function () {
        var obj = {};

        obj.getData = function () {
            return Math.floor(Math.random() * 10);
        }

        obj.getDataAsync1 = function (callback1, callback2) {
            var r = Math.floor(Math.random() * 100);
            if (r > 50) {
                callback1({ msg: "success", number: r });
                return;
            }
            callback2({ msg: "fail", number: r });
        }

        obj.getDataAsync2 = function (callback1, callback2) {
            setTimeout(() => obj.getDataAsync1(callback1, callback2), 0);
        }

        return obj;
    }();

    var result = dataServer.getData();
    console.log(result);

    dataServer.getDataAsync2(function (r) {
        console.log(r);
    }, function (r) {
        console.log(r);
    });




    console.log("End of the Line");
}());