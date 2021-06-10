var para = document.getElementById("id4711");
para.textContent = 'Hallo vom Javascript';


//fetch("personen.json")
//fetch("http://localhost:8080/personen.json")
//   .then( antwort => antwort.json())
//   .then( myjson => console.log(myjson.personen));
//   .then( myjson => console.log(myjson.personen[0].vorname));



// json einlesen
function getJson(irgendwas) {
	return irgendwas.json();
}
// celle ersetzen
function getTxtFromJsonUndPackInsHTML(myjson) {
	var tabelle=document.getElementById("tid01");
	var i=1;
	var pictogramm="";
	for(var laufvariable of myjson.personen){
		if (laufvariable.anrede == "Herr") 
			pictogramm = "<td><img src='bilder/mann.png'></td>";
	    else if (laufvariable.anrede == "Frau")   
		    pictogramm = "<td><img src='bilder/frau.png'></td>";
        else
		    pictogramm = "<td><img src='bilder/joker.png'></td>";

/*		tabelle.insertAdjacentHTML("beforeend","<tr>"
		                                     + "<th scope='row'>"+i+"</th>"
				                             + "<td>"+ laufvariable.anrede +"</td>"
				                             + "<td>"+ laufvariable.vorname +"</td>"
				                             + "<td>"+ laufvariable.nachname +"</td>"
                                    		 + pictogramm
                                             + "</tr>");*/
		tabelle.insertAdjacentHTML("beforeend",
		                                       "<tr>"
		                                     + `<th scope='row'> ${i} </th>`
				                             + `<td> ${laufvariable.anrede}</td>`
				                             + `<td> ${laufvariable.vorname} </td>`
				                             + `<td> ${laufvariable.nachname} </td>`
                                    		 + pictogramm
                                             + "</tr>");

    i++;
   // 	document.getElementById("vorname01").textContent = laufvariable.vorname;
	}
}

fetch("personen.json")
	.then(getJson) 								//  entspricht: .then( irgendwas => irgendwas.json() )
	.then(getTxtFromJsonUndPackInsHTML) 		// entpricht: cell.textContent = myjson.personen[0].vorname);
	
