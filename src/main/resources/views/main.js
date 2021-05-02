/////////////////////////////
// @Banujan Ragunathan
///////////////////////////

$(document).ready(function() {
	console.log("Zeiterfassungssystem der JKB wurde gestartet");
	$.getJSON("http://localhost:8081/timerecorders/erfasstemitarbeiter").done(handleMitarbeiterListReply)

});

///////////////////////////////////
// Funktion Kundenliste befüllen
//////////////////////////////////

function handleMitarbeiterListReply(erfasstemitarbeiter) {
	console.log(erfasstemitarbeiter)
	$("#tblMitarbeiterliste tbody").empty();
	for (let mitarbeiter of erfasstemitarbeiter) {
		fillupTablewithContent(mitarbeiter);

	}

	function fillupTablewithContent(mitarbeiter) {

		var newRow = "<tr>";
		newRow += "<td>" + mitarbeiter['name'] + "</td>";
		newRow += "<td>" + mitarbeiter['vorname'] + "</td>";
		newRow += "<td>" + mitarbeiter['mitarbeiterID'] + "</td>";
		newRow += "</tr>";

		$("#tblMitarbeiterliste tbody").append(newRow);
	}


}