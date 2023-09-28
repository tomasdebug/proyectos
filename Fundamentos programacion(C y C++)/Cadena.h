/************************************
* Este .h sólo define tipos. Como no
* hay métodos no hace falta .cpp
* asociado.
************************************/

#pragma once

const int MAX_LONG_CADENA = 100;

typedef char T_Cadena[MAX_LONG_CADENA];

/** TAD usado para poder devolver cadenas de forma indirecta*/
typedef struct T_TADCadena{
  T_Cadena cadena;
};
