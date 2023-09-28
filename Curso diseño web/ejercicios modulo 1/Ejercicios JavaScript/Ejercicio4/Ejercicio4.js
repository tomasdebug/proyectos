/*Creamos la sucesion de fibonnaci */
//METODO FOR
/*
let i=0,j=1,suma=0;//i es el numero actual y j el numero siguiente y la suma es el que lo continua
const limite=1000;
*/
/*
for(i=0;i<limite;j=suma){

    console.log(i);
    suma=i+j;// este es el tercer numero
    i=j;//damos al numero actual el numero siguiente 
    //primero asignamos el numero siguiente al actual y luego la suma pasa a ser el numero siguiente(de esa forma lovoy haciendo)
}
*/
//METODO WHILE
/*
while(i<limite){

    console.log(i);
    suma=i+j;// este es el tercer numero
    i=j;//damos al numero actual el numero siguiente 
    //primero asignamos el numero siguiente al actual y luego la suma pasa a ser el numero siguiente(de esa forma lovoy haciendo)
    j=suma;

}
*/
//metodo array
const limite=1000;
let lista=[0,1];
let i =2;//tengo lis dos primeros valores ya

for(let i=2;lista[i-2]<limite;i++){// lista de i es undefined al principio de la iteracion,ya que i empieza como 2,por ello i-2 será la posicion inicial
    lista[i]=lista[i-1] +lista[i-2];//la lista de 2 será igual a la los 2 anteriories (aquí me daría 1 +0), el array va almacenando todos los vlores automaticamente que vamos retocando
    console.log(lista[i-2]);
}