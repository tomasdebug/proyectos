#pragma once


typedef char TipoNombre[20];
typedef char TipoApellido[30];
typedef int TipoDNI[9];

typedef struct persona {
  TipoNombre nombre;
  TipoApellido ape1;
  TipoApellido ape2;
  TipoDNI dni;
  int edad;
};

typedef struct pers {

   persona buffer_personas[50];

   void imprimirMayoresDe(int limite_edad);
   void buscarApellido(TipoApellido ape);

};


