
/*
//PERTENECE A LA LIBRERIA OBJETO
Let vehiculo=Object.keys(coche);//devuelve el nombre de la propiedad
vehiculo=Object.values(coche);//devuelve los valores
let Objetocopia=Object.create(objeto)
Objetct.assign(objetoCopia,objeto)//meto en el primero las propiedades del segundo ,si alguno coincide en key lo sobreescribe,el primer objeto conserva sus propiedades 

*/
 //EJERCICIO2
 /*Dado el array de objetos producto, actualiza el precio de cada objeto de modo que si su valor está entre 100 y 50 rebaje un 10% si es 
 superior a 100 que rebaje un 20%
  */
const productos=[//productos es un array aquí, si fuera un objeto tendríamos que insertar manualmente un indice
    {producto:"lavadora",precio:400,descuento:0},
    {producto:"frigorifico",precio:650,descuento:0},
    {producto:"totadora",precio:20,descuento:0},
    {producto:"microondas",precio:70,descuento:0},

];

GenerarDescuento(productos);
function GenerarDescuento(productos){

    for (const i in productos) {// es basicamente lo mismo que un for each
    producto= productos[i];
    if(producto.precio>100){

        producto.descuento+=20;
    }
    else if(producto.precio<100 && producto.precio>50){

        producto.descuento+=10;
    }
    console.log("El producto "+ productos[i].producto + " con un precio de " + productos[i].precio+ " €"+" que tiene un descuento de "
     +productos[i].descuento+"%" +" quedandose en la jugosa cantidad de " +productos[i].precio*(1 - productos[i].descuento/100)+"€." );
    }

}

//SOLUCION APORTADA POR EL PROFE
/*
function Descuentos(entrada){
    //for(let i in entrada) // la principal diferencia entre el for in y el for each es que el for in unicamente itera en propiedades de objetos,pero funciona exactamente igual



    //}
    
//se puede hacer tambien con un foreach
    entrada.forEach(producto =>{
            if(producto.precio>100){
                producto.descuento=20;

            }

             else if(producto.precio>=50 && producto.precio <100){
            producto.descuento=10;

              }
            producto.precio-=(producto.precio/100 * producto.descuento);
            console.log(producto);
   
    });
}
Descuentos(productos);
*/