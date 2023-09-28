/*IMPLEMENTACIÓN DEL TIPO ABSTRACTO ARRAY CON MODA*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "arrayConModa.h"
/* Declaración de la operación calcularModa aplicable al tad arrayConModa */
int TipoArrayConModa::calcularModa () {
/* DECLARACIÓN DE VARIABLES LOCALES A LA OPERACIÓN */
/* ¿Por qué hacemos esta declaración de variables dentro de la operación? */
/* Porque si no lo hacemos así las variables declaradas en cabecera son variables globales y */
/* no serían reseteadas en cada ejecución. De esta manera nos aseguramos el resete */
/* Esto es un detalle a la hora de ejecutarlo y hacer pruebas, en el examen no habría que */
/* preocuparse demasiado por esto pues como decimos es un detalle */
/* www.aprenderaprogramar.com/foros/index.php?topic=401.0*/
bool valorEncontrado = false;
int lastValidIndex = 0;
int valoresDistintosEncontrados = 0;
int maximasRepeticionesTemporal = 0;
int indiceMaximoTemporal = 0;
typedef int TipoValor[upperBoundArray];
TipoValor valor;
typedef int TipoRepeticionesValor[upperBoundArray];
TipoRepeticionesValor repeticionesValor;
/* FIN DE DECLARACIÓN DE VARIABLES LOCALES A LO OPERACIÓN */
/* Inicialización de vectores todos los valores a cero*/
for (int i = 0; i <= upperBoundArray; i++) {
valor[i] = 0;
repeticionesValor[i] = 0;
} /*Cierre del for*/
/* CALCULO ULTIMO INDICE VALIDO */
/* Consideramos que los ceros terminales no son datos válidos */
/* Calculamos el último indice de dato válido */
for (int i = 0; i <= upperBoundArray; i++) {
if (array[i] != 0) {
lastValidIndex = i;
} else { /* Nada que hacer */ };
} /*Cierre del for*/
/* FIN CALCULO ULTIMO INDICE VALIDO */
/* CALCULO DE LAS VECES QUE APARECE CADA VALOR */
/* Si hay datos válidos procedemos a procesar */
if (lastValidIndex > 0) {
/* Inicializamos el primer dato como que aparece una vez, primer valor registrado */
valor[0] = array[0];
repeticionesValor[0] = 1;
valoresDistintosEncontrados = 1;
/*Recorremos los datos en el array uno a uno */
for (int i = 1; i <= lastValidIndex; i++) {
valorEncontrado = false;
/* Recorremos los datos registrados uno a uno y los comparamos con el dato del array */
for (int j = 0; j < valoresDistintosEncontrados; j++) {
/* Si ya teníamos ese valor registrado contamos que aparece una vez más */
if (array[i] == valor[j]) {
repeticionesValor[j]= repeticionesValor[j] +1;
valor[j] = array[i];
valorEncontrado = true;
}
} /*Cierre del for interno*/
/* Si no se encontró el valor dentro de los registrados lo añadimos al registro*/
if (valorEncontrado == false) {
valoresDistintosEncontrados = valoresDistintosEncontrados +1;
/* En este array el indice es una unidad inferior porque la variable empieza en 1 no en 0 */
repeticionesValor[valoresDistintosEncontrados-1]= 1;
valor[valoresDistintosEncontrados-1] = array[i];
}
} /*Cierre del for externo*/
/* www.aprenderaprogramar.com/foros/index.php?topic=401.0*/
/* Si el array está lleno de ceros devolvemos cero */
} else {return 0;}
/* FIN CALCULO DE LAS VECES QUE APARECE CADA VALOR */
/* DETERMINACIÓN DEL VALOR QUE ES LA MODA */
for (int i=0; i<=valoresDistintosEncontrados; i++){
if (repeticionesValor[i] > maximasRepeticionesTemporal) {
maximasRepeticionesTemporal = repeticionesValor[i];
indiceMaximoTemporal = i;
}
} /*Cierre del for */
return valor[indiceMaximoTemporal] ;
}/*Cierre void*/
int TipoArrayConModa::getValor(int indice) {
return array[indice];
}
void TipoArrayConModa::setValor(int indice, int valor) {
array[indice] = valor;
}
