

#include <stdio.h>
#include "m10por10.h"


void Tipom10por10::leer(){
  for (int i=0; i<10;i++){
    for (int j=0; j<10;j++){
      printf("Introduza el elemento (%d,%d): ",i,j);
      scanf("%d",& matriz[i][j]);
      printf("\n");
    }
  }
}


void Tipom10por10::escribir(){
  for (int i=0; i<10;i++){
    printf("| ");
    for (int j=0; j<10;j++){
      printf("%d ",matriz[i][j]);
    }
    printf("|\n");
  }
}

void Tipom10por10:: transponer(){
TipoMatriz Maux;

  for (int i=0; i<10;i++){
    for (int j=0; j<10;j++){
        Maux[j][i] = matriz[i][j];
    }
  }
  for (int i=0; i<10;i++){
    for (int j=0; j<10;j++){
        matriz[i][j] = Maux[i][j];
    }
  }

}




