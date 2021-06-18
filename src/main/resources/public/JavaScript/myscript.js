//var para = document.getElementById("id4711");
//para.textContent = 'Hallo vom Javascript';


//fetch("personen.json")
//fetch("http://localhost:8080/personen.json")
//   .then( antwort => antwort.json())
//   .then( myjson => console.log(myjson.personen));
//   .then( myjson => console.log(myjson.personen[0].vorname));

//document.getElementById("list").click();

getAllPersons();

function delPerson(id){
	    fetch(`/json/person/${id}`, {
		       method: 'DELETE' })
        .then(getAllPersons());
         console.log("DelPerson!"+id);
}


// json einlesen
function getJson(irgendwas) {
	return irgendwas.json();
}
// celle ersetzen
function getTxtFromJsonUndPackInsHTML(myjson) {
	var tabelle=document.getElementById("idbody");
	var i=1;
	var pictogramm="";
/*	var picto_loesch="<td><img src='bilder/trash.svg'></td>";*/
    var picto_aend="<td><img src='bilder/pen.svg'></td>";

    tabelle.innerHTML="";

/*	Array.prototype.slice.call(document.getElementsByTagName('tr')).forEach(
  		function(item) {
    	item.remove();
	});*/
	
	for(var laufvariable of myjson.personen){
		if (laufvariable.anrede == "Herr") 
			pictogramm = "<td><img src='bilder/mann.png'></td>";
	    else if (laufvariable.anrede == "Frau")   
		    pictogramm = "<td><img src='bilder/frau.png'></td>";
        else
		    pictogramm = "<td><img src='bilder/joker.png'></td>";


		tabelle.insertAdjacentHTML("beforeend",
		                                       "<tr>"
		                                     + `<th scope='row'> ${i} </th>`
				                             + `<td> ${laufvariable.anrede}</td>`
				                             + `<td> ${laufvariable.vorname} </td>`
				                             + `<td> ${laufvariable.nachname} </td>`
				                             + `<td> ${laufvariable.email} </td>`
                                    		 + pictogramm
                                             + picto_aend
                                             + `<td><img id='delete${i}'src='bilder/trash.svg' onclick='delPerson(${i})'></td>`
                                             + "</tr>");

    i++;
   // 	document.getElementById("vorname01").textContent = laufvariable.vorname;
	}
}

//fetch("personen.json")
function getAllPersons(){
  fetch("/json/persons/all",
           {
			  method: 'GET',
			  headers: {
				   'Content-Type': 'application/json'
			}
		   })
	.then(getJson) 								//  entspricht: .then( irgendwas => irgendwas.json() )
	.then(getTxtFromJsonUndPackInsHTML); 		// entpricht: cell.textContent = myjson.personen[0].vorname);
}


function oninputclick(event) {
	event.preventDefault();    // verhindert, dass Event weiter vom Browser bearbeitet wird
	console.log("Button betätigt");
	
	var salutation = document.getElementById('salut').value;
	var vorname = document.getElementById('fname').value;
	var nname = document.getElementById('lname').value;
	var email = document.getElementById('email').value;
	console.log(salutation,vorname,nname,email);
	var jsondata=`{ "anrede": "${salutation}", "vorname": "${vorname}", "nachname": "${nname}","email": "${email}"}`;
	console.log(jsondata);
	
	fetch("/json/person", {
		method: 'POST',
		body: jsondata,
		headers: { 'Content-Type': 'application/json'}
	})
	.then(getAllPersons());
}

var button = document.getElementById('button');
button.addEventListener('click', oninputclick);


function oninputdelclick(event) {
	event.preventDefault();    // verhindert, dass Event weiter vom Browser bearbeitet wird
	console.log("Del Button betätigt");
	
	var id = document.getElementById('loeschid').value;
	console.log(id);
	
	fetch(`/json/person/${id}`, {
		method: 'DELETE' })
	.then(getAllPersons());
}

function oninputrefreshclick(event) {
	event.preventDefault();    // verhindert, dass Event weiter vom Browser bearbeitet wird
	console.log("Refresh Button betätigt");
	getAllPersons();
}


var buttondel = document.getElementById('loesch');
buttondel.addEventListener('click', oninputdelclick);


var buttonrefresh = document.getElementById('refresh');
buttonrefresh.addEventListener('click', oninputrefreshclick);


//getAllPersons();


	




