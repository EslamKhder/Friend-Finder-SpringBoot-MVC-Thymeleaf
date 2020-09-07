/* Add Comment*/
var id,comment,nameus,image;
function sendComment(x,z,image)
{
    nameus = x;
    id = z;
    this.image = image;
    comment = document.getElementById("comment"+id).value;
    var url = "/comment";
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
            "text": comment,
            "post": {
                "id": z
            }
        }));
    } catch (e)
    {
        alert("Unable to connect to server");
    }
}
function getInfocomment() {
    if (this.readyState === 4 && this.status === 200) {
        var val = this.responseText;
        if (val === "invalid") {
            document.getElementById("invalid" + id).innerHTML = "Invalid Comment";
            clear(id);
        } else if (val === "success") {
            var par = document.createElement("P"),
                anc = document.createElement("A"),
                I2	= document.createElement("I"),
                div = document.createElement("DIV"),
                img = document.createElement("IMG");
            div.setAttribute("class","post-comment");
            img.setAttribute("src","photos/"+image);
            img.setAttribute("class","profile-photo-sm");
            anc.setAttribute("href","timeline.html");
            anc.setAttribute("class","profile-link");
            par.setAttribute("class","newstylecomment");
            anc.innerText = nameus;
            I2.innerText = comment;
            div.appendChild(img);
            par.appendChild(anc);
            par.appendChild(I2);
            div.appendChild(par);
            document.getElementById("post-text"+id).appendChild(div);
            document.getElementById("comment"+id).value = "";
        }
    }

}
function clear(x) {
    setTimeout(function () {
        document.getElementById("invalid" + x).innerHTML = "";
    }, 3000);
}