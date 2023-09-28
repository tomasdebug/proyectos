
/*IMPLEMENTACIÓN DEL TIPO ABSTRACTO ARRAY PERSONAS*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "arrayPersonas.h"
/* Declaración de la operación MayoresDe aplicable al tad arrayPersonas */
/*recibe como entrada un número natural e imprime por
pantalla los datos de aquellas personas cuya edad sea mayor o igual que la solicitada*/
void TipoArrayPersonas::MayoresDe (int edadParaListado) {
printf ("*** Operacion mayores de ***\n");
for (int i = 0; i <= upperBoundArray; i++) {
if (edad[i]>= edadParaListado) {
printf("Detectada persona con edad mayor o igual que %d con datos:\n", edadParaListado);
printf("Nombre y apellidos: %s %s %s\n", nombre[i], primerApellido[i], segundoApellido[i]);
if (estadoCivil[i] == soltero) {printf("Estado civil: soltero\n");}
if (estadoCivil[i] == casado) {printf("Estado civil: casado\n");}
if (estadoCivil[i] == divorciado) {printf("Estado civil: divorciado\n");}
printf("Edad: %d \n", edad[i]);
}
} /*Cierre del for*/
}/*Cierre operacion*/
/* Declaración de la operación ContEstadoCivil aplicable al tad arrayPersonas
Entrada un estado civil y devuelve el número de personas que tienen ese estado civil
www.aprenderaprogramar.com/foros/index.php?topic=401.0*/
int TipoArrayPersonas::ContEstadoCivil (TipoEstadoCivil estadoRecibido) {
int contadorResultado=0;
printf ("Operacion ContEstadoCivil\n");
for (int i = 0; i <= upperBoundArray; i++) {
if (estadoCivil[i] == estadoRecibido) {contadorResultado=contadorResultado+1;}
} /*Cierre del for*/
return contadorResultado;
}/*Cierre */
/* Declaración de la operación GuardarNuevo aplicable al tad arrayPersonas*/
void TipoArrayPersonas::GuardarNuevo (TipoCadena nombreRecibido, TipoCadena primerApRecibido,
TipoCadena segApellidoRecibido, TipoEstadoCivil estadoRecibido, int edadRecibida) {
int indiceDondeAlmacenaremos = 0;
int i=0;
printf ("Operacion guardar nuevo\n");
while (edad[i] != 0) {i=i+1;};
indiceDondeAlmacenaremos = i;
strcpy (nombre[indiceDondeAlmacenaremos], nombreRecibido);
strcpy (primerApellido[indiceDondeAlmacenaremos], primerApRecibido);
strcpy (segundoApellido[indiceDondeAlmacenaremos], segApellidoRecibido);
estadoCivil[indiceDondeAlmacenaremos] = estadoRecibido;
edad[indiceDondeAlmacenaremos] = edadRecibida;
printf ("Nuevos datos almacenados en posicion %d \n", indiceDondeAlmacenaremos);
}/*Cierre */
