(function () {

    count = 0;
    for (; ;) {
        count += 1;
        postMessage("counter: " + count);
    }
}());