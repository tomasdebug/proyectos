

#include <stdio.h>
#include <string.h>
#include "alumno.h"


void alumno::alta(TipoNombre n,TipoApellido a1, TipoApellido a2, TipoDNI d){
  strcpy(nombre,n);
  strcpy(ape1,a1);
  strcpy(ape2,a2);
  for (int i=0; i<8; i++){
    dni[i]=d[i];
  }
}

void alumno::intronotas(TipoNotas n){
  for (int i=1;i<15;i++){
     notas[i]=n[i];
  }
}

float alumno::media(){
 float accum=0;
 for (int i=0;i<15;i++){
    accum = accum + notas[i];
 }
 return (accum / 15.0);
}
