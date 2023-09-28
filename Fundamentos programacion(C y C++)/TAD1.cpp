#include <stdio.h>
#include <string.h>
#include "TAD1.h"
/*No hace falta incluir Cadena.h aquí porque ya se ha puesto en el .h*/

/** Imprimir una cadena recibida por parámetro */
void T_TAD1::imprimirCadena(const T_Cadena cadena){

  printf("Desde TAD1: %s",cadena);
}

/** Modificar dos cadenas recibidas por parámetro (por defecto,
    cualquier vector se pasa por referencia) */
void T_TAD1::escribirCadena(T_Cadena cadena1, T_Cadena cadena2){
  T_Cadena texto1 = "Soy la nueva cadena 1 de TAD1\n";
  T_Cadena texto2 = "Soy la nueva cadena 2 de TAD2\n";

  /*--Modificar las cadenas. No se puede usar asignación como arriba en texto1 porque
  no estamos inicializando la variable al definirla--*/
  strcpy(cadena1,texto1);  /*Modifica la cadena1 recibida por parámetro*/
  strcpy(cadena2,texto2);  /*Modifica la cadena2 recibida por parámetro*/
}

T_TADCadena T_TAD1::devuelveTADCadena(const T_Cadena cadena){
  T_TADCadena tadCadena;

  /*--Modificar la cadena del TAD--*/
  strcpy(tadCadena.cadena, cadena);

  return tadCadena;
}

