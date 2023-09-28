
#include <stdlib.h>
#include <time.h>
#include "domino.h"



bool ComprobarRepe(TipoMano juego, TipoFicha f)
{
  for (int i=0; i<4;i++)
  {
     if ((juego[i].v1 == f.v1) &&
        (juego[i].v2 == f.v2)) {
       return true;
     }
  }
  return false;
}


void TipoDomino::CrearFichas(){
int cont = 0;
for (int i=0; i<=6; i++){
  for (int j=0; j<=i; j++){
     Domino[cont].v1 = TipoRango(i);
     Domino[cont].v2 = TipoRango(j);
     cont++;
  }
}

}

void TipoDomino::Repartir4(TipoMano & juego){
  int i;
  TipoFicha f;

  srand( time(NULL) );
  for (int j=0;j<4;j++)
  {
    juego[j].v1 = nulo;
    juego[i].v2 = nulo;
  }
  i=0;
  while (i<4){
    f = Domino[rand()%28];
    if (ComprobarRepe (juego, f) == false){
      juego[i]=f;
      i++;
    }
  }

}

