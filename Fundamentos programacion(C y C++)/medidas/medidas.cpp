#include <stdio.h>
#include "medidas.h"
Medida medida;
TipoVector vector;
float lim_sup=0.0;
float lim_inf=0.0;
void Medida::NuevasMedidas(TipoVector &v){
for (int i=0;i<tam;i++){
printf("Introduzca medida %d : \n", i);
scanf ("%f", &v[i]);
}

}
bool Medida::ComprobarMedidas(TipoVector v){

printf("Introduzca limite superior : \n");
scanf ("%f", &lim_sup);
printf("Introduzca limite inferior : \n");
scanf ("%f", &lim_inf);
for (int i=0;i<tam;i++){
if(v[i]<=lim_sup && v[i]>=lim_inf){
  printf("Las medidas estan entre %f y %f: \n\n" ,lim_sup,lim_inf);
  return true;
  }else{
printf("Las medidas no estan entre %f y %f: \n\n", lim_sup,lim_inf);
return false;
  }
}
}
void Medida::MostrarMedidas(TipoVector v){
for (int i=0;i<tam;i++){
 printf("La medidas son %f \n",v[i]);
    }
}
int main(){
medida.NuevasMedidas (vector);
medida.ComprobarMedidas(vector);
medida.MostrarMedidas(vector);
  }
