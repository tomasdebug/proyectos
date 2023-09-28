/********************************************
* Proyecto de ejemplo con módulos y cadenas
* Cada módulo define diferentes TAD
* y se puede ver como se pueden usar o
* definir variables de ese tipo TAD sólo
* poniendo el include ""
*                       By: Airilanthalasa :D
*                           Enjoy!
*********************************************/

#include <stdio.h>
#include <string.h>
#include "TAD1.h"
#include "TAD2.h"
#include "Cadena.h"

int main(){

  T_Cadena textoOriginal_1="";
  T_Cadena textoOriginal_2="Soy la cadena original 2\n";
  T_Cadena aux="";
  T_TAD1 tad1;
  T_TAD2 tad2;
  T_TADCadena tadCadena;

  /*Las cadenas se puede inicializar con un valor (sólo ahí se puede usar =)
  o modificarlo después usando strcpy*/
  strcpy(textoOriginal_1,"Soy la cadena original 1\n");

  /*-- Usar las funciones de los TAD para modificar e imprimir las cadenas
  recibidas y devueltas de varias maneras --*/

  /*Imprimir una cadena recibida como parámetro*/
  tad1.imprimirCadena(textoOriginal_1);

  /*Modificar cadenas desde un tad recibidas como parámetro*/
  tad1.escribirCadena(textoOriginal_1, textoOriginal_2);
  /*Imprimir las cadenas modificada en el paso anterior*/
  tad1.imprimirCadena(textoOriginal_1);
  tad1.imprimirCadena(textoOriginal_2);

  /*Modificar una cadena de un tad (mientras no se defina private)*/
  strcpy(tad2.cadenaDeTAD,"Soy la otra cadena asignada al TAD\n");

  /*Usar su operación para imprimirla: no recibe nada porque el TAD
  llama a su propio campo cadena*/
  tad2.imprimirCadenaDeTAD();

  /*Imprimir una cadena de un tad mediante el procedimiento de otro*/
  tad1.imprimirCadena(tad2.cadenaDeTAD);

  /*Obtener un TAD que contiene una cadena como salida (no se pueden devolver vectores
  de forma sencilla) e imprimirlo*/
  tadCadena = tad1.devuelveTADCadena("Soy una cadena que vino como parametro\n");
  printf("Contenido del tadCadena: %s",tadCadena.cadena);

  /*Concatenar texto y números e imprimirlo. Cuidado de no sobrepasar la longitud
  de la cadena que hemos definido*/
  tad1.numero = MAX_LONG_CADENA; /*Accediendo a un valor definido en un módulo*/

  strcat(textoOriginal_1, " concatenando un valor ");
  sprintf(aux, "%d", tad1.numero);  /*Ahora aux contiene el valor 59 en texto.
                                    Parámetros: cadena donde guardar el valor,
                                    tipo de número (%d, %f...), número*/
  strcat(textoOriginal_1, aux);
  strcat(textoOriginal_1, " de un modulo\n");
  printf("Resultado de concatenar texto y numero: %s",textoOriginal_1);
  tad1.imprimirCadena(textoOriginal_1);

}
