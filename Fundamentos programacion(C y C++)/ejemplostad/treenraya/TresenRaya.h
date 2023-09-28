
/*
  Realizar un tipo abstracto de datos para el juego de las TRES EN RAYA.
 El tablero es de 3x3 y cualquier cuadricula podra estar vacia u ocupada
solo por una ficha blanca o negra. Las operaciones son:
  1.- Poner una ficha en una cuadricula que no esta ocupada
  2.- Quitar una ficha de una cuadricula
  3.- Comprobar si se produce tres en raya e indicar si es de blancas o
    de negras
*/

#pragma once

typedef enum TipoFicha { vacia, blanca, negra };

typedef struct TipoTresEnRaya{

   TipoFicha tablero[3][3];

   bool poner(int posX,int posY, TipoFicha f);
   TipoFicha quitar (int posX, int posY);
   TipoFicha tresenraya();
};
