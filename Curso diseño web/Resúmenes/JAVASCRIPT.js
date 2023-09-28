// Mostrar elementos en HTML y navegador

window.alert("Hola mundo"); // Ventana emergente
console.log("Hola Mundo");	// Consola del navegador
document.write("Hola Mundo"); // Escritura en el mismo HTML 
document.getElementById("output").innerHTML="Hola Mundo"; // Inserción en un elemento del DOM

/* Declaraciones: variables y tipos de datos */

var x;	// Variable genérica
let y;	// Variable de declaración única
const z;// Variable de cosntante (no cambia valor)

let a, b, c, d; // Declaración de variables en grupo
let a = 10, b = 3, c = 5; // O esta otra forma

// Tipos de datos primitivos

a = "Hola"; // Tipo cadena de caracteres (string)
b = true; // Tipo booleano (true/false)
c = 3; // Tipo numérico (double)

// Tipos de datos objeto (declarables con const)
const a = [x, y]; // Tipo array (lista de variables del mismo tipo)
const b = {x, y} // Tipo objeto con propiedades

a[0] = 5; // Asignamos un valor al 1er elemento del array a (posición 0)
a[1] = 3; 
b.x = "Hola"; // Asignamos un valor a la propiedad x del objeto b
b.y = true;

/* Bloques y Operadores */
{
	let variable; // Variable local encapsulada en un bloque (sólo puede usarse en su interior)
} 

z = x + y; // Asignamos valor a variable según el valor de las otras variables
z = x - y; // Sucesivas asignaciones de valor, borran las anteriores
z = x * y;
z = x / y;
z = a % b; // Módulo o resto (10%3 daría 1)

x++; // Sumar 1
x--; // Restar 1
x += y; // Igual que x = x + y
x /= y; // Igual que x = x / y

x < y; // Menor que
x > y; // Mayor que
x <= y; // Menor o igual que
x >= y; // Mayor o igual que
x == y; // Equivalente
x === y; // Equivalencia absoluta (incluye tipo)
x != y; // Distinto
x && y; // AND
x || y; // OR

/* Condicionales */
//Cumprueban si algo es verdadero o falso y ejecutan una porción de código si se cumplen las condiciones

if (x < y) {
    // Se ejecuta si x es menor que y
} else if (x > y) {
    // Se ejecuta si x es mayor que y
} else {
    // se ejecuta si las dos condiciones anteriores son falsas
}

// Ejemplo con operadores lógicos
if ( (a == b) || (b < c) || (++b !== c) ) {
	salida = a + b;
} else {
	salida = "Adiós " + lista[2];
}

// Condicional switch/case
switch ( a ) {
	case 3: salida = lista[0];
		break;
	case 2: salida = lista[1];
		break;
	case 5: salida = lista[2];
		break;
	default: salida = lista;
}

/* Bucles */
// Ejecutan una porción de código repetidamente hasta que se cumpla una condición determinada

// 1 For

for (let i = 0 /* variable de contador */; i < 5 /* Condición de iteración (se ejecuta mientras sea verdadero) */; i++ /* Código que se ejecuta al finalizar la iteración (aumento de valor de contador) */ ) {
    // Código que se ejecuta repetidamente
}

// 2 While

let i = 0; // Debemos inicializar el contador
while (i < 5) {
    // Código que se ejecuta repetidamente
    i++;
    // Podemos añadir más código aquí
}

// 3 Do while

let i = 0;
do {
    // Código que se ejecuta repetidamente
    i++;
} while (i < 5);

// Break

let j = 0;
for (let i = 0; i == 0; i = i) {
    if (j == 5) {
        break; // Detiene el bucle aunque la condición sea verdadera
    }
    j++;
}

// Continue

let i = 0;
while (i < 5) {
    if (i == 2) {
        i++;
        continue; // A partir de aquí el código no se ejecuta pero continúa las iteraciones
    }
    i++;
}

// Recorrer Array

c = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14];

for (let i = 0; i < c.length; i++) { // c.length - método para la longitud de un array
    console.log(c[i]);
}
const lista = ["Peras", "Manzanas", "Plátanos", "Piñas", "Aguacates"];
var i = 0;
while (i < lista.length ) {
	console.log(lista[i]);
	i++;
}

/* Funciones */

function suma(x, y) { // Declaración de la función con los parámetros x e y
    let salida; // "salida" es una variable local
    salida = x + y;
    return salida; // Devolvemos el valor de "salida" como resultado de la función
}
console.log(suma(2, 3)); // Llamamos a la función indicándole los parámetros y mostramos el resultado por consola

let f = function (x, y) { // Otra forma de declarar la función (función anónima)
    let salida;
    salida = x + y;
    return salida;
}

(function suma(x, y) { // Función que se llama a sí misma
    let salida;
    salida = x + y;
    console.log(salida);
})(a, b);

let suma = (a, b) => {	// Función flecha
	a + b;
}
console.log(suma(2, 3))

/* Objetos */

const coche = { // Definición
    marca: "Ford", // Pares propiedad-valor
    modelo: "Fiesta",
    cv: 9,
    color: "verde"
}
coche.color = "rojo";	// Asignación de valor a la propiedad
console.log(coche.color); // Acceso al valor de una propiedad

/* - Métodos propios de Javascript - */

// Math y operaciones con números

Math.PI // Numero PI
Math.sqrt(2); // Raíz cuadrada
Math.pow(3, 2); // Potencia de un número (exponencial)
Math.min(c[0], c[1], c[2], c[3], c[4], c[5]); // Valor mínimo de una serie de valores
Math.max(c[0], c[1], c[2], c[3], c[4], c[5]); // Valor máximo de una serie de valores
Math.random(); // Crea un número aleatorio entre 0 y 1
Math.trunc(); // Quita la parte decimal
Math.floor(); // Redondea un entero a lo bajo
Math.round(); // Redondea al entero más próximo

número.toFixed(n); // Redondea el número a n decimales
parseInt(); // Extrae de una cadena el primer número (entero)
parseFloat(); // Extraer de una cadena el primer decimal que encuentre

isNaN(valor); // Comprueba si el valor es un número o no y devuelve TRUE si no es un número

// Cadenas

cadena.length; // Extrae la longitud de la cadena (como si fuera un array)
cadena.split();
cadena.slice();
cadena.substring();
cadena.toUpperCase();
cadena.toLowerCase();

alert("Vamos a introducir un texto");
prompt("Escribe un texto:");

let texto = prompt("Escribe un texto:");
console.log(texto);

// Array

array.length; // Extrae la longitud del array
array.join(" * "); // Concatena todo los elementos con un separador
array.pop(); 
array.push();
array.shift();
array.unshift();
array.splice();
array.slice();

// DOM
/*
Document Object Model
Modifica:
- Elementos: Etiquetas en el HTML
- Atributos: Propiedades de etiquetas/elementos
- Estilos: Propiedades de estilo
- Nodos: Cualquier etiqueta o texto (contenido) en HTML. Son OBJETOS
Hace uso de:
- Métodos
- Eventos (interacciones)
Creando un documento HTML dinámico
*/

// Métodos DOM HTML
document.getElementById("id");
document.getElementsByClassName("class");
document.getElementsByName("nombre");
document.getElementsByTagName("etiqueta");

// Métodos DOM CSS (dentro de HTML)
document.querySelector("selector"); // Busca la primera etiqueta
document.querySelectorAll("selector"); // Busca todas las etiquetas

// Propiedades DOM / Elementos/Nodos
nodo.createElement("etiqueta");
nodo.createComment("texto");
nodo.createTextNode("texto");	// Añade texto dentro del nodo seleccionado sin eliminar el anterior
nodo.removeChild(elemento);
nodo.appendChild(elemento);
nodo.replaceChild(nuevo, anterior);
nodo.insertAdjacentElement("afterend", boton3);
document.write("texto");
nodo.cloneNode();  // Clonacion sin referencia
nodo.isConnected;  // Indica si el elemento está creado en el doc HTML
nodo.innerHTML = "contenido";  // Añade texto dentro del nodo seleccionado sustituyendo lo que haya
nodo."atributo" = "valor";
nodo.style."propiedad" = "valor";
nodo.setAttribute("atributo", "valor");

// Eventos
document.getElementById(id)."evento" = function () { /* Código */ }
// Eventos: onblur, onclick, onfocus, onload, onmousemove, onmouseout, onmouseover, onsubmit, etc.
nodo.addEventListener("evento", funcion);
// Eventos: click, blur, dblclick, drag, focus, load, mousemove, scroll, submit, etc.
