
function initAJAX() {
	var xmlHttpRequest;
	
	if (window.XMLHttpRequest) {
	    // code for modern browsers
		xmlHttpRequest = new XMLHttpRequest();
	 } else {
	    // code for old IE browsers
		 xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	} 
	return xmlHttpRequest;
}

function querybyzipcode() {
	console.log("Testing!");
	var zipCode = document.getElementById("zipcode").value;
    
	var AJAX = initAJAX();	
	AJAX.open("GET", "zipcode.jsp?zip=" + zipCode, true);
	AJAX.send();
	AJAX.onreadystatechange = processResponse;
	
	function processResponse() {
		if(AJAX.readyState == 4 && AJAX.status == 200) {
			console.log(AJAX.responseText);
			var divTag = document.getElementById("zipcontent");
			divTag.innerHTML = AJAX.responseText;
		}
	}
}

function querybylatandlon() {
	console.log("Testing!");
	var latitude = document.getElementById("latitude").value;
	var longitude = document.getElementById("longitude").value;
    
	var AJAX = initAJAX();	
	AJAX.open("GET", "latandlon.jsp?lat=" + latitude + "&lon=" + longitude, true);
	AJAX.send();
	AJAX.onreadystatechange = processResponse;
	
	function processResponse() {
		if(AJAX.readyState == 4 && AJAX.status == 200) {
			console.log(AJAX.responseText);
			var divTag = document.getElementById("latandloncontent");
			divTag.innerHTML = AJAX.responseText;
		}
	}
}