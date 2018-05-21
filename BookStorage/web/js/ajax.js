/**
 * Created by zzz on 2018/5/1.
 */
window.onload = function () {
    var categories = document.getElementsByClassName("category");
    for (var i = 0; i < categories.length; i++)
        categories[i].onclick = function () {

            var xmlhttp = new XMLHttpRequest();
            var url = "/ShowBookServlet?cid=" + this.id;
            xmlhttp.open("GET", url, true);
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    document.getElementById("books").innerHTML = xmlhttp.responseText;
                }
            }
            xmlhttp.send(null);
        }
}

