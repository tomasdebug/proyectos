/* INTERFAZ DEL TAD */
#pragma once
/* www.aprenderaprogramar.com/foros/index.php?topic=401.0*/
const int upperBoundArray = 49;
typedef int TipoArrayEnteros[upperBoundArray];
typedef struct TipoArrayConModa {
/*Datos: un vector de enteros*/
TipoArrayEnteros array;
/*Operaciones: calcular la moda usando los datos disponibles en el propio TAD y devolver el entero que es la moda*/
/* Operaciones auxiliares: setValor para establecer el valor en un elemento del array y getValor para obtenerlo */
int calcularModa ();
void setValor(int indice, int valor);
int getValor(int indice);
}; /*Cierre del struct con ; */
