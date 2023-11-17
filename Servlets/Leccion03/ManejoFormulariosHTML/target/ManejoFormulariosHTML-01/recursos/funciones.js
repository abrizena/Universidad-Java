function validarForma(forma){
    var usuario = forma.usuario;
    if (usuario=="" || usuario=="Escribir usuario"){
        alert("Debe proporcionar un nombre de usuario");
        usuario.focus();
        usuario.select();
        return false;
        }
        
    var password = forma.password;
    if (password ==""|| password.value.length<3){
        alert("Debe proporcionar un password de al menos 3 caracteres");
        usuario.focus();
        usuario.select();
        return false;
    }
    
    var tecnologias=forma.tecnologias;
    var checkSeleccionado=false;
    
    for (var i=0; i<tecnologias.length;i++){
        if (tecnologias[i].checked){
            checkSeleccionado=true;
        }
    }
    
    if (!checkSeleccionado){
        alert("Debe seleccionar al menos una tecnología");
        return false;
    }
    
    var generos = forma.genero;
    var radioSeleccionado = false;
    
    for(var i=0; i<generos.length; i++){
        if (generos[i].checked){
            radioSeleccionado=true;
        }
        
    }
    if (!radioSeleccionado){
            alert("Debe seleccionar un género");
            return false;
    }
    var ocupacion = forma.ocupacion;
    if (ocupacion.value ===""){
        alert("Debe seleccionar una ocupación");
        return false;
    }
    
    //El formulario es valido
    alert("El formulario es válido");
    return true;
  }


