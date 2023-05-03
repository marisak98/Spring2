// Call the dataTables jQuery plugin
$(document).ready(function() {

});

async function registerUsers() {
    let datos= {};
    datos.name = document.getElementById('FirstName').value;
    datos.surname= document.getElementById('LastName').value;
    datos.email = document.getElementById('InputEmail').value;
    datos.password = document.getElementById('InputPassword').value;

    let repeatPassword = document.getElementById('RepeatPassword').value;

if (repeatPassword != datos.password) {
    alert("[!] Passwords is differents");
  return;
}

    
   const resquest = await fetch('api/users', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },

    body: JSON.stringify(datos)

  });
  alert("[+] Account was created successfully!");
  window.location.href = 'login.html'
}
