var i;
var salida;
for (i = 1; i <= 50; i++) {
   
    if(i%5==0){
        salida="hola";
        document.getElementById("Salida").innerHTML+= salida;// con += se agrega como a la derecha
        console.log("hola");

    }else{
        salida=i;
        console.log(i);
        document.getElementById("Salida").innerHTML+=salida;
    }
}

