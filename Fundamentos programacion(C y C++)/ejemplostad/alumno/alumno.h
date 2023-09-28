
#pragma once

typedef float TipoNotas[15];
typedef char TipoNombre[20];
typedef char TipoApellido[30];
typedef int TipoDNI[9];



typedef struct alumno {
  TipoNombre nombre;
  TipoApellido ape1;
  TipoApellido ape2;
  TipoDNI dni;
  TipoNotas notas;


  void alta(TipoNombre n,TipoApellido a1, TipoApellido a2, TipoDNI d);
  void intronotas(TipoNotas n);
  float media();
};
