#include <stdio.h>
#include <stdlib.h>
#include "tarjetamonedero.h"
#include "gestordefechas.h" /*Modulo de gestión de fechas */
/* http://www.aprenderaprogramar.com/foros/index.php?topic=401.0*/
static float aux;
static int indiceOperacion = MaxRegOperaciones;
static void SaberOrdenOperacion() {
if (indiceOperacion > -1) {
indiceOperacion--;
}
}
/*CARGAR CANTIDAD*/
void TipoDatosTarjetaMonedero::CargarCantidad(TipoFecha fecha, float cantidad) {
SaberOrdenOperacion();
if (indiceOperacion == MaxRegOperaciones-1) {
saldo=0;
}
printf ("La fecha es %d/%d/%d. ", fechaHoy.dia, fechaHoy.mes, fechaHoy.anno);
saldo = saldo + cantidad;
Operacion[indiceOperacion].fechaOperacion = fechaHoy;
Operacion[indiceOperacion].cantidadOperacion = cantidad;
Operacion[indiceOperacion].claseOperacion = Cargar;
Operacion[indiceOperacion].saldoTrasOperacion =
Operacion[indiceOperacion+1].saldoTrasOperacion+cantidad;
printf("Carga ejecutada. El saldo es %.2f \n", saldo);
ReordenarRegistros();
}
/*Fin de CargarCantidad*/
/*SACAR UNA CANTIDAD*/
void TipoDatosTarjetaMonedero::SacarCantidad(TipoFecha fecha, float cantidad) {
SaberOrdenOperacion();
if (indiceOperacion == MaxRegOperaciones) {
saldo=0;
}
aux = saldo;
aux = aux - cantidad;
/* DEBUGGING printf ("aux vale %.2f", aux); */
if (aux < 0) {
printf("Operacion no realizable. No hay saldo sufciente\n");
indiceOperacion=indiceOperacion+1;
throw saldoinsuficiente;
} else {
saldo = saldo - cantidad;
}
/* DEBUGGING printf ("El indice de operacion es %d \n", indiceOperacion); */
printf ("La fecha es %d/%d/%d. ", fechaHoy.dia, fechaHoy.mes, fechaHoy.anno);
Operacion[indiceOperacion].fechaOperacion = fechaHoy;
Operacion[indiceOperacion].cantidadOperacion = cantidad;
Operacion[indiceOperacion].claseOperacion = Sacar;
Operacion[indiceOperacion].saldoTrasOperacion = Operacion[indiceOperacion+1].saldoTrasOperacion-
cantidad;
printf("Extracción ejecutada. El saldo es %.2f \n", saldo);
ReordenarRegistros();
}
/*Fin de SacarCantidad*/
/*REORDENAR REGISTROS: MANTIENE LOS DATOS DE LAS 10 ULTIMAS OPERACIONES*/
void TipoDatosTarjetaMonedero::ReordenarRegistros() {
if (indiceOperacion<0) {
for (int i=MaxRegOperaciones; i>=0; i--) {
Operacion[i] = Operacion[i-1];
}
}
}
/*Fin de reordenar registros*/
void TipoDatosTarjetaMonedero::Consultar() {
if (indiceOperacion>-1){
aux = indiceOperacion;
} else {
aux = 0;
}
printf("****** FECHA --> CANTIDAD --> TIPO DE OPERACION --> SALDO\n");
for (int i=MaxRegOperaciones-1; i>=aux; i--) {
printf ("%d/%d/%d --> ", Operacion[i].fechaOperacion.dia, Operacion[i].fechaOperacion.mes,
Operacion[i].fechaOperacion.anno);
printf ("%f -->
", Operacion[i].cantidadOperacion);
if (Operacion[i].claseOperacion == Cargar) {
printf ("Carga --> ");
} else if (Operacion[i].claseOperacion == Sacar) {
printf ("Sacar --> ");
}
printf ("%f
", Operacion[i].saldoTrasOperacion);
printf ("\n");
}
printf ("Consulta completada\n");
}
