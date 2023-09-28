
#include <stdio.h>
#include <string.h>
#include "pers.h"

void imprimirDatos(persona p){
 printf ("%s ",p.nombre);
 printf ("%s ",p.ape1);
 printf ("%s ",p.ape2);
 printf ("%s ",p.dni);
 printf ("%d \n",p.edad);
}


void pers::imprimirMayoresDe(int limite_edad){
  for (int i=0; i<50; i++){
     if (buffer_personas[i].edad >= limite_edad){
       imprimirDatos(buffer_personas[i]);
     }
  }
}

void pers::buscarApellido(TipoApellido ape){
   for (int i=0; i<50; i++){
      if (strcmp(buffer_personas[i].ape1,ape) == 0){
           imprimirDatos(buffer_personas[i]);
      }
   }
}
