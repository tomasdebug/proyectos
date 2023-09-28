#include <stdio.h>
#include <stdlib.h>
#include "helado.h"

static int contador;
TipoNombresHelados nombreHelado = {"desconocido", "chocolate", "vainilla", "fresa", "limon", "pistacho", "menta"};

/*OPERACION SOBRE EL TAD PARA INCREMENTAR LA CANTIDAD DISPONIBLE DE UN SABOR*/
void TipoHelado::IncrementarHelado (TipoSabor sabor, float cantidad) {
cantidadDisponible[int(sabor)] = cantidadDisponible[int(sabor)] + cantidad;
printf ("Helado sabor %d (%s) incrementado en %.2f gramos\n", int(sabor), nombreHelado[int(sabor)], cantidad);
}

/*OPERACION SOBRE EL TAD PARA SABER SI ES POSIBLE FABRICAR UN CUCURUCHO CON 3 SABORES DADOS*/
bool TipoHelado::EsPosibleCucurucho (TipoSabor sabor1, TipoSabor sabor2, TipoSabor sabor3) {
if (cantidadDisponible[int(sabor1)] > 25 && cantidadDisponible[int(sabor2)] >25 &&
cantidadDisponible[int(sabor3)]>25) {
return true;
} else {
return false;
}
}
void TipoHelado::CucuruchosDisponibles() {
for (int i=1; i<=6; i++) {
if (cantidadDisponible[i] > 25) {
printf ("Helado sabor %s disponible %.2f gramos permite preparar %.2f bolas\n", nombreHelado[i],
cantidadDisponible[i], cantidadDisponible[i]/25);
contador = contador+1;
} else {
printf ("Helado sabor %s no disponible\n", nombreHelado[i]);
}
}
if (contador >= 3) {
for (int i=1; i<=6; i++) {
for (int j=i+1; j<=6; j++) {
for (int k=j+1; k<=6; k++) {
if (cantidadDisponible[i] > 25 && cantidadDisponible[j] > 25 && cantidadDisponible[k] > 25) {
printf ("Combinacion disponible: %s - %s - %s\n", nombreHelado[i], nombreHelado[j], nombreHelado[k]);
}
}
}
}
} else {
printf ("No se puede confeccionar ningun tipo de cucurucho con el helado disponible\n"); }
}
