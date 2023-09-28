#pragma once
#include <string.h>

/* Definición de constantes */
const int MaxVehiculos = 50;

/* Tipo cadena para almacenar la matrícula */
typedef char CadMatricula[8];

/* Tipo registro para vehículo */
typedef struct Vehiculo {
  CadMatricula matricula;
  int kilometros;
};

/* Vector para guardar hasta 50 vehículos */
typedef Vehiculo ArrayVehiculos[MaxVehiculos];

/* TAD */
typedef struct FlotaVehiculos {
  /* Inicia el vector con todas las matrículas a "" y los km a 0 */
  void Iniciar();
  /* Inserta un nuevo vehículo en la flota, iniciando sus km a 0 */
  void Insertar (CadMatricula mat);
  /* Recibe una matrícula y el número de km a incrementar. Devuelve true si existe la matrícula y false en caso contrario */
  bool Aumentar(CadMatricula mat, int km);
  /* Devuelve el número de kilómetros totales que han recorrido los vehículos de la flota */
  int Total();
  private:
    ArrayVehiculos flota;
};
