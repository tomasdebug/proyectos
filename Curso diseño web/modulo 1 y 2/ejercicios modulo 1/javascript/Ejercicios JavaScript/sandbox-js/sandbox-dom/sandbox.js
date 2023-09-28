//aquí se irá haciendo el dom
let x,x2,x1,x3, y1,y2;

document.getElementById("salida");//esto da como resultado un objeto con las propiedades de un elemento,que se puede guardar en una variable
document.getElementsByClassName("salida");//tambien se puede buscar por el nombre de la clase
document.getElementsByName("salida");//igual que lo de arriba ,name es una etiqueta de html(mirarlo)
document.getElementsByTagName("div");//coge los elementos por el nombre de la etiqueta,si hay varios te aca un array

//CSS

//x=document.querySelector("#div3");//busca el selector en el css y te saca a lo que afecta(no necesita existir en el css),le cascamos todo lo que tendriamos que poner en css para selecionar
//x=document.querySelector("div div");//Puedo buscar un div que este dentro de un div
//x=document.querySelector("div:firts-child");//
//x=document.querySelector("[id*='div']");//devuelve el primer div que pilla
//x=document.querySelectorAll("[id*='div']");//devuelve todas las coincidencias del selector,selecciona todos los divs que contienen el string div en el id
//x=document.querySelectorAll("[id*='div']")[1].style="background-color:red;height:30px";//selecciono un elemento de ese array y le aplico el estilo que yo quiero
x1=document.querySelectorAll("[id*='div']")[1];//puede sobreescribir los elementos de un css (antes el div era azul)

//Documento/Nodos/elementos[vemos que podemos añadir/eliminar de los nodos]

document.write("algo");//escribe al final algo
x2=document.createElement("p");//nos crea una etiqueta
x2.innerHTML="LMAO";//Meto algo dentro del elemento p
document.getElementById("salida").appendChild(x2);//guardamos esa etiqueta dentro de salida append child=es añadir hijos ,lo que hace esta linea es buscar el elemento salida y agregarle como hijo lo el elemento que he creado antes 
//document.getElementsByTagName("main").removeChild(x1);//remuevo el segundo div
//document.replaceChild("elemento nuevo","elemento a sustituir");//tambien se puede reemplazar
//document.createComment("comentario");
//document.createTextNode("texto");    
x1.innerHTML="<br><p>hola</p><br>"//se pueden añadir varias etiquetas 
x3=document.getElementById("div2").setAttribute("name","algo");//coge el atributo name y le cambia el nombre a nombrediv3
//document.getElementById("div2").attributes[0]="nombrediv2";

y1=x1.cloneNode();//clonan los nodos
y2=x1;

y1.style="background-color:green";
y1.style="background-color:orange";

document.getElementById("main").appendChild(y1);//mete y1 justo antes de y 2
//document.getElementById("main").appendChild(y2);
y3=y1.isConnected;//y3 e y1 estan conectadas

//Eventos

//div3.setAttribute("onclick", "cambiarcolor()");//solo se puede dar con un unico id

div3.onclick = function(){
    div3.style="background-color:purple";
    setTimeout( function(){div3.style="background-color:green",console.log("ahora es verde");},3000);//Timeout pone un tiempo de espera para la ejecucion de una determinada funcion y a los 3 segundos cambia a verde
    console.log("colocambiado");

};

document.getElementById("div3");



