/////////////////////////////
// @Banujan Ragunathan
///////////////////////////

$(document).ready(function() {
	console.log("Zeiterfassungssystem der JKB wurde gestartet");
	$.pushJSON("http://localhost:8081/addEmployee").done(handleMitarbeiterListReply)

});

///////////////////////////////////
// Funktion Kundenliste befüllen
//////////////////////////////////

	function addEmployee(mitarbeiter){
    var link = "createNewMa("+mitarbeiter["id"]+")";
    	
    var newRow = "<tr>";
    newRow += "<td><a href=\""+link+"\">" + mitarbeiter['name'] + " " + mitarbeiter['passwort'] + "</a></td>";
    newRow += "<td>" + mitarbeiter['pensum'] + "</td>";
    newRow += "</tr>";
    	
    $("#tblnewMA tbody").append(newRow);	
}


