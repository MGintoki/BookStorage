window.onload = function () {
    showBook();
}
function showBook() {



    var categories = document.getElementsByClassName("category");
    for (var i = 0; i < categories.length; i++)
        categories[i].onclick = function () {

            var xmlhttp = new XMLHttpRequest();
            var url = "/ShowBookServlet?cid=" + this.id;
            xmlhttp.open("GET", url, true);
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    document.getElementById("books").innerHTML = xmlhttp.responseText;
                    addCat();

                }
            }
            xmlhttp.send(null);
        }




}

 function addCat() {

    // var addCats = document.getElementsByClassName("addCat");

     // for (var i = 0; i < addCats.length; i++)
     //    addCats[i].onclick = function () {
     //        var xmlHttp = new XMLHttpRequest();
     //        var url = "/addCatServlet?bId=" + this.id;
     //        xmlHttp.open("GET", url, true);
     //        xmlHttp.onreadystatechange = function () {
     //            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
     //
     //                document.getElementById("msg").innerHTML = xmlHttp.responseText;
     //
     //            }
     //        }
     //        xmlHttp.send(null);
     //    }
     var addCat= document.getElementsByClassName("addCat");
     for (var i = 0; i < addCat.length; i++)

         addCat[i].onclick = function () {
             var xmlhttp = new XMLHttpRequest();
             var url = "/addCatServlet?bId=" + this.id;
             xmlhttp.open("GET", url, true);
             xmlhttp.onreadystatechange = function () {
                 if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

                     console.log(xmlhttp.responseText);
                     document.getElementById("msg").innerHTML = xmlhttp.responseText;

                 }
             }
             xmlhttp.send(null);
         }

 }

