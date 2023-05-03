// Call the dataTables jQuery plugin
$(document).ready(function() {
    userCallServer();
  $('#dataTable').DataTable();
});

async function userCallServer() {
   const resquest = await fetch('api/users', {
    method: 'GET',
    headers: {
       'Accept': 'application/json',
       'Content-Type': 'application/json',
       'Authorization': localStorage.token


    }
  });
  const users = await resquest.json();



  let usersList = '';

  for (let user of users) {
     let deleteButtom = '<a href="#" onclick="eliminarUsers('+ user.id +')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

      let telephone = user.phone == null ? '-' : user.phone;
    
    let showUsers = '<tr><td>'+ user.id +'</td><td>'+ user.name +' '+ user.surname +'</td><td>'+ telephone +'</td><td>' + user.email +'</td><td>'+ deleteButtom +'</td></tr>';

    usersList += showUsers;
  }

  document.querySelector('#dataTable tbody').outerHTML = usersList;
}

function obtenerHeaders() {
  return {
   'Accept': 'application/json',
   'Content-Type': 'application/json',
   'Authorization': LocalStorage.token

  };

}

async function eliminarUsers(id) {
  if (!confirm('Desea Eliminar este usuario?')) {
    return;
  }
  const resquest = await fetch('api/users/' + id, {
    method: 'DELETE',
    headers: {
       'Accept': 'application/json',
       'Content-Type': 'application/json',
       'Authorization': localStorage.token
    }

  }); 
  location.reload()
}
