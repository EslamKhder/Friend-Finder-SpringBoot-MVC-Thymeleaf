/* Add Comment*/
var id;
function addFriend(id)
{
    this.id = id;
    var url = "/friend";
    if (window.XMLHttpRequest) {
        request = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        request = new ActiveXObject("Microsoft.XMLHTTP");
    }
    try
    {
        request.onreadystatechange = getInfocomment;
        request.open("POST", url, true);
        request.setRequestHeader("Accept", "application/json");
        request.setRequestHeader("Content-Type", "application/json");
        request.send(JSON.stringify({
            "friendid": id
        }));
    } catch (e)
    {
        alert("Unable to connect to server");
    }
}
function getInfocomment() {
    if (this.readyState === 4 && this.status === 200) {
        var val = this.responseText;
        if (val === "added") {
            document.getElementById("friend" + id).style.display = "none";
        }
    }
}