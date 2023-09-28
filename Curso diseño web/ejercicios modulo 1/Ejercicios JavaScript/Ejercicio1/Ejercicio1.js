let a,b,c,d,e,x,y,z,salida;
a=2;
b=3;
c=5;
d=0;
e=-1;
//Apartado1

/*
if(a>b){//lo hago por bloques la x compara 

    x=a;

}else{

    x=b;
}
console.log(x);
if(c>d){
    y=c;
}else{
    y=d;
}
console.log(y);
if(x>y){

    z=x;
}else{
    z=y;
}
console.log(z);
if(z>e){
    salida=z;

}else{
    salida=e;
}
document.getElementById("Salida").innerHTML=salida;
*/

//metodo2(usando los y(&&))
/*
if(a>=b && a>=c && a>=d && a>=e){
    salida=a;
}else if(b>=a && b>=c && b>=d && b>=e){
    salida=b;
}else if(c>=a && c>=b && c>=d && c>=e){
    salida=c;
}else if(d>=a && d>=b && d>=c && d>=e){
    salida=d;
}else{
    salida=e;
}
document.getElementById("Salida").innerHTML = salida;
*/
/*
let Array = [a,b,c,d,e]
console.log("El numero mas grande es: "+Array.sort.());
document.getElementById("Salida").innerHTML = mayor;
//voy a intentar ordenarlos todos utilizando un for
*/
//metodo 3
/*
salida=Math.max(a,b,c,d,e);
document.getElementById("Salida").innerHTML = salida;
*/
//Apartado1+Apartado2
salida = [a,b,c,d,e];//con este metodo se puede hacer ez peace
salida.sort();//para que se ordene de menor a mayor
salida.reverse();//para que se ordene de mayor a menor
document.getElementById("Salida").innerHTML = "Los numeros ordenador son: "+ salida.join(",") + "<br>"+"El numero mayor es: "+salida[0];//salida.join es para que esten separados por comas
//las cadenas de caracteres funcionan como arrays de caracteres
let algo="cosas"
console.log(algo[0]);