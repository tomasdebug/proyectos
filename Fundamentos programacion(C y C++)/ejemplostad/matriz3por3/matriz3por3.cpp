
#include "matriz3por3.h"



void matriz3por3::RotarFigura(){
TipoMatriz Maux;

for (int i=1;i <= rango ;i++){
  for (int j=1;j<= rango ;j++){
      Maux[j][rango+1-i]=M[i][j];
  }
}

for (int i=1;i<=rango;i++){
  for (int j=1;j<=rango;j++){
      M[i][j]=Maux[i][j];
  }
}

}


void matriz3por3::InvertirFigura(){

TipoMatriz Maux;

for (int i=1;i<=rango;i++){
  for (int j=1;j<=rango;j++){
      Maux[i][j]=M[i][rango-j+1];
  }
}

for (int i=1;i<=rango;i++){
  for (int j=1;j<=rango;j++){
      M[i][j]=Maux[i][j];
  }
}

}


