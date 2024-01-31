document.getElementById('botonListar').addEventListener('click', function() {
    fetch('http://localhost:9000/gestion_proyecto/v1/usuarios/listar')
        .then(response => response.json())
        .then(data => llenarTabla(data.data))
        .catch(error => console.error('Error:', error));
});

function llenarTabla(usuarios) {
    const cuerpoTabla = document.getElementById('cuerpoTabla');
    cuerpoTabla.innerHTML = '';
    usuarios.forEach(usuario => {
        const fila = cuerpoTabla.insertRow(-1);
        fila.insertCell(0).textContent = usuario.id;
        fila.insertCell(1).textContent = usuario.tipoDocumento;
        fila.insertCell(2).textContent = usuario.numeroDocumento;
        fila.insertCell(3).textContent = usuario.nombres;
        fila.insertCell(4).textContent = usuario.apellidos;
        const celdaAcciones = fila.insertCell(5);
        const botonActualizar = document.createElement('button');
        botonActualizar.textContent = 'Editar';
        botonActualizar.className = 'boton-actualizar';
        celdaAcciones.appendChild(botonActualizar);
        const botonEliminar = document.createElement('button');
        botonEliminar.textContent = 'Eliminar';
        botonEliminar.className = 'boton-eliminar';
        celdaAcciones.appendChild(botonEliminar);

        // Agregar evento de clic al botón de actualizar
        botonActualizar.addEventListener('click', function() {
            document.getElementById('id').value = usuario.id;
            document.getElementById('tipoDocumento').value = usuario.tipoDocumento;
            document.getElementById('numeroDocumento').value = usuario.numeroDocumento;
            document.getElementById('nombres').value = usuario.nombres;
            document.getElementById('apellidos').value = usuario.apellidos;
        });

        // Agregar evento de clic al botón de eliminar
        botonEliminar.addEventListener('click', function() {
            fetch(`http://localhost:9000/gestion_proyecto/v1/usuarios/eliminar/${usuario.id}`, {
                method: 'DELETE',
            })
            .then(response => response.json())
            .then(data => {
                console.log(data);
                // Aquí puedes actualizar la tabla o hacer algo más con la respuesta
            })
            .catch(error => console.error('Error:', error));
        });
    });
}

document.querySelector('form').addEventListener('submit', function(event) {
    event.preventDefault();
    var tipoDocumento = document.getElementById('tipoDocumento').value;
    var numeroDocumento = document.getElementById('numeroDocumento').value;
    var nombres = document.getElementById('nombres').value;
    var apellidos = document.getElementById('apellidos').value;
    var usuario = {
        tipoDocumento: tipoDocumento,
        numeroDocumento: numeroDocumento,
        nombres: nombres,
        apellidos: apellidos
    };

    // Enviar la solicitud POST
    fetch('http://localhost:9000/gestion_proyecto/v1/usuarios/agregar', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(usuario)
    })
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error('Error:', error));
});

document.getElementById('botonActualizar').addEventListener('click', function() {
    var idUsuario = document.getElementById('id').value;
    var tipoDocumento = document.getElementById('tipoDocumento').value;
    var numeroDocumento = document.getElementById('numeroDocumento').value;
    var nombres = document.getElementById('nombres').value;
    var apellidos = document.getElementById('apellidos').value;
    var usuario = {
        id: idUsuario,
        tipoDocumento: tipoDocumento,
        numeroDocumento: numeroDocumento,
        nombres: nombres,
        apellidos: apellidos
    };

    // Enviar la solicitud PUT
    fetch('http://localhost:9000/gestion_proyecto/v1/usuarios/actualizar', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(usuario)
    })
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error('Error:', error));
});