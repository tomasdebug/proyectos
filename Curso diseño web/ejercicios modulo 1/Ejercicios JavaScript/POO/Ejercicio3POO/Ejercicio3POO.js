
/*
//PERTENECE A LA LIBRERIA OBJETO
Let vehiculo=Object.keys(coche);//devuelve el nombre de la propiedad
vehiculo=Object.values(coche);//devuelve los valores
let Objetocopia=Object.create(objeto)
Objetct.assign(objetoCopia,objeto)//meto en el primero las propiedades del segundo ,si alguno coincide en key lo sobreescribe,el primer objeto conserva sus propiedades 

*/
 //EJERCICIO3
 /*
 Añade una estructura de programa al ejercicio anterior en el que le pidan al usuario:
 la cantidad de limites de rangos donde aplicar los descuentos:
 EJ:2,3,4...
Los valores para los rangos(max y min)
EJ:Rango 1: de 50 a 100
El % de descuento para cada rango
EJ: Rango 1 10%
  */
 //inicio productos
 /*
const productos=[//productos es un array aquí, si fuera un objeto tendríamos que insertar manualmente un indice
    {producto:"lavadora",precio:400,descuento:0},
    {producto:"frigorifico",precio:650,descuento:0},
    {producto:"totadora",precio:20,descuento:0},
    {producto:"microondas",precio:70,descuento:0},

];
let Numero_Rangos;
Numero_Rangos=prompt("¿Cuantos limites de rangos quieres?");

GenerarRangos(Numero_Rangos);   
function GenerarRangos(Numero_Rangos){
    for(let i=1; i<=Numero_Rangos;i++){//por cada rango que haga...
       //obtengo el maximo y el minimo del rango
   
        
       //if(true){
        let Minimo=parseInt(prompt("¿Minimo del rango?"));//100
        let Maximo=parseInt(prompt("¿Maximo del rango?"));//10
       
       Comparar_Intervalo(Minimo,Maximo);
    
        console.log(Minimo);
        console.log(Maximo);
        //una vez que tengo el minimo y el maximo del rango genero los intervalos 
        if(Minimo!=NaN && Maximo !=NaN){//si su minimo y maximo son numeros entonces...
           
             Recorrer_Elvector_Y_Poner_Descuento(productos,Minimo,Maximo);
           
        }else{
            console.log("Solo se aceptan numeros");
        }  

    }
    return productos;
}
//dentro
function Recorrer_Elvector_Y_Poner_Descuento(productos,Minimo,Maximo) {
      
   let Descuento=parseInt(prompt("¿Que descuento quieres en este rango?"));
            console.log(Descuento);
    if(Descuento!=NaN){// si el descuento es un numero cojo los valores de maximo y minimo y sobre los que esten ahí los meto
        //hacer otro for para recorrer el objeto producto
        let Maximo_anterior=0;
        let Minimo_anterior=0;
        //compruebo que el precio este en ese intervalo
        for (const i in productos) {
              if(Maximo_anterior<Maximo && Minimo_anterior<Minimo &&(Maximo_anterior - Minimo_anterior)){
                            if( productos[i].precio<Maximo &&  productos[i].precio>Minimo){
                                productos[i].descuento=Descuento;
                                productos[i].precio=productos[i].precio*(1 - productos[i].descuento/100);
                                let Maximo_anterior=Maximo;
                                let Minimo_anterior=Minimo;
                    }
                }
     }
    } else{
        console.log("Solo se aceptan numeros");
    }
      
}
function Comparar_Intervalo(){
    while(Minimo>Maximo){//la respuesta es mala 
        //pregunto de nuevo hasta que me den una respuesta buena
        let Minimo=parseInt(prompt("¿Minimo del rango?"));//100
        let Maximo=parseInt(prompt("¿Maximo del rango?"));//10
       
    }
}
*/
/*
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
*/
//SOLUCION PROFE 

//declaracion de variables

let rangos,vmin=0,vmax=0,vdec=0;
const listaRangos=[];
//pedir rangos
rangos=pedirNum("el numero de rangos a definir");
console.log(rangos);
//
for(let i=0;i<rangos;i++){
    listaRangos[i]={};
}
for(let nrango in listaRangos){
    if (nrango==0){//si es la primera iteracion
        while(vmin<=0){
            vmin=pedirNum("indica el minimo del rango"+ parseInt(nrango)+1);
        }
       
        
    }else{//sino es la primera iteración
        while (vmin<=listaRangos[nrango-1].vmax) {
            
        }


    }
    while(vmax<=vmin){
        vmax=pedirNum("indica el maximo del rango"+ parseInt(nrango)+1);
    }
    vdec=0;
    while(vdesc<=0 || vdesc>=100){

        vdesc=pedirNum("indica el descuento del rango"+ parseInt(nrango)+1);
    }
    listaRangos[nrango].max=vmax;//esto le agrega al 0 un apartado de maximo 
    listaRangos[nrango].min=vmin;
    listaRangos[nrango].dec=vdec;
}



console.log(listaRangos);

descuentos(productos,listaRangos)


//funciones
//herramienta para pedir un numero
console.log(pedirNum("El numero de rangos a defininir"));
function pedirNum(x){
    while (true) {
        let num=parseInt(prompt("Indica "+ x + ": "));
        num=parseInt(num);//NaN
        if(isNaN()){
            return num;
        }else{
            alert("indica un numero por favor");
        }
        
    }
}
function descuentos(productos,listaRangos){//le paso a la funcion descuentos tantos productos como la lista de arrays

}
