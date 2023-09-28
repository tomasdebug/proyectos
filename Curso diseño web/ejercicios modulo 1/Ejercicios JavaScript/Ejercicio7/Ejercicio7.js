/*
4.Escribe una función que nos pida escribir algo y nos muestre que tipo de variable es (texto,numero o booleano)
Entrada:true
Salida:booleano
Entrada:12345
Salida:Número

*/
//parseInt(algo)/ParseFloat(algo)transforma una cadena que consiste en un solo numero en un numero(la transforma en un int)

/*
let x=prompt("Escribe un valor numero:");
y=ParseInt(x);
console.log(y);
console.log(typeof x);
*/
let x,tipo;
//me pregunta 10 veces hasta que le de un tipo bueno bonito barato
for(let i=0;i<10;i++){
    x=prompt("Escribir un valor booleano/texto/numero:");
    tipo=comprobarTipo(x);
    //console.log(tipo);
    if(tipo===undefined){
        console.log("valor incorrecto.");
    }else{
        break;
    }
 
}
console.log("Valor introducido es "+typeof tipo);
function comprobarTipo(entrada) {
    entrada= entrada.toLowerCase();
    if(entrada == ""){//si está vacio
        return undefined;
      
    }else if(entrada === "true" || entrada ==="false"){//comprobamos si es booleano
        return true;
    }
    else if(!isNaN(entrada)){
        return 123;
    }//comprobamos si es numero es un numero (isNaN me devuelve un booleano que indica si es verdad que no es un numero(Not A Number(NaN)))
    else if(isNaN(entrada)){
        return entrada;
    }
    else{
        return undefined;
    }
}



