var para = document.getElementById("id4711");
para.textContent = 'Hallo vom Javascript';

// fetch("http:localhost:8080/personen.json")

fetch("personen.json")
   .then( antwort => antwort.json())
//   .then( myjson => console.log(myjson.personen));
   .then( myjson => console.log(myjson.personen[0].vorname));