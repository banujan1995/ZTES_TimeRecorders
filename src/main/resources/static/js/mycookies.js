
//Hier sind die Cookies-Funktionen (BR) 
function createMyCookies() {

	// Set a cookie
	
	if (typeof $.cookie("auth") === "undefined"){
 		$.cookie("auth", "false", {secure : true});
	}
	
	if (typeof $.cookie("userlogin") === "undefined"){
 		$.cookie("userlogin", null, {secure : true});
	}
}

function updateMyCookie (name, value){
	createMyCookies();
	$.cookie(name, value, {secure : true});
}

function deleteMyCookies() {
	$.removeCookie("auth");
	$.removeCookie("userlogin");
}

function getMyCookie(name){
	return $.cookie(name);
}