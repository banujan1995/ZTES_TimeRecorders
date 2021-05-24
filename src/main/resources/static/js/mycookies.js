
//Hier sind die Cookies-Funktionen (BR) 
function createMyCookies() {

	//Cookie erstellen, wenn nicht vorhanden!
	//https://stackoverflow.com/questions/1458724/how-do-i-set-unset-a-cookie-with-jquery
	//https://stackoverflow.com/questions/32579803/how-to-get-cookies-path-using-javascript/47112056

	if (typeof $.cookie("auth") === "undefined") {
		$.cookie("auth", "false", { secure: true });
	}

	if (typeof $.cookie("userlogin") === "undefined") {
		$.cookie("userlogin", null, { secure: true });
	}

	if (typeof $.cookie("role") === "undefined") {
		$.cookie("role", null, { secure: true });
	}
}

//Hier wird der Cookie erstellt und dann wird er updated (BR) - falls nicht vorhanden. 
function updateMyCookie(name, value) {
	createMyCookies();
	$.cookie(name, value, { secure: true });
}

//Hier sollen die Cookies gelöscht werden, wenn den User ausloggt (BR)

function deleteMyCookies() {
	$.removeCookie("auth");
	$.removeCookie("userlogin");
	$.removeCookie("role");
}

//Hier wird der Value des Cookies abgefragt! (BR)
function getMyCookie(name) {
	return $.cookie(name);
}