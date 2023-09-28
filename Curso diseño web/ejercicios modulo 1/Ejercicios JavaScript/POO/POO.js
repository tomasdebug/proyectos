

/*
almacena en 3,4 o 5 objetos la informacion relativa a los elementos que puedes encontrar en un parque con al menos 2 propiedades cada uno
Muestra la informacion mas relebante de cada uno.
Ejemplo:objeto:arbol={nombre:"Arbol",altura:6m}
Salida el arbol tiene 6m
*/

const columpio={//estoy definiendo un objeto(como una clase de Java)s
   asientos:2,//los dos puntos se utilizan para señalar un valor de una propiedad de un objeto
   altura:3,
}
const tobogan={//estoy definiendo un objeto(como una clase de Java)
    altura:3,
    longitud:3,
 }
 const banco={
    asientos:4,
    barandilla:"sí"

 }
 /*
 //otra alternativa hacer un objeto que tenga otros objetos
 //console.log(parque.columpio.asientos);
 const parque={
    columpio:{asientos:2,altura:3},
    tobogan:{ altura:3,longitud:3},
 }
 for(x in parque){
    console.log(x);
    //ahora si quiero que me enseñe las propiedades 
    for(y in parque[x]){//parque[x] es como un array ,te coge los objetos de este
        console.log(y+" "+parque[x][y]);//se van a mostrar los objetos y luego las propiedades
       
    }
    console.log(Object.values(parque)[2]);//me muestra el objeto 2
}
 
 */
const coche={
    marca:"Ford",
    modelo:"Fiesta",
    cv:90,
    velocidad:120,
    color:"verde",
    velCv:function(){//declaro una funcion dentro de un objeto

        return (this.velocidad/coche.cv);//especifica que se estan usando las de la clase es lo mismo que poner coche
    }
}
console.log(coche.velCv());//al llamar a una funcion se ponen parentesis 
delete coche.color;
for(x in coche){
    if(x=="velCv"){
        console.log(x+": "+coche.velCv());
    }

    console.log(coche[x])
    console.log(x+": "+coche.velCv());
}
/*
//PERTENECE A LA LIBRERIA OBJETO
Let vehiculo=Object.keys(coche);//devuelve el nombre de la propiedad
vehiculo=Object.values(coche);//devuelve los valores
let Objetocopia=Object.create(objeto)
Objetct.assign(objetoCopia,objeto)//meto en el primero las propiedades del segundo ,si alguno coincide en key lo sobreescribe,el primer objeto conserva sus propiedades 
*/
