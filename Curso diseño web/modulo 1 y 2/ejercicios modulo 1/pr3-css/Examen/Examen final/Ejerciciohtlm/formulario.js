
//FORMULARIO

let Nombre= new Array(5);

  console.log(Nombre[0]);
  //body.style.backgroundImage="url("+misImagenes[0]+")";
  let x = document.forms["formulario"];//el 0 es el nombre y el 1 son los apellidos
  boton.addEventListener("click",Log);//x[2] será nuestro submit
  let i=0;//asigno una variable que me va a servir de contador y que empieza por 0
  console.log(boton);             //colleccion de formularios (array)
  //esta funcion recoge la informacion 
      function Log() {

          boton.active=false;//Deshabilita el envio de informacion predeterminado para el submit
          let nombre,apellido;//los que vengan por x[0] tendrán nombre los que vengan por x[1] apellido
        
          //asigno los nombres al array
          nombre=x[0].value;
          Nombre[i]=nombre;

          apellido=x[1].value;
          Nombre[i]+=" "+apellido;
          Nombre.sort();
          console.log(Nombre[i]);
         
          //borro el value de formulario
          Nombres.value="";
          Apellidos.value="";
          console.log("input borrado");
          //Pongo el contador en pantalla
          
          contador.innerHTML=" informacion guardada "+(i+1) +" de 5";
        
          console.log(" informacion guardada "+(i+1) +" de 5");
          i++//incremento el contador para guardar en la lista
          //ahora me centraré en hacer la lista si el contador llega a 5.
          if(i%5==0){//si llega a algun multiplo de 5 entonces...
            for(let j=0;j<Nombre.length;j++){
              nombre=Nombre[j];
            
                li=document.createElement("li");
                li.innerHTML=nombre;
                Salida.appendChild(li);

         
            }
            formulario.innerHTML="";

          }


          }

           /*
      for (let i=0;i<=5;i++) {
        if(x[i].type=="text"){
            valor=x[i].value;
            Nombre[i]=valor;
            p=document.createElement("p");
            p.innerHTML=Nombre[i];
            console.log(p);
            Salida.appendChild(p);
            console.log("informacion recogida " + (i+1) +" de 5")
        }
      

*/




