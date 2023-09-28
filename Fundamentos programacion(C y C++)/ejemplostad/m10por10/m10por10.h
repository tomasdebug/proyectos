# pragma once

typedef int TipoMatriz[10][10];

typedef struct Tipom10por10{

  TipoMatriz matriz;

  void leer();
  void escribir();
  void transponer();

};
