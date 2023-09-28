#pragma once
const int tam=3;
typedef float TipoVector [tam];
extern TipoVector vector;
extern float lim_sup, lim_inf;
typedef struct Medida{
void NuevasMedidas(TipoVector &v);
bool ComprobarMedidas(TipoVector v);
void MostrarMedidas(TipoVector v);
};
