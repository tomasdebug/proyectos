/*
Escribe una funcion que añada una fila a la tabla
*/

 /*
let boton=document.querySelector("form input[type='boton']");
boton.addEventListener("click",Annadir_Fila);//x[2] será nuestro submit


function Annadir_Fila() {
   
   
    boton.active=false;//Deshabilita el envio de informacion predeterminado para el submit
            p=document.createElement("tr");
            p.innerHTML=("nueva fila");
         
            console.log(p);
            Salida.appendChild(p);
            }
      
   */  

  //solución

  //tabla.insertRow(0);
  //tabla.insertcell(0);
  
  
  addfila.addEventListener("click",añadirfila);
  
  function añadirfila(){

    let celdas = document.querySelectorAll("#tabla tr:first-child td");//numero de celdas

    let filas = document.querySelectorAll("#tabla tr");//numero de filas

    let celda,fila=document.createElement("tr");//declaramos la celda e inicializamos la variable fila

    for(let i =0;i<celdas.length;i++){
        celda = document.createElement("td");
        celda.innerHTML="Fila"+(filas.length+1) + " Celda "+(i+1);//pongo el numero de celda y fila
        fila.appendChild(celda);//las declaro como hijos de las filas

    }
    tabla.appendChild(fila)

  }
//apartado b añade un boton que añada una columna

addcolumna.addEventListener("click",añadircolumna);
function añadircolumna(){
    
    let celdas = document.querySelectorAll("#tabla tr:first-child td");//numero de celdas
    
    let filas = document.querySelectorAll("#tabla tr");//numero de filas(saca siempre un array)
    
    let celda;//declaramos la fila e inicializamos la variable celda 

    
    for(let i =0;i<filas.length;i++){//recorro las filas
        
        celda = document.createElement("td");//creas una celda
        celda.innerHTML="Fila"+(filas.length+1) + " Celda "+(celdas.length+1);//pongo el numero de celda y fila
        filas[i].appendChild(celda);//la metes en la fila que toca 
        
        
        
        
    }
    tabla.appendChild(fila);
}


//Solución
/*
//creamos el boton con el javascript

boton2=document.createElement("input");
console.log(boton2);
boton2.type="button";
boton2.id="addcol";
boton2.value="Añadir una columna";

//lo añado a HTML

addfila.insertAdjacementElement("afterend",boton2);

//Agrego la accion
addcol.addEventListener("click",añadircolumna);

function añadircolumna(){


    let celdas = document.querySelectorAll("#tabla tr:first-child td");//numero de celdas

    let filas = document.querySelectorAll("#tabla tr");//numero de filas

    let celda,fila=document.createElement("tr");//declaramos la celda e inicializamos la variable fila

    for(let i =0;i<celdas.length;i++){//declaro esta vez las filas.
        celda = document.createElement("td");
        let contenido=document.createTextNode(`Fila${filas.length+1} Celda${i+1}`);//pongo el numero de celda y fila
        filas[i].appendChild(celda);//las declaro como hijos de las filas

    }
}
console.log(addcol);


*/
