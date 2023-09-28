#pragma once
#include <string.h>

/* Definici�n de constantes */
const int MaxVehiculos = 50;

/* Tipo cadena para almacenar la matr�cula */
typedef char CadMatricula[8];

/* Tipo registro para veh�culo */
typedef struct Vehiculo {
  CadMatricula matricula;
  int kilometros;
};

/* Vector para guardar hasta 50 veh�culos */
typedef Vehiculo ArrayVehiculos[MaxVehiculos];

/* TAD */
typedef struct FlotaVehiculos {
  /* Inicia el vector con todas las matr�culas a "" y los km a 0 */
  void Iniciar();
  /* Inserta un nuevo veh�culo en la flota, iniciando sus km a 0 */
  void Insertar (CadMatricula mat);
  /* Recibe una matr�cula y el n�mero de km a incrementar. Devuelve true si existe la matr�cula y false en caso contrario */
  bool Aumentar(CadMatricula mat, int km);
  /* Devuelve el n�mero de kil�metros totales que han recorrido los veh�culos de la flota */
  int Total();
  private:
    ArrayVehiculos flota;
};
