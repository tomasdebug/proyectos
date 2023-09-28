#include "FlotaVehiculos.h"

/* Inicia el vector con todas las matrículas a "" y los km a 0 */
void FlotaVehiculos::Iniciar() {
  for (int i = 0; i < MaxVehiculos; i++) {
    strcpy(flota[i].matricula,"");
    flota[i].kilometros = 0;
  }
}

/* Inserta un nuevo vehículo en la flota, iniciando sus km a 0 */
void FlotaVehiculos::Insertar (CadMatricula mat) {
  bool encontrado = false;        /* Para buscar el hueco en el vector donde realizar la inserción */
  int indice = 0;                 /* Para recorrer el vector */
  while (!encontrado && indice < MaxVehiculos) {
    if (strcmp(flota[indice].matricula,"") == 0) {
      encontrado = true;
    }
    indice++;
  }
  /* -- Se inserta el nuevo vehículo. Los kilómetros ya deberían estar a 0 con la inicialización pero se vuelven a poner a 0 -- */
  strcpy(flota[indice-1].matricula,mat);
  flota[indice-1].kilometros = 0;
}

/* Recibe una matrícula y el número de km a incrementar. Devuelve true si existe la matrícula y false en caso contrario */
bool FlotaVehiculos::Aumentar(CadMatricula mat, int km) {
  bool encontrado = false;        /* Para buscar la matrícula en el vector */
  int indice = 0;                 /* Para recorrer el vector */
  while (!encontrado && indice < MaxVehiculos) {
    if (strcmp(flota[indice].matricula,mat) == 0) {
      flota[indice].kilometros = km;
      encontrado = true;
    }
    indice++;
  }
  return encontrado;
}

/* Devuelve el número de kilómetros totales que han recorrido los vehículos de la flota */
int FlotaVehiculos::Total() {
  int total = 0;                   /* Total de kilómetros recorridos */
  for (int i = 0; i < MaxVehiculos; i++) {
    total = total + flota[i].kilometros;
  }
  return total;
}
