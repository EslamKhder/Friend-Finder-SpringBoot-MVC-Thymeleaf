// Java script Code
window.onload = function () {
    "use strict";
    var image = document.getElementById("file"),
        text = document.getElementById("exampleTextarea"),
        button = document.getElementById("button");
    function checked() {
        if (image.value !== "" || text.value.trim() !== "") {
            button.style.opacity = "1";
            button.style.cursor = "pointer";
            
        } else {
            button.style.opacity = ".4";
            button.style.cursor = "no-drop";
        }
    }
    button.addEventListener("click", function (event) {
        if (image.value === "" && text.value.trim() === "") {
            event.preventDefault();
        }
    });
    
    image.onmouseout = function () {
        checked();
    };
    text.onkeyup = function () {
        checked();
    };
};