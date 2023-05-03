// Call the dataTables jQuery plugin
$(document).ready(function() {

});

async function loginSession() {
    let datos= {};
    datos.email = document.getElementById('InputEmail').value;
    datos.password = document.getElementById('InputPassword').value;

    
   const resquest = await fetch('api/login', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },

    body: JSON.stringify(datos)

  });
  const response = await resquest.text();
  console.log(response);
  if (response != 'FAIL') {
    localStorage.token = response;
    localStorage.email = datos.email;
    window.location.href = 'tables.html'
  } else {
    alert("[!] Credentials incorrect"); 
  }
}

