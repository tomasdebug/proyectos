

#pragma once

const int rango=3;

typedef char TipoMatriz [3][3];

typedef struct matriz3por3{
    TipoMatriz M;

    void RotarFigura();
    void InvertirFigura();
};
