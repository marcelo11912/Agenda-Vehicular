var opt_Hyundai = new Array("Escoger...", "Tucson", "Santa Fe", "Kona", "Elantra", "Accent", "Sonata");
var opt_Mazda = new Array("Escoger...", "CX-7", "MX-5", "MPV", "RX-8", "Premacy", "CX-30");
var opt_Ford = new Array("Escoger...", "Fiesta", "KA+", "Puma", "Kuga 2017", "Edge", "Galaxy");
var opt_Kia = new Array("Escoger...", "Rio", "Optima", "Picanto", "Stonic", "XCeed");
var opt_Chevrolet = new Array("Escoger...", "Spark", "Matiz", "Aveo", "Kalos", "Camaro");

function Cambio() {
    var marca;
    marca = document.formVehiculo.marca[document.formVehiculo.marca.selectedIndex].value;
    if (marca != 0) {
        var opt_ = "opt_";
        mis_opts = eval(opt_ + marca);
        num_opts = mis_opts.length;
        document.formVehiculo.opt.length = num_opts;
        for (i = 0; i < num_opts; i++) {
            document.formVehiculo.opt.options[i].value = mis_opts[i];
            document.formVehiculo.opt.options[i].text = mis_opts[i];
        }
    } else {

        document.formVehiculo.opt.length = 1;
        document.formVehiculo.opt.options[0].value = "Escoger...";
        document.formVehiculo.opt.options[0].text = "Escoger...";
    }

    document.formVehiculo.opt.options[0].selected = true;

}

function limpiar() {
    document.getElementById("kilometraje").value = "";
}

function KMCorrido() {
    var KMR = document.getElementById("kilometrajeRe").value;
    var KMA = document.getElementById("kilometrajeA").value;
    document.getElementById("kilometraje").value = parseInt(KMR)+ parseInt(KMA);
}

function NecesitaCam(){
    
    var  kma = document.getElementById("KMAC").value;
    var  kmc = document.getElementById("maxA").value;
   
    if(kma> kmc){
        document.getElementById("alertCambio").style.display = "block"
       
    }
    
    
    
}


