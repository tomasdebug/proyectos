
#include <math.h>
#include <stdio.h>

#include "ecuacion.h"

void TipoEcuacion::entrada_coeficientes()
{
  printf("Introduzca el coeficiente A: ");
  scanf("%f",&ax2);
  printf("\n");
  printf("Introduzca el coeficiente B: ");
  scanf("%f",&bx);
  printf("\n");
  printf("Introduzca el coeficiente C: ");
  scanf("%f",&c);
  printf("\n");
}


void TipoEcuacion::calculoraices(float & r1, float &r2)
{
  float aux;

   aux = bx * bx - 4.0 * ax2 * c;

   r1 = (-bx + sqrt(aux) ) / (2.0 * ax2);
   r2 = (-bx - sqrt(aux) ) / (2.0 * ax2);
}



