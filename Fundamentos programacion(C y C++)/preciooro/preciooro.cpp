/*IMPLEMENTACIÓN DEL TAD*/
#include <stdio.h>
#include <stdlib.h>
#include "precio_oro.h"
/* http://www.aprenderaprogramar.com/foros/index.php?topic=401.0*/
float cambioMoneda1 = 0.0;
float cambioMoneda2 = 0.0;
/*OPERACION NUEVO PRECIO SOBRE EL TAD*/
void TipoVectorOro::NuevoPrecio (TipoNombreMoneda nombre_moneda, float precionuevo) {
moneda[nombre_moneda].precioOroMoneda = precionuevo;
}
/*OPERACION CAMBIOPRECIO SOBRE EL TAD*/
void TipoVectorOro::CambioOro (TipoNombreMoneda nombre_moneda1, TipoNombreMoneda
nombre_moneda2) {
/*Unidades de moneda 2 que nos dan por cada unidad de moneda 1*/
cambioMoneda1 = moneda[nombre_moneda2].precioOroMoneda /
moneda[nombre_moneda1].precioOroMoneda;
/*Unidades de moneda 1 que nos dan por cada unidad de moneda 2*/
cambioMoneda2 = moneda[nombre_moneda1].precioOroMoneda /
moneda[nombre_moneda2].precioOroMoneda;
}
void TipoVectorOro::ListarPrecios () {
printf ("1=dolares 2=euros 3=yenes 4=libras 5=yuanes\n");
for (int i=1; i<= numeroMonedas; i++) {
printf ("Valor de la onza en la moneda %d es %f uds\n", i, moneda[i].precioOroMoneda);
}
}
