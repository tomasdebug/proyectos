
#pragma once

typedef struct TipoEcuacion{
  float ax2;
  float bx;
  float c;

  void entrada_coeficientes();
  void calculoraices(float & r1, float &r2);

};
