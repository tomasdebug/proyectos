/**********************************************************
Polinomio.h
**********************************************************/
#pragma once
const int numGrados=9;
typedef float TipoPolinomio[9];
typedef struct TipoOperacion{
void SumarPolinomio (TipoPolinomio P, float coeficiente, int n);
float Evaluar (const TipoPolinomio P, int b);
void Imprimir (const TipoPolinomio P);
TipoPolinomio Pol;
};
