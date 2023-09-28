#include "FlotaVehiculos.h"

int main() {
  FlotaVehiculos flota;
  bool hecho;
  flota.Iniciar();
  flota.Imprimir();
  flota.Insertar("5546HDF");
  flota.Insertar("8372FFS");
  flota.Insertar("7783HSS");
  flota.Insertar("7833CFD");
  flota.Insertar("7892CUR");
  flota.Insertar("8349KJD");
  flota.Insertar("4830CJU");
  flota.Insertar("3890CUE");
  flota.Insertar("8347CME");
  flota.Insertar("8293ERI");
  flota.Insertar("7803UIR");
  flota.Imprimir();
  hecho = flota.Aumentar("5546HDF",200);
  hecho = flota.Aumentar("8372FFS",230);
  hecho = flota.Aumentar("7783HSS",4500);
  hecho = flota.Aumentar("7833CFD",900);
  hecho = flota.Aumentar("7892CUR",20);
  hecho = flota.Aumentar("8349KJD",325);
  hecho = flota.Aumentar("4830CJU",260);
  hecho = flota.Aumentar("3890CUE",708);
  hecho = flota.Aumentar("8347CME",45);
  hecho = flota.Aumentar("8293ERI",20);
  hecho = flota.Aumentar("7803UIR",15);
  flota.Imprimir();
  printf("Total km flota: %d\n",flota.Total());
  hecho = flota.Aumentar("1111",15);
  printf("%d\n",int(hecho));
}
