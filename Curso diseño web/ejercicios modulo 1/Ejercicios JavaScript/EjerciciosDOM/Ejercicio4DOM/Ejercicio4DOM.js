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


addfila.addEventListener("click", añadirfila);

function añadirfila() {

    let celdas = document.querySelectorAll("#tabla tr:first-child td");//numero de celdas

    let filas = document.querySelectorAll("#tabla tr");//numero de filas

    let celda, fila = document.createElement("tr");//declaramos la celda e inicializamos la variable fila

    for (let i = 0; i < celdas.length; i++) {
        celda = document.createElement("td");
        celda.innerHTML = "Fila" + (filas.length + 1) + " Celda " + (i + 1);//pongo el numero de celda y fila
        fila.appendChild(celda);//las declaro como hijos de las filas

    }
    tabla.appendChild(fila)

}
//apartado b añade un boton que añada una columna

addcolumna.addEventListener("click", añadircolumna);
function añadircolumna() {

    let celdas = document.querySelectorAll("#tabla tr:first-child td");//numero de celdas

    let filas = document.querySelectorAll("#tabla tr");//numero de filas(saca siempre un array)

    let celda;//declaramos la fila e inicializamos la variable celda 


    for (let i = 0; i < filas.length; i++) {//recorro las filas

        celda = document.createElement("td");//creas una celda
        celda.innerHTML = "Fila" + (filas.length + 1) + " Celda " + (celdas.length + 1);//pongo el numero de celda y fila
        filas[i].appendChild(celda);//la metes en la fila que toca 




    }

}

//Apartado c AÑADE OTRO BOTON Y ESCRIBE UNA FUNCION EN JAVASCRIPT PARA QUE ESE BOTON MODIFIQUE EL 
//CONTENIDO DE LA CELDA
/**
 * se usará tabla.row[i].cells
 * idea :recorrer las filas de la tabla y pillar cual es la que quiero modificar
 * 
 * 
 */
modificarcelda.addEventListener("click", modificar_celda);
function modificar_celda() {
    
    
    let filaBuscada = parseInt(prompt("¿Que fila quieres modificar?"));
    
    let celdaBuscada = parseInt(prompt("¿Que celda quieres modificar?"));
    
    let contenido = prompt("¿que quieres escribir dentro?");
    
    try {
        tabla.rows[filaBuscada - 1].cells[celdaBuscada - 1].innerHTML = contenido;
        
    }
        catch {
            console.log("PONLO BIEN ");
            modificar_celda();
        }

    }
