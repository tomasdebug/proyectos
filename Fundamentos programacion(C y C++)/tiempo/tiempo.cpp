/*IMPLEMENTACIÓN DEL TIPO ABSTRACTO TIEMPO CIUDAD*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "tiempociudad.h"
/* http://www.aprenderaprogramar.com/foros/index.php?topic=401.0*/
typedef TipoCadena TipoTextoMomento[4];
TipoTextoMomento textoMomento = {"mannana", "tarde", "noche", "madrugada"};
typedef TipoCadena TipoSituacion[4];
TipoSituacion situacion;
void TipoTiempoCiudad::NuevaCiudad (TipoCadena nombredeciudad) {
strcpy (NombreCiudad, nombredeciudad);
printf ("Creada nueva ciudad: %s\n", NombreCiudad);
for (int i = 0; i < 4; i++) {
temperatura [i] = 0.0; estado [i] = sol;
} /*Cierre del for*/
}/*Cierre void*/
void TipoTiempoCiudad::NuevoTiempo (TipoCadena nombredeciudad, TipoMomento momento, float
temperaturamomento, TipoEstado estadomomento) {
temperatura [int(momento)] = temperaturamomento;
estado [int(momento)] = estadomomento;
printf ("Nuevos datos registrados para %s \n", nombredeciudad);
printf ("Momento %d : temperatura %.2f y estado %d\n", int(momento), temperaturamomento,
estadomomento);
}
void TipoTiempoCiudad::ListaTiempo (TipoCadena nombredeciudad) {
for (int i = 0; i < 4; i++) {
if (int(estado[i]) == 0) {
strcpy (situacion[i], "sol");
} else if (int(estado[i]) == 1) {
strcpy (situacion[i], "nubes");
} else if (int(estado[i]) == 2) {
strcpy (situacion[i], "lluvia");
} else if (int(estado[i]) == 3) {
strcpy (situacion[i], "nieve");
} else { throw ErrorGenerado; }
}
printf ("Ciudad : %s \n", nombredeciudad);
for (int i = 0; i < 4; i++) {
printf("Por la %s situacion : %s temperatura %.2f grados \n", textoMomento[i], situacion[i],
temperatura[i]);
}
}/*Cierre void*/
