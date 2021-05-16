/////////////////////////////
// @Banujan Ragunathan
///////////////////////////

$(document).ready(function() {
	console.log("Zeiterfassungssystem der JKB wurde gestartet");
	$.getJSON("http://localhost:8081/mitarbeiterList/").done(handleMitarbeiterListReply)

});

///////////////////////////////////
// Funktion Kundenliste befüllen
//////////////////////////////////

	
	// KG: Methode zum Liste erstellen
            function handleMitarbeiterlistReply(mitarbeiterList){
                console.log("mitarbeiter");
                
                $("#tblKundenliste tbody").empty();
                
                for ( let mitatbeiter of mitarbeiterList ) {
                	addEmployeeToList(mitarbeiter);	
                }
            }
         
         function addEmployeeToList( mitarbeiterRegister ){
        	console.log("kommt in addEmployeeList");
             var link = "javascript:/mitarbeiterList/("+mitarbeiterRegister["mitarbeiterID"]+")";
                	
             var newRow = "<tr>";
              	newRow += "<td><a href=\""+link+"\">" + mitarbeiterRegister['username'] +"</a></td>";
                newRow += "<td>" + mitarbeiterRegister['workload'] + "</td>";
                newRow += "</tr>";
                	
             $("#tblKundenliste tbody").append(newRow);
            }
            
   

