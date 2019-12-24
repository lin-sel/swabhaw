(function () {
    window.onload = function () {
        star();
    }

    window.onhashchange = function () {
        star();
    }

    const star = function () {
        // debugger
        var node = document.getElementsByName("val");
        var field = document.getElementsByTagName("fieldset");
        for (let i = 0; i < node.length; i++) {
            let value = Math.round(node[i].value * 2);
            let input = field[i].getElementsByTagName("input");
            input[9 - (value - 1)].checked = true;
            console.log(input[9 - (value - 1)].checked);
        }
    }
}())
