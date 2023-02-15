fuction Cambia(){
	var usuario = document.getElementById('usuario').value;
    var contrasena = document.getElementById('contrasena').value;
 
    if (usuario && contrasena) {
       	document.getElementById('update').disabled = false;
    } else {
		document.getElementById('update').disabled = true;
   }
}
Cambia()