var xmlhttp;
try {
    xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
} catch (e) {
    try {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    } catch (E) {
        xmlhttp = false;
    }
}
if (!xmlhttp && typeof XMLHttpRequest != 'undefined') {
    xmlhttp = new XMLHttpRequest();
}
var requestSender = function (url, xmlRequest, func) {
    xmlhttp.open('POST', url, true);
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4) {
            if (xmlhttp.status == 200) {
                var xmlResponce = xmlhttp.responseText;
                func(xmlResponce);
            }
        }
    };
    xmlhttp.setRequestHeader('Content-Type', 'text/xml; charset=utf-8');
    xmlhttp.send(xmlRequest);
}
var mapView = new Map();
var View = function (url) {
    var htmlview = "Not load view";
    if (mapView.get(url)==undefined) {
        var htmlret = "not html";
        xmlhttp.open('GET', url, false);
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4) {
                if (xmlhttp.status == 200) {
                    htmlret = xmlhttp.responseText;
                }
            }
        };
        xmlhttp.send(null);
        htmlview=htmlret;
        mapView.set(url,htmlret);
    }else{
        htmlview=mapView.get(url);
    }
    this.setAttribut = function (name, value) {
        htmlview = htmlview.replace("{" + name + "}", value);
    }
    this.getHTML = function () {
        return htmlview;
    }
}