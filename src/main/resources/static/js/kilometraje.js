
function selecionado() {
    var mantenimiento = document.formMantenimiento.mantenimiento[document.formMantenimiento.mantenimiento.selectedIndex].value;
    if (mantenimiento == "Aceite") {
        var kilometraje = document.getElementById("kilometraje").value;
        var cambioAceite = parseInt(kilometraje) + parseInt(15000);
        return (cambioAceite + " KILOMETROS");


    }
}

function mostrar() {
    var mantenimiento = document.formMantenimiento.mantenimiento[document.formMantenimiento.mantenimiento.selectedIndex].value;
    if (mantenimiento == "Aceite") {
        var kilometraje = document.getElementById("buttonAceite").style.display = "block";
    } else {
        var kilometraje = document.getElementById("buttonAceite").style.display = "none";

    }
}


function calcular() {
    var codigo,nombre;
    $('#tbMantenimiento tr').each(function (idx,fila) {
         nombre = fila.children[1].innerHTML;
         if(nombre == 'Aceite'){
                 codigo =fila.children[4].innerHTML;
                
                
        }   
           
    });
    document.getElementById("maxA").value = parseInt(codigo) +parseInt(15000);
  
    

}

