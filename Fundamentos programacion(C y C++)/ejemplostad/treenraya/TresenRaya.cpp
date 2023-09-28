
#include "TresenRaya.h"

bool TipoTresEnRaya::poner (int posX,int posY, TipoFicha f){
  if (tablero[posX][posY] == vacia){
     tablero[posX][posY] = f;
     return true;
  }
  else{
    return false;
  }
}


TipoFicha TipoTresEnRaya::quitar (int posX, int posY){
  TipoFicha f;

  tablero[posX][posY]=vacia;
  return f;
}



TipoFicha TipoTresEnRaya::tresenraya(){

  for (int i=0;i<3;i++){
   if ((tablero[i][0]==tablero[i][1]) && (tablero[i][0]==tablero[i][2])){
      return tablero[i][0];
   }
  }

  for (int i=0;i<3;i++){
   if ((tablero[0][i]==tablero[1][i]) && (tablero[0][i]==tablero[2][i])){
      return tablero[0][i];
   }
  }

   if ((tablero[0][0]==tablero[1][1]) && (tablero[2][2]==tablero[0][0])){
      return tablero[0][0];

   }

   if ((tablero[2][0]==tablero[1][1]) && (tablero[2][0]==tablero[0][2])){
      return tablero[2][0];
   }

   return vacia;

}
int main()
{
  TipoTresEnRaya.quitar(int posX, int posY);
  TipoTresEnRaya.poner(int posX,int posY, TipoFicha f);
  TipoTresEnRaya.tresenraya();

}
