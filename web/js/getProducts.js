function getLoad(){
     var ajaxRequest;  // The variable that makes Ajax possible!

    try {
        // Opera 8.0+, Firefox, Safari 
        ajaxRequest = new XMLHttpRequest();
    } catch (e) {

        // Internet Explorer Browsers
        try {
            ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {

            try {
                ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {

                // Something went wrong
                alert("Your browser broke!");
                return false;
            }
        }
    }

    ajaxRequest.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
             
             
        
     document.getElementById("tab1").innerHTML = this.responseText;
     
            
        }
    };
    ajaxRequest.open("GET", "getProducts.jsp?category=ACCESSORIES", true);
    ajaxRequest.send();
}

function getProdDetails(elem) {
    var ajaxRequest;  // The variable that makes Ajax possible!

    try {
        // Opera 8.0+, Firefox, Safari 
        ajaxRequest = new XMLHttpRequest();
    } catch (e) {

        // Internet Explorer Browsers
        try {
            ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {

            try {
                ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {

                // Something went wrong
                alert("Your browser broke!");
                return false;
            }
        }
    }

    ajaxRequest.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            if (catName == elem.innerText)
            {

                document.getElementById("tab1").innerHTML = this.responseText;

            }
            if (catName == elem.innerText) {
                //alert(this.responseText);

                document.getElementById("tab2").innerHTML = this.responseText;

            }
            if (catName == elem.innerText) {
                //alert(this.responseText);

                document.getElementById("tab3").innerHTML = this.responseText;

            }
            if (catName == elem.innerText) {
                //alert(this.responseText);

                document.getElementById("tab4").innerHTML = this.responseText;

            }
        }

    };

    var catName = elem.innerText;



    ajaxRequest.open("GET", "getProducts.jsp?category=" + catName, true);
    ajaxRequest.send();





}


