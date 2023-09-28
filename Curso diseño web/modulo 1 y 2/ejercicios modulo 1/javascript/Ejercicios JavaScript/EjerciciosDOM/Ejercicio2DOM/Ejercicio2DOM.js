/*
2.Crea el codigo Javascript que recoja los valores introducidos en consola y 
los muestre en el formulario


*/
/*
let x = document.forms;//nos da una coleccion de todos los furmularios del documento html es lo mismo que poner document.forms["Formulario"]
x[2].addEventListener("click",Log);//x[2] será nuestro submit

console.log(x);             //colleccion de formularios (array)
//console.log(x[0][0].value);//es un array de formularios ,ahora solo tengo que acceder al valor
function Log() {
    for (let i=0;let<x.length;i++) {
        console.log(x[i].value);
    }
}
*/
//solucion


/*
for(let i in x){
   console.log(x[i].value);
 
   if(i.value=="Submit"){
         boton=i;
    }
   

}
//
let boton2=document.querySelector("form input[type='Submit']");
console.log(y);

let boton2=document.querySelector("form input[type='Submit']");
*/
let x = document.forms["formulario"];
let boton=document.querySelector("form input[type='submit']");
console.log(x);

boton.addEventListener("click",Log);//x[2] será nuestro submit

console.log(boton);             //colleccion de formularios (array)
//console.log(x[0][0].value);//es un array de formularios ,ahora solo tengo que acceder al valor
function Log() {
    boton.active=false;//Deshabilita el envio de informacion predeterminado para el submit
    let valor;
    for (let i=0;i<x.length;i++) {
        if(x[i].type=="text"){
            valor=x[i].value;
            p=document.createElement("p");
            p.innerHTML=valor;
            console.log(p);
            Salida.appendChild(p);
            
        }
      
    }
}
