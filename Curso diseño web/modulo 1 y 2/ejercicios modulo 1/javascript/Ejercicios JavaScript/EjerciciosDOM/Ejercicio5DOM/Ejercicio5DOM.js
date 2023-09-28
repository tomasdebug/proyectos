/**
 * Escribir una funcion javascript que recoja un input el uqe aparezca por defecto el color de fondo y que escribirendo un color distinto
 * punte el fondo(body)de ese color
 */
let x = document.forms["formulario"];
let boton=document.querySelector("form input[type='submit']");
console.log(x);

boton.addEventListener("click",Log);//x[2] será nuestro submit


//console.log(x[0][0].value);//es un array de formularios ,ahora solo tengo que acceder al valor
function Log() {
    boton.active=false;//Deshabilita el envio de informacion predeterminado para el submit

     
        if(x[0].type=="text"){
            let valor=x[0].value;
           
            console.log(valor);
          //  body.style=`background-color:${valor}`;//las comillas invertidas son para meterlo como parametro y el dolar y las llaves mete codigo dentro del texto podria meter una variable
            //body.style="background-color:"+valor;//es lo mismo
            body.style.backgroundColor=valor;//tambien vale
        }
       
     
    
}
//apartado b


button2.addEventListener("click",Galeria);//x[2] será nuestro submit
let misImagenes= new Array(10)
  misImagenes [0]= "img/001.jpg";
  console.log(misImagenes[0]);
  //body.style.backgroundImage="url("+misImagenes[0]+")";
  misImagenes [1]= "img/002.jpg";
  misImagenes [2]= "img/003.jpg";
  misImagenes [3]= "img/004.jpg";
  misImagenes [4]= "img/005.jpg";
  misImagenes [5]= "img/006.jpg";
  misImagenes [6]= "img/007.jpg";
  misImagenes [7]= "img/008.jpg";
  misImagenes [8]= "img/009.jpg";
  misImagenes [9]= "img/010.jpg";
 
 

  function Galeria(){

        let numAleatorio=Math.floor(Math.random()*10);
        console.log(numAleatorio);
        salidaimg.src= misImagenes[numAleatorio];
}
/**
 * solucion
 * let random=Math.floor(Math.random()*10);
 * const galeria=[fotos]
 * button2.addEventListener("click",Galeria);//x[2] será nuestro submit
 * function galeria(){
 *  Salida.src=galeria[random]
 * }
 */
//apartado c

button3.addEventListener("click",calcularArea);//x[2] será nuestro submit
function calcularArea(){
    let base,altura;
    boton.active=false;//Deshabilita el envio de informacion predeterminado para el submit
    if(x[1].type=="text" && x[2].type=="text"){
        Base=parseFloat(x[1].value);
        altura=parseFloat(x[2].value);

        console.log(Base);
        console.log(altura);
      //  body.style=`background-color:${valor}`;//las comillas invertidas son para meterlo como parametro y el dolar y las llaves mete codigo dentro del texto podria meter una variable
        //body.style="background-color:"+valor;//es lo mismo
       let Area=(Base * altura)/2;
       console.log(Area);
       
    }
 
}







