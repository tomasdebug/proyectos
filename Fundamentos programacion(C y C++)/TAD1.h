
#pragma once

#include "Cadena.h"

/** TAD con un valor entero y algunos métodos para cadenas */
typedef struct T_TAD1{
  int numero;

  void imprimirCadena(const T_Cadena cadena); /*Con const no se podrá modificar la cadena*/
  void escribirCadena(T_Cadena cadena1, T_Cadena cadena2);  /*Modifica dos cadenas que entran
                                                            como parámetro (cualquier vector se pasa
                                                            por referencia y se puede modificar)*/
  T_TADCadena devuelveTADCadena(const T_Cadena cadena); /*Devulve un TAD con una cadena. */
};
