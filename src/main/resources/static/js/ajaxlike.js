/* Add Like */
var request, num;
function sendLike(x)
{
    num = x;
    var url = "/like";
    if (window.XMLHttpRequest) {
        request = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        request = new ActiveXObject("Microsoft.XMLHTTP");
    }
    try
    {
        request.onreadystatechange = getInfo;
        request.open("post", url, true);
        request.setRequestHeader("Accept", "application/json");
        request.setRequestHeader("Content-Type", "application/json");
        request.send(JSON.stringify({
            "post": {
                "id": x
            }
        }));
    } catch (e)
    {
        alert("Unable to connect to server");
    }
}
function getInfo() {
    if (this.readyState === 4 && this.status === 200) {
        var val = this.responseText;
        var likes = document.getElementById("likes" + num);
        if (val === "inc") {
            likes.innerHTML = parseInt(likes.innerHTML) + 1;
        } else if (val === "dec") {
            likes.innerHTML = parseInt(likes.innerHTML) - 1;
        }
    }
}