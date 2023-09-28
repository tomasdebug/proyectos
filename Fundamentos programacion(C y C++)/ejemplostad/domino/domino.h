

#pragma once


typedef enum TipoRango {blanco, uno, dos, tres, cuatro, cinco, seis, nulo};
typedef struct TipoFicha{
   TipoRango v1;
   TipoRango v2;
};
typedef TipoFicha TipoMano[4];



typedef struct TipoDomino{

   TipoFicha Domino[28];

   void CrearFichas();
   void Repartir4(TipoMano & juego);

};
