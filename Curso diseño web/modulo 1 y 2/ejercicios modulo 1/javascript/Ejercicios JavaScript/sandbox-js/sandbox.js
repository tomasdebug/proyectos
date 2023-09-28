/*//Aquí se añade el código javascript

let x=document.getElementById("ID");//esto da como resultado un objeto con las propiedades de un elemento,que se puede guardar en una variable
console.log(x);//y ahora puedo printarlo 

let a, b, c, d, e;
a=2;
b=3;
c=5;
d=0;
e=-1;
let mayor, order;
order=[2,3,5,0,-1];

if (a>b) {
    mayor = a;   
} else if(b>c) {
    mayor = b;   
} else if(c>d) {
    mayor = c;   
}else if(d>e) {
    mayor = d;   
}else{
    mayor = e;   
}

document.getElementById("salida").innerHTML= mayor;
//console.log(mayor);
//window.alert(mayor);
//Math.max(order)

order.sort();
order.reverse();
document.getElementById("order").innerHTML= "Los numeros ordenadoes son: " + order.join(",") + "<br>"+ "el numero mayor es:" + order[0]  ;
console.log(order);
console.log();


/*
let arr = [ 40, 1, 5, 200];
arr.sort();  //[ 1, 200, 40, 5 ]
console.log(arr);

function comparar ( a, b ){ return a - b; }
arr.sort( comparar );  // [ 1, 5, 40, 200 ]
console.log(arr);

arr.sort(function(a,b){return a - b;}); 
console.log(arr);

arr.sort((a,b)=>a-b);
console.log(arr);


for (var i = 0; i < 10; i++) {
    console.log(i);    
}
console.log(i);    
*/
/*for (let index = 0; index <= 50; index++) {
    console.log((index%5)?index:"hola");
}
document.getElementById("order").innerHTML = "Hola";
document.getElementById("order").innerHTML += "Adios";

document.getElementById("order").appen*/
/*let total=0;
for (let index = 0; index <= 400; index++) {

    if (index%3 ==0 || index%7 == 0) {
       total+=index;
        console.log(total);
    }
    if (index%3 ==0 && index%7 == 0) {
        total+=index;
         console.log(total);
     }
}*/

/*let j=1;
let total=0;

for (let index = 0; index < 1000; j=total) {
    console.log(index); 
    total=index+j;
    index=j;
}
*/
/*let i=0, j=1;
let total=0;
while (i<1000) {
    console.log(i); 
    total=i+j;
    i=j;
    j=total;
}


var i;
var lista = [0, 1]; // Initialize array!

for (i = 2; lista[i-2] <= 1000; i++) {
  lista[i] = lista[i - 1] + lista[i - 2];
  console.log(lista[i-2]);
}
*/
/*const multi=3;
for (let i = multi; i <= 50; i+=multi) {
        console.log(i + `es multiplo de ${multi}`);    
        console.log(i%2==0? i+" es par": i +" es impar");      
  }
  */

/*let sum = [23, 92, 7, 17, 459, 23, 178, 422, 291, 23, 26, 25, 74];

for (let i = 0; i < sum.length; i++) {
    
    console.log((sum[i]%2==0)?sum[i]:16);
}

let asteriscos="*****";
let asterisco="*   *"

for (let index = 0; index < asteriscos.length; index++) {
   
    if(index == 0||index == asteriscos.length-1){
       
        
            console.log(asteriscos);
    }else{
        
            console.log(asterisco);
            
            
    } 
}
*/
/*let fila, j;
let columna="";
let tamaño="5";
let x="*";

for (let index = 1; index <= tamaño; index++) {
   fila="";   
    if(index == 1||index == tamaño){
        for (j = 0; j < tamaño; j++) {
            fila+=x;
        }
    }else{
        for (j = 1; j < tamaño; j++) {            
            if(j==1 || j==tamaño){
                fila+=x;
            }
        }
    } 
    console.log(fila);
}*/

let lista = ["Pera", "Manzana", "Platano", "Fresa", "Kiwi"];
let lista2 = [...lista];//los tres puntos sirven para indicar que quiero una copia de la lista ,si pusiera solo lista entonces cambiaría los parametros de la lista original tambien ya que crearía una referencia a esta
let x = lista[0];
//ejercicio para desplazar pera al final del array y luego borrarlo y tener el otro array bien de chill
//forma1
/*for (let index = 0; index < lista.length; index++) {
    
    lista[index]=lista[index+1]; //para desplazar el primer elemento hacia el final del array
}
lista[lista.length-1]=x;//
console.log(lista);
*/
/*
//forma 2
lista.shift();//remueve el primer elemento de la lista
lista.push(lista2[0]);//te añade un elemento al final de la lista
console.log(lista);
*/
//lista.slice(lista[lista.length-1]);
//x= lista.slice(1,4);// devuelve una copia de una parte del array dentro de un nuevo array empezando por inicio hasta fin (fin no incluido).
//x= lista.splice(1);// cambia el contenido de un array eliminando elementos existentes y/o agregando nuevos elementos.
//Ej:
/*
const months = ['Jan', 'March', 'April', 'June'];
months.splice(1, 0, 'Feb');
// Inserts at index 1
console.log(months);
// Expected output: Array ["Jan", "Feb", "March", "April", "June"]
 */
/*let cont;
let lkup = lista[3];
/*
//sobreescribir todos los elementos de un array 
for (let index = 0; index < lista.length; index++) {

    lista[index] = lkup;//pillo variable auxiliar y convierto todos los elementos del array a esa(a fresas xd)
    if (index == lista.length - 1) {//
        console.log("todos son " + lkup);//una vez he acabado con el array todos son fresas
    } else {
        console.log("no son todo " + lkup + " aun");
    }
}*/
/*
//
let lkup = lista[3];
for (let index = 0; index < lista.length; index++) {
    
    lista[index] = lkup;//cambio la posicion actual a fresas
    console.log("lista " + lista);// printo la lista (me van a salir: 1iteracion Fresa pera manzana... 2iteracion Fresa Fresa manzana...Hasta tener todo fresas)
    cont=0;
   for (let j = 0; j < lista.length; j++) {
        if (lista[j]==lkup){
            cont+=1;
            console.log("estado " + cont);//cuento cuantas fresas hay
        }
    }
    if (cont==lista.length) {//lo mismo que antes
        console.log("todos son " + lkup);
    }else{
        console.log(`no son todo  ${lkup} aun`);
    }
}
console.log(lista);*/