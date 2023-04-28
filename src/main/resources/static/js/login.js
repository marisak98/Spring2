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
  const users = await resquest.json();
}

